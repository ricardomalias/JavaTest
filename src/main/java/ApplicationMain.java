import helper.KComplementaryPairs;
import helper.PalindromeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.SentencePhraseService;

public class ApplicationMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) {


        PalindromeHelper palindrome = new PalindromeHelper(true, false);

        String palindromeLoggerTxt = "Palindrome check for {}: {} ";
        LOGGER.info(palindromeLoggerTxt, "ovo", palindrome.isPalindrome("ovo"));
        LOGGER.info(palindromeLoggerTxt, "ov o", palindrome.isPalindrome("ov o"));
        LOGGER.info(palindromeLoggerTxt, "Ovo", palindrome.isPalindrome("Ovo"));
        LOGGER.info(palindromeLoggerTxt, "paçoca", palindrome.isPalindrome("paçoca"));

        KComplementaryPairs kComplementaryPairs = new KComplementaryPairs();
        kComplementaryPairs.isKComplementaryPair(4, new int[] {1, 2, 3, 4, 5, 6});

        SentencePhraseService sentencePhraseService = new SentencePhraseService(args[0]);
        sentencePhraseService.extractPhrase();
    }
}
