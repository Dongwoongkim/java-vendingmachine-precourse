package vendingmachine.model;

import java.util.List;
import vendingmachine.model.vo.Name;

public class Items {

    private final List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public Item getBuyItem(Name buyItemName) {
        for (Item item : items) {
            String name = item.getName();
            if (name.equals(buyItemName.getName())) {
                return item;
            }
        }
        throw new IllegalArgumentException("해당 상품이 존재하지 않습니다.");
    }

    public Integer getLowestAmount() {
        Integer lowestAmount = Integer.MAX_VALUE;
        for (Item item : items) {
            Integer amount = item.getAmount();
            lowestAmount = Math.min(lowestAmount, amount);
        }
        return lowestAmount;
    }
}
