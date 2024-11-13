package com.example.sala;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SalaTest {

    @Test
    void testKonstruktorSala() {
        Sala sala = new Sala(5, 150);
        assertEquals(5, sala.getNumerSali());
        assertEquals(150, sala.getLiczbaMiejsc());
        assertEquals(150, sala.getDostepneMiejsca());
    }

    @Test
    void testZarezerwujMiejscaPoprawnie() {
        Sala sala = new Sala(2, 100);
        sala.zarezerwujMiejsca(30);
        assertEquals(70, sala.getDostepneMiejsca());
    }

    @Test
    void testZarezerwujMiejscaNiewystarczajaco() {
        Sala sala = new Sala(3, 50);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sala.zarezerwujMiejsca(60);
        });
        assertEquals("Nie można zarezerwować więcej miejsc niż dostępnych.", exception.getMessage());
    }

    @Test
    void testZarezerwujMiejscaZero() {
        Sala sala = new Sala(4, 100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sala.zarezerwujMiejsca(0);
        });
        assertEquals("Liczba miejsc do rezerwacji musi być większa niż zero.", exception.getMessage());
    }

    @Test
    void testZarezerwujMiejscaUjemna() {
        Sala sala = new Sala(5, 100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sala.zarezerwujMiejsca(-10);
        });
        assertEquals("Liczba miejsc do rezerwacji musi być większa niż zero.", exception.getMessage());
    }
}

