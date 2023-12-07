package vendingmachine.model.vo;

import vendingmachine.exception.AmountLessThanMinAmountException;
import vendingmachine.exception.EmptyInputException;
import vendingmachine.exception.IndivisibleException;
import vendingmachine.exception.NonNumericInputException;

public class Amount {

    private static final Integer MIN_AMOUNT = 100;
    private static final Integer MIN_COIN_AMOUNT = 10;
    private final Integer amount;

    private Amount(Integer amount) {
        this.amount = amount;
    }

    public static Amount create(String amount) {
        validate(amount);
        return new Amount(Integer.valueOf(amount));
    }

    private static void validate(String amount) {
        if (amount.isEmpty()) {
            throw new EmptyInputException();
        }
        if (!isNumeric(amount)) {
            throw new NonNumericInputException();
        }
        if (!isOverMinAmount(Integer.valueOf(amount))) {
            throw new AmountLessThanMinAmountException(MIN_AMOUNT);
        }
        if (!isDivisibleByMinCoin(Integer.valueOf(amount))) {
            throw new IndivisibleException(MIN_COIN_AMOUNT);
        }
    }

    private static boolean isOverMinAmount(Integer amount) {
        if (amount >= MIN_AMOUNT) {
            return true;
        }
        return false;
    }

    private static boolean isNumeric(String amount) {
        try {
            Integer.valueOf(amount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDivisibleByMinCoin(int amount) {
        return amount % MIN_COIN_AMOUNT == 0;
    }

    public Integer getAmount() {
        return amount;
    }
}
