package config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Properties;

public class SparkConfig {

    private final Properties appProps;

    public SparkConfig(Properties appProps) {
        this.appProps = appProps;
    }

    public JavaSparkContext getSparkContext() {
        SparkConf sparkConf = new SparkConf()
                .setAppName(appProps.get("spark.appName").toString())
                .setMaster(appProps.get("spark.master").toString());

        return new JavaSparkContext(sparkConf);
    }
}
