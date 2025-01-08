package pl.payments;

import java.io.*;
import java.util.*;

// grupa 15:30
public class Raport {
    public int suma;
    int id;
    String imie;
    String nazwisko;
    int wplata;

    public Raport(int id, String imie, String nazwisko, int wplata) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wplata = wplata;
    }

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedReader brSrednik = new BufferedReader(new FileReader("inputB.txt"));
            BufferedReader brInputC = new BufferedReader(new FileReader("inputC.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            BufferedWriter bwSuma = new BufferedWriter(new FileWriter("suma.txt"));
            BufferedWriter bwPosortowanaSuma = new BufferedWriter(new FileWriter("PosortowanaSuma.txt"));
            BufferedWriter bwPosortowanaNazwiskachLubImionach = new BufferedWriter(new FileWriter("PosortowanaNazwiskoLubImie.txt"));



            List<Raport> raporty = new ArrayList<>();
            String linia;

//            while ((linia = br.readLine()) != null) {
//                // bw.write(line);
//                Raport raport = conwertujLiniePoSpacji(linia);
//                raporty.add(raport);
//            }

//            while ((linia = brSrednik.readLine()) != null) {
//                // bw.write(line);
//                Raport raport = conwertujLiniePoSredniku(linia);
//                raporty.add(raport);
//            }
            while ((linia = brInputC.readLine()) != null) {
                // bw.write(line);
                Raport raport = conwertujLinie(linia);
                raporty.add(raport);
            }


//            int maxWplata = 0;
//            for (Raport raport : raporty) {
//                if (raport.wplata > maxWplata){
//                    maxWplata = raport.wplata;
//                }
//            }

//            Iterator<Raport> iterator = raporty.iterator();
//            while(iterator.hasNext()){
//                Raport raport = iterator.next();
//            }
//            for (int i = 0; i < raporty.size(); i++) {
//                Raport raport = raporty.get(i);
//            }
//
//            for(Raport raport : raporty) {
//                if (raport.wplata == maxWplata){
//                    bw.write(raport.id + " " + raport.imie + " " + raport.nazwisko + " " + raport.wplata + "\n");
//                }
//            }


            Raport maxRaport = null;
            for (Raport raport : raporty) {
                if (maxRaport == null || raport.wplata > maxRaport.wplata) {
                    maxRaport = raport;
                }
            }
            bw.write(maxRaport.id + " " + maxRaport.imie + " " + maxRaport.nazwisko + " " + maxRaport.wplata + "\n");


//            br.close();
            brSrednik.close();
            brInputC.close();
            bw.close();

            Map<Integer, Raport> map = new HashMap<>();

            for (Raport raport : raporty) {
                if (map.containsKey(raport.id)) {
                    map.get(raport.id).wplata += raport.wplata;
                } else {
                    map.put(raport.id, raport);
                }
            }

            for (Raport raport : map.values()) {
                bwSuma.write(raport.id + " " + raport.imie + " " + raport.nazwisko + " " + raport.wplata + "\n");
            }
            
            bwSuma.close();
            
            List<Raport> listaPoSumie = new ArrayList<>(map.values());
            List<Raport> listaPoNazwiskachLubImionach = new ArrayList<>(map.values());
            
            listaPoSumie.sort(new RaportPoSumie());
            listaPoNazwiskachLubImionach.sort(new RaportPoNazwiskachLubImionach());
            
            for (Raport raport : listaPoSumie) {
                bwPosortowanaSuma.write(raport.id + " " + raport.imie + " " + raport.nazwisko + " " + raport.wplata + "\n");
            }
            bwPosortowanaSuma.close();

            for (Raport raport : listaPoNazwiskachLubImionach) {
                bwPosortowanaNazwiskachLubImionach.write(raport.id + " " + raport.imie + " " + raport.nazwisko + " " + raport.wplata + "\n");
            }

            bwPosortowanaNazwiskachLubImionach.close();

        } catch (IOException e) {
            System.out.printf("błąd odczytu");
        }


    }

    private static Raport conwertujLiniePoSpacji(String linia) {
        String[] parts = linia.split(" ");
        int id = Integer.parseInt(parts[0]);
        String imie = parts[1];
        String nazwisko = parts[2];
        int wplata = Integer.parseInt(parts[3]);
        return new Raport(id, imie, nazwisko, wplata);
    }

    private static Raport conwertujLiniePoSredniku(String linia) {
        String[] parts = linia.split(";");
        int id = Integer.parseInt(parts[0]);
        String imie = parts[1];
        String nazwisko = parts[2];
        int wplata = Integer.parseInt(parts[3]);
        return new Raport(id, imie, nazwisko, wplata);
    }

    private static Raport conwertujLinie(String linia) {
        String[] parts = linia.split(" ");
        int id = Integer.parseInt(parts[0]);
        String imie = parts[2];
        String nazwisko = parts[3];
        int wplata = Integer.parseInt(parts[1]);
        return new Raport(id, imie, nazwisko, wplata);
    }



}
