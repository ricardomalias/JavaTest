package com.ricardomalias.test.service;

import org.junit.Test;

import static org.mockito.Mockito.mock;

public class PhraseServiceTest {

    @Test
    public void extractPhraseSuccess() {
        // need refactor PhraseService to test


//        JavaSparkContext javaSparkContextMock = mock(JavaSparkContext.class);
//        Properties appProps = PropertyConfig.getProperties();
////        SparkConfig sparkConfig = new SparkConfig(appProps);
////        JavaSparkContext sparkContext = sparkConfig.getSparkContext();
//        String filePath = "./src/main/resources/example.csv";
//        JavaRDD<String> javaRDD = mock(JavaRDD.class);
////        JavaRDD<String> stringJavaRDD = new JavaRDD<String>(stringContentFile);
//
//        Mockito.when(javaSparkContextMock.textFile(filePath))
//                .thenReturn(javaRDD);
//
//        String phrase = "o rato roeu a roupa do rei de roma";
//        Tuple2<String, Integer> stringIntegerTuple2 = new Tuple2<>(phrase, 1);
//
//        PhraseService phraseService = new PhraseService(filePath, appProps, javaSparkContextMock);
//        phraseService.extractPhrase();
//
//        Mockito.verify(javaSparkContextMock, Mockito.times(1))
//                .textFile(filePath);
    }
}