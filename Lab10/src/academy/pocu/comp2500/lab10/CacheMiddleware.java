package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.ArrayList;
import java.util.HashMap;

public class CacheMiddleware implements IRequestHandler {
    private IRequestHandler store;
    private int expiryMax;
    private HashMap<Request, Integer> cache = new HashMap<>();

    public CacheMiddleware(IRequestHandler store, int expiryCount) {
        this.store = store;
        this.expiryMax = expiryCount;
    }

    @Override
    public ResultBase handle(Request request) {
        if (cache.containsKey(request)) {
            int expireCount = cache.get(request) - 1;

            if (expireCount > 1) {
                cache.replace(request, expireCount);
            } else {//if (expireCount == 0) {
                cache.remove(request);
            }

            return new CachedResult(expireCount);
        } else {
            ResultBase base = store.handle(request);

            if (base.getCode() == ResultCode.OK && base instanceof OkResult) {
                if (expiryMax > 1) {
                    cache.put(request, expiryMax);
                }
            }

            return base;
        }
    }
}
