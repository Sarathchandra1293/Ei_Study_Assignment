import java.util.Scanner;

interface Coffee {
    String getDescription();
    double cost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }

    public double cost() {
        return 5.0;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double cost() {
        return coffee.cost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    public double cost() {
        return super.cost() + 1.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    public double cost() {
        return super.cost() + 0.5;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        Scanner scanner = new Scanner(System.in);

        System.out.println("You have a Simple Coffee. Add 'milk', 'sugar', or type 'done' to finish.");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("milk")) {
            coffee = new MilkDecorator(coffee);
        } else if (choice.equalsIgnoreCase("sugar")) {
            coffee = new SugarDecorator(coffee);
        } else if (!choice.equalsIgnoreCase("done")) {
            System.out.println("Invalid choice.");
        }

        System.out.println("Final Coffee: " + coffee.getDescription());
        System.out.println("Total Cost: $" + coffee.cost());

        scanner.close();
    }
}
