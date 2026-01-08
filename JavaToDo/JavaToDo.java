// This is a simple java class file for a to-do list.
// Import necessary libraries
import java.util.*;
import java.time.LocalDateTime;


enum priorityIndex{
    // Priority 1,2,3 matched to their degree of criticality.
    HIGH, MEDIUM, LOW
}

enum completionStatus {
    COMPLETED,
    INPROGRESS,
    COMING SOON
}
class Task {

    //Variables
    private String taskName;
    private LocalDateTime dueDate;
    private priorityIndex priorityIndex;
    private String description;


    // Constructors
    Task(String taskName, priorityIndex priorityIndex, LocalDateTime dueDate, String taskDescription){
        this.taskName = taskName;
        this.priorityIndex = priorityIndex;
        this.dueDate = dueDate;
        this.taskDescription = taskDescription;
    }


    // Getters and Setters
    public String getTaskName(){
        return taskName;
    }
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }
    public LocalDateTime getDueDate(){
        return dueDate;
    }
    public void setDueDate(LocalDateTime dueDate){
        this.dueDate = dueDate;
    }
    public priorityIndex getPriorityIndex(){
        return priorityIndex;
    }
    public void setPriorityIndex(priorityIndex priorityIndex) {
        this.priorityIndex = priorityIndex;
    }
    public String getTaskDescription(){
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }

}

class TodoManager{

    private ArrayList<Task> taskList; // We are storing the Task object and not the string.

    TodoManager(){  // We do not accept a paramater if we are creating  anew empty list
        this.taskList = new ArrayList<Task>();
    }

    // METHODS
    public void addTask(String taskName, String taskDescription){
        // To add a new task we need a data structure that will store it, in our case we will use the ArrayList



    }

    public String removeTask(String taskName){
        System.out.println("Task: " + getTaskName)
    }

    public void markAsComplete (String taskName){

    }

    public String viewTask (String taskName, LocalDateTime dueDate){
        //Search the task using the taskName, use the getter.


    }

    public void saveTask(String taskName, LocalDateTime dueDate){

    }

    public String displayAllTasks(String taskName, LocalDateTime dueDate, priorityIndex priorityIndex){

    }


}

public class JavaToDo{
    private String taskDescription;
    private completionStatus completionStatus;
    private ToDoManager TodoManager;

        JavaToDo(completionStatus completionStatus, TodoManager TodoManager){
            this.taskDescription = taskDescription;
            this.completionStatus = completionStatus;
            this.ToDoManager = new ToDoManager();
        }


        // Getters and Setters
        public completionStatus getCompletionStatus(){
            return completionStatus;
        }
        public void setCompletionstatus(completionStatus completionStatus){
            this.completionStatus = completionStatus;
        }

    public static void displayMenu(){
            System.out.println("======PLAN YOUR DAY WELL!!=========");
            System.out.println("1. Display all Tasks")
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Save Task")
            System.out.println("5. Mark as Complete");
            System.out.println("6. View Task");
            System.out.println("7. List Tasks based on priority")

    }
    public static void main(String[] args){

        // To accept inputs we use scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Here to plan!! Welcome");
        System.out.println("Please enter your name:");

        String userName = sc.nextLine();

        // Create a to-do list object
        TodoManager todoManager = new JavaTodo(userName);
        int choice;

        // We will use a switch case loop that is embeded in the do while loop.

        do{
            System.out.println("Please enter Option (1 - 7)");
            choice = sc.nextInt();
            sc.nextLine(); // Use the next line

            switch(choice){
                case 1:

                    break;

                case 2:
                    System.out.println("Enter task name: ");
                    String taskName = sc.nextLine();
                    System.out.println("Enter the task description: ");
                    String description = sc.nextLine();
                    System.out.println("Enter the task due date: ");
                    LocalDateTime dueDate = sc.nextLine();
                    System.out.println("Enter the task's priority level: (HIGH, MEDIUM, LOW.)");
                    priorityIndex priorityIndex = sc.nextLine();

                    // Create a new task object
                    Task newTask = new Task (taskName, description, dueDate, priorityIndex);
                    toDoManager.addTask();
                   break;

                case 3:

                    break;

                case 4:


                    break;


                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;
            }

        } while (choice !=7){
            System.out.println("Invalid number. Choose a number between 1 - 7");
            sc.close;

        }
    }

}
