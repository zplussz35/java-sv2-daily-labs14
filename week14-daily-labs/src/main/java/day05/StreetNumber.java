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
                if (!setUpStreets(street, hNumber)) {
                    addNewNumber(street,hNumber);
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot reach file!");
        }
    }

    private void addNewNumber(String street, int hNumber) {
        int maxNumber=sNumbers.get(street).stream().mapToInt(i->i).filter(i->i%2==hNumber).max().orElse(-hNumber);
        sNumbers.get(street).add(maxNumber+2);
    }

    private boolean setUpStreets(String street, int hNumber) {
        if (!sNumbers.containsKey(street)) {
            sNumbers.put(street, new ArrayList<>());
            if (hNumber == 1) {
                sNumbers.get(street).add(1);
            } else {
                sNumbers.get(street).add(2);
            }
            return true;
        }
        return false;
    }

    public Map<String, List<Integer>> getsNumbers() {
        return sNumbers;
    }


    public static void main(String[] args) {
        StreetNumber streetNumber = new StreetNumber();
        streetNumber.readFromFile("src/main/resources/streets.txt");
        System.out.println(streetNumber.getsNumbers());
    }
}
