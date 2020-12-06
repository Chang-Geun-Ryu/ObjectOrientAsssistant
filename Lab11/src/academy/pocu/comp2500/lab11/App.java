package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.WarehouseType;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Department;
import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.ProductNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class App {
    public void run(BufferedReader in, PrintStream out, PrintStream err) {
        int warehouseTypeCount = WarehouseType.values().length;
        ArrayList<WarehouseType> warehouseTypes = new ArrayList<WarehouseType>();

        WarehouseType warehouseTypeSelected = null;
        int parsedInteger = -1;

        while (true) {
            try {
                int counter = 1;
                out.println("WAREHOUSE: Choose your warehouse!");
                for (WarehouseType warehouseType : WarehouseType.values()) {
                    out.print(counter);
                    out.print(". ");
                    out.println(warehouseType);
                    warehouseTypes.add(warehouseType);

                    counter += 1;
                }
                String choice = in.readLine();

                try {
                    if (choice.equals("exit")) {
                        return;
                    }

                    parsedInteger = Integer.parseInt(choice);

                    if (parsedInteger > 0 && parsedInteger <= warehouseTypeCount) {
                        int index = parsedInteger - 1;
                        warehouseTypeSelected = warehouseTypes.get(index);
                        break;
                    } else {
                    }
                } catch (NumberFormatException e) {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        User user = new User();
        Department department = user.getDepartment();

        SafeWallet wallet = null;

        try {
            wallet = new SafeWallet(user);
        } catch (IllegalAccessException e) {
            err.println("AUTH_ERROR");
            return;
        }

        int amount;

//        if (wallet.getAmount() < 0) {
//            throw new OverflowException("Overflow Error");
//        }

        amount = wallet.getAmount();

        out.println("BALANCE: " + amount);

        boolean isRepeat = false;

        parsedInteger = -1;

        Warehouse warehouse = new Warehouse(warehouseTypeSelected);
        Product productSelected = null;

        while (true) {
            amount = wallet.getAmount();

            ArrayList<Product> products = warehouse.getProducts();
            String choice = null;

            if (isRepeat) {
                out.println("BALANCE: " + amount);
            } else {
                isRepeat = true;
            }

            int counter = 1;
            int productsCount = products.size();
            out.println("PRODUCT_LIST: Choose the product you want to buy!");
            for (int i = 0; i < productsCount; ++i) {
                out.print(counter);
                out.print(". ");
                out.println(String.format("%-16s", products.get(i).getName()) + String.format("%4d", products.get(i).getPrice()));

                counter += 1;
            }

            try {
                choice = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (choice.equals("exit")) {
                return;
            }

            boolean isValidNum = true;

            for (int i = 0; i < choice.length(); i++) {
                if (!Character.isDigit(choice.charAt(i))) {
                    isValidNum = false;
                    break;
                }
            }

            System.out.println(isValidNum);

            if (isValidNum) {
                parsedInteger = Integer.parseInt(choice);
                if (parsedInteger > 0 && parsedInteger <= productsCount) {
                    int index = parsedInteger - 1;
                    productSelected = products.get(index);


                    if (wallet.getAmount() >= productSelected.getPrice()) {
                        wallet.withdraw(productSelected.getPrice());
                        try {
                            warehouse.removeProduct(productSelected.getId());
                        } catch (ProductNotFoundException e) {
                            wallet.deposit(productSelected.getPrice());
                        }
                    }
                }
            }
        }
    }
}
