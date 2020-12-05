package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {
    public SafeWallet(User user) throws IllegalAccessException {
        super(user);
    }

    public boolean deposit(final int amount) throws OverflowException {
        int superAmount = super.getAmount();
        if (amount > Integer.MAX_VALUE - superAmount) {
            throw new OverflowException("Amount was overflowed");
        } else {
            return super.deposit(amount);
        }

    }
}
