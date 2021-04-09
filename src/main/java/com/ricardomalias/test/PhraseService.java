package com.ricardomalias.test;

import com.ricardomalias.test.helper.TupleComparator;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;

public class PhraseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhraseService.class);
    private final String filePath;
    private final Properties appProps;
    private final JavaSparkContext sparkContext;

    public PhraseService(String filePath, Properties appProps, JavaSparkContext sparkContext) {
        this.filePath = filePath;
        this.appProps = appProps;
        this.sparkContext = sparkContext;
    }

    public void extractPhrase() {
        int limit = Integer.parseInt(appProps.get("phrase.frequency.limit").toString());

        if (filePath.isEmpty()) {
            LOGGER.error("Error on load file, please provide file absolute path as application argument");
            System.exit(1);
        }

        try {
            JavaRDD<String> lines = sparkContext.textFile(filePath, 1);

            JavaPairRDD<String, Integer> stringIntegerJavaPairRDD = lines.flatMap(s -> Arrays.stream(s.split("\\|")).iterator())
                    .mapToPair(phrase -> new Tuple2<>(phrase, 1))
                    .reduceByKey(Integer::sum);

            stringIntegerJavaPairRDD.takeOrdered(
                    limit,
                    TupleComparator.INSTANCE)
                    .forEach(p -> LOGGER.info("Phrase: {} has {} occurrences", p._1(), p._2()));

            saveOutputFile(stringIntegerJavaPairRDD);

            sparkContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveOutputFile(JavaPairRDD<String, Integer> stringIntegerJavaPairRDD) {

        Path path = Paths.get("src", "main", "resources");
        File absoluteFile = path.toFile().getAbsoluteFile();

        if (appProps.get("phrase.save.output").equals("1")) {
            stringIntegerJavaPairRDD.saveAsTextFile(absoluteFile + "/output.txt");
        }
    }
}
