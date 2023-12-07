package vendingmachine.view;

public class OutputView {

    public void printVendingMachineCoin() {
        System.out.println("자판기가 보유한 동전");
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
