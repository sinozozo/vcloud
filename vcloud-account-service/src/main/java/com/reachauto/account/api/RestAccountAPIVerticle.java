package com.reachauto.account.api;

import com.reachauto.account.Account;
import com.reachauto.account.AccountService;
import com.reachauto.common.RestAPIVerticle;

import io.vertx.core.Future;
import io.vertx.core.Verticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Created by zouqiang on 2016/10/30.
 */
public class RestAccountAPIVerticle extends RestAPIVerticle {

	private static final String API_ADD = "/account";
	private static final String API_RETRIEVE = "/account/:id";
	private static final String API_RETRIEVE_ALL = "/account";
	private static final String API_UPDATE = "/account/:id";
	private static final String API_DELETE = "/account/:id";
	private static final String SERVICE_NAME = "account-rest-api";
	AccountService accountService;

	public RestAccountAPIVerticle(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	  public void start(Future<Void> future) throws Exception {
	    super.start();
	    final Router router = Router.router(vertx);
	    // body handler
	    router.route().handler(BodyHandler.create());
	    // api route handler
	    router.post(API_ADD).handler(this::apiAddUser);
	    router.get(API_RETRIEVE).handler(this::apiRetrieveUser);
	    router.get(API_RETRIEVE_ALL).handler(this::apiRetrieveAll);
	    router.patch(API_UPDATE).handler(this::apiUpdateUser);
	    router.delete(API_DELETE).handler(this::apiDeleteUser);

	    String host = config().getString("user.account.http.address", "0.0.0.0");
	    int port = config().getInteger("user.account.http.port", 8081);

	    // create HTTP server and publish REST service
	    createHttpServer(router, host, port)
	      .compose(serverCreated -> publishHttpEndpoint(SERVICE_NAME, host, port))
	      .setHandler(future.completer());
	  }

	private void apiAddUser(RoutingContext context) {
		Account account = new Account(context.getBodyAsJson());
	    accountService.addAccount(account, resultVoidHandler(context, 201));

	}

	private void apiRetrieveUser(RoutingContext context) {
		String id = context.request().getParam("id");
		accountService.retrieveAccount(Integer.valueOf(id), resultHandlerNonEmpty(context));
	}

	private void apiRetrieveAll(RoutingContext context) {

	}

	private void apiUpdateUser(RoutingContext context) {
		Account account = new Account(context.getBodyAsJson());
		accountService.updateAccount(account, resultHandlerNonEmpty(context));
	}

	private void apiDeleteUser(RoutingContext context) {
		String id = context.request().getParam("id");
		accountService.deleteAccount(Integer.valueOf(id), deleteResultHandler(context));
	}

}
