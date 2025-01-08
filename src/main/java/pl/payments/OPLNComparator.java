package pl.payments;

public class OPLNComparator implements java.util.Comparator<Osoba> {

    @Override
    public int compare(Osoba o1, Osoba o2) {
        if (o1.getNazwisko().compareTo(o2.getNazwisko()) == 0) {
            o1.getImie().compareTo(o2.getImie());
        }
        return o1.getNazwisko().compareTo(o2.getNazwisko());
    }
}
