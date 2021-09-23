package ru.job4j.ood.srp1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * нарушение принципа SRP
 * У класса должна быть только одна цель.
 */

public class SimpleReadingFile implements ReadingFile<String> {

    @Override
    public List<String> reading(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
           in.lines().forEach(list::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void output(List<String> stringListFile) {
        stringListFile.forEach(System.out::println);

    }
}
