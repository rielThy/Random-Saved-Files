import java.util.Scanner; //IMPORTING THE UTIL SCANNER

public class ToDoListSystem {
	//FOR ADDING TASKS
	enum DueDay { 
	    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}
	
	enum Priority { 
	    HIGH, MEDIUM, LOW
	}
	
	// GLOBAL VARIABLES FOR CATEGORY METHOD
	static String[] categories = new String[10]; // max 10 categories for now
	static int categoryCount = 0;
	
	
	// GLOBAL VARIABLES FOR VIEW TASKS METHOD
	static String[] tasks = new String[20];
	static DueDay[] taskDueDays = new DueDay[20];
	static boolean[] taskCompleted = new boolean[20];
	static int taskCount = 0;
	
	
	//GLOBAL VARIABLE/ARRAY FOR TASK PRIORITY
	static Priority[] taskPriorities = new Priority[20];
	
	
    // SHARED SCANNER FOR WHOLE CLASS
    private static Scanner scanner = new Scanner(System.in);

    public static void showGreetingMenu() { //MAIN MENU INTERFACE
        System.out.println("===============================");
        System.out.println("TO-DO / TASK SYSTEM");
        System.out.println("Hello, User! What tasks are we making this time?\n");

        System.out.println("Press (1, 2, 3, ...) for the following requests:");
        System.out.println("1: ADD TASKS");
        System.out.println("2: ADD A CATEGORY FOR TASKS");
        System.out.println("3: MANAGE ALL TASKS/WORKS");
        System.out.println("4: MANAGE TASK PRIORITY / VIEW COMPLETED TASKS");
        System.out.println("5: EXIT");
        System.out.println("=============================== \n");
        System.out.print("Enter your choice: "); //USER CAN INPUT NUMBER AFTER THIS TEXT

        int choice = scanner.nextInt(); //THIS WILL SCAN THE USER'S INPUT

        switch (choice) { //THIS PART OF THE CODE WILL SHOW THE NECESSARY SCREEN BASED ON WHAT THE USER HAS INPUTTED
            case 1:
            	clearScreen();
                addTasksScreen(); //SHOWS addTasksScreen()
                break;
            case 2:
            	clearScreen();
                addCategoryScreen(); //SHOWS addCategoryScreen()
                break;
            case 3:
            	clearScreen();
                viewTasksScreen(); //SHOWS viewTasksScreen()
                break;
            case 4:
            	clearScreen();
                rankPriorityScreen(); //SHOWS rankPriorityScreen()
                break;
            case 5:
                exitProgram(); //EXITS THE PROGRAM
                break;
            default:
                System.out.println("\nInvalid choice. Please try again.\n"); //IF USER ENTERS AN INVALID NUMBER OR CHOICE
                showGreetingMenu();
        }
    }
    
    public static void clearScreen() { //THIS METHOD'S FUNCTION WILL ADD 9 SPACES TO ENHANCE READABILITY FOR THE NEXT TEXTS
        for (int i = 0; i < 9; i++) {
            System.out.println();
        }
    }
    
    
    
    
    
    //============================================

    // ADD TASKS METHOD ||
    
