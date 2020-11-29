package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.Movie;


public class ResultValidator {
    private ResultBase base;
    public ResultValidator(ResultBase result) {
        this.base = result;
    }

    public boolean isValid(ResultCode code) {
        return isInstance(code);
    }

    private boolean isInstance(ResultCode code) {
        if (base instanceof OkResult && base.getCode() == ResultCode.OK) {
            return code == ResultCode.OK;
        } else if (base instanceof NotFoundResult && base.getCode() == ResultCode.NOT_FOUND) {
            return code == ResultCode.NOT_FOUND;
        } else if (base instanceof ServiceUnavailableResult && base.getCode() == ResultCode.SERVICE_UNAVAILABLE) {
            return code == ResultCode.SERVICE_UNAVAILABLE;
        } else if (base instanceof UnauthorizedResult && base.getCode() == ResultCode.UNAUTHORIZED) {
            return code == ResultCode.UNAUTHORIZED;
        } else if (base instanceof CachedResult && base.getCode() == ResultCode.NOT_MODIFIED) {
            return code == ResultCode.NOT_MODIFIED;
        } else {
            return false;
        }
    }

}
