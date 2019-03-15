public class Main {

    public static void main(String[] args){

        Operation operation = new Operation();

        //Calling the reader (recover the data was saved)
        operation.readT();

        //Calling the counter method to use it in below
        operation.sizeOfArray(operation.counter);
        operation.doneTaskList();

        //Interface
        System.out.println(">> Welcome to ToDoLy ");
        System.out.println(">> You have " + (operation.counter - operation.doneCounter) + " tasks to do, " + (operation.doneCounter) + " tasks are done!");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List in detail (by date or project)");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit Task (update, mark as done, remove)");
        System.out.println(">> (4) Save and Quit");
        System.out.println(">>");

        //Calling the options to choose what do you want to do!
        operation.chooseO();
    }

}
