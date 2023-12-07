package vendingmachine.view;

import java.util.Map;
import vendingmachine.model.Coin;

public class OutputView {

    public void printVendingMachineCoin(Map<Coin, Integer> coins) {
        System.out.println("\n자판기가 보유한 동전");
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount() + "원 - " + coins.get(coin) + "개");
        }
        System.out.println();
    }

    public void printVendingMachineInsertMoney(Integer amount) {
        System.out.println(String.format("\n투입 금액: %d원", amount));
    }

    public void printVendingMachineHasChange(Map<Coin, Integer> changeInfo) {
        System.out.println("잔돈");
        for (Coin coin : changeInfo.keySet()) {
            System.out.println(coin.getAmount() + "원 - " + changeInfo.get(coin) + "개");
        }
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
