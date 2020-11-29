package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;

public class CacheMiddleware implements IRequestHandler {
    private IRequestHandler requestHandler;
    private ArrayList<Request> requests;
    private ArrayList<Integer> remainingCounts;
    private int cacheExpiryCount;

    public CacheMiddleware(IRequestHandler requestHandler, int count) {
        this.requestHandler = requestHandler;
        this.cacheExpiryCount = count;
        this.requests = new ArrayList<Request>();
        this.remainingCounts = new ArrayList<Integer>();
    }

    public ResultBase handle(Request request) {
        ResultBase resultBase = this.requestHandler.handle(request);

        if (resultBase instanceof OkResult) {
            boolean hasSameRequestInCache = false;
            int existingRequestIndex = -1;

            for (int i = 0; i < requests.size(); ++i) {
                Request req = requests.get(i);
                if (req.getMovieName().equals(request.getMovieName())) {
                    if (request.getUser() == null) {
                        if (req.getUser() == null) {
                            hasSameRequestInCache = true;
                            existingRequestIndex = i;
                            break;
                        }
                    } else if (req.getUser() != null && req.getUser().equals(request.getUser())) {
                        hasSameRequestInCache = true;
                        existingRequestIndex = i;
                        break;
                    }
                }
            }

            if (!hasSameRequestInCache) {
                requests.add(request);
                remainingCounts.add(this.cacheExpiryCount);
                return resultBase;
            } else {
                int currentRequestRemainingCount = this.remainingCounts.get(existingRequestIndex);
                if (currentRequestRemainingCount > 1) {
                    this.remainingCounts.set(existingRequestIndex, currentRequestRemainingCount - 1);
                    return new CachedResult(currentRequestRemainingCount - 1);
                } else {
                    this.remainingCounts.set(existingRequestIndex, this.cacheExpiryCount);
                    return resultBase;
                }
            }
        } else {
            return resultBase;
        }
    }
}