    public static void addTasksScreen() { //THIS METHOD WILL SHOW THE addTasksScreen()
    	clearScreen(); //ADDS SOME SPACE AFTER THE USER MAKES A CHOICE

        System.out.println("=====| NEW TASK |=====");
        System.out.println("↓ Add your tasks here ↓");
        System.out.print("• ");

        scanner.nextLine(); // CLEAR LEFTOVER NEWLINE
        String taskName = scanner.nextLine(); //INITIALIZE AND STORE USER'S INPUT IN VARIABLE "taskName"

        //SETTING THE TASK'S DUE DATE
        System.out.println("\n → Enter the number that is correlated to its due date:"); //USER WILL BE ASKED TO ENTER A NUMBER THAT WILL
        System.out.println("[Monday (1), Tuesday (2), Wednesday (3), Thursday (4),"); //SET THE DUE DATE FOR THE TASK
        System.out.println(" Friday (5), Saturday (6), Sunday (7)] \n"); 
        System.out.print("Choice: ");

        
        //SCANNING USER'S CHOICE FOR DUE DATE
        int dayChoice = scanner.nextInt();
        DueDay dueDay = null;
      
        //ASSIGNING THE DAY FOR THE TASK
        switch (dayChoice) { 
            case 1 -> dueDay = DueDay.MONDAY;
            case 2 -> dueDay = DueDay.TUESDAY;
            case 3 -> dueDay = DueDay.WEDNESDAY;
            case 4 -> dueDay = DueDay.THURSDAY;
            case 5 -> dueDay = DueDay.FRIDAY;
            case 6 -> dueDay = DueDay.SATURDAY;
            case 7 -> dueDay = DueDay.SUNDAY;
            default -> {
                System.out.println("\nInvalid day choice.");
                returnToMenu();
                return;
            }
        }
        
        
      //SETTING THE TASK'S PRIORITY
        System.out.println();
        System.out.println("→ Assign the task's priority:");
        System.out.println("1: HIGH");
        System.out.println("2: MEDIUM");
        System.out.println("3: LOW");
        System.out.print("Enter your choice: ");

        int priorityChoice = scanner.nextInt();
        Priority priority = null;

        switch (priorityChoice) {
            case 1 -> priority = Priority.HIGH;
            case 2 -> priority = Priority.MEDIUM;
            case 3 -> priority = Priority.LOW;
            default -> {
                System.out.println("Invalid priority choice.");
                returnToMenu();
                return;
            }
        }
        
        
      //STORING TASKS
        tasks[taskCount] = taskName;
        taskDueDays[taskCount] = dueDay;
        taskPriorities[taskCount] = priority;
        taskCompleted[taskCount] = false;
        taskCount++;

      //DISPLAYING THE TASK AND ITS DUE DATE
        System.out.println();
        System.out.println("This task ↓");
        System.out.println("||\"" + taskName + "\"||");
        System.out.println("→ is set for " + dueDay);
        System.out.println("with " + priority + " priority!\n");
        
        
      //ASKING THE USER FOR NEXT REQUEST, EITHER TO MAKE ANOTHER TASK OR GO BACK TO MENU
        System.out.println("Would you like to make another task?");
        System.out.println("1: YES");
        System.out.println("2: GO BACK TO MAIN MENU \n");
        System.out.print("Choice: ");

        int nextChoice = scanner.nextInt();

        if (nextChoice == 1) {
            addTasksScreen(); // recursion (allowed & useful)
        } else {
        	showGreetingMenu();
        }
    }
    

    
    
    
    //============================================
    
