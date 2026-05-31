import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("PID: " + ProcessHandle.current().pid());
        System.out.println("PROGRAM STARTED");

        while (true) {

            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // pulizia buffer
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine(); // reset buffer anche in caso di errore
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Task title: ");
                    String title = scanner.nextLine();
                    tasks.add(new Task(title));
                    System.out.println("Task added!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nTASK LIST:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + " - " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Index to complete: ");
                    int completeIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (completeIndex >= 0 && completeIndex < tasks.size()) {
                        tasks.get(completeIndex).completeTask();
                        System.out.println("Task completed!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    System.out.print("Index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (deleteIndex >= 0 && deleteIndex < tasks.size()) {
                        tasks.remove(deleteIndex);
                        System.out.println("Task deleted!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}