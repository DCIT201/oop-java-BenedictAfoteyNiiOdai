// RentalTransaction.java
import java.time.LocalDate;

public class RentalTransaction {
    private final Vehicle vehicle;
    private final Customer customer;
    private final int rentalDays;
    private final LocalDate rentalDate;
    private final double rentalCost;

    public RentalTransaction(Vehicle vehicle, Customer customer, int rentalDays) {
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be positive.");
        }
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDays = rentalDays;
        this.rentalDate = LocalDate.now();
        this.rentalCost = vehicle.calculateRentalCost(rentalDays);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public boolean isOverdue() {
        return rentalDate.plusDays(rentalDays).isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Rental by " + customer.getName() + " for vehicle " + vehicle.getModel() + " ($" + rentalCost + ")";
    }
}