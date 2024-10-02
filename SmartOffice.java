import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface RoomObserver {
    void onRoomStatusChange(boolean isOccupied);
}

class AirConditioningSystem implements RoomObserver {
    public void onRoomStatusChange(boolean isOccupied) {
        System.out.println("Air Conditioning: " + (isOccupied ? "ON" : "OFF"));
    }
}

class LightingSystem implements RoomObserver {
    public void onRoomStatusChange(boolean isOccupied) {
        System.out.println("Lights: " + (isOccupied ? "ON" : "OFF"));
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

class OfficeFacility {
    private Map<Integer, Room> rooms = new HashMap<>();
    private int roomCount = 0;

    public void addRoom(String roomName) {
        roomCount++;
        rooms.put(roomCount, new Room());
        System.out.println("Room " + roomName + " added successfully.");
    }

    public void bookRoom(int roomId) {
        if (rooms.containsKey(roomId)) {
            Room room = rooms.get(roomId);
            room.setOccupied(true);
            System.out.println("Room " + roomId + " is now booked and occupied.");
        } else {
            System.out.println("Invalid room ID. Please try again.");
        }
    }

    public void vacateRoom(int roomId) {
        if (rooms.containsKey(roomId)) {
            Room room = rooms.get(roomId);
            room.setOccupied(false);
            System.out.println("Room " + roomId + " is now vacated.");
        } else {
            System.out.println("Invalid room ID. Please try again.");
        }
    }
}

public class SmartOffice {
    public static void main(String[] args) {
        OfficeFacility officeFacility = new OfficeFacility();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter room name to add: ");
        String roomName = scanner.nextLine();
        officeFacility.addRoom(roomName);

        System.out.print("Enter the Room ID to book: ");
        int roomIdToBook = scanner.nextInt();
        officeFacility.bookRoom(roomIdToBook);

        System.out.print("Enter the Room ID to vacate: ");
        int roomIdToVacate = scanner.nextInt();
        officeFacility.vacateRoom(roomIdToVacate);

        scanner.close();
    }
}
