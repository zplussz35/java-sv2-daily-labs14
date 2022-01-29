package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StreetNumber {
    private Map<String, List<Integer>> sNumbers = new TreeMap<>();

    public void readFromFile(String filename) {
        try (BufferedReader bf = Files.newBufferedReader(Paths.get(filename))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] parts = line.split(" ");
                String street = parts[0];
                int hNumber = Integer.parseInt(parts[1]);
                if (!sNumbers.containsKey(street)) {
                    sNumbers.put(street, new ArrayList<>());
                }
                if (hNumber == 1) {
                    if (sNumbers.get(street).isEmpty()) {
                        sNumbers.get(street).add(1);
                    } else {
                        sNumbers.get(street).add(sNumbers.get(street).get(sNumbers.get(street).size() - 1) + 2);
                    }
                } else {
                    if (sNumbers.get(street).isEmpty()) {
                        sNumbers.get(street).add(2);
                    } else {
                        sNumbers.get(street).add(sNumbers.get(street).get(sNumbers.get(street).size() - 1) + 2);
                    }
                }

            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot reach file!");
        }
    }

    public Map<String,List<Integer>> getsNumbers(){
        return sNumbers;
    }


    public static void main(String[] args) {
        StreetNumber streetNumber= new StreetNumber();
        streetNumber.readFromFile("src/main/resources/streets.txt");
        System.out.println(streetNumber.getsNumbers());
    }
}
