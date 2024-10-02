import java.util.Scanner;

interface SortStrategy {
    void sort(int[] numbers);
}

class BubbleSort implements SortStrategy {
    public void sort(int[] numbers) {
        System.out.println("Sorting using Bubble Sort");
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        printArray(numbers);
    }

    private void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}

class QuickSort implements SortStrategy {
    public void sort(int[] numbers) {
        System.out.println("Sorting using Quick Sort");
        quickSort(numbers, 0, numbers.length - 1);
        printArray(numbers);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}

class SortContext {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortNumbers(int[] numbers) {
        if (strategy != null) {
            strategy.sort(numbers);
        } else {
            System.out.println("No sorting strategy chosen.");
        }
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortContext context = new SortContext();

        System.out.println("Choose sorting strategy: (1) Bubble Sort (2) Quick Sort");
        int choice = scanner.nextInt();

        int[] numbers = {5, 2, 9, 1, 5, 6};

        switch (choice) {
            case 1:
                context.setStrategy(new BubbleSort());
                break;
            case 2:
                context.setStrategy(new QuickSort());
                break;
            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
                return;
        }

        System.out.println("Sorting the array...");
        context.sortNumbers(numbers);

        scanner.close();
    }
}
