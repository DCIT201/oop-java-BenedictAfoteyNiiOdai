public class Car extends Vehicle {
    private static final double INSURANCE_FEE = 40.0;

    public Car(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
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
            throw new IllegalStateException("Car is not available for rental.");
        }
        setAvailable(false);
        System.out.println("Car rented: " + getModel() + " to " + customer.getName() + " for " + days + " days.");
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
        return "Car: " + getModel() + " (ID: " + getVehicleId() + "), Rate: $" + getBaseRentalRate();
    }
}
