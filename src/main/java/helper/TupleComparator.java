package helper;

import scala.Tuple2;

import java.io.Serializable;
import java.util.Comparator;

public class TupleComparator implements Comparator<Tuple2<String, Integer>>, Serializable {
    public final static TupleComparator INSTANCE = new TupleComparator();

    public int compare(Tuple2<String, Integer> t1,
                       Tuple2<String, Integer> t2) {
        return -t1._2.compareTo(t2._2);    // sort descending
        // return t1._2.compareTo(t2._2);  // sort ascending
    }
}
