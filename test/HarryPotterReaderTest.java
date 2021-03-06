import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 10/10/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class HarryPotterReaderTest {

    @Mock
    private BufferedReader bufferedReader;
    @Mock
    private PrintStream printStream;

    private HarryPotterReader harryPotterReader;


    @Before
    public void setup()
    {
        initMocks(this);
        harryPotterReader = new HarryPotterReader(printStream, bufferedReader);

    }

    @Test
    public void shouldReadOutOneNumberWhenGivenOneResult() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("");
        List<Integer> result = harryPotterReader.readAmountsFromUser();

        verify(printStream).println("Amount of Book 1 requested: ");
        verify(printStream).println("Amount of Book 2 requested: ");

        List<Integer> expectedResult = Arrays.asList(1);
        assertThat(result, is(expectedResult));


    }

    @Test
    public void shouldReturnOnlyOneValueInListWhenBook1HasNoBooksButBook2HasOne() throws Exception
    {
        when(bufferedReader.readLine()).thenReturn("").thenReturn("1").thenReturn("");
        List<Integer> result = harryPotterReader.readAmountsFromUser();

        verify(printStream).println("Amount of Book 1 requested: ");
        verify(printStream).println("Amount of Book 2 requested: ");

        List<Integer> expectedResult = Arrays.asList(1);
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldReturnFourNumbersWhenGivenFourInputs() throws Exception
    {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("1").thenReturn("1").thenReturn("1").thenReturn("");
        List<Integer> result = harryPotterReader.readAmountsFromUser();

        verifyPromptsForSeriesAmountsOccur(4);

        List<Integer> expectedResult = Arrays.asList(1,1,1,1);
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldPrintNumberOfInputsRequestedGivenCertainNumberOfBooksInSeries() throws Exception
    {
        when(bufferedReader.readLine()).thenReturn("");
        harryPotterReader.readAmountsFromUser();
        for(int seriesNumber=1; seriesNumber <= 7; seriesNumber++)
        {
            verify(printStream).println("Amount of Book " + seriesNumber + " requested: ");
        }

    }

    @Test
    public void shouldReturnNumberOfInputsGivenCertainNumberOfNonBlankValues() throws Exception
    {
        for(int seriesNumber=1; seriesNumber < 7; seriesNumber++)
        {
            OngoingStubbing<String> continuedStubbing = when(bufferedReader.readLine());
            for(int numberOfValues=0; numberOfValues < seriesNumber; numberOfValues++)
            {
                continuedStubbing = continuedStubbing.thenReturn("1");
            }
            continuedStubbing.thenReturn("");
            List<Integer> result = harryPotterReader.readAmountsFromUser();
            assertThat("Should be making a list of size proportional to the inputs given, in this case: " + seriesNumber, result.size(), is(seriesNumber));
        }

    }

    private void verifyPromptsForSeriesAmountsOccur(int seriesAmount) {
        for(int i=1; i<= seriesAmount; i++)
        {
        verify(printStream).println("Amount of Book " + i + " requested: ");
        }
    }

    @Test
    public void shouldReturnThreeNumbersWhenGivenThreeInputs() throws Exception
    {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("1").thenReturn("1").thenReturn("");
        List<Integer> result = harryPotterReader.readAmountsFromUser();

        verify(printStream).println("Amount of Book 1 requested: ");
        verify(printStream).println("Amount of Book 2 requested: ");
        verify(printStream).println("Amount of Book 3 requested: ");

        List<Integer> expectedResult = Arrays.asList(1,1,1);
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldReadOutTwoNumbersWhenGivenTwoInputs() throws Exception
    {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("1").thenReturn("");
        List<Integer> result = harryPotterReader.readAmountsFromUser();

        verify(printStream).println("Amount of Book 1 requested: ");
        verify(printStream).println("Amount of Book 2 requested: ");

        List<Integer> expectedResult = Arrays.asList(1,1);
        assertThat(result, is(expectedResult));
    }



    @Test
    public void shouldParseOutIntegerWhenGivenAnInteger() throws Exception {
        int result = harryPotterReader.readBookCountFromUser("1");
        assertThat(result, is(1));
        int secondResult = harryPotterReader.readBookCountFromUser("2");
        assertThat(secondResult, is(2));
    }

    @Test
    public void shouldParseOutZeroWhenGivenBlankString() throws Exception
    {
        int result = harryPotterReader.readBookCountFromUser("");
        assertThat(result, is(0));
    }


}
