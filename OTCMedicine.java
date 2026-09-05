package model;

import java.time.LocalDate;

public class OTCMedicine extends Medicine {

    private int ageLimit;

    public OTCMedicine(String id, String name, String batchNumber,
                       double price, int quantity, LocalDate expiryDate,
                       int ageLimit) {
        super(id, name, batchNumber, price, quantity, expiryDate);
        this.ageLimit = ageLimit;
    }

    @Override
    public String getCategory() {
        return "OTC";
    }

    public int getAgeLimit() {
        return ageLimit;
    }
}

