package ru.job4j.kiss;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {
     MaxMin maxMin = new MaxMin();
    List<Integer> list = List.of(1,3,5,3,1,5,86,-1);

    Comparator<Integer> comparatorMax = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1,o2);
        }
    };
    Comparator<Integer> comparatorMin = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };
    @Test
    public void testMax(){
        assertThat(maxMin.max(list, comparatorMax), is(86));
    }
    @Test
    public void testMin(){
        assertThat(maxMin.min(list, comparatorMin), is(-1));
    }
}