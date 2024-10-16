package com.example.film;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    @Test
    void testKonstruktorFilm() {
        Film film = new Film("Matrix", "Akcja", 136);
        assertEquals("Matrix", film.getTytul());
        assertEquals("Akcja", film.getGatunek());
        assertEquals(136, film.getCzasTrwania());
    }

    @Test
    void testGetteryFilm() {
        Film film = new Film("Avatar", "Sci-Fi", 162);
        assertEquals("Avatar", film.getTytul());
        assertEquals("Sci-Fi", film.getGatunek());
        assertEquals(162, film.getCzasTrwania());
    }
}

