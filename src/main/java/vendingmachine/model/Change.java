package vendingmachine.model;

import java.util.Map;

public class Change {

    private Map<Coin, Integer> coins;

    private Change(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public static Change create(Integer amount, RandomNumberGenerator randomNumberGenerator) {
        Map<Coin, Integer> info = randomNumberGenerator.makeChange(amount);
        return new Change(info);
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }
}
