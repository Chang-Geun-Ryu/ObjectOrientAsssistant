package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class MaintenanceMiddleware implements IRequestHandler {
    private IRequestHandler store;
    private OffsetDateTime time;
    private ServiceUnavailableResult serviceUnavailableResult;

    public MaintenanceMiddleware(IRequestHandler store, OffsetDateTime time) {
        this.store = store;
        this.time = time;
        OffsetDateTime end = time.plusHours(1);
        this.serviceUnavailableResult = new ServiceUnavailableResult(time, end);
    }

    @Override
    public ResultBase handle(Request request) {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        if (serviceUnavailableResult.getStartDateTime().isBefore(now) &&
                serviceUnavailableResult.getEndDateTime().isAfter(now)) {
            return serviceUnavailableResult;
        } else {
            return store.handle(request);
        }
    }

//    private boolean isMaintenance() {
//
//        return serviceUnavailableResult.getStartDateTime().isBefore(now) &&
//                serviceUnavailableResult.getEndDateTime().isAfter(now);
//    }
}
