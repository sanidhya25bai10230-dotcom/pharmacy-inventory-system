package service;

import model.Medicine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReportService {

    private InventoryService inventoryService;

    public ReportService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public List<Medicine> getLowStockAlerts(int threshold) {

        List<Medicine> lowStock = new ArrayList<>();

        for (Medicine med : inventoryService.getAllMedicines()) {
            if (med.getQuantity() <= threshold) {
                lowStock.add(med);
            }
        }

        return lowStock;
    }

    public List<Medicine> getExpiredMedicines() {

        LocalDate today = LocalDate.now();
        List<Medicine> expired = new ArrayList<>();

        for (Medicine med : inventoryService.getAllMedicines()) {
            if (med.getExpiryDate().isBefore(today)) {
                expired.add(med);
            }
        }

        return expired;
    }
}

