package com.example.kino;

import com.example.film.Film;
import com.example.rezerwacja.Rezerwacja;
import com.example.sala.Sala;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KinoTest {

    private Kino kino;
    private Film film1;
    private Film film2;
    private Sala sala1;
    private Sala sala2;

    @BeforeEach
    void setUp() {
        kino = new Kino();
        film1 = new Film("Incepcja", "Sci-Fi", 148);
        film2 = new Film("Interstellar", "Sci-Fi", 169);
        sala1 = new Sala(1, 100);
        sala2 = new Sala(2, 150);
    }

    @Test
    void testDodajWieleFilmow() {
        kino.dodajFilm(film1);
        kino.dodajFilm(film2);

        assertEquals(2, kino.getFilmy().size());
        assertEquals("Incepcja", kino.getFilmy().get(0).getTytul());
        assertEquals("Interstellar", kino.getFilmy().get(1).getTytul());
    }

    @Test
    void testDodajWieleSal() {
        kino.dodajSale(sala1);
        kino.dodajSale(sala2);

        assertEquals(2, kino.getSale().size());
        assertEquals(1, kino.getSale().get(0).getNumerSali());
        assertEquals(2, kino.getSale().get(1).getNumerSali());
    }

    @Test
    void testDokonajWieluRezerwacji() {
        kino.dodajFilm(film1);
        kino.dodajSale(sala1);

        Rezerwacja rezerwacja1 = kino.dokonajRezerwacji(film1, sala1, 30);
        Rezerwacja rezerwacja2 = kino.dokonajRezerwacji(film1, sala1, 20);

        assertNotNull(rezerwacja1);
        assertNotNull(rezerwacja2);
        assertEquals(2, kino.getRezerwacje().size());
        assertEquals(50, sala1.getDostepneMiejsca());
    }

    @Test
    void testUnikalneNumeryRezerwacji() {
        kino.dodajFilm(film1);
        kino.dodajSale(sala1);

        Rezerwacja rezerwacja1 = kino.dokonajRezerwacji(film1, sala1, 10);
        Rezerwacja rezerwacja2 = kino.dokonajRezerwacji(film1, sala1, 20);

        assertNotEquals(rezerwacja1.getNumerRezerwacji(), rezerwacja2.getNumerRezerwacji());
    }

    @Test
    void testDokonajRezerwacjiNieistniejacegoFilmu() {
        kino.dodajSale(sala1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            kino.dokonajRezerwacji(film1, sala1, 10);
        });
        assertEquals("Film nie jest dostępny w kinie.", exception.getMessage());
    }

    @Test
    void testDokonajRezerwacjiNieistniejacejSali() {
        kino.dodajFilm(film1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            kino.dokonajRezerwacji(film1, sala1, 10);
        });
        assertEquals("Sala nie jest dostępna w kinie.", exception.getMessage());
    }

    @Test
    void testDokonajRezerwacjiZerowaLiczbaMiejsc() {
        kino.dodajFilm(film1);
        kino.dodajSale(sala1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            kino.dokonajRezerwacji(film1, sala1, 0);
        });
        assertEquals("Liczba miejsc do rezerwacji musi być większa niż zero.", exception.getMessage());
    }

    @Test
    void testDokonajRezerwacjiUjemnaLiczbaMiejsc() {
        kino.dodajFilm(film1);
        kino.dodajSale(sala1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            kino.dokonajRezerwacji(film1, sala1, -5);
        });
        assertEquals("Liczba miejsc do rezerwacji musi być większa niż zero.", exception.getMessage());
    }

    @Test
    void testDodajTenSamFilmKilkaKrotnie() {
        kino.dodajFilm(film1);
        kino.dodajFilm(film1); // Dodanie tego samego filmu ponownie

        assertEquals(2, kino.getFilmy().size());
        assertSame(film1, kino.getFilmy().get(0));
        assertSame(film1, kino.getFilmy().get(1));
    }

    @Test
    void testDodajTakaSamaSalaKilkaKrotnie() {
        kino.dodajSale(sala1);
        kino.dodajSale(sala1); // Dodanie tej samej sali ponownie

        assertEquals(2, kino.getSale().size());
        assertSame(sala1, kino.getSale().get(0));
        assertSame(sala1, kino.getSale().get(1));
    }

    @Test
    void testRezerwacjeNaRóżneFilmyISale() {
        Film film2 = new Film("Matrix", "Akcja", 136);
        Sala sala2 = new Sala(2, 120);

        kino.dodajFilm(film1);
        kino.dodajFilm(film2);
        kino.dodajSale(sala1);
        kino.dodajSale(sala2);

        Rezerwacja rezerwacja1 = kino.dokonajRezerwacji(film1, sala1, 40);
        Rezerwacja rezerwacja2 = kino.dokonajRezerwacji(film2, sala2, 60);

        assertNotNull(rezerwacja1);
        assertNotNull(rezerwacja2);
        assertEquals(2, kino.getRezerwacje().size());
        assertEquals(60, sala1.getDostepneMiejsca());
        assertEquals(60, sala2.getDostepneMiejsca());
    }

    @Test
    void testRezerwacjePrzekraczajaceLiczbeMiejscPoWieluRezerwacjach() {
        kino.dodajFilm(film1);
        kino.dodajSale(sala1);

        kino.dokonajRezerwacji(film1, sala1, 70);
        kino.dokonajRezerwacji(film1, sala1, 20);

        // Pozostaje 10 miejsc
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            kino.dokonajRezerwacji(film1, sala1, 15);
        });
        assertEquals("Nie można zarezerwować więcej miejsc niż dostępnych.", exception.getMessage());
    }
}

