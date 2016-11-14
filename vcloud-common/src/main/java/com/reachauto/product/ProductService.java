package com.reachauto.product;

import com.reachauto.account.Account;
import com.reachauto.account.AccountService;
import com.reachauto.common.service.JdbcRepositoryWrapper;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.List;

/**
 * Created by zouqiang on 2016/11/8.
 */
@ProxyGen
@VertxGen
public interface ProductService  {
    public static final String SERVICE_ADDRESS = "service.product";
    public static final String SERVICE_NAME = "product-eb-service";


    @Fluent
    ProductService addProduct(Product product, Handler<AsyncResult<Void>> resultHandler);

    @Fluent
    ProductService deleteProduct(Integer id,Handler<AsyncResult<Void>> resultHandler);

    @Fluent
    ProductService updateProduct(Product product, Handler<AsyncResult<Product>> resultHandler);

    @Fluent
    ProductService retrieveProduct(Integer id, Handler<AsyncResult<Product>> resultHandler);

    @Fluent
    ProductService retrieveAllProduct(Handler<AsyncResult<List<Product>>> resultHandler);
}
