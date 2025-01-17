package vendingmachine.model.vo;

import vendingmachine.exception.EmptyInputException;
import vendingmachine.exception.LessThanZeroQuantityException;
import vendingmachine.exception.NonNumericInputException;

public class Quantity {

    private Integer quantity;

    private Quantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static Quantity create(String quantity) {
        validate(quantity);
        return new Quantity(Integer.valueOf(quantity));
    }

    private static void validate(String quantity) {
        if (quantity.isEmpty()) {
            throw new EmptyInputException();
        }
        if (!isNumeric(quantity)) {
            throw new NonNumericInputException();
        }
        if (!isOverZero(quantity)) {
            throw new LessThanZeroQuantityException();
        }
    }

    private static boolean isOverZero(String quantity) {
        return Integer.valueOf(quantity) > 0;
    }

    private static boolean isNumeric(String quantity) {
        try {
            Integer.valueOf(quantity);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void purchase() {
        quantity--;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
