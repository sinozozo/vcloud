package com.reachauto.product;

import com.reachauto.account.Account;
import com.reachauto.product.Product;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by zouqiang on 2016/11/8.
 */
@RunWith(VertxUnitRunner.class)
public class ProductVerticleTest {
    private Vertx vertx;
    public static final int PORT = 8082;
    private static final int ID = 1;

    @Before
    public void setUp(TestContext context) {
        vertx = Vertx.vertx(new VertxOptions().setMaxEventLoopExecuteTime(Long.MAX_VALUE));
        DeploymentOptions options = new DeploymentOptions().setConfig(
                new JsonObject().put("url", "jdbc:mysql://localhost/vcloud?characterEncoding=UTF-8&useSSL=false")
                        .put("driver_class", "com.mysql.cj.jdbc.Driver").put("user", "root").put("password", "root")
                        .put("max_pool_size", 30));

        vertx.deployVerticle(ProductVerticle.class.getName(), options, context.asyncAssertSuccess());
    }

    @After
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test(timeout = 3000L)
    public void testAdd(TestContext context) throws Exception {
        HttpClient client = vertx.createHttpClient();
        Async async = context.async();
        Product product = new Product();
        product.setName("test1");
        Account account = new Account();
        account.setId(1);
        product.setAccount(account);
        client.post(PORT, "localhost", "/product", response -> {
            context.assertEquals(201, response.statusCode());
            client.close();
            async.complete();
        }).putHeader("content-type", "application/json").end(Json.encodePrettily(product));
    }

    @Test
    public void testGet(TestContext context) throws Exception {
        HttpClient client = vertx.createHttpClient();
        Async async = context.async();
        client.getNow(PORT, "localhost", "/product/"+ID, response -> response.bodyHandler(body -> {
            Product product  =  new Product(new JsonObject(body.getString(0, body.length())));
            context.assertTrue(!product.getName().isEmpty());
            client.close();
            async.complete();
        }));
    }

    @Test
    public void testGetAll(TestContext context) throws Exception {
        HttpClient client = vertx.createHttpClient();
        Async async = context.async();
        client.getNow(PORT, "localhost", "/product/", response -> response.bodyHandler(body -> {
            context.assertTrue(body.toJsonArray().size()>0);
            client.close();
            async.complete();
        }));
    }

    @Test(timeout = 3000L)
    public void testUpdateAndDelete(TestContext context) throws Exception {
        HttpClient client = vertx.createHttpClient();
        Async async = context.async();

        Product product = new Product();
        product.setId(1);
        String tempName = String.valueOf(System.currentTimeMillis());
        product.setName(tempName);

        client.request(HttpMethod.PATCH, PORT, "localhost", "/product/"+ID, response -> response.bodyHandler(body -> {
            context.assertEquals(new Product(body.toString()).getName(),tempName);
            client.request(HttpMethod.DELETE, PORT, "localhost", "/product/"+ID, rsp -> {
                context.assertEquals(204, rsp.statusCode());
                async.complete();
            }).end();

        })).putHeader("content-type", "application/json").end(Json.encodePrettily(product));
    }

}
