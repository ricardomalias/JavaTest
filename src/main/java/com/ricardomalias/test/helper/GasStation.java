package com.ricardomalias.test.helper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GasStation {

    public String run(String[] strArr) {

        List<String> collect = Arrays.stream(strArr)
                .filter(str -> str.length() > 2)
                .collect(Collectors.toList());

        for(int i = 0; i < collect.size(); i++) {
            boolean acc = acc(collect);

            String s = collect.get(0);
            collect.remove(0);
            collect.add(s);

            if(acc) {
                return String.valueOf(i + 1);
            }
        }

        return String.valueOf("impossible");
    }

    private boolean acc(List<String> collect) {
        int acc = 0;
        for(String str : collect) {
            String[] split = str.split(":");
            int g = Integer.parseInt(split[0]);
            int c = Integer.parseInt(split[1]);

            acc = acc + g - c;

            if(acc < 0) {
                return false;
            }
        }

        return true;
    }
}
