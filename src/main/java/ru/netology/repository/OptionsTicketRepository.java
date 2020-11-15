package ru.netology.repository;

import ru.netology.domain.OptionsTicket;

public class OptionsTicketRepository {
    private OptionsTicket[] ways = new OptionsTicket[0];

    public void add(OptionsTicket way) {
        int length = ways.length + 1;
        OptionsTicket[] tmp = new OptionsTicket[length];
        System.arraycopy(ways, 0, tmp, 0, ways.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = way;
        ways = tmp;
    }

    public OptionsTicket[] findAll() {
        return ways;
    }

    public OptionsTicket findById(int id) {
        for (OptionsTicket way : ways) {
            if (way.getId() == id) {
                return way;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = ways.length - 1;
        OptionsTicket[] tmp = new OptionsTicket[length];
        int index = 0;
        for (OptionsTicket way : ways) {
            if (way.getId() != id) {
                tmp[index] = way;
                index++;
            }
        }
        ways = tmp;
    }
}
