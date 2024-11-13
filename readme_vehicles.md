# Zadanie: Podstawy Dziedziczenia w Java

Twoim zadaniem jest utworzenie struktury klas reprezentujących różne typy pojazdów z wykorzystaniem dziedziczenia i klasy abstrakcyjnej. Zadanie obejmuje implementację klas w jednym pakiecie oraz przetestowanie ich działania za pomocą testów JUnit.

## Wymagania

### 1. Utwórz pakiet `pl.example.vehicles`.

### 2. Utwórz klasę abstrakcyjną `Vehicle`:
- Pole `String name` przechowujące nazwę pojazdu.
- Konstruktor przyjmujący parametr `name` i przypisujący go do pola `name`.
- Abstrakcyjną metodę `int getMaxSpeed()`, która zwraca maksymalną prędkość pojazdu.
- Metodę `String getName()`, która zwraca nazwę pojazdu.

### 3. Utwórz dwie klasy `Car` i `Bike`, które dziedziczą po klasie `Vehicle`:
- **Klasa `Car`**:
    - Pole `int doors`, przechowujące liczbę drzwi.
    - Konstruktor przyjmujący `name` i `doors`, wywołujący konstruktor klasy `Vehicle` oraz przypisujący wartość do `doors`.
    - Nadpisaną metodę `getMaxSpeed()` zwracającą wartość 200.
    - Metodę `int getDoors()`, która zwraca liczbę drzwi pojazdu.

- **Klasa `Bike`**:
    - Konstruktor przyjmujący parametr `name`, wywołujący konstruktor klasy `Vehicle`.
    - Nadpisaną metodę `getMaxSpeed()` zwracającą wartość 50.

### 4. Utwórz klasę testową `VehiclesTest` w pakiecie `pl.example.vehicles`:
- Przetestuj poprawność działania klas `Car` i `Bike`, w szczególności:
    - Czy `Car` zwraca maksymalną prędkość 200.
    - Czy `Bike` zwraca maksymalną prędkość 50.
    - Czy `Car` poprawnie przechowuje i zwraca liczbę drzwi.
    - Czy metoda `getName()` działa poprawnie dla obiektów `Car` i `Bike`.

### Przykład Użycia

Przykładowy kod testowy powinien wyglądać następująco:

```java
Car car = new Car("Sedan", 4);
assertEquals(200, car.getMaxSpeed());
assertEquals(4, car.getDoors());

Bike bike = new Bike("Mountain Bike");
assertEquals(50, bike.getMaxSpeed());
