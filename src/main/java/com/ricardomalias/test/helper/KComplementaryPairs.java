package com.ricardomalias.test.helper;

import io.vavr.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KComplementaryPairs {

    private static final Logger LOGGER = LoggerFactory.getLogger(KComplementaryPairs.class);

    public Tuple2<Integer, Integer> findKComplementaryPair(int target, int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            for(int j = i; j < numbers.length; j++) {
                if (i != j && numbers[i] + numbers[j] == target) {
                    return new Tuple2<>(numbers[i], numbers[j]);
                }
            }
        }

        LOGGER.error("not found K-Complementary Pair");
        return new Tuple2<>(0, 0);
    }
}
