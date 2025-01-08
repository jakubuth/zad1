package pl.payments;

public class ComparatePoWplacie implements java.util.Comparator<ZapisIodczyt.Dane> {

    @Override
    public int compare(ZapisIodczyt.Dane o1, ZapisIodczyt.Dane o2) {
        return o1.wplata - o2.wplata;
    }
}
