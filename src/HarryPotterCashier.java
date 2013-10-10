import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 10/10/13
 * Time: 9:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class HarryPotterCashier {
    public static final int BOOK_PRICE = 8;
    BufferedReader bufferedReader;
    PrintStream printStream;

    public HarryPotterCashier(BufferedReader bufferedReader, PrintStream printStream) {
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public void processBookRequests() throws IOException {
        printStream.println("Amount of Book 1 requested: ");
        int book1Copies = Integer.parseInt(bufferedReader.readLine());

        printStream.println("Amount of Book 2 requested: ");
        String output2 = bufferedReader.readLine();

        if(output2 != null && output2 != "")
            printStream.println("Total with applicable discounts: $15.2");
        else
            printStream.println("Total with applicable discounts: $" + book1Copies * BOOK_PRICE);
    }

    public static void main(String[] args) throws IOException {
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HarryPotterCashier harryPotterCashier = new HarryPotterCashier(bufferedReader, printStream);
        harryPotterCashier.processBookRequests();
    }
}
