package com.ricardomalias.test.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RequestDataCounter {

    public void start() {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            request(url);
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }

    private void request(URL url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");

            InputStream response = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(response, UTF_8));

            String s = reader.readLine();
            counter(s);

            response.close();
        } catch (IOException ioEx) {
            System.out.println(ioEx);
        }
    }

    private void counter(String content) {
        ArrayList<Integer> ages = new ArrayList<>();

        Pattern pattern = Pattern.compile("(?:age=)(\\d+)");
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()) {
            ages.add(Integer.parseInt(matcher.group(1)));
        }

        long count = ages.stream().filter(age -> age >= 50).count();
        System.out.println("The number of the ages above or equal fifty is " + count);
    }
}
