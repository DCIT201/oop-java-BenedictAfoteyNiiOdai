public class Main {
    public static void main(String[] args) {
        // Create rental service
        RentalServices rentalServices = new RentalServices();

        // Create sample vehicles
        Vehicle car1 = new Car("V1", "Honda Civic", 35.0);
        Vehicle car2 = new Car("V2", "Ford Focus", 50.0);
        Vehicle truck1 = new Truck("T1","Corrola",88);

        // Add vehicles to rental service
        rentalServices.addVehicle(car1);
        rentalServices.addVehicle(car2);

        // Create a customer
        Customer customer = new Customer("CUST001", "John Doe", "haoah@BenedictAfotey.com","291297");

        // Rent the car1
        rentalServices.rentVehicle("V1", customer, 3);
        System.out.println("Is Honda Civic available? " + car1.isAvailableForRental());

        // Rent car2
        rentalServices.rentVehicle("V2", customer, 5);
        System.out.println("Is Ford Focus available? " + car2.isAvailableForRental());

        // Return car2
        rentalServices.returnVehicle("V2");
        System.out.println("Is Ford Focus available? " + car2.isAvailableForRental());

        // Display rental costs
        System.out.println("\nRental costs:");
        System.out.println(car1.getModel() + " for 3 days: $" + car1.calculateRentalCost(3));
        System.out.println(car2.getModel() + " for 5 days: $" + car2.calculateRentalCost(5));
    }
}
