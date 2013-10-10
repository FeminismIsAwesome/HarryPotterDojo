import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 10/10/13
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class HarryPotterCashierTest {

    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private HarryPotterCashier harryPotterCashier;
    private InOrder inOrder;
    private PriceCalculator priceCalculator;
    private HarryPotterReader harryPotterReader;

    @Before
    public void setup()
    {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        harryPotterReader = mock(HarryPotterReader.class);
        harryPotterCashier = new HarryPotterCashier(bufferedReader, printStream, harryPotterReader);
        inOrder = inOrder(printStream);
        priceCalculator = mock(PriceCalculator.class);
        harryPotterCashier.setPriceCalculator(priceCalculator);
    }

    @Test
    public void shouldScanThat1CopyOfBook1WantedAndDisplayEight() throws IOException {

        List<Integer> listResultsReturnedFromReader = mock(List.class);
        when(harryPotterReader.readAmountsFromUser()).thenReturn(listResultsReturnedFromReader);
        when(priceCalculator.determineBestPriceOfBooks(listResultsReturnedFromReader)).thenReturn(8.0);
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("");
        harryPotterCashier.processBookRequests();

        verify(printStream).println("Total with applicable discounts: $" + 8.0);
    }


}
