package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {
    public SafeWallet(User user) throws IllegalAccessException {
        super(user);
    }

    @Override
    public boolean deposit(int amount) {
        if (!super.deposit(amount)) {
            return false;
        }

        if (this.getAmount() < 0) {
            super.deposit(amount * -1);
            throw new OverflowException("통장에 돈이 너무너무 많아요");
        }

        return true;
    }
}
