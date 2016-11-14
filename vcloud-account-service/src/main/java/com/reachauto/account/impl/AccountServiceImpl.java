package com.reachauto.account.impl;

import com.reachauto.account.Account;
import com.reachauto.account.AccountService;
import com.reachauto.common.service.JdbcRepositoryWrapper;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zouqiang on 2016/10/27.
 */
public class AccountServiceImpl extends JdbcRepositoryWrapper implements AccountService {

    public static final String INSERT_STATEMENT = "INSERT INTO account(`account`.`username`,`account`.`password`,`account`.`create_date`,`account`.`del_flag`) VALUES (?,?,?,?)";
    public static final String DELETE_STATEMENT = "UPDATE account SET del_flag = " + Account.DEL_FLAG_DELETE + " WHERE id = ?";
    public static final String FETCH_STATEMENT = "SELECT * FROM account WHERE id = ?";
    private static final String UPDATE_STATEMENT = "UPDATE account SET username = ?,password = ? WHERE id = ?";

    public AccountServiceImpl(Vertx vertx, JsonObject config) {
        super(vertx, config);
    }

    @Override
    public AccountService addAccount(Account account, Handler<AsyncResult<Void>> resultHandler) {
        JsonArray params = new JsonArray();
        params.add(account.getUsername());
        params.add(account.getPassword());
        params.add(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        params.add(account.getDelFlag());
        executeNoResult(params, INSERT_STATEMENT, resultHandler);
        return this;
    }

    @Override
    public AccountService deleteAccount(Integer id, Handler<AsyncResult<Void>> resultHandler) {
//        this.removeOne(id, DELETE_STATEMENT, resultHandler);
//        return this;
        JsonArray params = new JsonArray();
        params.add(id);
        executeNoResult(params, DELETE_STATEMENT, resultHandler);
        return this;
    }

    @Override
    public AccountService updateAccount(Account account, Handler<AsyncResult<Account>> resultHandler) {
        JsonArray params = new JsonArray();
        params.add(account.getUsername());
        params.add(account.getPassword());
        params.add(account.getId());
        execute(params, UPDATE_STATEMENT, account, resultHandler);
        return this;
    }

    @Override
    public AccountService retrieveAccount(Integer id, Handler<AsyncResult<Account>> resultHandler) {
        retrieveOne(id, FETCH_STATEMENT).map(option -> option.map(Account::new).orElse(null)).setHandler(resultHandler);
        return this;
    }


}
