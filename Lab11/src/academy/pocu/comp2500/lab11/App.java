package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class App {
    private User user;

    public App() {
        user = new User();
    }

    public void run(BufferedReader in, PrintStream out, PrintStream err) {

        WarehouseType warehouseType;
        SafeWallet wallet;
        Warehouse warehouse;

        while (true) {
            out.println("WAREHOUSE: Choose your warehouse!");
            out.printf("%d. %s", 1, WarehouseType.APPLE);
            out.println();
            out.printf("%d. %s", 2, WarehouseType.MICROSOFT);
            out.println();
            out.printf("%d. %s", 3, WarehouseType.SAMSUNG);
            out.println();
            String inputString = readWarehouseType(in);


            if (inputString.equals("1")) {
                warehouseType = WarehouseType.APPLE;


            } else if (inputString.equals("2")) {
                warehouseType = WarehouseType.MICROSOFT;


            } else if (inputString.equals("3")) {
                warehouseType = WarehouseType.SAMSUNG;


            } else if (inputString.equals("exit")) {
                return;
            } else {
                continue;
            }
            wallet = readSafeWallet(user);

            if (wallet == null) {
                err.println("AUTH_ERROR");
                return;
            }
            break;

        }

        warehouse = readWarehouse(warehouseType);
        while (true) {

            out.printf("BALANCE: ");
            out.println(wallet.getAmount());

            out.println("PRODUCT_LIST: Choose the product you want to buy!");
            ArrayList<Product> products = warehouse.getProducts();
            for (int i = 0; i < products.size(); i++) {
                out.printf("%d. ", i + 1);
                out.printf("%-17s%3d", products.get(i).getName(), products.get(i).getPrice());
                out.printf(System.lineSeparator());
            }
            int input = readProduct(in);
            if (input == -99) {
                return;
            }
            if (input < 0 || input > products.size()) {
                continue;
            }
            Product wantProduct = products.get(input - 1);
            int amount = wallet.getAmount();
            if (wantProduct.getPrice() > amount) {
                continue;
            }
            int price = wantProduct.getPrice();
            wallet.withdraw(price);

            try {
                warehouse.removeProduct(wantProduct.getId());
            } catch (ProductNotFoundException e) {
                wallet.deposit(price);
                continue;
            }
            return;

        }

    }


    private String readWarehouseType(BufferedReader in) {
        try {
            String inputString = in.readLine();
            if (inputString.equals("1") || inputString.equals("2") || inputString.equals("3") || inputString.equals("exit")) {
                return inputString;
            } else {
                return "null";
            }

        } catch (IOException e) {
            return "null";
        }
    }

    private SafeWallet readSafeWallet(User user) {

        SafeWallet safeWallet;

        try {
            safeWallet = new SafeWallet(user);
            return safeWallet;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    private Warehouse readWarehouse(WarehouseType warehouseType) {
        Warehouse warehouse;
        try {
            warehouse = new Warehouse(warehouseType);
            return warehouse;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private int readProduct(BufferedReader in) {
        try {
            String inputString = in.readLine();
            if (inputString.equals("exit")) {
                return -99;
            }
            try {
                int inputValue = Integer.parseInt(inputString);
                return inputValue;
            } catch (NumberFormatException e) {
                return -1;
            }
        } catch (IOException e) {
            return -1;
        }
    }

}
