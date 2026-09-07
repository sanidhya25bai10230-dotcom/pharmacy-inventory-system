package service;

import exception.MedicineNotFoundException;
import model.Medicine;
import util.FileStorage;

import java.util.*;

public class InventoryService {

    private Map<String, Medicine> inventory;

    public InventoryService() {
        inventory = FileStorage.loadMedicines();
    }

    public void addMedicine(Medicine med) {
        inventory.put(med.getId(), med);
        FileStorage.saveMedicines(inventory);
    }

    public Medicine getMedicine(String id) throws MedicineNotFoundException {

        Medicine med = inventory.get(id);

        if (med == null) {
            throw new MedicineNotFoundException(
                    "Medicine with ID " + id + " was not found."
            );
        }

        return med;
    }

    public List<Medicine> getAllMedicines() {
        return new ArrayList<>(inventory.values());
    }

    public void updateStock(String id, int newQuantity)
            throws MedicineNotFoundException {

        Medicine med = getMedicine(id);
        med.setQuantity(newQuantity);

        FileStorage.saveMedicines(inventory);
    }

    public void removeMedicine(String id)
            throws MedicineNotFoundException {

        if (!inventory.containsKey(id)) {
            throw new MedicineNotFoundException(
                    "Medicine with ID " + id + " was not found."
            );
        }

        inventory.remove(id);
        FileStorage.saveMedicines(inventory);
    }

    public Map<String, Medicine> getRawInventory() {
        return inventory;
    }
}

