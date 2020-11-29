package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public class AuthorizationMiddleware implements IRequestHandler {
    private IRequestHandler requestHandler;
    private HashSet<User> users;

    public AuthorizationMiddleware(IRequestHandler requestHandler, HashSet<User> users) {
        this.requestHandler = requestHandler;
        this.users = users;
    }

    public ResultBase handle(Request request) {
        boolean isAuthorized = false;

        if (users == null || users.size() == 0) {
            return new UnauthorizedResult();
        } else if (users.size() > 0) {
            for (User user : users) {
                if (user.equals(request.getUser())) {
                    isAuthorized = true;
                    break;
                }
            }
        }

        if (!isAuthorized) {
            return new UnauthorizedResult();
        } else {
            return this.requestHandler.handle(request);
        }
    }
}
