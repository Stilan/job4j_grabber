package ru.job4j.ood.lsp;

/**
 * 2. Постусловия (Postconditions) не могут быть ослаблены в подклассе.
 * Есть класс Институт с методом  определения, что студент поступил в институт
 * в классе instituteOfProgrammers наследнике Institute мы забыли добавить дополнительное условие.
 *
 */
public class Institute {

    protected int mathScore;
    protected int russianScore;
    protected int physicScore;

    public Institute(int mathScore, int russianScore, int physicScore) {
        this.mathScore = mathScore;
        this.russianScore = russianScore;
        this.physicScore = physicScore;
    }

    public void goToUniversity() {
       if (mathScore <= 80) {
           System.out.println("OK");
       }
        if (russianScore <= 80) {
            System.out.println("OK");
        }
        if (physicScore <= 90) {
            System.out.println("OK");
        }
    }
    public static class InstituteOfProgrammers extends Institute {

        public InstituteOfProgrammers(int mathScore, int russianScore, int physicScore) {
            super(mathScore, russianScore, physicScore);
        }
        @Override
        public void goToUniversity() {
            if (mathScore <= 80) {
                System.out.println("OK");
            }
            if (russianScore <= 80) {
                System.out.println("OK");
            }
        }
    }
}
