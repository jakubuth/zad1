package pl.payments;

public class RaportPoNazwiskachLubImionach implements java.util.Comparator <Raport> {
    @Override
    public int compare(Raport o1, Raport o2) {

        if(o2.nazwisko.toUpperCase().compareTo(o1.nazwisko.toUpperCase()) == 0){
          return o1.imie.toUpperCase().compareTo(o2.imie.toUpperCase());
        }

//        if(o2.nazwisko.compareTo(o1.nazwisko) = 0){
//            return o1.nazwisko.compareTo(o2.nazwisko) < 0 ? 1 : -1;
//        }
        return o1.nazwisko.toUpperCase().compareTo(o2.nazwisko.toUpperCase());
    }
}
