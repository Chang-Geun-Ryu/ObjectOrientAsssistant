package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.Department;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

import java.util.HashSet;

public class SafeWallet extends Wallet {

    public SafeWallet(final User user) throws IllegalAccessException {
        super(user);
    }

    @Override
    public boolean deposit(final int amount) {
        boolean result = super.deposit(amount);

        if (this.getAmount() + 100 < 0) {
            throw new OverflowException("Overflow!");
        }

        return result;
    }
}
