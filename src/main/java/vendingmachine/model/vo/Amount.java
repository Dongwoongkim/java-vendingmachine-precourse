package vendingmachine.model.vo;

public class Amount {

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
            throw new IllegalArgumentException();
        }
        if (!isNumeric(amount)) {
            throw new IllegalArgumentException();
        }
        if (!isOverMinAmount(Integer.valueOf(amount))) {
            throw new IllegalArgumentException();
        }
        if (!isDivisibleBy10(Integer.valueOf(amount))) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOverMinAmount(Integer amount) {
        if (amount >= 100) {
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

    public static boolean isDivisibleBy10(int amount) {
        return amount % 10 == 0;
    }

    public Integer getAmount() {
        return amount;
    }
}
