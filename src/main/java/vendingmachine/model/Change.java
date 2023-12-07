package vendingmachine.model;

import java.util.HashMap;
import java.util.Map;
import vendingmachine.exception.IndivisibleException;

public class Change {

    private static final Integer MIN_COIN_AMOUNT = 10;

    private Map<Coin, Integer> coins;

    private Change(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public static Change create(Integer amount, RandomNumberGenerator randomNumberGenerator) {
        validate(amount);
        return new Change(randomNumberGenerator.makeChange(amount));
    }

    private static void validate(Integer amount) {
        if (!isDivisibleByMinCoin(Integer.valueOf(amount))) {
            throw new IndivisibleException(MIN_COIN_AMOUNT);
        }
    }

    public static boolean isDivisibleByMinCoin(int amount) {
        return amount % MIN_COIN_AMOUNT == 0;
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
