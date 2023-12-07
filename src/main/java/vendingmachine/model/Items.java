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
            if (name.equals(buyItemName.getName()) && item.isPurchaseAble()) {
                return item;
            }
        }
        throw new IllegalArgumentException("해당 상품은 구매할 수 없습니다.");
    }

    public Integer getLowestAmount() {
        Integer lowestAmount = Integer.MAX_VALUE;
        for (Item item : items) {
            Integer amount = item.getAmount();
            lowestAmount = Math.min(lowestAmount, amount);
        }
        return lowestAmount;
    }

    public boolean isPurchaseAble() {
        for (Item item : items) {
            if (item.isPurchaseAble()) {
                return true;
            }
        }
        return false;
    }
}
