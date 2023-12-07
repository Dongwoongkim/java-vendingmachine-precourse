package vendingmachine.model;

import java.util.List;
import vendingmachine.exception.NonExistInVendingMachineException;
import vendingmachine.model.vo.Name;

public class Items {

    private final List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public Item getBuyItem(Name buyItemName) {
        for (Item item : items) {
            String name = item.getName();
            if (name.equals(buyItemName.getName()) && item.isRemain()) {
                return item;
            }
        }
        throw new NonExistInVendingMachineException();
    }

    public Integer getLowestAmount() {
        return items.stream()
                .map(Item::getAmount)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public boolean isPurchaseAble() {
        return items.stream().anyMatch(Item::isRemain);
    }
}
