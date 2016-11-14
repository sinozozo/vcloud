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

package com.reachauto.product.rxjava;

import java.util.Map;
import rx.Observable;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import com.reachauto.product.Product;

/**
 * Created by zouqiang on 2016/11/8.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link com.reachauto.product.ProductService original} non RX-ified interface using Vert.x codegen.
 */

public class ProductService {

  final com.reachauto.product.ProductService delegate;

  public ProductService(com.reachauto.product.ProductService delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public ProductService addProduct(Product product, Handler<AsyncResult<Void>> resultHandler) { 
    delegate.addProduct(product, resultHandler);
    return this;
  }

  public Observable<Void> addProductObservable(Product product) { 
    io.vertx.rx.java.ObservableFuture<Void> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    addProduct(product, resultHandler.toHandler());
    return resultHandler;
  }

  public ProductService deleteProduct(Integer id, Handler<AsyncResult<Void>> resultHandler) { 
    delegate.deleteProduct(id, resultHandler);
    return this;
  }

  public Observable<Void> deleteProductObservable(Integer id) { 
    io.vertx.rx.java.ObservableFuture<Void> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    deleteProduct(id, resultHandler.toHandler());
    return resultHandler;
  }

  public ProductService updateProduct(Product product, Handler<AsyncResult<Product>> resultHandler) { 
    delegate.updateProduct(product, resultHandler);
    return this;
  }

  public Observable<Product> updateProductObservable(Product product) { 
    io.vertx.rx.java.ObservableFuture<Product> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    updateProduct(product, resultHandler.toHandler());
    return resultHandler;
  }

  public ProductService retrieveProduct(Integer id, Handler<AsyncResult<Product>> resultHandler) { 
    delegate.retrieveProduct(id, resultHandler);
    return this;
  }

  public Observable<Product> retrieveProductObservable(Integer id) { 
    io.vertx.rx.java.ObservableFuture<Product> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    retrieveProduct(id, resultHandler.toHandler());
    return resultHandler;
  }


  public static ProductService newInstance(com.reachauto.product.ProductService arg) {
    return arg != null ? new ProductService(arg) : null;
  }
}
