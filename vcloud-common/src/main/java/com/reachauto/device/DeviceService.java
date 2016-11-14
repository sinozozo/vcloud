package com.reachauto.device;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Created by zouqiang on 23/10/2016.
 */
@VertxGen
@ProxyGen
public interface DeviceService {

    public static final String SERVICE_ADDRESS = "service.device";
    public static final String SERVICE_NAME = "device-eb-service";

    @Fluent
    DeviceService addDevice(Device device, Handler<AsyncResult<Void>> resultHandler);

    @Fluent
    DeviceService deleteDevice(String id ,Handler<AsyncResult<Void>> resultHandler);

    @Fluent
    DeviceService updateDevice(Device device,Handler<AsyncResult<Device>> resultHandler);


    @Fluent
    DeviceService retrieveDevice(String id,Handler<AsyncResult<Device>> resultHandler);

}
