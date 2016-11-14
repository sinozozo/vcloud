
package com.reachauto.device;

import static com.reachauto.device.DeviceService.SERVICE_ADDRESS;
import static com.reachauto.device.DeviceService.SERVICE_NAME;

import java.util.ArrayList;
import java.util.List;

import com.reachauto.common.BaseMicroserviceVerticle;
import com.reachauto.device.api.RestDeviceAPIVerticle;
import com.reachauto.device.impl.DeviceServiceImpl;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ProxyHelper;

/**
 * Created by zouqiang on 23/10/2016.
 */
public class DeviceVerticle extends BaseMicroserviceVerticle {

	private DeviceService deviceService;

	@Override
	public void start(Future<Void> future) throws Exception {
		super.start();

		// create the service instance
		deviceService = new DeviceServiceImpl(vertx, config());
		// regist the service proxy on event bus
		ProxyHelper.registerService(DeviceService.class, vertx, deviceService, SERVICE_ADDRESS);

		publishEventBusService(SERVICE_NAME, SERVICE_ADDRESS, DeviceService.class)
				.compose(servicePublished -> deployRestVerticle()).setHandler(future.completer());
	}

	private Future<Void> deployRestVerticle() {
		Future<String> future = Future.future();
		vertx.deployVerticle(new RestDeviceAPIVerticle(deviceService), new DeploymentOptions().setConfig(config()),
				future.completer());
		return future.map(r -> null);
	}

	 public static void main(String[] args){
	    	Vertx vertx = Vertx.vertx();
			DeploymentOptions options = new DeploymentOptions().setConfig(
					new JsonObject().put("url", "jdbc:mysql://localhost/vcloud?characterEncoding=UTF-8&useSSL=false")
							.put("driver_class", "com.mysql.cj.jdbc.Driver").put("user", "root").put("password", "root")
							.put("max_pool_size", 30));

			vertx.deployVerticle(DeviceVerticle.class.getName(), options);
	    }

}
