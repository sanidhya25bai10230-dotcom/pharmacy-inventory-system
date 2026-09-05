import exception.InsufficientStockException;
import exception.MedicineNotFoundException;
import model.Medicine;
import model.OTCMedicine;
import model.PrescriptionMedicine;
import service.BillingService;
import service.InventoryService;
import service.ReportService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static InventoryService inventoryService = new InventoryService();
    private static BillingService billingService =
            new BillingService(inventoryService);
    private static ReportService reportService =
            new ReportService(inventoryService);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            printMenu();

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    displayAllMedicines();
                    break;

                case "2":
                    addNewMedicine();
                    break;

                case "3":
                    modifyStock();
                    break;

                case "4":
                    checkoutMedicine();
                    break;

                case "5":
                    viewReports();
                    break;

                case "6":
                    System.out.println("Thank you for using the Pharmacy System.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private static void printMenu() {

        System.out.println("Pharmacy Management System");
        System.out.println("1 View All Medicines");
        System.out.println("2 Add New Medicine");
        System.out.println("3 Update Medicine Stock");
        System.out.println("4 Billing");
        System.out.println("5 View Reports");
        System.out.println("6 Exit");
    }

    private static void displayAllMedicines() {

        List<Medicine> medicines = inventoryService.getAllMedicines();

        if (medicines.isEmpty()) {
            System.out.println("No medicines found in inventory.");
            return;
        }

        System.out.println("Medicine Inventory:");

        for (Medicine med : medicines) {
            System.out.println(med);
        }
    }

    private static void addNewMedicine() {

        try {

            System.out.print("Enter Medicine ID: ");
            String id = scanner.nextLine().trim();

            System.out.print("Enter Medicine Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Batch Number: ");
            String batch = scanner.nextLine().trim();

            System.out.print("Enter Price: ");
            double price = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Enter Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
            LocalDate expiry =
                    LocalDate.parse(scanner.nextLine().trim());

            System.out.print("Is it a prescription medicine? (y/n): ");
            String answer = scanner.nextLine().trim();

            Medicine medicine;

            if (answer.equalsIgnoreCase("y")) {

                medicine = new PrescriptionMedicine(
                        id, name, batch, price, quantity,
                        expiry, "General Practice"
                );

            } else {

                medicine = new OTCMedicine(
                        id, name, batch, price, quantity,
                        expiry, 0
                );
            }

            inventoryService.addMedicine(medicine);

            System.out.println("Medicine added successfully.");

        } catch (DateTimeParseException e) {

            System.out.println("Invalid date. Please use YYYY-MM-DD.");

        } catch (NumberFormatException e) {

            System.out.println("Price and quantity must be numbers.");
        }
    }

    private static void modifyStock() {

        try {

            System.out.print("Enter Medicine ID: ");
            String id = scanner.nextLine().trim();

            System.out.print("Enter New Quantity: ");
            int quantity =
                    Integer.parseInt(scanner.nextLine().trim());

            inventoryService.updateStock(id, quantity);

            System.out.println("Stock updated successfully.");

        } catch (NumberFormatException e) {

            System.out.println("Quantity must be a number.");

        } catch (MedicineNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void checkoutMedicine() {

        try {

            System.out.print("Enter Medicine ID: ");
            String id = scanner.nextLine().trim();

            System.out.print("Enter Quantity: ");
            int quantity =
                    Integer.parseInt(scanner.nextLine().trim());

            double total =
                    billingService.processOrder(id, quantity);

            System.out.printf(
                    "Purchase successful. Total including 5%% tax: Rs %.2f%n",
                    total
            );

        } catch (NumberFormatException e) {

            System.out.println("Quantity must be a number.");

        } catch (MedicineNotFoundException |
                 InsufficientStockException e) {

            System.out.println("Purchase failed: " + e.getMessage());
        }
    }

    private static void viewReports() {

        System.out.println("Inventory Reports:");

        List<Medicine> lowStock =
                reportService.getLowStockAlerts(5);

        System.out.println("Low Stock Medicines: " + lowStock.size());

        for (Medicine med : lowStock) {

            System.out.println(
                    "Low Stock: " + med.getName()
                    + " Quantity: " + med.getQuantity()
            );
        }

        List<Medicine> expired =
                reportService.getExpiredMedicines();

        System.out.println("Expired Medicines: " + expired.size());

        for (Medicine med : expired) {

            System.out.println(
                    "Expired: " + med.getName()
                    + " Expiry Date: " + med.getExpiryDate()
            );
        }
    }
}

