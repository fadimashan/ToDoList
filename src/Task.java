import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Task implements Serializable {
    public static final long serialVersionUID = -5971538861194843412L;

    //TODO change or add getter and setter methods
    private String title;
    private String desc;
    private String date;
    private String project;
    private boolean done;
    private String done1 ;

    //public Project taskList;

    public Task(String title, String desc, String date , String project )
    {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.project = project;
        this.done=false;
        status();
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
        return this.date = (date.format(date));
    }

    public String status(){
        if(this.done == true){
            this.done1="Done!";
        }
        else{this.done1="In progress"; }
        return done1;
    }
//    public void setProject(String p) {
//        this.project = p;
//    }

    public String getProjectName(){
        return this.project;
    }

    public void markAsDone()
    {this.done=true;
        status();
    }
    @Override
    public String toString()
    {
        return String.format("Title: %-15s |Due date: %-12s Project: %-20s  |Status: %-12s \n%-29s  |*** Description: %s\n",
                title , date  , project, done1 , "", desc );
    }
}