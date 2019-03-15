import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class OperationTest {

        private Task task1;
        private Task task2;
        private Task task3;
        private ArrayList<Task> taskList1=new ArrayList<>();
        private ArrayList<Task> doneTaskList = new ArrayList<>();
        private int counter;
        private Operation operation = new Operation();

        @Before
        public void setup() {

            task1 = new Task("task1", "desc1", LocalDate.of(1985,03,27), "pro1");
            task2 = new Task("task2", "desc2", LocalDate.of(2019,03,27), "pro2");
            task3 = new Task("task3", "desc3", LocalDate.of(2019,03,27), "pro2");
            taskList1.add(task1);
            taskList1.add(task2);
            taskList1.add(task3);
            this.counter=taskList1.size();
            task1.markAsDone();
            task2.markAsDone();
        }

    @Test
    public void sizeOfArray() {
        final int expected = 3;
        int result = operation.sizeOfArray(counter);
        assertEquals(result,expected);

    }

    @Test
    public void doneTaskList() {
        final int expected = 3;
        for(int i = 0; i < taskList1.size(); i++) {
            taskList1.get(i).markAsDone();
                if(taskList1.get(i).getDone() == true)
                {
                    doneTaskList.add(taskList1.get(i));
                }
        }
        int result = doneTaskList.size();
        assertEquals(expected,result);
    }
}