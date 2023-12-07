package vendingmachine.exception;

public class NonExistInVendingMachineException extends IllegalArgumentException {

    public NonExistInVendingMachineException() {
        super("[ERROR] 해당 상품은 구매할 수 없습니다.");
    }
}
