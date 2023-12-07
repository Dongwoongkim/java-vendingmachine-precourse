package vendingmachine.view;

import java.util.Map;
import vendingmachine.model.Coin;

public class OutputView {

    public void printVendingMachineCoin(Map<Coin, Integer> coins) {
        System.out.println("자판기가 보유한 동전");
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount() + "원 - " + coins.get(coin) + "개");
        }
        System.out.println();
    }

    public void printVendingMachineInsertMoney(Integer amount) {
        System.out.println(String.format("투입 금액: %d원", amount));
    }

    public void printVendingMachineHasChange() {
        System.out.println("잔돈");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
