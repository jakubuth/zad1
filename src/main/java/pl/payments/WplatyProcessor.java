package pl.payments;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class WplatyProcessor {

    public static void main(String[] args) throws IOException {
        if (args.length < 5) {
            System.out.println("Podaj 5 ścieżek plików: input, raport_max, raport_suma, raport_suma_sort_po_sumie, raport_suma_sort_po_nazwisku");
            return;
        }

        String inputFilePath = args[0];
        String maxReportFilePath = args[1];
        String sumReportFilePath = args[2];
        String sortedSumReportFilePath = args[3];
        String sortedByNameReportFilePath = args[4];

        // Wczytaj wpłaty
        List<Wplata> wplaty = wczytajWplaty(inputFilePath);

        // Generuj raporty
        zapiszRaportMax(wplaty, maxReportFilePath);
        zapiszRaportSuma(wplaty, sumReportFilePath);
        zapiszRaportSumaSortPoSumie(wplaty, sortedSumReportFilePath);
        zapiszRaportSumaSortPoNazwisku(wplaty, sortedByNameReportFilePath);
    }

    private static List<Wplata> wczytajWplaty(String filePath) throws IOException {
        List<Wplata> wplaty = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int id = Integer.parseInt(parts[0]);
                String imie = parts[1];
                String nazwisko = parts[2];
                int wplata = Integer.parseInt(parts[3]);
                wplaty.add(new Wplata(id, imie, nazwisko, wplata));
            }
        }
        return wplaty;
    }

    private static void zapiszRaportMax(List<Wplata> wplaty, String filePath) throws IOException {
        Optional<Wplata> maxWplata = wplaty.stream().max(Comparator.comparingInt(Wplata::getWplata));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            maxWplata.ifPresent(w -> {
                try {
                    writer.write(w.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void zapiszRaportSuma(List<Wplata> wplaty, String filePath) throws IOException {
        Map<String, Integer> sumaMap = wplaty.stream()
                .collect(Collectors.groupingBy(Wplata::getKey, Collectors.summingInt(Wplata::getWplata)));

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (Map.Entry<String, Integer> entry : sumaMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        }
    }

    private static void zapiszRaportSumaSortPoSumie(List<Wplata> wplaty, String filePath) throws IOException {
        Map<String, Integer> sumaMap = wplaty.stream()
                .collect(Collectors.groupingBy(Wplata::getKey, Collectors.summingInt(Wplata::getWplata)));

        List<Map.Entry<String, Integer>> sorted = sumaMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (Map.Entry<String, Integer> entry : sorted) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        }
    }

    private static void zapiszRaportSumaSortPoNazwisku(List<Wplata> wplaty, String filePath) throws IOException {
        Map<String, Integer> sumaMap = wplaty.stream()
                .collect(Collectors.groupingBy(Wplata::getKey, Collectors.summingInt(Wplata::getWplata)));

        List<Map.Entry<String, Integer>> sorted = sumaMap.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Integer> e) -> e.getKey().split(" ")[2]) // Nazwisko
                        .thenComparing(e -> e.getKey().split(" ")[1])) // Imię
                .collect(Collectors.toList());

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (Map.Entry<String, Integer> entry : sorted) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        }
    }

    // Klasa reprezentująca wpłatę
    static class Wplata {
        private final int id;
        private final String imie;
        private final String nazwisko;
        private final int wplata;

        public Wplata(int id, String imie, String nazwisko, int wplata) {
            this.id = id;
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.wplata = wplata;
        }

        public int getWplata() {
            return wplata;
        }

        public String getKey() {
            return id + " " + imie + " " + nazwisko;
        }

        @Override
        public String toString() {
            return id + " " + imie + " " + nazwisko + " " + wplata;
        }
    }
}
