package vendingmachine.exception;

public class AmountLessThanMinAmountException extends IllegalArgumentException {

    public AmountLessThanMinAmountException(Integer minAmount) {
        super(String.format("[ERROR] 상품 금액은 최소 %d원입니다. 다시 입력해주세요.", minAmount));
    }
}
