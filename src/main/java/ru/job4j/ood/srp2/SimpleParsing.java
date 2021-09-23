package ru.job4j.ood.srp2;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 *
 * 2 создаваемые объекты Если класс умеет их создавать и инициализировать, то это скорее всего нарушает принцип SRP
 */

public class SimpleParsing implements Parsing<Integer, String> {

    @Override
    public List<Integer> parsing(List<String> strList) {
        List<Integer> integerList = new ArrayList<>();
        return  integerList = strList.stream()
                .map(Integer::parseInt)
                .collect(toList());
    }

}
