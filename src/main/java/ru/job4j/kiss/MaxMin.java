package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @version 2
 * @since 20.09.2021
 */
public class MaxMin {
    /**
     * поиск max в List
     * @param value
     * @param comparator
     * @param <T>
     * @return
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return comm(value, true, comparator);
    }

    /**
     * поиск min в List
     * @param value
     * @param comparator
     * @param <T>
     * @return
     */
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return comm(value, false, comparator);
    }

    /**
     * универсальный метод для поиска
     * @param value
     * @param isMaxMin
     * @param comparator
     * @param <T>
     * @return
     */
    public static  <T> T comm(List<T> value, boolean isMaxMin, Comparator<T> comparator) {
        T t0 = value.get(0);
        for (T t: value) {
                if (isMaxMin && comparator.compare(t, t0) > 0) {
                       t0 = t;
                } else if (!isMaxMin && comparator.compare(t, t0) < 0) {
                  t0 = t;
                }
        }
        return t0;
    }

}
