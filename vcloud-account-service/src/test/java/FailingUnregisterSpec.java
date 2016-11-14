import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class FailingUnregisterSpec {

  @Test
  public void test(final TestContext context) {
    final Vertx vertx = Vertx.vertx();
    final Async async = context.async();

    vertx.deployVerticle(TestVerticle.class.getName(), ar -> {
      vertx.undeploy(ar.result(), context.asyncAssertSuccess());
      async.complete();
    });
  }

  public static class TestVerticle extends AbstractVerticle {
    private MessageConsumer<Object> consumer;

    @Override
    public void start() throws Exception {
      consumer = vertx.eventBus().consumer("test", msg -> {
      });
    }

    @Override
    public void stop() throws Exception {
      // manual unregister gets rid of the problem
      //consumer.unregister();
    }
  }
}