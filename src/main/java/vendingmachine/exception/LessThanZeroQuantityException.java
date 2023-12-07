package vendingmachine.exception;

public class LessThanZeroQuantityException extends IllegalArgumentException {

    public LessThanZeroQuantityException() {
        super("[ERROR] 상품 수량은 0보다 커야 합니다. 다시 입력해주세요.");
    }
}
