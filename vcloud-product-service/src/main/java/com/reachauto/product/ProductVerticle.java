package com.reachauto.product;

import com.reachauto.account.AccountService;
import com.reachauto.common.BaseMicroserviceVerticle;
import com.reachauto.product.api.RestProductAPIVerticle;
import com.reachauto.product.impl.ProductServiceImpl;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.serviceproxy.ProxyHelper;

import static com.reachauto.product.ProductService.SERVICE_ADDRESS;
import static com.reachauto.product.ProductService.SERVICE_NAME;


/**
 * Created by zouqiang on 2016/11/8.
 */
public class ProductVerticle extends BaseMicroserviceVerticle{
    ProductService productService;

    @Override
    public void start(Future<Void> future) throws Exception {
        super.start();
        productService = new ProductServiceImpl(vertx, config());
        //regist the service proxy on event bus
        ProxyHelper.registerService(ProductService.class, vertx, productService, SERVICE_ADDRESS);

        publishEventBusService(SERVICE_NAME, SERVICE_ADDRESS, ProductService.class)
                .compose(servicePublished -> deployRestVerticle())
                .setHandler(future.completer());


    }

    private Future<Void> deployRestVerticle() {
        Future<String> future = Future.future();
        vertx.deployVerticle(new RestProductAPIVerticle(productService),
                new DeploymentOptions().setConfig(config()),
                future.completer());
        return future.map(r -> null);
    }
}
