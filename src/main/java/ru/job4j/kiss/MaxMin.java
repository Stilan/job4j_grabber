package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return comm(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return comm(value, comparator);
    }
    public static  <T> T comm(List<T> value, Comparator<T> comparator) {
        T t0 = value.get(0);
        for (T t: value) {
                if (comparator.compare(t, t0) > 0) {
                       t0 = t;
                }
        }
        return t0;
    }

}
