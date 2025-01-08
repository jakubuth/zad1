package pl.payments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


// grupa 19:00
public class Raporty {
    enum Input{
        A,
        B,
        C,
        D,
    }
    public static void main(String[] args) {

        //stworzenie plików
        String inputFile = "inputC.txt";
        String raportMaxFile = "raport_max.txt";
        String raportSumafile = "raport_suma.txt";
        String raportSSPW = "raport_suma_sort_po_sumie_wplat.txt";
        String raportSSPN = "raport_suma_sort_po_nazwisku.txt";
        String raportID = "raport_sort_po_id.txt";

        List<Dane> dataList = new ArrayList<>();

        System.out.println("Podaj typ raportu");
        Scanner typ = new Scanner(System.in);
        Input input = Input.valueOf(typ.nextLine());
        switch(input){
            case Input.A: inputFile = "input.txt";
                break;
            case Input.B: inputFile = "inputB.txt";
                break;
            case Input.C: inputFile = "inputC.txt";
                break;
            case Input.D: inputFile = "inputD.txt";
                break;
        }

        try (Scanner scanner = new Scanner(new File(inputFile))) {
            extracteddata(scanner, dataList, input);
            Map<String, Osoba> osobaMap = new HashMap<>();
            hashmapwrite(dataList, osobaMap);
            max(raportMaxFile, osobaMap);
            sum(raportSumafile, osobaMap);
            sortSSPW(raportSSPW, osobaMap);
            sortLN(raportSSPN, osobaMap);
            sortID(raportID, osobaMap);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void hashmapwrite(List<Dane> dataList, Map<String, Osoba> osobaMap) {
        for (Dane data : dataList) {
            String key = data.id;
            Osoba osoba = osobaMap.get(key);

            if (osoba == null) {
                osoba = new Osoba(data.id, data.imie, data.nazwisko);
                osobaMap.put(key, osoba);
            }

            osoba.dodajWplate(data.wplata);
        }
    }

    private static void extracteddata(Scanner scanner, List<Dane> dataList, Input typ) {
        while (scanner.hasNextLine()) {
           switch (typ) {
               case Input.A: parseA(scanner, dataList);
               break;
               case Input.B: parseB(scanner, dataList);
               break;
               case Input.C: parseC(scanner, dataList);
               break;
               case Input.D: parseD(scanner, dataList);
               break;
           }

        }
    }

    private static void parseA(Scanner scanner, List<Dane> dataList) {
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        if (parts.length != 4) return;
        String id = parts[0];
        String imie = parts[1];
        String nazwisko = parts[2];
        String wplaty = parts[3];
        dataList.add(new Dane(id, imie, nazwisko, wplaty));
    }
    private static void parseB(Scanner scanner, List<Dane> dataList) {
        String line = scanner.nextLine();
        String[] parts = line.split(";");
        if (parts.length != 4) return;
        String id = parts[0];
        String imie = parts[1];
        String nazwisko = parts[2];
        String wplaty = parts[3];
        dataList.add(new Dane(id, imie, nazwisko, wplaty));
    }
    private static void parseC(Scanner scanner, List<Dane> dataList) {
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        if (parts.length != 4) return;
        String id = parts[0];
        String wplaty = parts[1];
        String imie = parts[2];
        String nazwisko = parts[3];
        dataList.add(new Dane(id, imie, nazwisko, wplaty));
    }
    private static void parseD(Scanner scanner, List<Dane> dataList) {
        String line = scanner.nextLine();
        String[] parts = line.split(";");
        if (parts.length != 4) return;
        String id = parts[0];
        String wplaty = parts[1];
        String imie = parts[2];
        String nazwisko = parts[3];
        dataList.add(new Dane(id, imie, nazwisko, wplaty));
    }

    private static void max(String raportMaxFile, Map<String, Osoba> osobaMap) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(new File(raportMaxFile))) {
            //opt. 1
            Osoba maxOsoba = null;

            for (Osoba osoba : osobaMap.values()) {
                if (maxOsoba == null || osoba.maxWplata >= maxOsoba.maxWplata) {
                    maxOsoba = osoba;
                }
            }

            /*
            //opt 2
            Dane x = dataList.get(0); //dane pierwszej osoby

            //Osoba maxOsoba = osobaMap.get(dataList.get(0).id);

            for(Osoba osoba : osobaMap.values()) {
                if(osoba.maxWplata >= maxOsoba.maxWplata) maxOsoba = osoba;
            }
             */
           pw.println(maxOsoba.getId() + " " + maxOsoba.getImie() + " " + maxOsoba.getNazwisko() + " " + maxOsoba.getMaxWplata());
        }
    }

    private static void sum(String raportSumafile, Map<String, Osoba> osobaMap) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(raportSumafile)) {
            for (Osoba osoba : osobaMap.values()) {
                //pw.println(osoba.getId() + " " + osoba.getImie() + " " + osoba.getNazwisko() + " " + osoba.getSumaWplat());
                pw.println(osoba.toString());
            }
        }
    }

    private static void sortSSPW(String raportSSPW, Map<String, Osoba> osobaMap) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(raportSSPW)) {
            List<Osoba> sortedSum = new ArrayList<>(osobaMap.values());

            //sortedSum.sort(Comparator.comparing(Osoba::getSumaWplat));

            sortedSum.sort(new OPSWComparator());
            for (Osoba osoba : sortedSum) {
                pw.println(osoba.toString());
            }
        }
    }

    private static void sortLN(String raportSSPN, Map<String, Osoba> osobaMap) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(raportSSPN)) {
            List<Osoba> sortedLN = new ArrayList<>(osobaMap.values());

            sortedLN.sort(new OPLNComparator());
            for (Osoba osoba : sortedLN) {
                pw.println(osoba.toString());
            }
        }
    }
    private static void sortID(String raportID, Map<String, Osoba> osobaMap) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(raportID)){
            List <Osoba> sortedID = new ArrayList<>(osobaMap.values());

            sortedID.sort(new IDComparator());
            for(Osoba osoba : sortedID){
                pw.println(osoba.toString());
            }
        }
    }

}