package ru.job4j.ood.srp3;

/**
 * 3. Обращать внимание на используемые операции, которые используются без зависимости.
 * -- фигура может поменяться.
 */
public class SimpleFigures {
    public int length;
    public int width;

    public SimpleFigures(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void square(int length, int width) {
        int square = length * width;
        System.out.println(square);
    }
}
