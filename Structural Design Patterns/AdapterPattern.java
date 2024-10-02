import java.util.Scanner;

class OldSystem {
    public void performTask() {
        System.out.println("Performing task in the old system.");
    }
}

interface NewSystem {
    void executeTask();
}

class Adapter implements NewSystem {
    private OldSystem oldSystem;

    public Adapter(OldSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    public void executeTask() {
        oldSystem.performTask();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        OldSystem oldSystem = new OldSystem();
        NewSystem newSystem = new Adapter(oldSystem);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 'perform' to execute the task or 'exit' to quit: ");
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("perform")) {
            newSystem.executeTask();
        } else {
            System.out.println("Exiting...");
        }

        scanner.close();
    }
}
