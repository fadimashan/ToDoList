import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Task implements Serializable{
    public static final long serialVersionUID = -5971538861194843412L;

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
    public String getTitle() {
        return this.title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
        return;
    }

    public void setDate(String date){
        this.date = date;
    }
    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
//        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
       return this.date = (date.format(date));
    }


    public void setProject(String p) {
        this.project = p;
    }

    public String getProjectName(){
        return this.project;
    }

    @Override
    public String toString()
    {
        return title + " --- " + "date :" + date  + " ==> " + "project name: " + project + "\n" + "The description is: " + desc + ".\n";
    }

}