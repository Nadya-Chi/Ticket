package ru.netology.manager;

import ru.netology.domain.OptionsTicket;
import ru.netology.repository.OptionsTicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class OptionsTicketManager {
    private OptionsTicketRepository repository;

    public OptionsTicketManager(OptionsTicketRepository repository) {
        this.repository = repository;
    }

    public void add(OptionsTicket way) {
        repository.add(way);
    }

    public OptionsTicket[] findAll(String from, String to, Comparator<OptionsTicket> comparator) {
        OptionsTicket[] ways = new OptionsTicket[0];
        for (OptionsTicket way : repository.findAll()) {
            if (way.getFrom().equals(from) && way.getTo().equals(to)) {
                OptionsTicket[] tmp = new OptionsTicket[ways.length + 1];
                System.arraycopy(ways, 0, tmp, 0, ways.length);
                tmp[tmp.length - 1] = way;
                ways = tmp;
            }
        }
        Arrays.sort(ways, comparator);
        return ways;
    }
}
