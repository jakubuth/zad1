package pl.payments;

public class Osoba {

    String id;
    String imie;
    String nazwisko;
    int sumaWplat;
    int maxWplata;

    public Osoba(String id, String imie, String nazwisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.sumaWplat = 0;
        this.maxWplata = 0;
    }

    public Osoba dodajWplate(int ilosc) {
        sumaWplat += ilosc;
        if (ilosc > maxWplata) {
            maxWplata = ilosc;
        }
        return this;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getSumaWplat() {
        return sumaWplat;
    }

    public int getMaxWplata() {
        return maxWplata;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + imie + " " + nazwisko + " " + sumaWplat;
    }
}
