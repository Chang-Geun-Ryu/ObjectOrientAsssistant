package academy.pocu.comp2500.lab11;


import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;
import academy.pocu.comp2500.lab11.pocu.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class App {

    public void run(BufferedReader in, PrintStream out, PrintStream err) {//throws Exception {
        User user = new User();

        //요청 창고 받아오기
        Warehouse warehouse;
        WarehouseType[] warehouseTypes = WarehouseType.values();
        String input;

        while (true) {
            out.println("WAREHOUSE: Choose your warehouse!");
            for (int i = 0; i < warehouseTypes.length; i++) {
                out.printf("%d. %s%n", i + 1, warehouseTypes[i]);
            }

            try {
                input = in.readLine();
            } catch (IOException e) {
                return ;
            } catch (NumberFormatException e) {
                return ;
            }
            if (!checkProcess(input, warehouseTypes)) {
                continue;
            }

            WarehouseType warehouseType = warehouseTypes[tryParseInt(input) - 1];
            warehouse = new Warehouse(warehouseType);
            break;
        }

        // 지갑 받아오기
        Wallet wallet;
        try {
            wallet = new SafeWallet(user);
        } catch (IllegalAccessException e) {
            //사용 권한이 없는 경우
            err.println("AUTH_ERROR");
            return;
        }

        // 지갑의 잔고를 출력
        out.println("BALANCE: " + wallet.getAmount());

//        ArrayList<Product> products = warehouse.getProducts();
//        while (true) {
//            out.println("PRODUCT_LIST: Choose the product you want to buy!");
//            for (int i = 0; i < products.size(); i++) {
//                Product product = products.get(i);
//                out.println(String.format("%d. %-18s%2d", i + 1, product.getName(), product.getPrice()));
//            }
//
//            String inputStr = in.readLine();
//            if (checkProcess(inputStr, products.toArray())) {
//                Product product = products.get(tryParseInt(inputStr) - 1);
//
//                if (wallet.withdraw(product.getPrice())) {
//                    warehouse.removeProduct(product.getId());
//                    break;
//                }
//            }
//        }

    }

    private boolean checkProcess(String input, Object[] enums) {
        if (input.equals("exit")) {
            System.exit(0);
        }

        int inputNum = tryParseInt(input);
        return inputNum >= 1 && inputNum <= enums.length;
//        return inputNum <= enums.length;
    }

    private int tryParseInt(String str) {
        return tryParseInt(str, Integer.MAX_VALUE);
    }

    private int tryParseInt(String str, Integer defaultInt) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return defaultInt;
        }
    }
}
