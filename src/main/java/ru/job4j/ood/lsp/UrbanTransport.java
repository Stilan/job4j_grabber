package ru.job4j.ood.lsp;

/**
 * 1 Предусловия (Preconditions) не могут быть усилены в подклассе
 * UrbanTransport ожидается 25 но в RouteTaxi усилено предусловие .
 */
public class UrbanTransport {

    protected int sum;

    public UrbanTransport(int sum) {
        this.sum = sum;
    }
    public void theTrip() {
       if (sum < 25) {
           System.out.println("go");
       }
    }

    public static class RouteTaxi extends UrbanTransport {

        public RouteTaxi(int sum) {
            super(sum);
        }

        @Override
        public void theTrip() {
            if (sum < 40) {
                System.out.println("go");
            }
        }
    }
}
