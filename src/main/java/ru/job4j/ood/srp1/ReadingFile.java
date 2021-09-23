package ru.job4j.ood.srp1;

import java.util.List;

public interface ReadingFile<T> {
    List<T> reading(String file);
    void output(List<T> stringListFile);
}

