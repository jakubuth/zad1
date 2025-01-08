package pl.payments;

import java.util.ArrayList;
import java.util.List;

public class SampleVararg {

    public static void main(String[] args) {
//        System.out.println(sumuj("foo", 2));
//        System.out.println(sumuj("bar",  2,3,4));
//        System.out.println(sumuj("baz", 2,3,7,8,9));


        List<Integer> liczby = new ArrayList<>();
        liczby.add(1);
        liczby.add(2);
        liczby.add(3);

        List<Integer> liczby2 = new ArrayList<>(liczby);
        liczby2.add(4);

        System.out.println(liczby);
        System.out.println(liczby2);
    }

    public static int sumuj(String opis, int... args) {
        int suma = 0;
        System.out.println("rozmiar: " + args.length);
        for (int arg: args) {
            suma+=arg;
        }
        return suma;
    }

    public List<Integer> sortuj(List<Integer> liczby) {
        return null;
    }


}
