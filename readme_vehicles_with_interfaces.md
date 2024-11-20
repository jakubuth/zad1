# Zadanie Domowe – Dziedziczenie i Interfejsy w Java

## Ważne Uwagi

1. **Praca musi być samodzielna!**  
   Rozwiąż zadanie bez konsultacji z innymi. Wszelkie rozmowy z kolegami, zadawanie pytań lub odpowiadanie na pytania (zarówno w trakcie rozwiązywania, jak i po jego ukończeniu) będą uznane za brak samodzielności i skutkować będą **brakiem możliwości uzyskania plusa za aktywność na ćwiczeniach**.

2. **Pomaganie innym**, nawet po ukończeniu zadania, również skutkuje utratą uzyskanego wcześniej plusa.

3. Zadanie należy rozwiązać w środowisku **IntelliJ IDEA**.

4. **Zrzut ekranu na dowód samodzielności**:  
   Po wykonaniu zadania:
    - Otwórz dysk `z:` w swoim systemie, aby pokazać swój identyfikator użytkownika.
    - Na zrzucie ekranu powinny być widoczne:
        - wszystkie testy przechodzące (w zakładce testów IntelliJ IDEA, z rozwiniętą opcją `Show Passed`),
        - Twój identyfikator użytkownika (login w systemie).

5. Po wykonaniu zrzutu ekranu, **prześlij swoje rozwiązanie na GitHub**.

---

## Treść Zadania

Stwórz system odwzorowujący **pojazdy** z wykorzystaniem dziedziczenia oraz interfejsów w Javie.

---

### Wymagania

1. **Pakiet**:
    - Wszystkie klasy umieść w pakiecie `pl.example.vehicles`.

2. **Interfejsy**:
    - `Driveable`:
        - Metoda `void drive()`, która opisuje sposób poruszania się pojazdu.
    - `Refuelable`:
        - Metoda `void refuel(int amount)`, która zwiększa poziom paliwa.
        - Metoda `int getFuelLevel()`, która zwraca poziom paliwa.

3. **Klasa abstrakcyjna `Vehicle`**:
    - Implementuje **oba interfejsy**: `Driveable` i `Refuelable`.
    - Pola:
        - `String name` – nazwa pojazdu.
        - `int fuelLevel` – poziom paliwa (domyślnie `0`).
    - Konstruktor:
        - Przyjmuje nazwę pojazdu i przypisuje ją do pola `name`.
    - Metody:
        - `String getName()` – zwraca nazwę pojazdu.
        - `void refuel(int amount)` – zwiększa poziom paliwa o podaną wartość.
        - `int getFuelLevel()` – zwraca aktualny poziom paliwa.

4. **Klasy dziedziczące `Vehicle`**:
    - `Car`:
        - Implementuje `Driveable`.
        - Metoda `drive()`:
            - Jeśli poziom paliwa wynosi co najmniej `10`, wypisuje `"Car is driving"` i zmniejsza poziom paliwa o `10`.
            - Jeśli poziom paliwa wynosi mniej niż `10`, wypisuje `"Not enough fuel to drive"` i nie zmniejsza poziomu paliwa.
    - `Motorbike`:
        - Implementuje `Driveable`.
        - Metoda `drive()`:
            - Jeśli poziom paliwa wynosi co najmniej `5`, wypisuje `"Motorbike is riding"` i zmniejsza poziom paliwa o `5`.
            - Jeśli poziom paliwa wynosi mniej niż `5`, wypisuje `"Not enough fuel to ride"` i nie zmniejsza poziomu paliwa.
    - `Truck`:
        - Implementuje `Driveable`.
        - Metoda `drive()`:
            - Jeśli poziom paliwa wynosi co najmniej `20`, wypisuje `"Truck is hauling"` i zmniejsza poziom paliwa o `20`.
            - Jeśli poziom paliwa wynosi mniej niż `20`, wypisuje `"Not enough fuel to haul"` i nie zmniejsza poziomu paliwa.

5. **Testy:**
    - Przetestuj klasy przy użyciu dostarczonych testów w pliku `VehicleTest.java`.
    - Testy weryfikują:
        - poprawność implementacji metody `drive()`,
        - obsługę paliwa metodami `refuel()` i `getFuelLevel()`.

---

## Co należy oddać?

1. **Pliki `.java`**:
    - `Vehicle`, `Car`, `Motorbike`, `Truck`, `Driveable`, `Refuelable`.

2. **Zrzut ekranu**:
    - Widoczne wszystkie testy, które przeszły (zakładka testów IntelliJ IDEA, z rozwiniętą opcją `Show Passed`).
    - Widoczny identyfikator użytkownika (login w systemie po otwarciu dysku `z:`).

3. **Link do repozytorium GitHub** z Twoim rozwiązaniem.

Pracę należy przesłać do godziny **X** dnia **Y**.
