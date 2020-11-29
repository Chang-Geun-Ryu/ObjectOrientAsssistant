package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class MaintenanceMiddleware implements IRequestHandler {
    private static final int MAINTENANCE_TIME = 1;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private IRequestHandler requestHandler;

    public MaintenanceMiddleware(IRequestHandler requestHandler, OffsetDateTime startTime) {
        this.requestHandler = requestHandler;
        this.startTime = startTime;
        this.endTime = startTime.plusHours(MAINTENANCE_TIME);
    }

    public ResultBase handle(Request request) {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        if (now.compareTo(this.startTime) >= 0 && this.endTime.compareTo(now) > 0) {
            return new ServiceUnavailableResult(this.startTime, this.endTime);
        } else {
            return this.requestHandler.handle(request);
        }
    }
}
