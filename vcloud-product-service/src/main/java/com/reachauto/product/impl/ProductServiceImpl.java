package com.reachauto.product.impl;

import com.reachauto.common.service.JdbcRepositoryWrapper;
import com.reachauto.product.Product;
import com.reachauto.product.ProductService;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.reachauto.util.TokenKit.generateShortUuid;

/**
 * Created by zouqiang on 2016/11/8.
 */
public class ProductServiceImpl extends JdbcRepositoryWrapper implements ProductService {

    public static final String INSERT_STATEMENT = "INSERT INTO product(`name`,`api_key`,`create_date`,`aid`,`del_flag`) VALUES (?,?,?,?,?)";
    public static final String DELETE_STATEMENT = "UPDATE product SET del_flag = " + Product.DEL_FLAG_DELETE + " WHERE id = ?";
    public static final String FETCH_STATEMENT = "SELECT * FROM product WHERE id = ?";
    public static final String FETCH_ALL_STATEMENT = "SELECT * FROM product";
    private static final String UPDATE_STATEMENT = "UPDATE product SET name = ? WHERE id = ?";


    public ProductServiceImpl(Vertx vertx, JsonObject config) {
        super(vertx, config);
    }

    @Override
    public ProductService addProduct(Product product, Handler<AsyncResult<Void>> resultHandler) {
        JsonArray params = new JsonArray();
        params.add(product.getName());
        params.add(generateShortUuid());
        params.add(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        params.add(product.getAccount().getId());
        params.add(product.getDelFlag());
        executeNoResult(params, INSERT_STATEMENT, resultHandler);
        return this;

    }

    @Override
    public ProductService deleteProduct(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        JsonArray params = new JsonArray();
        params.add(id);
        executeNoResult(params, DELETE_STATEMENT, resultHandler);
        return this;
    }

    @Override
    public ProductService updateProduct(Product product, Handler<AsyncResult<Product>> resultHandler) {
        JsonArray params = new JsonArray();
        params.add(product.getName());
        params.add(product.getId());
        execute(params, UPDATE_STATEMENT, product, resultHandler);
        return this;
    }

    @Override
    public ProductService retrieveProduct(Integer id, Handler<AsyncResult<Product>> resultHandler) {
        retrieveOne(id, FETCH_STATEMENT).map(option -> option.map(Product::new).orElse(null)).setHandler(resultHandler);
        return this;
    }

    @Override
    public ProductService retrieveAllProduct(Handler<AsyncResult<List<Product>>> resultHandler) {
        retrieveAll(FETCH_ALL_STATEMENT).map(
                rawList -> rawList.stream().map(
                        Product::new).collect(Collectors.toList())
        ).setHandler(resultHandler);
        return this;
    }

}
