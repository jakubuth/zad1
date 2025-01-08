package pl.pliki;

public class Person {

    private int id;
    private String imie;
    private String nazwisko;
    private double wyplata;

    public Person(int id, String imie, String nazwisko, double wyplata) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wyplata = wyplata;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getWyplata() {
        return wyplata;
    }
}
