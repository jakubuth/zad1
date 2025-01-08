package pl.payments;

public class Dane {

    String id;
    String imie;
    String nazwisko;
    int wplata;

    public Dane(String id, String imie, String nazwisko, String wplata) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wplata = Integer.parseInt(wplata);
    }
}
