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

public class JavaToDo {

    //Variables
    private String taskName;
    private LocalDateTime dueDate;
    private priorityIndex priorityIndex;
    private String taskDescription;
    private completionStatus completionStatus;



    // Constructors
    JavaToDo(String taskName, priorityIndex priorityIndex, LocalDateTime dueDate, String taskDescription, CompletionStatus completionStatus){
        this.taskName = taskName;
        this.priorityIndex = priorityIndex;
        this.dueDate = dueDate;
        this.taskDescription = taskDescription;
        this.completionStatus = completionStatus;
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
    public String getTaskDescription(){
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }
    public completionStatus getCompletionStatus(){
        return completionStatus;
    }
    public void setCompletionstatus(completionStatus completionStatus){
        this.completionStatus = completionStatus;
    }



    // METHODS
    public void addTask(String taskName){
        // Ensure that a task with a similar name does not exist before adding task


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

    public static void main(String[] args){

        // To accept inputs we use scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Here to plan!! Welcome");
        System.out.println("Please enter your name:");

        String userName = sc.nextline();

        // Create a to-do list object
        JavaToDo JavaToDo = new JavaTodo(userName);

        // We will use a switch case loop that is embeded in the do while loop.

        do{


        } while (){

        }
    }
}