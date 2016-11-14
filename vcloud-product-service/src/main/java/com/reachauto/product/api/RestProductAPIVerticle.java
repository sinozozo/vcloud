package com.reachauto.product.api;

import com.reachauto.account.Account;
import com.reachauto.account.AccountService;
import com.reachauto.common.RestAPIVerticle;
import com.reachauto.product.Product;
import com.reachauto.product.ProductService;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Created by zouqiang on 2016/11/8.
 */
public class RestProductAPIVerticle extends RestAPIVerticle {
    private static final String API_ADD = "/product";
    private static final String API_RETRIEVE = "/product/:id";
    private static final String API_RETRIEVE_ALL = "/product";
    private static final String API_UPDATE = "/product/:id";
    private static final String API_DELETE = "/product/:id";
    private static final String SERVICE_NAME = "product-rest-api";
    ProductService productService;

    public RestProductAPIVerticle(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void start(Future<Void> future) throws Exception {
        super.start();
        final Router router = Router.router(vertx);
        // body handler
        router.route().handler(BodyHandler.create());
        // api route handler
        router.post(API_ADD).handler(this::apiAddProduct);
        router.get(API_RETRIEVE).handler(this::apiRetrieveProduct);
        router.get(API_RETRIEVE_ALL).handler(this::apiRetrieveAll);
        router.patch(API_UPDATE).handler(this::apiUpdateProduct);
        router.delete(API_DELETE).handler(this::apiDeleteProduct);

        String host = config().getString("user.product.http.address", "0.0.0.0");
        int port = config().getInteger("user.product.http.port", 8082);

        // create HTTP server and publish REST service
        createHttpServer(router, host, port)
                .compose(serverCreated -> publishHttpEndpoint(SERVICE_NAME, host, port))
                .setHandler(future.completer());
    }

    private void apiAddProduct(RoutingContext context) {
        Product product = new Product(context.getBodyAsJson());
        productService.addProduct(product, resultVoidHandler(context, 201));

    }

    private void apiRetrieveProduct(RoutingContext context) {
        String id = context.request().getParam("id");
        productService.retrieveProduct(Integer.valueOf(id), resultHandlerNonEmpty(context));
    }

    private void apiRetrieveAll(RoutingContext context) {
        productService.retrieveAllProduct(resultHandler(context, Json::encodePrettily));
    }

    private void apiUpdateProduct(RoutingContext context) {
        Product product = new Product(context.getBodyAsJson());
        productService.updateProduct(product, resultHandlerNonEmpty(context));
    }

    private void apiDeleteProduct(RoutingContext context) {
        String id = context.request().getParam("id");
        productService.deleteProduct(Integer.valueOf(id), deleteResultHandler(context));
    }
}
