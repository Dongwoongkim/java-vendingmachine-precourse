package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomNumberGenerator {

    public Map<Coin, Integer> makeChange(Integer amount) {
        Map<Coin, Integer> map = initMap();
        List<Integer> numbers = Arrays.asList(Coin.COIN_500.getAmount(), Coin.COIN_100.getAmount(),
                Coin.COIN_50.getAmount(), Coin.COIN_10.getAmount());
        makeChangeInfo(amount, numbers, map);
        return map;
    }

    private static void makeChangeInfo(Integer amount, List<Integer> numbers, Map<Coin, Integer> map) {
        int sum = 0;
        while (sum != amount) {
            int coinAmount = Randoms.pickNumberInList(numbers); // 동전 고름
            if (sum + coinAmount <= amount) {
                Coin coin = Coin.get(coinAmount);
                map.put(coin, map.get(coin) + 1);
                sum += coinAmount;
            }
        }
    }

    private static Map<Coin, Integer> initMap() {
        Map<Coin, Integer> map = new HashMap<>();
        for (Coin coin : Coin.values()) {
            map.put(coin, 0);
        }
        return map;
    }
}
