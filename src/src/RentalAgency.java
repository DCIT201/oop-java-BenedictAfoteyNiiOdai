import java.util.HashMap;
import java.util.Map;

class RentalServices {
    private final Map<String, Vehicle> vehicles;

    public RentalServices() {
        this.vehicles = new HashMap<>();
    }

    // Adds a new vehicle to the rental system
    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        vehicles.put(vehicle.getVehicleId(), vehicle);
        System.out.println("Vehicle added: " + vehicle.getModel());
    }

    // Rents a vehicle to a customer for a specified number of days
    public void rentVehicle(String vehicleId, Customer customer, int days) {
        if (vehicleId == null || customer == null) {
            throw new IllegalArgumentException("Vehicle ID and Customer cannot be null.");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Rental days must be positive.");
        }

        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle with ID " + vehicleId + " does not exist.");
        }

        // Check if vehicle is available for rental
        if (!vehicle.isAvailable()) {
            throw new IllegalArgumentException("Vehicle with ID " + vehicleId + " is not available for rental.");
        }

        // Rent the vehicle and update its status
        vehicle.setAvailable(false);

        // Record the rental transaction
        RentalTransaction transaction = new RentalTransaction(vehicle, customer, days);
        customer.addRental(transaction);

        System.out.println("Vehicle rented: " + vehicle.getModel() + " to " + customer.getName() + " for " + days + " days.");
    }

    // Returns a vehicle to the rental system
    public boolean returnVehicle(String vehicleId) {
        if (vehicleId == null) {
            throw new IllegalArgumentException("Vehicle ID cannot be null.");
        }

        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle == null) {
            System.out.println("Vehicle with ID " + vehicleId + " does not exist in the system.");
            return false;
        }

        // Check if the vehicle is already available
        if (vehicle.isAvailable()) {
            System.out.println("Vehicle with ID " + vehicleId + " is already marked as available.");
            return false;
        }

        // Mark the vehicle as available and return it
        vehicle.setAvailable(true);
        System.out.println("Vehicle returned: " + vehicle.getModel());
        return true;
    }

    // Method to check if a vehicle is available for rental (optional)
    public boolean isVehicleAvailable(String vehicleId) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle with ID " + vehicleId + " does not exist.");
        }
        return vehicle.isAvailable();
    }
}