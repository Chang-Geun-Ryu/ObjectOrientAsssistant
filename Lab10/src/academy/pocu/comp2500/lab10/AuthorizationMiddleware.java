package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;
import java.util.HashSet;

public class AuthorizationMiddleware implements IRequestHandler {
    private IRequestHandler store;
    private HashSet<User> users;

    public AuthorizationMiddleware(IRequestHandler store, HashSet<User> users) {
        this.store = store;
        this.users = users;
    }

    @Override
    public ResultBase handle(Request request) {
        if (request.getUser() != null && this.users.contains(request.getUser())) {
            return store.handle(request);
        } else {
            return new UnauthorizedResult();
        }
    }
}
