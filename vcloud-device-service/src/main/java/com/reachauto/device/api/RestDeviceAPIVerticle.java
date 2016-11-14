package com.reachauto.device.api;

import com.reachauto.common.RestAPIVerticle;
import com.reachauto.device.DeviceService;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Created by zouqiang on 24/10/2016.
 */
public class RestDeviceAPIVerticle extends RestAPIVerticle{

    public static final String SERVICE_NAME = "device-rest-api";

    private DeviceService deviceService;

    public static final String API_ADD="/devices";
    public static final String API_RETRIEVE="/devices/:device_id";
    public static final String API_UPDATE="/devices/:device_id";
    public static final String API_DELETE="/devices/:device_id";


    public RestDeviceAPIVerticle(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);
        final Router router = Router.router(vertx);
        //body route handler
        router.route().handler(BodyHandler.create());
        //api route handler
        router.post(API_ADD).handler(this::apiAddDivice);
        router.post(API_RETRIEVE).handler(this::apiRetrieveDivice);
        router.post(API_UPDATE).handler(this::apiUpdateDivice);
        router.post(API_DELETE).handler(this::apiDeleteDivice);

        String host = config().getString("device.http.address","0.0.0.0");
        int port = config().getInteger("device.http.port",8081);

        //create HTTP server and publish REST service
        createHttpServer(router,host,port)
                .compose(serverCreated -> publishHttpEndpoint(SERVICE_NAME,host,port))
                .setHandler(startFuture.completer());
    }

    private void apiDeleteDivice(RoutingContext routingContext) {
    }

    private void apiUpdateDivice(RoutingContext routingContext) {
    }

    private void apiRetrieveDivice(RoutingContext routingContext) {
    }

    private void apiAddDivice(RoutingContext routingContext) {
    }
}
