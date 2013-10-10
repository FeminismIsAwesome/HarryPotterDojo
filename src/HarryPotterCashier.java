import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 10/10/13
 * Time: 9:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class HarryPotterCashier {
    BufferedReader bufferedReader;
    PrintStream printStream;

    public HarryPotterCashier(BufferedReader bufferedReader, PrintStream printStream) {
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public void processBookRequests() {
        printStream.println("Amount of Book 1 requested: ");
        printStream.println("Total with applicable discounts: $8");
    }
}
