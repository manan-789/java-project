import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleTaskScheduler {
    private static class Task {
        String name;
        boolean completed;

        Task(String name) {
            this.name = name;
            this.completed = false;
        }

        void markCompleted() {
            completed = true;
        }

        @Override
        public String toString() {
            return name + (completed ? " (Completed)" : " (Pending)");
        }
    }

    private List<Task> tasks = new ArrayList<>();

    public void addTask(String taskName) {
        tasks.add(new Task(taskName));
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        SimpleTaskScheduler scheduler = new SimpleTaskScheduler();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    scheduler.addTask(taskName);
                    break;
                case 2:
                    scheduler.listTasks();
                    break;
                case 3:
                    System.out.print("Enter task number to mark as completed: ");
                    int taskNumber = scanner.nextInt() - 1; // Convert to zero-based index
                    scheduler.markTaskCompleted(taskNumber);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}
