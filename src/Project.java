import java.io.Serializable;
import java.util.ArrayList;


public class  Project implements Serializable {

    public static String projectName;
    public static ArrayList<Task> tasks;
    public static int conter ;


    public Project(){
        tasks = new ArrayList<>();
    }

    public void setProjectName(String projectName) {

        this.projectName = projectName;
    }

    public void addTask (Task task){
        tasks.add(task);
        conter = conter + 1;
    }

//    public void editTask(){
//        tasks.set(0, new Task("","","",""));
//    }

    public void editTask(int index, String title, String desc, String date)
    {

        Task taskToEdit = tasks.get(index -1);
        //System.out.println("title");
        taskToEdit.setTitle(title);
       // System.out.println("desc");
        taskToEdit.setDesc(desc);
       // System.out.println("date");
        taskToEdit.setDate(date);

//        System.out.println("edit the description: ");
//        taskToEdit.setTitle(desc);

    }
    public void removeTask(int index){
        Task taskToRemove = tasks.remove( index - 1);

    }
    //public ObjectOutputStream oSave;
    //TODO
    public void showForEdit()
    {
        for (int i=0; i< tasks.size(); i++)
        {
            System.out.println("Task " + (i+1) + ":    " + tasks.get(i) );

        }
    }

    public void showListTitle(){
        int i=0;
        for(Task task : tasks){
            i++;
            System.out.println("Task " + (i) + ":" + task.getTitle());

        }

    }

}


