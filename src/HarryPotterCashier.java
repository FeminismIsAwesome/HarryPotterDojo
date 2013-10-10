import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 10/10/13
 * Time: 9:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class HarryPotterCashier {
    private HarryPotterReader harryPotterReader;
    private PriceCalculator priceCalculator;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public HarryPotterCashier(BufferedReader bufferedReader, PrintStream printStream, HarryPotterReader harryPotterReader) {
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.priceCalculator = new PriceCalculator();
        this.harryPotterReader = harryPotterReader;
    }


    public void setPriceCalculator(PriceCalculator priceCalculator)
    {
        this.priceCalculator = priceCalculator;
    }

    public void processBookRequests() throws IOException {
        List<Integer> bookCopies = harryPotterReader.readAmountsFromUser();
        double price = priceCalculator.determineBestPriceOfBooks(bookCopies);
        printStream.println("Total with applicable discounts: $" + price);
    }



    public static void main(String[] args) throws IOException {
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HarryPotterReader harryPotterReader = new HarryPotterReader(printStream, bufferedReader);
        HarryPotterCashier harryPotterCashier = new HarryPotterCashier(bufferedReader, printStream, harryPotterReader);
        harryPotterCashier.processBookRequests();
    }
}
