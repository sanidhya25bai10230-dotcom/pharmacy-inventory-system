package model;

import java.time.LocalDate;

public class PrescriptionMedicine extends Medicine {

    private String doctorSpecializationRequired;

    public PrescriptionMedicine(String id, String name, String batchNumber,
                                double price, int quantity, LocalDate expiryDate,
                                String specialization) {
        super(id, name, batchNumber, price, quantity, expiryDate);
        this.doctorSpecializationRequired = specialization;
    }

    @Override
    public String getCategory() {
        return "Prescription";
    }

    public String getDoctorSpecializationRequired() {
        return doctorSpecializationRequired;
    }
}

