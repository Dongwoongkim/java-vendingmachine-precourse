package vendingmachine.model.vo;

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
            throw new IllegalArgumentException();
        }
        if (!isNumeric(quantity)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeric(String quantity) {
        try {
            Integer.valueOf(quantity);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Integer getQuantity() {
        return quantity;
    }
}
