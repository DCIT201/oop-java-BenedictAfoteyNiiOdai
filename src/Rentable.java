/**
 * Interface for rentable items.
 * Defines behaviors for renting, returning, and managing rental status.
 */
public interface Rentable {

    void rent(Customer customer, int days);

    void returnVehicle();

    boolean isAvailableForRental();

    double calculateRentalCost(int days);

    String getDescription();
}