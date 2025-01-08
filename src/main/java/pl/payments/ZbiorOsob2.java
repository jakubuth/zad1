package pl.payments;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

// License server:  https://uthwaw.fls.jetbrains.com
public class ZbiorOsob2 implements Collection<Osoba> {

    Osoba[] osoby;
    private int liczbaOsob;


    public ZbiorOsob2(int maxRozmiar) {
        osoby = new Osoba[maxRozmiar];
    }


    @Override
    public boolean isEmpty() {
        if (liczbaOsob == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        for (Osoba osoba : osoby) {
            if (osoba.equals(o)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }


    @Override
    public boolean add(Osoba osoba) {
        if (liczbaOsob < osoby.length) {
            if (contains(osoba)) {
                return false;
            }
            osoby[liczbaOsob++] = osoba;
            return true;
        }
        return false;
    }
    // Dokończyć

    @Override
    public int size() {
        return liczbaOsob;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < liczbaOsob; i++) {
            if (osoby[i].equals(o)) {
                osoby[i] = null;
                for (int j = 0; i > 0; j--) {
                    osoby[i - 1] = osoby[i];
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Osoba> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<Osoba> iterator() {
        return null;
    }
}
