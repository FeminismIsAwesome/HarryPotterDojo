import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

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
        when(bufferedReader.readLine()).thenReturn("").thenReturn("1");
        List<Integer> result = harryPotterReader.readAmountsFromUser();

        verify(printStream).println("Amount of Book 1 requested: ");
        verify(printStream).println("Amount of Book 2 requested: ");

        List<Integer> expectedResult = Arrays.asList(1);
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldReadOutTwoNumbersWhenGivenTwoInputs() throws Exception
    {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("1");
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
