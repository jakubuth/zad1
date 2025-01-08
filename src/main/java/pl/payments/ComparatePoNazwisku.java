package pl.payments;

public class ComparatePoNazwisku implements java.util.Comparator< ZapisIodczyt.Dane> {
    @Override
    public int compare(ZapisIodczyt.Dane o1, ZapisIodczyt.Dane o2) {
        if(o1.nazwisko.toUpperCase().compareTo(o2.nazwisko.toUpperCase()) == 0){
            return o1.imie.toUpperCase().compareTo(o2.imie.toUpperCase());
        }else{
            return o1.nazwisko.toUpperCase().compareTo(o2.nazwisko.toUpperCase());
        }
    }
}
