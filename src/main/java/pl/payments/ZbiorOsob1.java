package pl.payments;

import java.util.Collection;
import java.util.Iterator;

public class ZbiorOsob1 implements Collection<Osoba> {

    Osoba[] osoby;
    int iloscOsob = 0;


    public ZbiorOsob1(int rozmiar) {
        osoby = new Osoba[rozmiar];
    }

    @Override
    public int size() {
        return iloscOsob;
    }

    @Override
    public boolean isEmpty() {
        return iloscOsob == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < iloscOsob; i++) {
            if (osoby[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Osoba> iterator() {
        throw new RuntimeException("Tego nie robimy");
    }

    @Override
    public Object[] toArray() {
        Osoba[] kopia = new Osoba[iloscOsob];
        System.arraycopy(osoby, 0, kopia, 0, iloscOsob);
        return kopia;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new RuntimeException("Tego nie robimy");
    }

    @Override
    public boolean add(Osoba osoba) {
        if (contains(osoba)) {
            return false;
        } else {
            osoby[iloscOsob] = osoba;
            iloscOsob++;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        int idx = -1;
        for (int i = 0; i < iloscOsob; i++) {
            if (osoby[i].equals(o)) {
                idx = i;
            }
        }
        if (idx != -1) {
//            osoby[idx] = null;
//            for (int i = idx; idx+1 < iloscOsob; i++) {
//                osoby[i] = osoby[i+1];
//            }
//
//            iloscOsob--;
//            osoby[iloscOsob] = null;

            osoby[idx] = osoby[iloscOsob - 1];
            osoby[iloscOsob - 1] = null;
            iloscOsob--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Osoba> c) {

        boolean changed = false;

        for (Osoba osoba : c) {
            boolean dodano = add(osoba);
            if (dodano) {
                changed = true;
            }
        }

        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;

        for (Object osoba : c) {
            boolean usunieto = remove(osoba);
            if (usunieto) {
                changed = true;
            }
        }

        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int i = 0;
        boolean changed = false;
        while (i < iloscOsob) {
            if (!c.contains(osoby[i])) {
                remove(osoby[i]);
                changed = true;
            } else {
                i++;
            }

        }

        return changed;
    }

    @Override
    public void clear() {

        for (int i = 0; i < iloscOsob; i++) {
            osoby[i] = null;
        }
        iloscOsob = 0;
    }
}
