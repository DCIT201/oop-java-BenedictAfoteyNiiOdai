public abstract class Vehicle implements Rentable {
    private final String vehicleId;
    private final String model;
    private double baseRentalRate;
    private boolean isAvailable;

    // Constructor with validation for required fields
    public Vehicle(String vehicleId, String model, double baseRentalRate) {
        if (vehicleId == null || vehicleId.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty.");
        }
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be positive.");
        }

        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true; // Default availability
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Restricting external modification of availability
    void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // Abstract method to calculate rental cost, to be implemented by subclasses
    public abstract double calculateRentalCost(int days);

    @Override
    public String toString() {
        return model + " (ID: " + vehicleId + ", Rate: $" + baseRentalRate + ")";
    }

    public abstract void rent(Customer customer, int days);
}