    // CATEGORY METHOD ||
    public static void addCategoryScreen() {
    	clearScreen();

        System.out.println("=====| CATEGORY MANAGER |=====");
        System.out.println("Press the following numbers for the following commands:");
        System.out.println("1: ADD A CATEGORY");
        System.out.println("2: MANAGE CURRENT CATEGORIES");
        System.out.println("3: GO BACK TO MAIN MENU");
        System.out.println("==========================\n");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addNewCategory();
                break;
            case 2:
                viewCategories();
                break;
            case 3:
                returnToMenu();
                break;
            default:
                System.out.println("\nInvalid choice.");
                addCategoryScreen();
    }
   }

    
    //ADDING NEW CATEGORY METHOD OPTION
	public static void addNewCategory() {
	
	    clearScreen();
	
	    if (categoryCount >= categories.length) {
	        System.out.println("Category limit reached.");
	        returnToMenu();
	        return;
	    }
	
	    System.out.println("=====| CATEGORY MANAGER |=====");
	    System.out.println("Enter the name for your new category here:");
	    System.out.print("→ ");
	
	    scanner.nextLine(); //CLEAR NEW LINE
	    String categoryName = scanner.nextLine();
	
	    categories[categoryCount] = categoryName;
	    categoryCount++;
	
	    System.out.println("\nCategory \"" + categoryName + "\" has been added successfully!");
	
	    System.out.println("\n1: ADD ANOTHER CATEGORY");
	    System.out.println("2: GO BACK TO CATEGORY MANAGER\n");
	    System.out.print("Choice: ");
	
	    int nextChoice = scanner.nextInt();
	
	    if (nextChoice == 1) {
	        addNewCategory();
	    } else {
	        addCategoryScreen();
	    }
	}
	
	
	//VIEW CATEGORIES METHOD OPTION
	public static void viewCategories() {
	
	    clearScreen();
	
	    System.out.println("=====| CURRENT CATEGORIES |=====");
	
	    if (categoryCount == 0) {
	        System.out.println("No categories created yet.");
	    } else {
	        for (int i = 0; i < categoryCount; i++) {
	            System.out.println((i + 1) + ". " + categories[i]);
	        }
	    }
	
	    System.out.println("\nPress any number to go back...");
	    scanner.nextInt();
	
	    addCategoryScreen();
	}
	
	
	
	
	
	//============================================

	// MANAGE TASKS METHOD ||
    public static void viewTasksScreen() {
    	clearScreen();

        System.out.println("=====| TASK MANAGER |=====");
        System.out.println("↓ LIST OF TASKS (" + taskCount + ") ↓");

        if (taskCount == 0) {
            System.out.println("No tasks created yet.");
        } else {
            for (int i = 0; i < taskCount; i++) {
                if (!taskCompleted[i]) {
                    System.out.println((i + 1) + ". " + tasks[i] +
                            " (Due: " + taskDueDays[i] + ")");
                }
            }
        }

        System.out.println("======================\n");
        System.out.println("1: ADD A NEW TASK");
        System.out.println("2: DELETE A TASK");
        System.out.println("3: MARK A TASK AS DONE");
        System.out.println("4: GO BACK TO MAIN MENU");
        System.out.print("\nEnter your choice of next command: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addTasksScreen();
                break;
            case 2:
                deleteTaskScreen();
                break;
            case 3:
                markTaskAsDoneScreen();
                break;
            case 4:
                returnToMenu();
                break;
            default:
                System.out.println("Invalid choice.");
                viewTasksScreen();
        }
    }
    
    
    // DELETE TASK METHOD OPTION
    public static void deleteTaskScreen() {

        clearScreen();

        if (taskCount == 0) {
            System.out.println("No tasks to delete.");
            returnToMenu();
            return;
        }

        System.out.println("=====| DELETE TASK |=====");

        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }

        System.out.print("\nEnter task number to delete: ");
        int choice = scanner.nextInt() - 1;

        if (choice < 0 || choice >= taskCount) {
            System.out.println("Invalid task number.");
            viewTasksScreen();
            return;
        }

        for (int i = choice; i < taskCount - 1; i++) {
            tasks[i] = tasks[i + 1];
            taskDueDays[i] = taskDueDays[i + 1];
            taskCompleted[i] = taskCompleted[i + 1];
        }

        taskCount--;

        System.out.println("Task deleted successfully!");
        viewTasksScreen();
    }
    
    
    // MARK TASK AS DONE METHOD
    public static void markTaskAsDoneScreen() {

        clearScreen();

        if (taskCount == 0) {
            System.out.println("No tasks available.");
            returnToMenu();
            return;
        }

        System.out.println("=====| MARK TASK AS DONE |=====");

        for (int i = 0; i < taskCount; i++) {
            if (!taskCompleted[i]) {
                System.out.println((i + 1) + ". " + tasks[i]);
            }
        }

        System.out.print("\nEnter task number to mark as done: ");
        int choice = scanner.nextInt() - 1;

        if (choice < 0 || choice >= taskCount) {
            System.out.println("Invalid task number.");
            viewTasksScreen();
            return;
        }

        taskCompleted[choice] = true;

        System.out.println("Task marked as DONE!");
        viewTasksScreen();
    }
    
    
    
    
    
    //============================================
    
    // RANK PRIORITY METHOD ||
    public static void rankPriorityScreen() {
    	clearScreen();

        System.out.println("=====| TASK MANAGER |=====");
        System.out.println("Sort the tasks in...");
        System.out.println("1: PRIORITY");
        System.out.println("2: DUE DATE");
        System.out.println("3: VIEW COMPLETED TASKS");
        System.out.println("4: GO BACK TO MAIN MENU");
        System.out.println("======================");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
            	sortTasksByPriority();
                break;
            case 2:
            	sortTasksByDueDate();
                break;
            case 3:
                System.out.println("Viewing COMPLETED TASKS (to be implemented)");
                returnToMenu();
                break;
            case 4:
                returnToMenu();
                break;
            default:
                rankPriorityScreen();
        }
    }
    
    
    // SORTING TASK'S PRIORITY METHOD ONLY
    public static void sortTasksByPriority() {

        clearScreen();

        System.out.println("=====| TASKS SORTED BY PRIORITY |=====");

        if (taskCount == 0) {
            System.out.println("No tasks available.");
            returnToMenu();
            return;
        }

        int displayCount = 0;

        // HIGH priority first
        for (int i = 0; i < taskCount; i++) {
            if (!taskCompleted[i] && taskPriorities[i] == Priority.HIGH) {
                System.out.println(
                    (displayCount + 1) + ". " + tasks[i] +
                    " (Priority: HIGH)"
                );
                displayCount++;
            }
        }

        // MEDIUM priority
        for (int i = 0; i < taskCount; i++) {
            if (!taskCompleted[i] && taskPriorities[i] == Priority.MEDIUM) {
                System.out.println(
                    (displayCount + 1) + ". " + tasks[i] +
                    " (Priority: MEDIUM)"
                );
                displayCount++;
            }
        }

        // LOW priority last
        for (int i = 0; i < taskCount; i++) {
            if (!taskCompleted[i] && taskPriorities[i] == Priority.LOW) {
                System.out.println(
                    (displayCount + 1) + ". " + tasks[i] +
                    " (Priority: LOW)"
                );
                displayCount++;
            }
        }

        if (displayCount == 0) {
            System.out.println("No unfinished tasks available.");
        }

        System.out.println("\nPress any number to return...");
        scanner.nextInt();

        rankPriorityScreen();
    }
    
    
    //SORTING TASK BY DUE DATE
    public static void sortTasksByDueDate() {

        clearScreen();

        System.out.println("=====| TASKS SORTED BY DUE DATE |=====");

        if (taskCount == 0) {
            System.out.println("No tasks available.");
            returnToMenu();
            return;
        }

        int displayCount = 0;

        // Loop through DueDay enum in order (MONDAY → SUNDAY)
        for (DueDay day : DueDay.values()) {

            for (int i = 0; i < taskCount; i++) {
                if (!taskCompleted[i] && taskDueDays[i] == day) {

                    System.out.println(
                        (displayCount + 1) + ". " + tasks[i] +
                        "(Due: " + taskDueDays[i] + ")");

                    displayCount++;
                }
            }
        }

        if (displayCount == 0) {
            System.out.println("No unfinished tasks available.");
        }

        System.out.println("\nPress any number to return...");
        scanner.nextInt();

        rankPriorityScreen();
    }
    
    
   
    
    
    //============================================

    // RETURN TO MAIN MENU METHOD ||
    public static void returnToMenu() {
        System.out.println("Press any number to return to the main menu...");
        scanner.nextInt();
        clearScreen();
        showGreetingMenu();
    }
    
    
    
    
    
    //============================================

    // EXIT PROGRAM METHOD ||
    public static void exitProgram() {
        System.out.println("\nThank you for using the To-Do / Task System!");
        System.out.println("Goodbye!");
        scanner.close();
        System.exit(0);
    }
    
    
    
    
    
    //============================================

    public static void main(String[] args) {
        showGreetingMenu();
    }
}

