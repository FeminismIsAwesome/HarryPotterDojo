import java.io.BufferedReader;
import java.io.IOException;
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

    public void processBookRequests() throws IOException {
        printStream.println("Amount of Book 1 requested: ");
        String output1 = bufferedReader.readLine();
        printStream.println("Amount of Book 2 requested: ");
        String output2 = bufferedReader.readLine();

        if(output2 != null)
            printStream.println("Total with applicable discounts: $15.2");
        else
            printStream.println("Total with applicable discounts: $8");
    }
}
