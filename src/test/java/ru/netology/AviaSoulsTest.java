package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Moscow", "Novosibirsk", 7_000, 10, 14);
    Ticket ticket2 = new Ticket("Moscow", "Novosibirsk", 6_000, 11, 17);
    Ticket ticket3 = new Ticket("Moscow", "Novosibirsk", 8_000, 15, 23);
    Ticket ticket4 = new Ticket("Vladivostok", "Khabarovsk", 6_000, 10, 14);
    Ticket ticket5 = new Ticket("Khabarovsk", "Moscow", 15_000, 16, 24);

    @Test
    public void shouldPriceMoreThanAnother() {
        AviaSouls avia = new AviaSouls();

        avia.add(ticket1);
        avia.add(ticket2);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPriceLessAnother() {
        AviaSouls avia = new AviaSouls();

        avia.add(ticket1);
        avia.add(ticket3);

        int expected = -1;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPriceEqual() {
        AviaSouls avia = new AviaSouls();

        avia.add(ticket2);
        avia.add(ticket4);

        int expected = 0;
        int actual = ticket2.compareTo(ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortPrice() {
        AviaSouls avia = new AviaSouls();

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);

        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = avia.search("Moscow", "Novosibirsk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicket() {
        AviaSouls avia = new AviaSouls();

        avia.add(ticket5);

        Ticket[] expected = {ticket5};
        Ticket[] actual = avia.search("Khabarovsk", "Moscow");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortFlightTime() {
        AviaSouls avia = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = avia.searchAndSortBy("Moscow", "Novosibirsk", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}