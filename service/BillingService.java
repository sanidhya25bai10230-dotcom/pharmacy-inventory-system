package service;

import exception.InsufficientStockException;
import exception.MedicineNotFoundException;
import model.Medicine;
import util.FileStorage;

public class BillingService {

    private InventoryService inventoryService;
    private static final double TAX_RATE = 0.05;

    public BillingService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public double processOrder(String medicineId, int quantityPurchased)
            throws MedicineNotFoundException, InsufficientStockException {

        Medicine med = inventoryService.getMedicine(medicineId);

        if (med.getQuantity() < quantityPurchased) {
            throw new InsufficientStockException(
                    "Not enough stock. Only " + med.getQuantity()
                    + " units are available."
            );
        }

        double subtotal = med.getPrice() * quantityPurchased;
        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax;

        
        med.setQuantity(med.getQuantity() - quantityPurchased);

        FileStorage.saveMedicines(inventoryService.getRawInventory());

        return total;
    }
}

