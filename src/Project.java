import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


public class  Project implements Serializable {
    public static final long serialVersionUID = -5971538861194843412L;

    public ArrayList<Task> tasks;
    public static int conter ;


    public Project(){
        tasks = new ArrayList<>();
    }

    public void addTask (Task task){
        tasks.add(task);
        conter = conter + 1;
    }


    public void editTask(int index, String title, String desc, String date)
    {

        Task taskToEdit = tasks.get(index -1);
        //System.out.println("title");
        taskToEdit.setTitle(title);
       // System.out.println("desc");
        taskToEdit.setDesc(desc);
       // System.out.println("date");
        taskToEdit.setDate(date);

    }
    public void removeTask(int index){
        Task taskToRemove = tasks.remove( index - 1);

    }

    public void showForEdit()
    {
        for (int i=0; i< tasks.size(); i++)
        {
            System.out.println("Task " + (i+1) + ":    " + tasks.get(i) );

        }
    }

    public ArrayList<Task> getTasks()
    {
        return this.tasks;
    }


    }




