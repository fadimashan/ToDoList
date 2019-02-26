import java.io.Serializable;


public class Task implements Serializable{

    //TODO change or add getter and setter methods
    private String title;
    private String desc;
    private String date;
    private String project;
    //public Project taskList;

    public Task(String title, String desc, String date , String project)
    {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.project = project;
    }

    public Task(){}

    public static void createTask(String title, String Desc, String Date /*, Project taskList*/) {
    }


    public void setTitle(String title) {
        this.title = title;

    }
    public String getTitle()
    {
        return this.title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
        return;
    }

    public void setDate(String date) {
        this.date = date;
        return;
    }


    public void setProject(String p) {
        this.project = p;

    }

    @Override
    public String toString()
    {
        return title + " --- " + "date :" + date  + " ==> " + "project name: " + project + "\n" + "The description is: " + desc + ".\n";
    }

}