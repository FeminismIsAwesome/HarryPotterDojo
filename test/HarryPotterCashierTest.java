import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

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

    @Before
    public void setup()
    {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        harryPotterCashier = new HarryPotterCashier(bufferedReader, printStream);
        inOrder = inOrder(printStream);
    }

    @Test
    public void shouldScanThat1CopyOfBook1WantedAndDisplayEight() throws IOException {


        when(bufferedReader.readLine()).thenReturn("1").thenReturn(null);
        harryPotterCashier.processBookRequests();
        inOrder.verify(printStream).println("Amount of Book 1 requested: ");
        inOrder.verify(printStream).println("Total with applicable discounts: $8");
    }

    @Test
    public void shouldScanSuchThatIf1CopyOfBook1And1CopyOfBook2WantedItShouldProcessADiscount() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("1");
        harryPotterCashier.processBookRequests();
        verify(printStream).println("Amount of Book 1 requested: ");
        verify(printStream).println("Amount of Book 2 requested: ");
        verify(printStream).println("Total with applicable discounts: $" + 8*2*0.95);

    }

    @Test
    public void shouldScanSuchThat2CopiesOfBook1WantedGivesMultipleCopies() throws IOException
    {
        when(bufferedReader.readLine()).thenReturn("2").thenReturn("");
        harryPotterCashier.processBookRequests();
        inOrder.verify(printStream).println("Amount of Book 1 requested: ");
        inOrder.verify(printStream).println("Total with applicable discounts: $16");
    }
}
