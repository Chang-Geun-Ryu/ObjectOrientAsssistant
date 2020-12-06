package academy.pocu.comp2500.lab11;


import academy.pocu.comp2500.lab11.pocu.PermanentlyClosedException;
import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.ProductNotFoundException;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;


public class App {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void run(BufferedReader in, PrintStream out, PrintStream err) {
        //
        // 창고를 고르는 단계
        //
        // 다음으로 넘겨줄 유일한 정보 : 창고
        Warehouse warehouse;
        {
            String input;
            int index;
            int warehouseNo;
            while (true) {
                //초기 인자 설정
                index = 0;
                warehouseNo = -1;

                //창고를 선택하라는 문구 출력
                out.println("WAREHOUSE: Choose your warehouse!");
                for (WarehouseType type : WarehouseType.values()) {
                    index++;
                    out.printf("%d. %s%s", index, type, LINE_SEPARATOR);
                }

                //문구 출력 후 사용자 입력을 받음
                try {
                    input = in.readLine();
                    if (input.equals("exit")) {
                        return;
                    }
                    warehouseNo = Integer.parseInt(input);
                    warehouseNo--;
                    if (warehouseNo < 0) {
                        continue;
                    }
                } catch (IOException e) {
                    err.println(e.getMessage());
                    input = null;
                    continue;
                } catch (NumberFormatException e) {
                    out.println("숫자를 입력하세요!");
                    err.println(e.getMessage());
                    continue;
                }

                //빼낸 정수에 따라 올바른 창고 생성
                if (warehouseNo != -1
                        && warehouseNo < index) {
                    WarehouseType type = WarehouseType.values()[warehouseNo];
                    warehouse = new Warehouse(type);
                    break;
                }

            }
        }
        //
        // 지갑을 생성하는 단계
        //
        //다음으로 넘겨줄 정보 : 지갑
        SafeWallet wallet = null;
        {
            User user = new User();
            try {
                wallet = new SafeWallet(user);
                out.println("BALANCE: " + wallet.getAmount());
            } catch (IllegalArgumentException e) {
                err.println("IllegalArgumentException");
                return;
            } catch (PermanentlyClosedException e) {
                err.println("PermanentlyClosedException");
                return;
            } catch (IllegalAccessException e) {
                err.println("AUTH_ERROR");
                return;
            }
        }
        //
        //창고와 지갑이 구해졌으니 구매함
        //
        {
            String input;
            int index;
            int warehouseNo;
            while (true) {
                //초기 설정
                index = 0;
                warehouseNo = -1;

                //제품을 선택하라는 문구 출력
                out.println("PRODUCT_LIST: Choose the product you want to buy!");
                for (Product product : warehouse.getProducts()) {
                    index++;
                    out.printf("%d. %s\t\t%d%s", index, product.getName(), product.getPrice(), LINE_SEPARATOR);
                }

                //문구 출력 후 사용자 입력을 받음
                try {
                    input = in.readLine();
                    if (input.equals("exit")) {
                        return;
                    }
                    warehouseNo = Integer.parseInt(input);
                    warehouseNo--;
                    if (warehouseNo < 0) {
                        continue;
                    }
                } catch (IOException e) {
                    err.println("다시 입력하세요. ( 번호, exit )");
                    input = null;
                    continue;
                } catch (NumberFormatException e) {
                    out.println("숫자를 입력하세요!");
                    err.println(e.getMessage());
                    continue;
                }

                //빼낸 정수에 따라 제품 삭제 후 지갑 갱신
                //제품이 사라진 것에 대한 예외처리
                try {
                    if (warehouseNo != -1
                            && warehouseNo < index) {
                        Product product = warehouse.getProducts().get(warehouseNo);

                        warehouse.removeProduct(product.getId());

                        wallet.withdraw(product.getPrice());
                        out.println("BALANCE: " + wallet.getAmount());
                    }
                } catch (ProductNotFoundException e) {
                    err.println(e.getMessage());
                }
            }
        }
    }
}
