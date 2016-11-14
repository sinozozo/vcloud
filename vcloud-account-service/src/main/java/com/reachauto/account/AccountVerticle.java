package com.reachauto.account;

import com.reachauto.account.api.RestAccountAPIVerticle;
import com.reachauto.account.impl.AccountServiceImpl;
import com.reachauto.common.BaseMicroserviceVerticle;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ProxyHelper;

import static com.reachauto.account.AccountService.SERVICE_ADDRESS;
import static com.reachauto.account.AccountService.SERVICE_NAME;

/**
 * Created by zouqiang on 27/10/2016.
 */
public class AccountVerticle extends BaseMicroserviceVerticle {

    AccountService accountService;

    @Override
    public void start(Future<Void> future) throws Exception {
    	super.start();
        accountService = new AccountServiceImpl(vertx, config());
        //regist the service proxy on event bus
        ProxyHelper.registerService(AccountService.class, vertx, accountService, SERVICE_ADDRESS);

        publishEventBusService(SERVICE_NAME, SERVICE_ADDRESS, AccountService.class)
                .compose(servicePublished -> deployRestVerticle())
                .setHandler(future.completer());
        
        
    }

    private Future<Void> deployRestVerticle() {
        Future<String> future = Future.future();
        vertx.deployVerticle(new RestAccountAPIVerticle(accountService),
                new DeploymentOptions().setConfig(config()),
                future.completer());
        return future.map(r -> null);
    }
    
    
    
    public static void main(String[] args) throws InterruptedException{
    	Vertx vertx = Vertx.vertx();
		DeploymentOptions options = new DeploymentOptions().setConfig(
				new JsonObject().put("url", "jdbc:mysql://localhost/vcloud?characterEncoding=UTF-8&useSSL=false")
						.put("driver_class", "com.mysql.cj.jdbc.Driver").put("user", "root1").put("password", "root")
						.put("max_pool_size", 30));
		
		
		vertx.deployVerticle(AccountVerticle.class.getName(), options);
		Thread.sleep(5000);
		vertx.close();
    }

}
