public class Main {

    public static void main(String[] args){

        Operation op = new Operation();

        System.out.println(">> Welcome to ToDoLy ");
        System.out.println(">> You have " + Project.conter + " tasks todo and " + " tasks are done!");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List in detail (by date or project)");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit Task (update, mark as done, remove)");
        System.out.println(">> (4) Save and Quit");
        System.out.println(">>");


        //int option = scanner.nextInt();

//        do {
//            switch (scanner.nextInt()) {
//
//                case 1:
//
//                    Project Reader = readT();
//                    System.out.println(" the title: " + Reader.tasks);
//                    x = true;
//                    break;
//
//                case 2:  // to create a new task with scanner
//                    // enter a title
//                    System.out.print("enter the title \n");
//                    scanner.nextLine();
//                    task.title(scanner.nextLine());
//
//                    // enter a desc
//                    System.out.println("enter the descraption");
//                    task.Desc(scanner.nextLine());
//                    // enter a date
//                    System.out.println("enter the date");
//                    task.Date(scanner.nextLine());
//                    // enter a taskList name
//                    System.out.println("enter the taskList name");
//                   taskList.setProjectName(scanner.nextLine());
//                    task.setProject(taskList);
//
//                    Task.createTask(task.title, task.Desc, task.Date , task.taskList);
//                    System.out.println(task.title + task.Desc + task.taskList.projectName);
//
//
//                    taskList.addTask(task);
//                   // System.out.println(task);
//                    saveT(taskList);
//                    x = true;
//                    System.out.println("Done!");
//                    System.out.println("++++++++++++++++++++++++++++++++++++++++");
//                    break;
//
//                case 3:     {
//                            System.out.println(">> (1) update");
//                            System.out.println(">> (2) mark as done");
//                            System.out.println(">> (3) remove");
//                            switch (scanner.nextInt()){
//
//                            case 1:
//
//                            }
//
//
//                }
//
//                    break;
//
//                case 4:
//
//                    break;
//
//                default:
//                    System.out.println(" Enter number from 1 to 4 ");
//                    //x = true;
//                    break;
//            }
//        } while (x);
//
//
//    }
//
//    public static void saveT(Project P) {
//
//        String fileName = "data.bin";
//        try {
//            ObjectOutputStream oSave = new ObjectOutputStream(new FileOutputStream(fileName , true));
//            oSave.writeObject(P);
//            oSave.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // هون برجع الشغلات الي موجودة ع الفايل
//
//    public static Project readT() {
//
//        Project Reader = new Project();
//        try {
//            ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.bin"));
//            //Reader = (Project) is.readObject();
//            Reader = (Project) is.readObject();
//            is.close();
//            return Reader;
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//
//        }
//        return Reader;

        // calling the options to choose what do you want to do!
        op.chooseO();



    }

}
