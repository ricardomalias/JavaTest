package com.ricardomalias.test.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StringScramble {

    public StringScramble() {}

    public boolean run(String str1, String str2) {
        List<String> split1 = new ArrayList<>(Arrays.asList(str1.split("")));
        String[] split2 = str2.split("");

        return Arrays.stream(split2)
                .allMatch(s2 -> {
                    Optional<String> first = split1.stream().filter(s2::equals).findFirst();
                    if(first.isPresent()) {
                        split1.remove(first.get());
                        return true;
                    }
                    return false;
                });
    }
}