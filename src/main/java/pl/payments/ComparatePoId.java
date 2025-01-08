package pl.payments;

public class ComparatePoId implements java.util.Comparator< ZapisIodczyt.Dane> {

    @Override
    public int compare(ZapisIodczyt.Dane o1, ZapisIodczyt.Dane o2) {
        return o1.id - o2.id;
    }
}
