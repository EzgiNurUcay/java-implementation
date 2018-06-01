/**
 * Created by Ezgi on 15.11.2017.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        HashTable hash = new HashTable(8);
        System.out.println("-- -- -- Extendible Hashing -- -- --");
        String fileName = "src/cartoon.txt";
        readTxt(fileName, hash);
        while (true) {

            System.out.println();
            System.out.print("Search: ");
            String input = scan.nextLine(); // To take input.
            //hash.add(input, 1); // means insert
            // hash.printhash();

            if (input.equals("*")) {
                System.out.print("Local: ");
                try {
                    input = scan.nextLine(); // To take input.
                    hash.searchtoDepth(Integer.valueOf(input));
                } catch (NumberFormatException e) {
                    System.err.println("Wrong input format");
                }
            } else if (input.equals("")) {
                System.err.println("Wrong entry");
            } else if (input.equals("--")) {
                System.out.println("Enter a word to completely delete");
                input = scan.nextLine(); // To take input.
                hash.add(input, 3); //delete all

            } else if (input.equals("-")) {
                System.out.println("Enter a word for deletion");
                input = scan.nextLine(); // To take input.
                hash.add(input, 4); //delete just one

            } else {
                hash.add(input, 2); // search

            }

        }

    }

    public static void readTxt(String filename, HashTable hash) {
        String line;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String str;

            while ((str = br.readLine()) != null) {
                line = str;
                String[] data = line.split(" ");
                for (int i = 0; i < data.length; i++) {

                    hash.add(data[i], 1); // insert
                    // If operation is true ,add function can provide insert.
                }
            }
        } catch (IOException ex) {
            System.err.println("Text not exist");

        }
    }
}
