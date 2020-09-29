package helper;

import io.vavr.Tuple2;
import org.junit.Test;

import java.util.Optional;

public class KComplementaryPairsTest {

    @Test
    public void isKComplementaryPair() {

        int[] numbers = new int[] {1, 2, 3, 4, 5, 6};

        KComplementaryPairs kComplementaryPairs = new KComplementaryPairs();
        Tuple2<Integer, Integer> kComplementaryPair = kComplementaryPairs.isKComplementaryPair(7, numbers);

//        kComplementaryPair.ifPresent(k -> {
        System.out.println("primeiro");
            System.out.println(kComplementaryPair._1);
        System.out.println("segundo");
            System.out.println(kComplementaryPair._2);
//        });
    }
}