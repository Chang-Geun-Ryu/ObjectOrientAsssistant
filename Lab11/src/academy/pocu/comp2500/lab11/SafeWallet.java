package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {
    public SafeWallet(final User user) throws IllegalAccessException {
        super(user);
    }

    public boolean deposit(final int amount) {
//        if (amount <= 0) {
//            return false;
//        }
//
//        int balanceAfterDeposit = this.getAmount() + amount;
//
//        if (balanceAfterDeposit < this.getAmount()) {
//            throw new OverflowException("Overflow Error");
//        }
//
//        super.deposit(amount);
//
//        return true;
        if (amount < 0) {
            return false;
        }

        if (getAmount() > 0) {
            if ((long) getAmount() + (long) amount > Integer.MAX_VALUE) {
                throw new OverflowException("OverFlow amount");
            }
        } else {
            if ((long) getAmount() + (long) amount > Integer.MAX_VALUE) {
                throw new OverflowException("OverFlow amount");
            }
        }

        return super.deposit(amount);
    }
}
