package ru.job4j.ood.srp2;

import java.util.List;

public interface Parsing<T, E> {
    List<T> parsing(List<E> strList);
}
