package com.ricardomalias.test;

import com.ricardomalias.test.config.PropertyConfig;
import com.ricardomalias.test.config.SparkConfig;
import com.ricardomalias.test.helper.CoinDeterminer;
import com.ricardomalias.test.helper.GasStation;
import com.ricardomalias.test.helper.KComplementaryPairs;
import com.ricardomalias.test.helper.LongestWord;
import com.ricardomalias.test.helper.PalindromeHelper;
import com.ricardomalias.test.helper.StringScramble;
import io.vavr.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        startPhrase(args[0]);
        startKComplementaryPairs();
        startPalindrome();
        System.out.println(LongestWord.run("fun&!! time"));
        startStringScramble();
        startCoinDeterminer();
        startGasStation();
    }

    private static void startPhrase(String filePath) {
        LOGGER.info("----- START PHRASE COUNTER -----");

        Properties appProps = PropertyConfig.getProperties();
        SparkConfig sparkConfig = new SparkConfig(appProps);

        PhraseService phraseService = new PhraseService(filePath, appProps, sparkConfig.getSparkContext());
        phraseService.extractPhrase();
    }

    private static void startKComplementaryPairs() {
        LOGGER.info("----- START K-Complementary Pairs -----");

        int target = 7;
        KComplementaryPairs kComplementaryPairs = new KComplementaryPairs();
        Tuple2<Integer, Integer> k = kComplementaryPairs.findKComplementaryPair(target, new int[]{9, 1, 2, 3, 4, 5, 6});
        LOGGER.info("Target: {}, K-Complementary Pair: {} and {}", target, k._1(), k._2());
    }

    private static void startPalindrome() {
        System.out.println("----- START PALINDROME -----");

        PalindromeHelper palindrome = new PalindromeHelper(true, false);

        String[] strings = {"ovo", "ov o", "Ovo", "paçoca"};

        Arrays.stream(strings).forEach(item -> {
            System.out.println("Palindrome check for: " + item + " is " + palindrome.isPalindrome(item));
        });
    }

    private static void startStringScramble() {
//        String[] s = {"cdore", "coder"};
        String[] s = {"h3llko", "hello"};
//        String[] s = {"rkqodlw", "world"};

        StringScramble stringScramble = new StringScramble();
        boolean run = stringScramble.run(s[0], s[1]);
        System.out.println(run);
    }

    private static void startCoinDeterminer() {
        CoinDeterminer coinDeterminer = new CoinDeterminer();
        int run = coinDeterminer.run(25);
        System.out.println(run);
    }

    private static void startGasStation() {
//        String[] strings = {"4","3:1","2:2","1:2","0:1"};
//        String[] strings = {"4", "1:1", "2:2", "1:2", "0:1"};
        String[] strings = {"4","0:1","2:2","1:2","3:1"};

        GasStation gasStation = new GasStation();
        String run = gasStation.run(strings);
        System.out.println("resultador final: " + run);
    }
}
