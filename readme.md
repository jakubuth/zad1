# Zadanie: System Rezerwacji Biletów do Kina

## Cel zadania

Celem zadania jest zaimplementowanie systemu do rezerwacji biletów do kina w języku Java z wykorzystaniem paradygmatu programowania obiektowego. System będzie umożliwiał dodawanie filmów, sal kinowych oraz dokonywanie rezerwacji miejsc. Ważnym elementem zadania jest również przetestowanie poprawności implementacji za pomocą testów jednostkowych z użyciem frameworka JUnit.

## Wymagania

Twoim zadaniem jest zaimplementowanie kilku klas, które będą symulować działanie systemu rezerwacji biletów w kinie:

1. **Film** - klasa reprezentująca film.
2. **Sala** - klasa reprezentująca salę kinową.
3. **Rezerwacja** - klasa reprezentująca pojedynczą rezerwację.
4. **Kino** - klasa, która będzie zarządzać filmami, salami i rezerwacjami.

Poza implementacją, musisz przygotować testy jednostkowe JUnit, które zweryfikują poprawność Twojego rozwiązania.

### 1. Klasa `Film`
Klasa powinna przechowywać informacje o filmie, takie jak:
- `tytul` (String) – tytuł filmu,
- `gatunek` (String) – gatunek filmu (np. Akcja, Sci-Fi, Romans),
- `czasTrwania` (int) – czas trwania filmu w minutach.

**Metody**:
- Konstruktor przyjmujący wszystkie powyższe parametry,
- Gettery dla wszystkich pól.

### 2. Klasa `Sala`
Klasa powinna reprezentować salę kinową, która ma następujące pola:
- `numerSali` (int) – numer sali,
- `liczbaMiejsc` (int) – całkowita liczba miejsc w sali,
- `dostepneMiejsca` (int) – liczba dostępnych miejsc w sali (na początku równa liczbaMiejsc).

**Metody**:
- Konstruktor przyjmujący numer sali i liczbę miejsc,
- Gettery dla wszystkich pól,
- Metoda `zarezerwujMiejsca(int liczba)`, która zmniejszy liczbę dostępnych miejsc w sali o podaną liczbę. W przypadku, gdy liczba miejsc do rezerwacji jest większa niż dostępna lub mniejsza niż 1, metoda powinna rzucić odpowiedni wyjątek (`IllegalArgumentException`).

### 3. Klasa `Rezerwacja`
Klasa powinna reprezentować pojedynczą rezerwację, która zawiera:
- `numerRezerwacji` (int) – unikalny numer rezerwacji,
- `film` (Film) – obiekt klasy `Film`,
- `sala` (Sala) – obiekt klasy `Sala`,
- `liczbaMiejsc` (int) – liczba miejsc zarezerwowanych na dany film w danej sali.

**Metody**:
- Konstruktor przyjmujący wszystkie powyższe parametry,
- Gettery dla wszystkich pól.

### 4. Klasa `Kino`
Klasa zarządzająca salami, filmami oraz rezerwacjami. Powinna zawierać:
- Listę dostępnych filmów,
- Listę dostępnych sal,
- Listę dokonanych rezerwacji.

**Metody**:
- `dodajFilm(Film film)` – dodaje film do listy filmów,
- `dodajSale(Sala sala)` – dodaje salę do listy sal,
- `dokonajRezerwacji(Film film, Sala sala, int liczbaMiejsc)` – dokonuje rezerwacji dla określonego filmu i sali. W przypadku powodzenia, liczba dostępnych miejsc w sali powinna zostać odpowiednio zaktualizowana. Metoda powinna rzucać wyjątki, jeśli:
    - Film nie jest dostępny w repertuarze kina,
    - Sala nie jest dostępna w kinie,
    - Liczba miejsc do rezerwacji jest większa niż dostępna liczba miejsc.

## Wymagania dotyczące testów

Do każdej klasy musisz napisać odpowiednie testy jednostkowe przy użyciu JUnit. Testy powinny weryfikować poprawność działania wszystkich metod klas, z uwzględnieniem przypadków poprawnych oraz niepoprawnych (np. próby zarezerwowania zbyt wielu miejsc).

Przykłady testów, które należy uwzględnić:
- Dodawanie filmów i sal do kina,
- Dokonywanie poprawnych i niepoprawnych rezerwacji,
- Sprawdzanie, czy liczba dostępnych miejsc jest poprawnie aktualizowana,
- Próba rezerwacji z nieprawidłową liczbą miejsc (np. ujemną lub zerową).

## Przykład

Przykład rezerwacji w kinie:
```java
Kino kino = new Kino();
Film film = new Film("Matrix", "Akcja", 136);
Sala sala = new Sala(1, 100);

// Dodanie filmu i sali do kina
kino.dodajFilm(film);
kino.dodajSale(sala);

// Dokonanie rezerwacji 20 miejsc na film "Matrix" w sali nr 1
Rezerwacja rezerwacja = kino.dokonajRezerwacji(film, sala, 20);
System.out.println("Dokonano rezerwacji nr " + rezerwacja.getNumerRezerwacji());

Zalecana struktura katalogów projektu powinna wyglądać następująco:


src/
├── main/
│   └── java/
│       └── com/
│           └── example/
│               ├── kino/
│               │   └── Kino.java
│               ├── film/
│               │   └── Film.java
│               ├── sala/
│               │   └── Sala.java
│               └── rezerwacja/
│                   └── Rezerwacja.java
└── test/
    └── java/
        └── com/
            └── example/
                ├── kino/
                │   └── KinoTest.java
                ├── film/
                │   └── FilmTest.java
                ├── sala/
                │   └── SalaTest.java
                └── rezerwacja/
                    └── RezerwacjaTest.java
