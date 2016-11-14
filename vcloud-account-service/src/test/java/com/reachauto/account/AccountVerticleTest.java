
package com.reachauto.account;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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

/**
 * Created by zouqiang on 2016/10/30.
 */
@RunWith(VertxUnitRunner.class)
public class AccountVerticleTest {

	private Vertx vertx;
	public static final int PORT = 8081;
	private static final int ID = 1;

	@Before
	public void setUp(TestContext context) {
		vertx = Vertx.vertx(new VertxOptions().setMaxEventLoopExecuteTime(Long.MAX_VALUE));
		DeploymentOptions options = new DeploymentOptions().setConfig(
				new JsonObject().put("url", "jdbc:mysql://localhost/vcloud?characterEncoding=UTF-8&useSSL=false")
						.put("driver_class", "com.mysql.cj.jdbc.Driver").put("user", "root").put("password", "root")
						.put("max_pool_size", 30));
		
		vertx.deployVerticle(AccountVerticle.class.getName(), options, context.asyncAssertSuccess());
	}

	@After
	public void tearDown(TestContext context) {
		vertx.close(context.asyncAssertSuccess());
	}

	@Test(timeout = 3000L)
	  public void testAdd(TestContext context) throws Exception {
	    HttpClient client = vertx.createHttpClient();
	    Async async = context.async();
	    Account account = new Account();
	    account.setUsername("zouqiang");
	    account.setPassword("zouqiang");
	    client.post(PORT, "localhost", "/account", response -> {
	      context.assertEquals(201, response.statusCode());
	      client.close();
	      async.complete();
	    }).putHeader("content-type", "application/json").end(Json.encodePrettily(account));
	  }

	  @Test
	  public void testGet(TestContext context) throws Exception {
	    HttpClient client = vertx.createHttpClient();
	    Async async = context.async();
	    client.getNow(PORT, "localhost", "/account/"+ID, response -> response.bodyHandler(body -> {
	      Account account  =  new Account(new JsonObject(body.getString(0, body.length())));
	      context.assertTrue(!account.getUsername().isEmpty());
	      client.close();
	      async.complete();
	    }));
	  }

	  @Test(timeout = 3000L)
	  public void testUpdateAndDelete(TestContext context) throws Exception {
	    HttpClient client = vertx.createHttpClient();
	    Async async = context.async();
	    
	    Account account = new Account();
	    account.setId(1);
		  String tempUsername = String.valueOf(System.currentTimeMillis());
	    account.setUsername(tempUsername);
	    account.setPassword(String.valueOf(System.currentTimeMillis()));
	    client.request(HttpMethod.PATCH, PORT, "localhost", "/account/"+ID, response -> response.bodyHandler(body -> {
	      context.assertEquals(new Account(body.toString()).getUsername(),tempUsername);
	      client.request(HttpMethod.DELETE, PORT, "localhost", "/account/"+ID, rsp -> {
	        context.assertEquals(204, rsp.statusCode());
	        async.complete();
	      }).end();
	      
	    })).putHeader("content-type", "application/json").end(Json.encodePrettily(account));
	  }
	  
	 

}
