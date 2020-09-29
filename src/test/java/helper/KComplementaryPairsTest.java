package helper;

import io.vavr.Tuple2;
import org.junit.Assert;
import org.junit.Test;

public class KComplementaryPairsTest {

    @Test
    public void isKComplementaryPair() {

        int[] numbers = new int[] {1, 2, 3, 4, 5, 6};

        KComplementaryPairs kComplementaryPairs = new KComplementaryPairs();
        Tuple2<Integer, Integer> kComplementaryPair = kComplementaryPairs.findKComplementaryPair(7, numbers);

        Assert.assertEquals(1, kComplementaryPair._1().intValue());
        Assert.assertEquals(6, kComplementaryPair._2().intValue());
    }

    @Test
    public void isKComplementaryPairError() {

        int[] numbers = new int[] {1, 2, 3, 4, 5, 6};

        KComplementaryPairs kComplementaryPairs = new KComplementaryPairs();
        Tuple2<Integer, Integer> kComplementaryPair = kComplementaryPairs.findKComplementaryPair(25, numbers);

        Assert.assertEquals(0, kComplementaryPair._1().intValue());
        Assert.assertEquals(0, kComplementaryPair._2().intValue());
    }
}