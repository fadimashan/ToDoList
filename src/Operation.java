import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.Serializable;

public class Operation implements Serializable {

    Scanner scanner = new Scanner(System.in);
    boolean x = false;
    //ArrayList<Task> tasks = new ArrayList<>();
    //Task task = new Task();
    Project taskList = new Project();


    // to save the task in a file: data.bin
    public static void saveT(Project project) {

        String fileName = "data.bin";
        try {
            ObjectOutputStream oSave = new ObjectOutputStream(new FileOutputStream(fileName, true));
            oSave.writeObject(project);
            oSave.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // to read the Array list (tasks)

    public static Project readT() {

        Project Reader = new Project();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.bin"));
            Reader = (Project) is.readObject();
            System.out.println(Reader.tasks);
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


    public void chooseO(){

        do {
            switch (scanner.nextInt()) {

                case 1:
                    //todo show the details of the tasks (project name and description)
                    if(Project.conter < 2){
                        System.out.println("You have " + Project.conter + " task");}
                    else {
                        System.out.println("You have " + Project.conter + " tasks");}
                    //System.out.println("The tasks is: ");
                    taskList.showForEdit();
//                            Project Reader = readT();
//                            System.out.println(" the title: " + Reader.tasks);
                    System.out.println("To sort it due date press 6 or press 7 to sort it by the Project name" );
                    //todo (sorting the tasks due date or by project name)
                    System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                    x = true;
                    break;

                case 2:

                    // to create a new task with scanner
                    // enter a title
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
                    taskList.addTask(t);

                    //===============
                    //taskList.addTask(task);
                    //Task.createTask(task.title, task.Desc, task.Date, task.taskList);
                    //System.out.println(task.title + task.Desc + task.taskList.projectName);

                    //taskList.addTask(task);
                    // saveT(taskList);
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
                    if(Project.conter < 2){
                        System.out.println("You have " + Project.conter + " task");}
                    else {
                        System.out.println("You have " + Project.conter + " tasks");}

                    taskList.showListTitle();

                    switch (scanner.nextInt()) {

                        case 1:
                            System.out.println("Please choose the task number to edit");
                            int index = scanner.nextInt();
                            if(index > Project.conter){
                                System.out.println("Choose a correct task number");
                            } else {
                            System.out.println("Please edit your title");
                            scanner.nextLine();
                            String newTitle = scanner.nextLine();
                            System.out.println("Please edit your Desc");
                            String newDesc = scanner.nextLine();
                            System.out.println("Please edit your date");
                            String newDate = scanner.nextLine();
                            taskList.editTask(index, newTitle, newDesc,newDate);
                            taskList.showForEdit();
                            System.out.println("Thank you, edit successful");
                            System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");

                            break;}
                        case 2:


                            break;
                        case 3:
                            System.out.println("Please choose the task number to remove");
                            int inde = scanner.nextInt();
                            if(inde > Project.conter){
                                System.out.println("Choose a correct task number");
                            } else {
                                taskList.removeTask(inde);
                                taskList.showListTitle();
                                System.out.println("Thank you, remove successful");
                                System.out.println("Choose other option (press 5 to see the options again) or press 4 to save and exit! ");
                            }
                            break;
                    }
                }
                break;

                case 4:

                    this.saveT(taskList);
                    System.out.println("Bye!");
                    x = false;
                    break;

                case 5:
                    System.out.println(">> Welcome to ToDoLy ");
                    System.out.println(">> You have " + Project.conter + " tasks todo and " + " tasks are done!");
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

}
