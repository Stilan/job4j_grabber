package ru.job4j.ood.lsp.food;

import java.util.Calendar;

public class Bread extends Food {

    public Bread(String name, int expiryDate, Calendar createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
