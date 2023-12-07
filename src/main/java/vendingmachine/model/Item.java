package vendingmachine.model;

import vendingmachine.model.vo.Amount;
import vendingmachine.model.vo.Name;
import vendingmachine.model.vo.Quantity;

public class Item {

    private final Name name;
    private final Amount amount;
    private final Quantity quantity;

    public Item(Name name, Amount amount, Quantity quantity) {
        this.name = name;
        this.amount = amount;
        this.quantity = quantity;

        System.out.println(this.name.getName() + " " + this.amount.getAmount() + " " + this.quantity.getQuantity());
    }

    public static Item create(String name, String amount, String quantity) {
        return new Item(Name.create(name), Amount.create(amount), Quantity.create(quantity));
    }
}
