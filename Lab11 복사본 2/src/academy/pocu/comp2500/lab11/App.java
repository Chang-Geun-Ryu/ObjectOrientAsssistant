package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;
import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.ProductNotFoundException;
import academy.pocu.comp2500.lab11.pocu.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public void run(BufferedReader in, PrintStream out, PrintStream err) throws IOException {
        String choice = null;
        WarehouseType warehouseType = null;

        while (true) {
            // 1. show warehouse message
            HashMap<String, WarehouseType> warehouseTypeMap = new HashMap<>();
            for (WarehouseType type : WarehouseType.values()) {
                warehouseTypeMap.put(String.format("%s", type.ordinal() + 1), type);
            }

            out.println(this.showWarehouseMessage(warehouseTypeMap));

            // 2. read user's choice from input stream
            choice = in.readLine();

            if (choice.equals("exit")) {
                return;
            }

            if (!warehouseTypeMap.containsKey(choice)) {
                continue;
            }

            int choiceValue = Integer.parseInt(choice);
            if (choiceValue > 0 && choiceValue <= warehouseTypeMap.size()) {
                warehouseType = warehouseTypeMap.get(choice);
                break;
            }
        }


        // 3. get wallet from user's department
        User user = new User();
        SafeWallet wallet = null;
        try {
            wallet = new SafeWallet(user);
        } catch (IllegalAccessException e) {
            err.println("AUTH_ERROR");
            return;
        }

        while (true) {
            out.println("loop starts");
            Warehouse warehouse = new Warehouse(warehouseType);
            ArrayList<Product> products = warehouse.getProducts();
            Product targetProduct = null;
            ArrayList<String> productNumbers = new ArrayList<>();
            for (int i = 0; i < products.size(); ++i) {
                productNumbers.add(String.format("%s", i + 1));
            }
            while (true) {
                // 4. print balance of the wallet
                out.println(String.format("BALANCE: %s", wallet.getAmount()));

                // 5. print product catalog
                out.println(this.showCatalog(products));

                // 6. read user's choice from input stream
                int catalogSize = products.size();
                choice = in.readLine();

                if (choice.equals("exit")) {
                    return;
                }

                if (!productNumbers.contains(choice)) {
                    continue;
                }

                int choiceValue = Integer.parseInt(choice);
                if (choiceValue > 0 && choiceValue <= catalogSize) {
                    targetProduct = products.get(choiceValue - 1);
                    break;
                }

            }

            // 7. purchase it and go to 4.
            boolean withdrawResult = wallet.withdraw(targetProduct.getPrice());
            if (!withdrawResult) {
                continue;
            }

            try {
                warehouse.removeProduct(targetProduct.getId());
            } catch (ProductNotFoundException e) {
                wallet.deposit(targetProduct.getPrice());
            }

            out.println(String.format("purchased %s", targetProduct.getName()));
        }
    }

    private String showWarehouseMessage(HashMap<String, WarehouseType> warehouseTypeMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("WAREHOUSE: Choose your warehouse!")
                .append(System.lineSeparator());

        for (String key : warehouseTypeMap.keySet()) {
            sb.append(String.format("%s. %s", key, warehouseTypeMap.get(key)))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String showCatalog(ArrayList<Product> products) {
        StringBuilder sb = new StringBuilder();
        sb.append("PRODUCT_LIST: Choose the product you want to buy!")
                .append(System.lineSeparator());

        for (int i = 0; i < products.size(); ++i) {
            String productName = products.get(i).getName();
            String price = "" + products.get(i).getPrice();
            sb.append(String.format("%s. ", i + 1))
                    .append(productName)
                    .append(" ".repeat(20 - (productName.length() + price.length())))
                    .append(price)
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
