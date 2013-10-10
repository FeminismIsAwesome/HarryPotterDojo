import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 10/10/13
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class HarryPotterCashierTest {

    @Test
    public void shouldScanThat1CopyOfBook1WantedAndDisplayEight() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        PrintStream printStream = mock(PrintStream.class);
        HarryPotterCashier harryPotterCashier = new HarryPotterCashier(bufferedReader, printStream);

        when(bufferedReader.readLine()).thenReturn("1");
        harryPotterCashier.processBookRequests();
        verify(printStream).println("Amount of Book 1 requested: ");
        verify(printStream).println("Total with applicable discounts: $8");
    }
}
