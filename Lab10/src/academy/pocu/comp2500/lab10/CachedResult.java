package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class CachedResult extends ResultBase {
    private int expiryCount;

    public CachedResult(int exprireCount) {
        super(ResultCode.NOT_MODIFIED);
        this.expiryCount = exprireCount;
    }

    public int getExpiryCount() {
        System.out.println(expiryCount);
        return this.expiryCount;
    }
}
