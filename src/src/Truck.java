public class Truck extends Vehicle {
    private static final double INSURANCE_FEE = 40.0;

    public Truck(String truckId, String model, double baseRentalRate) {
        super(truckId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Rental days must be positive.");
        }
        return (getBaseRentalRate() + INSURANCE_FEE) * days;
    }

    @Override
    public void rent(Customer customer, int days) {
        if (!isAvailableForRental()) {
            throw new IllegalStateException("Truck is not available for rental.");
        }
        setAvailable(false);
        System.out.println("Truck rented: " + getModel() + " to " + customer.getName() + " for " + days + " days.");
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car returned: " + getModel());
    }

    /**
     * @return
     */
    @Override
    public boolean isAvailableForRental() {
        return false;
    }

    @Override
    public String getDescription() {
        return "Truck: " + getModel() + " (ID: " + getVehicleId() + "), Rate: $" + getBaseRentalRate();
    }
}