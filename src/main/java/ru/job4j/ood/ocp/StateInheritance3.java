package ru.job4j.ood.ocp;

public class StateInheritance3 {

    public static class Montana {
        public int population() {
            return 1015165;
        }
    }
    public static void main(String[] args) {
        Montana russia = new Montana();
        System.out.println(russia);
    }
}
