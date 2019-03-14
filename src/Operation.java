import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.io.Serializable;
import java.util.stream.Collectors;


public class Operation implements Serializable {
    public static final long serialVersionUID = -5971538861194843412L;
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private ArrayList<Task> taskList = new ArrayList<>();
    private ArrayList<Task> doneTaskList = new ArrayList<>();
    boolean x = false;
    Verification verification = new Verification();
    public int counter;
    public int doneCounter;

    /**
     *
     * To save the tasks in a file "data.bin",
     *
     */
    public void saveT() {
        try {
            ObjectOutputStream oSave = new ObjectOutputStream(new FileOutputStream("data.bin"));
            oSave.writeObject(taskList);
            oSave.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * to read the ArrayList (tasks) for the file "data.bin", give exception if there is no task to show
     *
     */
    public List<Task> readT() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.bin"));
            taskList = (ArrayList<Task>) is.readObject();
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("There is no tasks to show");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    //Check the size of the Array list and append it to the counter
    public int sizeOfArray(int counter) {
       this.counter = taskList.size();
       return counter;
    }

    public int doneTaskList(int doneCounter){
        this.doneCounter= doneTaskList.size();
        return doneCounter;
    }

    /**
     *
     * @param index specifies task number to remove
     */
    public void removeTask(int index) {
        taskList.remove(index);
    }

    /**
     *
     * @param index specifies task number to edit task (title, description, date)
     */
    public void editTask(int index, String title, String desc, LocalDate date) {
        Task taskToEdit = taskList.get(index);
        //System.out.println("title");
        taskToEdit.setTitle(title);
        // System.out.println("desc");
        taskToEdit.setDesc(desc);
        // System.out.println("date");
        taskToEdit.setDate(date);
    }

    /**
     *
     * Print all the tasks you have with "Task number" to view it before choosing one task to edit, this method determine ID for each task.
     */
    public void showForEdit() {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("Task " + (i + 1) + ":    " + taskList.get(i));
        }
    }

    /**
     *
     * Print "You have .... task" if the number of task you have less than 2,
     * and print "You have .... tasks" if the number of task you have equal or more than 2 tasks.
     */
    public void  taskOrTasks(){
        if (counter < 2) {
            System.out.printf("You have %d task \n", counter);
        } else {
            System.out.printf("You have %d tasks\n", counter);
        }
    }

    public void chooseTask(){
        Task t;
        for (int i = 0; i < taskList.size(); i++) {
            t = taskList.get(i);
            System.out.println("Task " + (taskList.indexOf(t) + 1) + ": " + t.toString());
        }
    }


    // the interface options
    public void chooseO() {

        do {
            System.out.println("Choose option number");

           verification.justNum();

            switch (verification.num) {


                case 1:
                    //Press 1 to sort tasks (by: 1: task name, 2: project name, 3: date)
                    taskOrTasks();
                    System.out.println("1: for sorting by title,\n2: sorting by the project name, \n3: for sorting by date");
                    sortTaskOption();
                    break;

                case 2:
                    // press 2 to create a new task
                    // Enter the title
                    System.out.println("Enter the title");
                    String title = scanner.next();


                    // Enter the desc
                    System.out.println("Enter the description");
                    String desc = scanner.next();

                    // Enter the date
                    System.out.println("Enter the date (dd/mm/yyyy)");
                    LocalDate date = verification.checkDateFormat();


                    // Enter the project name
                    System.out.println("Enter the project name");
                    String project = scanner.next();


                    Task t = new Task(title, desc, date, project);
                    taskList.add(t);

                    x = true;
                    System.out.println("Done!");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                    break;

                case 3:
                    //Press 3 to modify tasks (1: edit a task, 2: mark it as done, 3: delete task)
                    System.out.println("please press: ");
                    System.out.println(">> (1) update");
                    System.out.println(">> (2) mark as done");
                    System.out.println(">> (3) remove");
                    //to print task/tasks according to the number of task you have
                    taskOrTasks();
                    editTaskOption();
                    break;

                case 4:
                    //Save the task/tasks to the data file.
                    this.saveT();
                    System.out.println("Bye!");
                    x = false;
                    break;

                case 5:
                    System.out.println(">> Welcome to ToDoLy ");
                    System.out.println(">> You have " + (counter) + " tasks, " +doneCounter+ " tasks are done!");
                    System.out.println(">> Pick an option:");
                    System.out.println(">> (1) Show Task List in details(by date or taskList)");
                    System.out.println(">> (2) Add New Task");
                    System.out.println(">> (3) Edit Task (update, mark as done, remove)");
                    System.out.println(">> (4) Save and Quit");
                    System.out.println(">>");

                default:

                    System.out.println("Enter option number (1 to 4) or enter 5 to see the option again");
                    x = true;
                    break;
            }
            //todo fix X
        } while (x);
    }

    /**
     * Check if the use enter a number out of range (as we have just three options)
     * Choose option to sort the tasks you have, by: task name, project name or date.
     */
    public void sortTaskOption() {
        verification.justNum();
        if (verification.num < 0 || (verification.num) > 3) {
            System.out.println("out of range! enter option number");
            sortTaskOption();
        }
        switch (verification.num) {

            case 1:
                //Sort by task's name
                //TaskList.indexOf(t) + 1 because I want to avoid starting the task number from "0"
                chooseTask();
                System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                x = true;
                break;

            case 2:
                /**
                 *
                 * Enter a project name to check it if it's equal to the projects name were saved then print out all the tasks with this project name.
                 * if there is no equal name will print "project not founded!".
                 */
                //Sort by the project name
                System.out.println("Sort by the project name");
                System.out.println("enter project name");
                String d = scanner.next();
                ArrayList<Task> sortByProject = (ArrayList<Task>) taskList.stream().filter(x -> x.getProjectName()
                        .equals(d)).collect(Collectors.toList());
                    if (sortByProject.size() > 0) {
                        System.out.println(sortByProject.toString());
                        System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                        break;
                    } else {
                        System.out.println("Project not founded!");
                        x = true;
                    }

            break;

            case 3:
                /**
                 *
                 * Compare task's date and sort it in ascending way.
                 */
                System.out.println("Sort by the date");
                taskList.stream().sorted(Comparator.comparing(Task::getDate))
                        .forEach(x -> {
                            System.out.println(x.toString());
                        });
                System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                x = true;
                break;
        }
        chooseO();
    }

     /**
     * Check if the use enter a number out of range (as we have just three options)
     * Choose option to modify your tasks (1:edit, 2:mark as done, 3:remove task)
     */
    public void editTaskOption() {
        verification.justNum();
        if (verification.num < 0 || verification.num > 3) {
            System.out.println("out of range! enter option number");
            editTaskOption();
        }
        switch (verification.num) {
            case 1:
                do {
                    System.out.println("Please choose the task number to edit");
                    verification.justNum();}

                    while ((verification.num - 1) > counter || (verification.num - 1) <= 0) ;
                    // index = num-1 because I add "1" to the sorting number of tasks I have to avoid starting the task number from "0"
                    int index = (verification.num -1);

                    System.out.println("Please edit your title");
                    String newTitle = scanner.next();
                    System.out.println("Please edit your Desc");
                    String newDesc = scanner.next();
                    System.out.println("Please edit your date");
                    String newDate = scanner.next();
                    editTask(index, newTitle, newDesc, LocalDate.parse(newDate));
                    showForEdit();
                    System.out.println("Thank you, edit successful");
                    System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                    x = true;
                    break;

            case 2:

                    /**
                     * Choose the task number to make it Done! and add 1 to the (done task counter), then add the task to the (ArrayList of done tasks).
                     * Check if the task is already (done) so don't add the task to the (ArrayList of done tasks) and don't add 1 to the counter.
                     */
                    chooseTask();
                    System.out.println("Please choose task number to mark it as Done!");
                    verification.justNum();
                    for (int i = 0; i < taskList.size(); i++) {
                        Task task = taskList.get(i);
                        if (taskList.indexOf(task) == (verification.num - 1)) {
                            taskList.stream().filter(x -> x.equals(task)).findFirst().get().markAsDone();

                            if (doneTaskList.size() == 0){
                                doneTaskList.add(task);
                                doneCounter = doneTaskList(doneCounter);}
                            else {
                                for (int j = 0; j < doneTaskList.size(); j++) {
                                    if (task == doneTaskList.get(j))
                                        break;
                                    else {
                                        doneTaskList.add(task);
                                        doneCounter= doneTaskList(doneCounter);
                                    }
                                }
                            }
                        }
                    }

                    showForEdit();
                    System.out.println("Thank you, Mark as done successful");
                    System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                    x = true;
                    break;

            case 3:
                    // Remove the task by index
                    System.out.println("Please choose the task number to remove");
                    verification.justNum();
                    int TaskNumber = (verification.num - 1);
                    if (TaskNumber > counter) {
                        System.out.println("Choose a correct task number");
                    } else {
                        removeTask(TaskNumber);
                        System.out.println("Thank you, remove successful");
                        System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                    }
                    break;
        }
    }
}

