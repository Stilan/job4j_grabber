package ru.job4j.ood.srp2;

import java.time.LocalDate;

public interface Lottery {
    LocalDate getLotteryDate();
    int numberOfTicketsSold(int soldTickets);
    void convertSql(int numberOfTicketsSold, LocalDate dataLottery);
}
