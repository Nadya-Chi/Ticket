package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.OptionsTicket;
import ru.netology.domain.TicketByTimeAscComparator;
import ru.netology.repository.OptionsTicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsTicketManagerTest {
    OptionsTicketRepository repository = new OptionsTicketRepository();
    OptionsTicketManager manager = new OptionsTicketManager(repository);
    TicketByTimeAscComparator comparator = new TicketByTimeAscComparator();

    OptionsTicket one = new OptionsTicket(1,5000,"LED","GOJ",180);
    OptionsTicket two = new OptionsTicket(2,5000,"KUF","OGZ",210);
    OptionsTicket three = new OptionsTicket(3,5000,"DME","LED",90);
    OptionsTicket four = new OptionsTicket(4,5000,"LED","GOJ",200);

    @BeforeEach
    public void setUp() {
        repository.add(one);
        repository.add(two);
        repository.add(three);
        repository.add(four);
    }

    @Test
    public void findWay() {
        OptionsTicket[] actual = manager.findAll("KUF", "OGZ",comparator);
        OptionsTicket[] expected = new OptionsTicket[]{two};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findWays() {
        OptionsTicket[] actual = manager.findAll("LED", "GOJ",comparator);
        OptionsTicket[] expected = new OptionsTicket[]{one,four};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findWaysToNot() {
        OptionsTicket[] actual = manager.findAll("GOJ", "OGZ",comparator);
        OptionsTicket[] expected = new OptionsTicket[]{};

        assertArrayEquals(expected, actual);
    }
}
