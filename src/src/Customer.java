import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Customer {
    private final String customerId;
    private final String name;
    private final String email;  // New field: email address
    private final String phoneNumber;  // New field: phone number
    private final List<RentalTransaction> rentalHistory;

    // Constructor with additional details
    public Customer(String customerId, String name, String email, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.rentalHistory = new ArrayList<>();
    }


    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Method to add a rental transaction to the history
    public void addRental(RentalTransaction transaction) {
        rentalHistory.add(transaction);
    }

    // Get a read-only view of rental history
    public List<RentalTransaction> getRentalHistory() {
        return Collections.unmodifiableList(rentalHistory);
    }

    // New method to get current rentals
    public List<RentalTransaction> getCurrentRentals() {
        List<RentalTransaction> currentRentals = new ArrayList<>();
        for (RentalTransaction transaction : rentalHistory) {
            if (!transaction.isOverdue()) {
                currentRentals.add(transaction);
            }
        }
        return currentRentals;
    }

    // New method to get overdue rentals
    public List<RentalTransaction> getOverdueRentals() {
        List<RentalTransaction> overdueRentals = new ArrayList<>();
        for (RentalTransaction transaction : rentalHistory) {
            if (transaction.isOverdue()) {
                overdueRentals.add(transaction);
            }
        }
        return overdueRentals;
    }

    // Method to display basic customer information
    public String getCustomerDetails() {
        return "Customer: " + name + " (ID: " + customerId + ")";
    }

    // Method to display customer contact details
    public String getContactDetails() {
        return "Email: " + email + ", Phone: " + phoneNumber;
    }
}