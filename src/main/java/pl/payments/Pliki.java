package pl.payments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pliki

{
    public static void main(String[] args) throws FileNotFoundException {
        String Plikodczyt = args[0];
        String Plikzapis = args[1];
        System.out.printf(args[0]);
        File file = new File(Plikodczyt);
        Scanner in = new Scanner(file);
       //String zdanie= "Hello World\n";
        PrintWriter zapis2 = new PrintWriter(Plikzapis);
        zapis2.println("Hello World");

        while (in.hasNextLine())
        {
            zapis2.println(in.nextLine());
        }


        zapis2.println("Hello World");
        zapis2.close();


    }
}
