package academy.pocu.comp2500.lab10.app;

import academy.pocu.comp2500.lab10.ResultValidator;
import academy.pocu.comp2500.lab10.UnauthorizedResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        UnauthorizedResult result = new UnauthorizedResult();

        ResultValidator validator = new ResultValidator(result);

        boolean b = validator.isValid(ResultCode.UNAUTHORIZED); // true
        boolean b1 = validator.isValid(ResultCode.OK); // false
    }
}
