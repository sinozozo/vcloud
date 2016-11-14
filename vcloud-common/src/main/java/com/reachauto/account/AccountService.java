package com.reachauto.account;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Created by zouqiang on 27/10/2016.
 */
@VertxGen
@ProxyGen
public interface AccountService {

    public static final String SERVICE_ADDRESS = "service.account";
    public static final String SERVICE_NAME = "account-eb-service";

    @Fluent
    AccountService addAccount(Account account, Handler<AsyncResult<Void>> resultHandler);

    @Fluent
    AccountService deleteAccount(Integer id,Handler<AsyncResult<Void>> resultHandler);

    @Fluent
    AccountService updateAccount(Account account, Handler<AsyncResult<Account>> resultHandler);

    @Fluent
    AccountService retrieveAccount(Integer id, Handler<AsyncResult<Account>> resultHandler);

}
