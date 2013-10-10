
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 10/10/13
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class PriceCalculatorTest {



    @Test
    public void shouldReturnPriceOfOneBookWhenOnlyOneBookWanted()
    {
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Integer> bookCounts = Arrays.asList(1);

        double price = priceCalculator.determineBestPriceOfBooks(bookCounts);

        assertThat("Should return price for one book when book 1 bought once", price, is(PriceCalculator.BOOK_PRICE));
    }

    @Test
    public void shouldReturnDiscountForTwoSeriesBooksWhenBook1and2bought()
    {
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Integer> bookCounts = Arrays.asList(1,1);

        double price = priceCalculator.determineBestPriceOfBooks(bookCounts);
        assertThat("Should return price for one book when book 1, book 2 bought once", price, is(PriceCalculator.BOOK_PRICE*2*0.95));

    }

    @Test
    public void shouldReturnPriceOfOneBookTwiceWhenOnlyOneBookInSeriesBought()
    {
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Integer> bookCounts = Arrays.asList(2);

        double price = priceCalculator.determineBestPriceOfBooks(bookCounts);
        assertThat("Should return price for one book bought twice", price, is(PriceCalculator.BOOK_PRICE*2));

    }

}
