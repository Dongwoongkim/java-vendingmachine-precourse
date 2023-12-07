package vendingmachine.model;

import java.util.HashMap;
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

    public Map<Coin, Integer> makeChangeInfo(Integer insertMoney) {
        Map<Coin, Integer> changeInfo = new HashMap<>();
        for (Coin coin : Coin.values()) {
            if (coins.get(coin) != 0 && (coins.get(coin) * coin.getAmount()) < insertMoney) {
                changeInfo.put(coin, coins.get(coin));
            }
            insertMoney -= (coins.get(coin) * coin.getAmount());
        }
        return changeInfo;
    }
}
