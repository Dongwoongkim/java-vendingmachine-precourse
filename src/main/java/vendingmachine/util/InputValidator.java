package vendingmachine.util;

import vendingmachine.exception.EmptyInputException;
import vendingmachine.exception.InvalidItemsFormatException;
import vendingmachine.exception.NonNumericInputException;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateMoney(String money) {
        if (money.isEmpty()) {
            throw new EmptyInputException();
        }

        if (!isNumeric(money)) {
            throw new NonNumericInputException();
        }
    }

    public static void validateItemsInfo(String itemsInfo) {
        if (itemsInfo.isEmpty()) {
            throw new EmptyInputException();
        }
    }

    public static void validateItemInfo(String itemInfo) {
        if (!itemInfo.startsWith("[") && !itemInfo.endsWith("]")) {
            throw new InvalidItemsFormatException();
        }
    }

    public static void validateBuyItemName(String itemName) {
        if (itemName.isEmpty()) {
            throw new EmptyInputException();
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
