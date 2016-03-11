package vertx.first;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MyVerticle extends AbstractVerticle {
	@Override 
	public void start(Future<Void> future) {
		vertx
			.createHttpServer()
			.requestHandler(r -> {
				r.response().end("This is my first app");
			})
			.listen(8080,result -> {
				if(result.succeeded()){
					future.complete();
				}
				else {
					future.fail(result.cause());
				}
			});
	}
}

