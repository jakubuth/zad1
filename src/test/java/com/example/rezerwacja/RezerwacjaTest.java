package com.example.rezerwacja;

import com.example.film.Film;
import com.example.sala.Sala;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RezerwacjaTest {

    @Test
    void testKonstruktorRezerwacja() {
        Film film = new Film("Titanic", "Romans", 195);
        Sala sala = new Sala(1, 200);
        Rezerwacja rezerwacja = new Rezerwacja(1001, film, sala, 2);

        assertEquals(1001, rezerwacja.getNumerRezerwacji());
        assertEquals(film, rezerwacja.getFilm());
        assertEquals(sala, rezerwacja.getSala());
        assertEquals(2, rezerwacja.getLiczbaMiejsc());
    }

    @Test
    void testGetteryRezerwacja() {
        Film film = new Film("Gladiator", "Historia", 155);
        Sala sala = new Sala(2, 150);
        Rezerwacja rezerwacja = new Rezerwacja(1002, film, sala, 4);

        assertEquals(1002, rezerwacja.getNumerRezerwacji());
        assertEquals("Gladiator", rezerwacja.getFilm().getTytul());
        assertEquals(2, rezerwacja.getSala().getNumerSali());
        assertEquals(4, rezerwacja.getLiczbaMiejsc());
    }
}

