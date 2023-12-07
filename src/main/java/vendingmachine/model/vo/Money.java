package vendingmachine.model.vo;

public class Money {

    private Integer amount;

    public Money(Integer amount) {
        this.amount = amount;
    }

    public boolean isLessThanAmount(Integer amount) {
        return this.amount < amount;
    }

    public void decrease(Integer amount) {
        this.amount -= amount;
    }

    public Integer getAmount() {
        return amount;
    }
}
