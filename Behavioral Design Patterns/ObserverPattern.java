import java.util.Scanner;

interface RoomObserver {
    void onRoomStatusChange(boolean isOccupied);
}

class AirConditioningSystem implements RoomObserver {
    public void onRoomStatusChange(boolean isOccupied) {
        if (isOccupied) {
            System.out.println("Air Conditioning: ON");
        } else {
            System.out.println("Air Conditioning: OFF");
        }
    }
}

class LightingSystem implements RoomObserver {
    public void onRoomStatusChange(boolean isOccupied) {
        if (isOccupied) {
            System.out.println("Lights: ON");
        } else {
            System.out.println("Lights: OFF");
        }
    }
}

class Room {
    private boolean isOccupied = false;
    private RoomObserver acSystem = new AirConditioningSystem();
    private RoomObserver lightSystem = new LightingSystem();

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
        notifyObservers();
    }

    private void notifyObservers() {
        acSystem.onRoomStatusChange(isOccupied);
        lightSystem.onRoomStatusChange(isOccupied);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Room conferenceRoom = new Room();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 'occupy' to occupy the room or 'vacate' to vacate the room:");
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("occupy")) {
            conferenceRoom.setOccupied(true);
        } else if (command.equalsIgnoreCase("vacate")) {
            conferenceRoom.setOccupied(false);
        } else {
            System.out.println("Invalid command.");
        }

        scanner.close();
    }
}
