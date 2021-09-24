package ru.job4j.ood.srp2;

import java.time.LocalDate;

public interface Lottery {
    LocalDate getLotteryDate();
    int winnerNumber(int numberOfTickets);
    void convertSql(int numberOfTicketsSold, LocalDate dataLottery);
}
