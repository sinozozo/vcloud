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

package com.reachauto.device.rxjava;

import java.util.Map;
import rx.Observable;
import com.reachauto.device.Device;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Created by zouqiang on 23/10/2016.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link com.reachauto.device.DeviceService original} non RX-ified interface using Vert.x codegen.
 */

public class DeviceService {

  final com.reachauto.device.DeviceService delegate;

  public DeviceService(com.reachauto.device.DeviceService delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public DeviceService addDevice(Device device, Handler<AsyncResult<Void>> resultHandler) { 
    delegate.addDevice(device, resultHandler);
    return this;
  }

  public Observable<Void> addDeviceObservable(Device device) { 
    io.vertx.rx.java.ObservableFuture<Void> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    addDevice(device, resultHandler.toHandler());
    return resultHandler;
  }

  public DeviceService deleteDevice(String id, Handler<AsyncResult<Void>> resultHandler) { 
    delegate.deleteDevice(id, resultHandler);
    return this;
  }

  public Observable<Void> deleteDeviceObservable(String id) { 
    io.vertx.rx.java.ObservableFuture<Void> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    deleteDevice(id, resultHandler.toHandler());
    return resultHandler;
  }

  public DeviceService updateDevice(Device device, Handler<AsyncResult<Device>> resultHandler) { 
    delegate.updateDevice(device, resultHandler);
    return this;
  }

  public Observable<Device> updateDeviceObservable(Device device) { 
    io.vertx.rx.java.ObservableFuture<Device> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    updateDevice(device, resultHandler.toHandler());
    return resultHandler;
  }

  public DeviceService retrieveDevice(String id, Handler<AsyncResult<Device>> resultHandler) { 
    delegate.retrieveDevice(id, resultHandler);
    return this;
  }

  public Observable<Device> retrieveDeviceObservable(String id) { 
    io.vertx.rx.java.ObservableFuture<Device> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    retrieveDevice(id, resultHandler.toHandler());
    return resultHandler;
  }


  public static DeviceService newInstance(com.reachauto.device.DeviceService arg) {
    return arg != null ? new DeviceService(arg) : null;
  }
}
