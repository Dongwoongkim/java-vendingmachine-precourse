package vendingmachine.model;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin get(Integer amount) {
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == amount) {
                return coin;
            }
        }
        throw new IllegalArgumentException("해당 코인이 존재하지 않습니다.");
    }

    public int getAmount() {
        return amount;
    }
}
