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
import java.util.HashMap;
import java.util.UUID;

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
        } catch (IllegalArgumentException e) {
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

        do {
            out.println(String.format("BALANCE: %d", wallet.getAmount()));
            out.println("PRODUCT_LIST: Choose the product you want to buy!");
            int num = 0;
            int index = 0;
            HashMap<Integer, Product> products = new HashMap<>();
            for (Product p : warehouse.getProducts()) {
                out.printf("%d. %-19.19s%10s%s", ++index, p.getName(), String.format("%d", p.getPrice()), System.lineSeparator());
                products.put(index, p);
            }

            num = getProductIndex(warehouse, in, out, err);

            if (num == -1) {
                return;
            }

            if (products.containsKey(num)) {
                Product p = products.get(num);
                int price = p.getPrice();
                UUID id = p.getId();

                if (wallet.withdraw(price)) {
                    try {
                        warehouse.removeProduct(id);
                    } catch (ProductNotFoundException e) {
                        try {
                            wallet.deposit(price);
                        } catch (OverflowException over) {
                            throw over;
                        }
//                                continue;
//                        err.println(e.getLocalizedMessage());
                        continue;
                    }
                } else {
                    continue;
                }
            }
        } while (true);
    }


    private int getProductIndex(Warehouse warehouse, BufferedReader in, PrintStream out, PrintStream err) {
        try {
            int num = 0;
            String s = in.readLine();
            if (s == null) {
                return 0;
            }

            if (s.length() == 4 && s.equals("exit")) {// || warehouse.getProducts().size() == 0) {  // exit
                return -1;
            }

            String length = String.format("%d", warehouse.getProducts().size());
            if (length.length() > s.length()) {
                return 0;
            }

            boolean isDigit = true;
            for (int i = 0; i < length.length(); ++i) {
                if (Character.isDigit(s.charAt(i)) == false) {
                    isDigit = false;
                }
            }
            if (isDigit) {
                num = Integer.parseInt(s);
            } else {
                return 0;
            }

            if (s.equals(String.format("%d", num)) == false) {
                return 0;
            }

            if (num < 1 || num > warehouse.getProducts().size()) {
                return 0;
            }
            return num;
        } catch (IOException e) {
            return 0;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
