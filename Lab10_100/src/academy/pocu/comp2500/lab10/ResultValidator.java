package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    private ResultBase base;

    public ResultValidator(ResultBase base) {
        this.base = base;
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

//        if (base.getCode() == code && base instanceof OkResult) {
//            return true;
//        } else if (base.getCode() == code && base instanceof NotFoundResult) {
//            return true;
//        } else if (base.getCode() == code && base instanceof ServiceUnavailableResult) {
//            return true;
//        } else if (base.getCode() == code && base instanceof UnauthorizedResult) {
//            return true;
//        } else if (base.getCode() == code && base instanceof CachedResult) {
//            return true;
//        } else {
//            return false;
//        }
    }
}
