package com.reachauto.device.impl;

import com.reachauto.common.service.JdbcRepositoryWrapper;
import com.reachauto.device.Device;
import com.reachauto.device.DeviceService;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * Created by zouqiang on 23/10/2016.
 */
public class DeviceServiceImpl extends JdbcRepositoryWrapper implements DeviceService {

    private static final String FETCH_STATEMENT = "";

    public DeviceServiceImpl(Vertx vertx, JsonObject config) {
        super(vertx, config);
    }

    @Override
    public DeviceService addDevice(Device device, Handler<AsyncResult<Void>> resultHandler) {
        return null;
    }

    @Override
    public DeviceService deleteDevice(String id, Handler<AsyncResult<Void>> resultHandler) {
        return null;
    }

    @Override
    public DeviceService updateDevice(Device device, Handler<AsyncResult<Device>> resultHandler) {
        return null;
    }

    @Override
    public DeviceService retrieveDevice(String id, Handler<AsyncResult<Device>> resultHandler) {
        this.retrieveOne(id,FETCH_STATEMENT).map(option -> option.map(Device::new).orElse(null)).setHandler(resultHandler);
        return this;
    }
}
