package service;

import config.PropertyConfig;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import static org.apache.commons.lang3.StringUtils.SPACE;

public class SentencePhraseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SentencePhraseService.class);
    private final String filePath;

    public SentencePhraseService(String filePath) {
        this.filePath = filePath;
    }

    public void extractPhrase() {
        Properties appProps = PropertyConfig.getProperties();

        if (filePath.isEmpty()) {
            LOGGER.error("Error on load file, please provide file absolute path as application argument");
            System.exit(1);
        }

        SparkConf sparkConf = new SparkConf()
                .setAppName(appProps.get("spark.appName").toString())
                .setMaster(appProps.get("spark.master").toString());

        try (JavaSparkContext ctx = new JavaSparkContext(sparkConf)) {
            JavaRDD<String> lines = ctx.textFile(filePath, 1);

            lines.flatMap(s -> Arrays.stream(s.split("\\|")).iterator())
                    .mapToPair(phrase -> new Tuple2<>(phrase, 1))
                    .reduceByKey(Integer::sum)
                    .collect()
                    .stream()
                    .sorted(Comparator.comparing(Tuple2::_2, Comparator.reverseOrder()))
                    .forEach(p -> {
                        LOGGER.info("Phrase: {} has {} occurrences", p._1(), p._2());
                    });

            ctx.stop();
        }
    }
}
