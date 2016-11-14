import io.vertx.core.Future;

public class Test {

	public static void main(String[] args){
		Future<Object> future = Future.future();
	    future.complete(null);
	    future.result();
	}
}
