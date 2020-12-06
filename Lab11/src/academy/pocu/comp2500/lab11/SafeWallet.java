package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {

    public SafeWallet(User user) throws IllegalAccessException {
        super(user);
    }

    @Override
    public boolean deposit(int amount) {
        int resultInt = super.getAmount() + amount;
        long resultLong = super.getAmount() + amount;

        if ((long) resultInt != resultLong) {
            throw new OverflowException("OVERFLOW!");
        }

        return super.deposit(amount);
    }
}
