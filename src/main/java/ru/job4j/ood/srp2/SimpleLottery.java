package ru.job4j.ood.srp2;

import java.time.LocalDate;
import java.util.Random;

public class SimpleLottery  implements Lottery {

    @Override
    public LocalDate getLotteryDate() {
        return null;
    }

    @Override
    public int winnerNumber(int numberOfTickets) {
        Random random = new Random();
        int winNumber = random.nextInt(1000000);
        int ticket = 0;
        for (int i = 0; i < numberOfTickets; i++) {
               ticket = random.nextInt(1000000);
              if (ticket == winNumber) {
                  break;
              }
        }
        return ticket;
    }

    @Override
    public void convertSql(int numberOfTicketsSold, LocalDate dataLottery) {

    }

    public static void main(String[] args) {
      SimpleLottery simpleLottery = new SimpleLottery();
     int numberOfTickets = simpleLottery.winnerNumber(1800000);
        System.out.println(numberOfTickets);

    }
}
