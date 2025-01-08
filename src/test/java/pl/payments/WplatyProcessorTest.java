package pl.payments;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WplatyProcessorTest {

    private final String inputFilePath = "test_input.txt";
    private final String maxReportFilePath = "test_raport_max.txt";
    private final String sumReportFilePath = "test_raport_suma.txt";
    private final String sortedSumReportFilePath = "test_raport_suma_sort_po_sumie_wplat.txt";
    private final String sortedByNameReportFilePath = "test_raport_suma_sort_po_nazwisku.txt";

    @BeforeEach
    void setup() throws Exception {
        List<String> input = Arrays.asList(
                "123 Jan Kowalski 20",
                "333 Paweł Nowak 300",
                "123 Jan Kowalski 40",
                "333 Paweł Nowak 10",
                "444 Anna Kwiatkowska 50",
                "123 Jan Kowalski 10"
        );
        Files.write(Paths.get(inputFilePath), input);
    }

    @Test
    void testRaportMax() throws Exception {
        WplatyProcessor.main(new String[]{inputFilePath, maxReportFilePath, sumReportFilePath, sortedSumReportFilePath, sortedByNameReportFilePath});
        List<String> maxReport = Files.readAllLines(Paths.get(maxReportFilePath));

        assertEquals(1, maxReport.size());
        assertEquals("333 Paweł Nowak 300", maxReport.get(0));
    }

    @Test
    void testRaportSuma() throws Exception {
        WplatyProcessor.main(new String[]{inputFilePath, maxReportFilePath, sumReportFilePath, sortedSumReportFilePath, sortedByNameReportFilePath});
        List<String> sumReport = Files.readAllLines(Paths.get(sumReportFilePath));

        List<String> expected = Arrays.asList(
                "123 Jan Kowalski 70",
                "333 Paweł Nowak 310",
                "444 Anna Kwiatkowska 50"
        );
        assertEquals(expected, sumReport);
    }

    @Test
    void testRaportSumaSortPoSumieWplat() throws Exception {
        WplatyProcessor.main(new String[]{inputFilePath, maxReportFilePath, sumReportFilePath, sortedSumReportFilePath, sortedByNameReportFilePath});
        List<String> sortedSumReport = Files.readAllLines(Paths.get(sortedSumReportFilePath));

        List<String> expected = Arrays.asList(
                "333 Paweł Nowak 310",
                "123 Jan Kowalski 70",
                "444 Anna Kwiatkowska 50"
        );
        assertEquals(expected, sortedSumReport);
    }

    @Test
    void testRaportSumaSortPoNazwisku() throws Exception {
        WplatyProcessor.main(new String[]{inputFilePath, maxReportFilePath, sumReportFilePath, sortedSumReportFilePath, sortedByNameReportFilePath});
        List<String> sortedByNameReport = Files.readAllLines(Paths.get(sortedByNameReportFilePath));

        List<String> expected = Arrays.asList(
                "123 Jan Kowalski 70",
                "444 Anna Kwiatkowska 50",
                "333 Paweł Nowak 310"
        );
        assertEquals(expected, sortedByNameReport);
    }

    @AfterEach
    void cleanup() throws Exception {
        Files.deleteIfExists(Paths.get(inputFilePath));
        Files.deleteIfExists(Paths.get(maxReportFilePath));
        Files.deleteIfExists(Paths.get(sumReportFilePath));
        Files.deleteIfExists(Paths.get(sortedSumReportFilePath));
        Files.deleteIfExists(Paths.get(sortedByNameReportFilePath));
    }
}

