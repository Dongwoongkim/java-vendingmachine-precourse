package vendingmachine.view;

public class OutputView {

    public void printVendingMachineCoin() {
        System.out.println("자판기가 보유한 동전");
    }

    public void printVendingMachineReceivedMoney() {
        System.out.println("투입 금액: ");
    }

    public void printVendingMachineHasChange() {
        System.out.println("잔돈");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
