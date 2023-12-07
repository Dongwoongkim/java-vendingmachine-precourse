package vendingmachine.exception;

public class IndivisibleException extends IllegalArgumentException {

    public IndivisibleException(Integer minCoinAmount) {
        super(String.format("[ERROR] 상품 판매 금액은 %d원으로 나누어 떨어져야 합니다.", minCoinAmount));
    }
}
