package pl.archplikigr15;

public class Osoby {

    int id;
    String imie;
    String nazwisko;
    int wyplata;
    public Osoby(String imie, String nazwisko, int wyplata, int id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wyplata = wyplata;
        this.id = id;
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

    public int getWyplata() {
        return wyplata;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setWyplata(int wyplata) {
        this.wyplata = wyplata;
    }
}
