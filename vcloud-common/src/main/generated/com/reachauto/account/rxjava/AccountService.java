/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.reachauto.account.rxjava;

import java.util.Map;
import rx.Observable;
import com.reachauto.account.Account;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Created by zouqiang on 27/10/2016.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link com.reachauto.account.AccountService original} non RX-ified interface using Vert.x codegen.
 */

public class AccountService {

  final com.reachauto.account.AccountService delegate;

  public AccountService(com.reachauto.account.AccountService delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public AccountService addAccount(Account account, Handler<AsyncResult<Void>> resultHandler) { 
    delegate.addAccount(account, resultHandler);
    return this;
  }

  public Observable<Void> addAccountObservable(Account account) { 
    io.vertx.rx.java.ObservableFuture<Void> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    addAccount(account, resultHandler.toHandler());
    return resultHandler;
  }

  public AccountService deleteAccount(Integer id, Handler<AsyncResult<Void>> resultHandler) { 
    delegate.deleteAccount(id, resultHandler);
    return this;
  }

  public Observable<Void> deleteAccountObservable(Integer id) { 
    io.vertx.rx.java.ObservableFuture<Void> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    deleteAccount(id, resultHandler.toHandler());
    return resultHandler;
  }

  public AccountService updateAccount(Account account, Handler<AsyncResult<Account>> resultHandler) { 
    delegate.updateAccount(account, resultHandler);
    return this;
  }

  public Observable<Account> updateAccountObservable(Account account) { 
    io.vertx.rx.java.ObservableFuture<Account> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    updateAccount(account, resultHandler.toHandler());
    return resultHandler;
  }

  public AccountService retrieveAccount(Integer id, Handler<AsyncResult<Account>> resultHandler) { 
    delegate.retrieveAccount(id, resultHandler);
    return this;
  }

  public Observable<Account> retrieveAccountObservable(Integer id) { 
    io.vertx.rx.java.ObservableFuture<Account> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    retrieveAccount(id, resultHandler.toHandler());
    return resultHandler;
  }


  public static AccountService newInstance(com.reachauto.account.AccountService arg) {
    return arg != null ? new AccountService(arg) : null;
  }
}
