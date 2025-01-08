package pl.payments;

public class OPSWComparator implements java.util.Comparator<Osoba> {
    @Override
    public int compare(Osoba o1, Osoba o2) {
        return o1.sumaWplat - o2.sumaWplat;
    }
}
