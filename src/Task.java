import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    public static final long serialVersionUID = -5971538861194843412L;
    private String title;
    private String desc;
    private LocalDate date;
    private String project;
    private boolean done;
    private String done1 ;

    public Task(String title, String desc, LocalDate date , String project )
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
    public String getTilte(){
        return title;
    }
    public void setDesc(String desc) {
        this.desc = desc;
        return;
    }
    public String getDesc(){
        return desc;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setProjectname(String project){this.project=project;}
    public String getProjectName(){
        return this.project;
    }

    public String status(){
        if(this.done == true){
            this.done1="Done!";

        }
        else{this.done1="In progress"; }
        return done1;
    }

    public boolean getDone()
    {
        return this.done;
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