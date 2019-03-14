import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Verification {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    public int num;

    /**
     * Method to determine the input type as Integer.
     */
    public void justNum() {
        while (true)
            try {
                num = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid! Please enter a number:");
            }
    }

    /**
     * Method to check date's format and the validation (should not be in the past).
     */
    public LocalDate checkDateFormat(){
        while(true) {
            String date1 = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            try {
                LocalDate localDate = LocalDate.parse(date1, formatter);
                if (LocalDate.now().compareTo(localDate) <= 0) {
                    return localDate;
                } else if(LocalDate.now().compareTo(localDate) > 0){
                    System.out.println("The date should not be in the past! Try again please.");
                }
            }catch (DateTimeParseException e){
                System.out.println("Please enter the date in a right format");
            }
        }
    }
}
