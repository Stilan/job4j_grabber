package ru.job4j.ood.ocp;

public class ProfessionsInheritance2 {

    public static class Programmer {
        public String skills() {
            return "...";
        }
    }

    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        System.out.println(programmer);
    }
}
