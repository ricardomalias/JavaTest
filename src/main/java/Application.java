import config.PropertyConfig;
import config.SparkConfig;
import helper.KComplementaryPairs;
import helper.PalindromeHelper;
import io.vavr.Tuple2;
import service.PhraseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        startPhrase(args[0]);
        startKComplementaryPairs();
        startPalindrome();
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
        LOGGER.info("----- START PALINDROME -----");

        PalindromeHelper palindrome = new PalindromeHelper(true, false);
        String palindromeLoggerTxt = "Palindrome check for {}: {} ";
        LOGGER.info(palindromeLoggerTxt, "ovo", palindrome.isPalindrome("ovo"));
        LOGGER.info(palindromeLoggerTxt, "ov o", palindrome.isPalindrome("ov o"));
        LOGGER.info(palindromeLoggerTxt, "Ovo", palindrome.isPalindrome("Ovo"));
        LOGGER.info(palindromeLoggerTxt, "paçoca", palindrome.isPalindrome("paçoca"));
    }
}
