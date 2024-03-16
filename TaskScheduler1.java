import java.util.*;
import java.text.*;

class Task {
    private String name;
    private Date dueDate;
    private int priority;
    private boolean completed;

    public Task(String name, Date dueDate, int priority) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        this.completed = true;
    }
}

public class TaskScheduler1 {
    private List<Task> tasks;

    public TaskScheduler1() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println(task.getName() + " | Due Date: " + task.getDueDate() + " | Priority: " + task.getPriority());
        }
    }

    public void markTaskAsCompleted(String taskName) {
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                task.markAsCompleted();
                System.out.println("Task '" + taskName + "' marked as completed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskScheduler1 scheduler = new TaskScheduler1();

        while (true) {
            System.out.println("\n1. Add Task\n2. Display Tasks\n3. Mark Task as Completed\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter due date (yyyy-mm-dd): ");
                    String dueDateString = scanner.nextLine();
                    Date dueDate;
                    try {
                        dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use yyyy-mm-dd.");
                        continue; // Restart the loop
                    }
                    System.out.print("Enter priority (1-5): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    Task task = new Task(name, dueDate, priority);
                    scheduler.addTask(task);
                    break;
                case 2:
                    scheduler.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter task name to mark as completed: ");
                    String taskName = scanner.nextLine();
                    scheduler.markTaskAsCompleted(taskName);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}