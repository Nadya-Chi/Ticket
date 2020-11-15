package ru.netology.domain;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<OptionsTicket> {
    public int compare(OptionsTicket o1,OptionsTicket o2) {
        return o1.getTime() - o2.getTime();
    }
}
