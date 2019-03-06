import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.io.Serializable;

public class Operation implements Serializable {
    public static final long serialVersionUID = -5971538861194843412L;
    Scanner scanner = new Scanner(System.in);
    //Project taskList = new Project();
    ArrayList<Task> taskList = new ArrayList<>();
    boolean x = false;
    private int counter;

    // to save the task in a file: data.bin
    public void saveT() {

        try {

            ObjectOutputStream oSave = new ObjectOutputStream(new FileOutputStream("/Users/fadi.m/Desktop/github/toDoL/data.bin"));
            oSave.writeObject(taskList);
            oSave.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // to read the Array list (tasks)
    public Project readT() {

        Project Reader = new Project();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("/Users/fadi.m/Desktop/github/toDoL/data.bin"));
            taskList = (ArrayList<Task>) is.readObject();
            //System.out.println(taskList.toString());
            is.close();
            return Reader;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

        }
        return Reader;
    }
    public void removeTask(int index){
        Task taskToRemove = taskList.remove( index );

    }

    public void editTask(int index, String title, String desc, String date)
    {

        Task taskToEdit = taskList.get(index);
        //System.out.println("title");
        taskToEdit.setTitle(title);
        // System.out.println("desc");
        taskToEdit.setDesc(desc);
        // System.out.println("date");
        taskToEdit.setDate(date);

    }
//    public void addTask (Task task){
//        taskList.add(task);
//        counter = counter + 1;
//    }

    public void showForEdit()
    {
        for (int i=0; i< taskList.size(); i++)
        {
            System.out.println("Task " + (i+1) + ":    " + taskList.get(i) );

        }
    }

    public void editTask(int id)
    {

    }

    public void chooseO(){

        do {
            switch (scanner.nextInt()) {

                case 1:
                    //here you can choose one of the option in the main class
                    //todo there is a problem with the counter
                    if(Project.counter < 2){
                        System.out.println("You have " + Project.counter + " task");}
                        else {
                        System.out.println("You have " + Project.counter + " tasks");}
                        System.out.println("1: for sorting by title,\n2: sorting by the project name, \n3: for sorting by date");

                    showTaskOption();
                    break;

                case 2:

                    // to create a new task with scanner
                    scanner.nextLine();
                    //TODO
                    System.out.print("Enter the title \n");
                    String title = scanner.nextLine();


                    // enter a desc
                    System.out.println("Enter the description");
                    String desc = scanner.nextLine();

                    // enter a date
                    System.out.println("Enter the date");
                    String date = scanner.nextLine();


                    // enter a project name
                    System.out.println("Enter the project name");
                    String project = scanner.nextLine();

                    //taskList.setProjectName(project);

                    //TODO:
                    Task t = new Task(title, desc, date, project);
                    taskList.add(t);
                    counter = counter + 1;
                    //===============
                    x = true;
                    System.out.println("Done!");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                    break;

                case 3: {
                    System.out.println("please press: ");
                    System.out.println(">> (1) update");
                    System.out.println(">> (2) mark as done");
                    System.out.println(">> (3) remove");
                    if(Project.counter < 2){
                        System.out.println("You have " + Project.counter + " task");}
                    else {
                        System.out.println("You have " + Project.counter + " tasks");}

                    Task y;
                    for(int i = 0; i < taskList.size(); i++)
                    {
                        y = taskList.get(i);
                        System.out.println("Task " + (taskList.indexOf(y)+1) +": "+ y.toString());
                    }

                   editTaskOption();

                }
                break;

                case 4:

                    this.saveT();
                    System.out.println("Bye!");
                    x = false;
                    break;

                case 5:
                    System.out.println(">> Welcome to ToDoLy ");
                    System.out.println(">> You have " + Project.counter + " tasks todo and " + " tasks are done!");
                    System.out.println(">> Pick an option:");
                    System.out.println(">> (1) Show Task List in details(by date or taskList)");
                    System.out.println(">> (2) Add New Task");
                    System.out.println(">> (3) Edit Task (update, mark as done, remove)");
                    System.out.println(">> (4) Save and Quit");
                    System.out.println(">>");

                default:
                    System.out.println(" Enter number from 1 to 4 ");
                    //x = true;
                    break;
            }
        } while (x);


    }
    public void showTaskOption(){
        switch (scanner.nextInt()) {

            case 1:
                //sort by task's name
                Task t;
                for(int i = 0; i < taskList.size(); i++)
                {
                    t = taskList.get(i);
                    System.out.println("Task " + (taskList.indexOf(t)+1) +": "+ t.toString());
                }
                System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                x= true;
                break;

            case 2:
                //Sort by the project name
                System.out.println("Sort by the project name");
                System.out.println("enter project title");
                String d = scanner.next();
                taskList.stream().filter(x->x.getProjectName().equals(d)).forEach(x-> {System.out.println(x.toString());
                });
                System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                x= true;
                break;
            case 3:
                //Sort by the date
                System.out.println("Sort by the date");
                taskList.stream().sorted(Comparator.comparing(Task::getDate)).forEach(x-> {System.out.println(x.toString());
                });
                System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                x= true;
                break;

        }

    }
    public void editTaskOption(){
        switch (scanner.nextInt()) {

            case 1:
                System.out.println("Please choose the task number to edit");
                int index = (scanner.nextInt() -1);
                if(index > Project.counter){
                    System.out.println("Choose a correct task number");
                } else {
                    System.out.println("Please edit your title");
                    scanner.nextLine();
                    String newTitle = scanner.nextLine();
                    System.out.println("Please edit your Desc");
                    String newDesc = scanner.nextLine();
                    System.out.println("Please edit your date");
                    String newDate = scanner.nextLine();
                    editTask(index, newTitle, newDesc,newDate);
                    showForEdit();
                    System.out.println("Thank you, edit successful");
                    System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");

                    break;}
            case 2:
                System.out.println("Please choose task number to mark it as Done!");



                break;
            case 3:
                System.out.println("Please choose the task number to remove");
                int inde = (scanner.nextInt()-1);
                if(inde > Project.counter){
                    System.out.println("Choose a correct task number");
                } else {
                    removeTask(inde);
                    System.out.println("Thank you, remove successful");
                    System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                }
                break;
        }


    }


}
