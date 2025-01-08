package pl.pliki;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner in = new Scanner(file);
        //String zdanie = in.nextLine();
        PrintWriter zapis2 = new PrintWriter(args[1]);
        // zapis2.println("hello word");
        //zapis2.println(zdanie);

        while(in.hasNextLine()) {
            // zdanie = in.nextLine();
            zapis2.println(in.nextLine());
            int id = in.nextInt();
            String imie = in.next();
            String nazwisko = in.next();
            double wyplata = in.nextDouble();


        }

        // zapis2.println("hello word");
        zapis2.close();
    }

}

