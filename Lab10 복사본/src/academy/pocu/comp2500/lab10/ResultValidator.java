package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.Movie;


public class ResultValidator {
    private ResultBase result;
    public ResultValidator(ResultBase result) {
        this.result = result;
    }

    public boolean isValid(ResultCode resultCode) {

        if (result instanceof OkResult) {
            OkResult okResult = (OkResult) result;

            if (okResult.getMovie() instanceof Movie) {
                if (okResult.getCode() == resultCode) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (result instanceof NotFoundResult) {
            NotFoundResult notFoundResult = (NotFoundResult) result;

            if (notFoundResult.getCode() == resultCode) {
                return true;
            }

            return false;
        }

        if (result instanceof UnauthorizedResult) {
            UnauthorizedResult unauthorizedResult = (UnauthorizedResult) result;

            if (unauthorizedResult.getCode() == resultCode && unauthorizedResult.getErrorMessage().equals("Unauthorized access")) {
                return true;
            } else {
                return false;
            }
        }

        if (result instanceof CachedResult) {
            CachedResult cachedResult = (CachedResult) result;

            if (cachedResult.getCode() == resultCode) {
                return true;
            } else {
                return false;
            }
        }

        if (result instanceof ServiceUnavailableResult) {
            ServiceUnavailableResult serviceUnavailableResult = (ServiceUnavailableResult) result;

            if (serviceUnavailableResult.getCode() == resultCode) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
