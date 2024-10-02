import java.util.Scanner;

interface Car {
    void drive();
}

class Sedan implements Car {
    public void drive() {
        System.out.println("Driving a Sedan.");
    }
}

class SUV implements Car {
    public void drive() {
        System.out.println("Driving an SUV.");
    }
}

class CarFactory {
    public static Car getCar(String carType) {
        if (carType.equalsIgnoreCase("SUV")) {
            return new SUV();
        } else if (carType.equalsIgnoreCase("Sedan")) {
            return new Sedan();
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of car you want to create (Sedan/SUV): ");
        String carType = scanner.nextLine();

        Car car = CarFactory.getCar(carType);

        if (car != null) {
            car.drive();
        } else {
            System.out.println("Invalid car type. Please enter either 'Sedan' or 'SUV'.");
        }

        scanner.close();
    }
}
