package com.ricardomalias.test.helper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CoinDeterminer {
    private List<Integer> coins = Arrays.asList(1, 5, 7, 9, 11);

    public int run(int num) {
        int i = 0;

        int finalNum = num;

        int biggerCoin = getBiggetCoin(finalNum);

        System.out.println("bigger " + biggerCoin);

        coins = coins.stream()
//                .filter(c -> c <= biggerCoin)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

//        while(num > 0) {
//            i++;
//            recursiveCoin(num);
//        }

        return sumCoin(num);
    }

    private int sumCoin(int num) {
        int i = 0;
        for(Integer coin : coins) {
            i++;
            System.out.println(coin);

            num = num - coin;
            System.out.println(num);
        }

        if(num > 0) {
            return 0;
        }

        return i;
    }

    private int recursiveCoin(int num) {
        Integer coin = coins.stream()
                .sorted(Comparator.reverseOrder())
                .filter(c -> {
                    return c <= num;
                })
                .findFirst()
                .orElse(coins.get(0));

        System.out.println("num " + num);
        System.out.println("coin" + coin);

        return num - coin;
    }

    private int getBiggetCoin(int finalNum) {
        int subtotal = 0;
        int biggerCoin = 0;
        for (Integer coin : coins) {
            if (subtotal + coin <= finalNum) {
                subtotal = subtotal + coin;
                biggerCoin = coin;
            }
        }

        return biggerCoin;
    }
}
