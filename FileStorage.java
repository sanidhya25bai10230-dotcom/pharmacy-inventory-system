package util;

import model.Medicine;
import model.OTCMedicine;
import model.PrescriptionMedicine;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FileStorage {

    private static final String FILE_PATH = "data/medicines.csv";

    public static Map<String, Medicine> loadMedicines() {

        Map<String, Medicine> medicines = new HashMap<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return medicines;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length >= 7) {

                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String batch = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    int quantity = Integer.parseInt(parts[4].trim());
                    LocalDate expiry = LocalDate.parse(parts[5].trim());
                    String category = parts[6].trim();

                    if (category.equalsIgnoreCase("Prescription")) {
                        medicines.put(id, new PrescriptionMedicine(
                                id, name, batch, price, quantity, expiry, "General"
                        ));
                    } else {
                        medicines.put(id, new OTCMedicine(
                                id, name, batch, price, quantity, expiry, 0
                        ));
                    }
                }
            }

        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error loading medicines: " + e.getMessage());
        }

        return medicines;
    }

    public static void saveMedicines(Map<String, Medicine> medicines) {

        File folder = new File("data");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Medicine med : medicines.values()) {
                writer.write(med.toCsvRow());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving medicines: " + e.getMessage());
        }
    }
}

