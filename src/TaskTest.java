import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
public class TaskTest {
    private Task task1;
    private Task task2;

    @Before
    public void setup() {
        task1 = new Task("task1", "desc1", LocalDate.of(1985,03,27), "pro1");
        task2 = new Task("task2", "desc2", LocalDate.of(2019,03,27), "pro2");
    }

     @Test
     public void testStatus(){
        final String expected = "Done!";
        task1.markAsDone();
        String result = task1.status();
        assertEquals(result,expected);
    }

    @Test
    public void testSetGetTitle(){
        final String expected = "task1";
       String result = task1.getTilte();
       assertEquals(result,expected);
    }

    @Test
    public void testSetGet(){
        final String expected = "desc1";
        String result = task1.getDesc();
        assertEquals(result,expected);
    }

    @Test
    public void testSetGetDate(){
        final LocalDate expected = LocalDate.of(1985,03,27);
        LocalDate result = task1.getDate();
        assertEquals(result,expected);
    }

    @Test
    public void testSetGetProjectName(){
        final String expected = "pro2";
        String result = task2.getProjectName();
        assertEquals(expected,result);
    }
}