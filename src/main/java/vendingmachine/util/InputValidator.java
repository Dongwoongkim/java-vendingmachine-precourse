package vendingmachine.util;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateMoney(String money) {
        if (money.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!isNumeric(money)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateItemsInfo(String itemsInfo) {
        if (itemsInfo.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateItemInfo(String itemInfo) {
        if (!itemInfo.startsWith("[")) {
            throw new IllegalArgumentException();
        }
        if (!itemInfo.endsWith("]")) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeric(String money) {
        try {
            Integer.valueOf(money);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
