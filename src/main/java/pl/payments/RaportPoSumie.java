package pl.payments;

public class RaportPoSumie implements java.util.Comparator<Raport> {
    @Override
    public int compare(Raport o1, Raport o2) {
        return o1.wplata - o2.wplata;
    }
}
