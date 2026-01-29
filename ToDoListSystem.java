import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ToDoListSystem {

    enum DueDay { 
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    enum Priority { 
        HIGH, MEDIUM, LOW
    }

    static String[] categories = new String[10];
    static int categoryCount = 0;

    static String[] tasks = new String[20];
    static DueDay[] taskDueDays = new DueDay[20];
    static Priority[] taskPriorities = new Priority[20];
    static boolean[] taskCompleted = new boolean[20];
    static int taskCount = 0;

    private static Scanner scanner = new Scanner(System.in);

    // ================= CSV SAVE =================
    public static void saveTasksToCSV() {
        try {
            FileWriter writer = new FileWriter("tasks.csv");
            writer.append("Task,DueDay,Priority,Completed\n");

            for (int i = 0; i < taskCount; i++) {
                writer.append(tasks[i].replace(",", " ")).append(",");
                writer.append(taskDueDays[i].toString()).append(",");
                writer.append(taskPriorities[i].toString()).append(",");
                writer.append(String.valueOf(taskCompleted[i])).append("\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    // ================= CSV LOAD =================
    public static void loadTasksFromCSV() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("tasks.csv"));
            String line = reader.readLine(); // skip header

            while ((line = reader.readLine()) != null && taskCount < tasks.length) {
                String[] data = line.split(",");

                tasks[taskCount] = data[0];
                taskDueDays[taskCount] = DueDay.valueOf(data[1]);
                taskPriorities[taskCount] = Priority.valueOf(data[2]);
                taskCompleted[taskCount] = Boolean.parseBoolean(data[3]);
                taskCount++;
            }
            reader.close();
        } catch (IOException e) {
            // file doesn't exist yet → ignore
        }
    }

    public static void showGreetingMenu() {
        System.out.println("===============================");
        System.out.println("TO-DO / TASK SYSTEM");
        System.out.println("1: ADD TASK");
        System.out.println("2: VIEW TASKS");
        System.out.println("3: EXIT");
        System.out.println("===============================");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> addTasksScreen();
            case 2 -> viewTasksScreen();
            case 3 -> exitProgram();
            default -> showGreetingMenu();
        }
    }

    public static void addTasksScreen() {
        scanner.nextLine();
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();

        System.out.print("Due day (1=MON ... 7=SUN): ");
        int day = scanner.nextInt();
        DueDay due = DueDay.values()[day - 1];

        System.out.print("Priority (1=HIGH 2=MEDIUM 3=LOW): ");
        int p = scanner.nextInt();
        Priority priority = Priority.values()[p - 1];

        tasks[taskCount] = name;
        taskDueDays[taskCount] = due;
        taskPriorities[taskCount] = priority;
        taskCompleted[taskCount] = false;
        taskCount++;

        showGreetingMenu();
    }

    public static void viewTasksScreen() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println(
                (i + 1) + ". " + tasks[i] +
                " | " + taskDueDays[i] +
                " | " + taskPriorities[i] +
                " | Done: " + taskCompleted[i]
            );
        }
        showGreetingMenu();
    }

    public static void exitProgram() {
        saveTasksToCSV();
        System.out.println("Tasks saved. Goodbye!");
        scanner.close();
        System.exit(0);
    }

    public static void main(String[] args) {
        loadTasksFromCSV();
        showGreetingMenu();
    }
}
