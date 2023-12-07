package vendingmachine.exception;

public class IndivisibleException extends IllegalArgumentException {

    public IndivisibleException(Integer minCoinAmount) {
        super(String.format("[ERROR] %d으로 나누어 지는 값을 입력해주세요.", minCoinAmount));
    }
}
