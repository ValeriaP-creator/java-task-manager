import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("PROGRAM STARTED");

        ArrayList<Task> tasks = FileManager.loadTasks();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            String input = scanner.nextLine();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Please enter a number!");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Task title: ");
                    String title = scanner.nextLine();

                    tasks.add(new Task(title));
                    FileManager.saveTasks(tasks);

                    System.out.println("Task added!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + " - " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Index: ");
                    int cIndex = Integer.parseInt(scanner.nextLine());

                    if (cIndex >= 0 && cIndex < tasks.size()) {
                        tasks.get(cIndex).completeTask();
                        FileManager.saveTasks(tasks);
                        System.out.println("Task completed!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    System.out.print("Index: ");
                    int dIndex = Integer.parseInt(scanner.nextLine());

                    if (dIndex >= 0 && dIndex < tasks.size()) {
                        tasks.remove(dIndex);
                        FileManager.saveTasks(tasks);
                        System.out.println("Task deleted!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 5:
                    FileManager.saveTasks(tasks);
                    System.out.println("Bye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}