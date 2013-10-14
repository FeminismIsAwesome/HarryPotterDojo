
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
    public void shouldReturnDiscountForThreeSeriesBooksWhenBook1and2and3bought()
    {
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Integer> bookCounts = Arrays.asList(1,1,1);
        double price = priceCalculator.determineBestPriceOfBooks(bookCounts);
        assertThat("Should return price for discount when book 1,2,3 bought once", price, is(PriceCalculator.BOOK_PRICE*3*0.9));
    }

    @Test
    public void shouldReturnDiscountForFourSeriesWhenBooks1And2And3And4Bought()
    {
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Integer> bookCounts = Arrays.asList(1,1,1,1);
        double price = priceCalculator.determineBestPriceOfBooks(bookCounts);
        assertThat("Should return price for discount when book 1,2,3,4 bought once", price, is(PriceCalculator.BOOK_PRICE*4*0.85));

    }

    @Test
    public void shouldReturnPriceOfOneBookTwiceWhenOnlyOneBookInSeriesBought()
    {
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Integer> bookCounts = Arrays.asList(2);

        double price = priceCalculator.determineBestPriceOfBooks(bookCounts);
        assertThat("Should return price for one book bought twice", price, is(PriceCalculator.BOOK_PRICE*2));

    }

    @Test
    public void shouldReturnDiscountOnlyOnceWhenBook1BoughtTwiceAndBook2BoughtOnce()
    {
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Integer> bookCounts = Arrays.asList(2,1);

        double price = priceCalculator.determineBestPriceOfBooks(bookCounts);
        assertThat("Should return price for one book bought twice and book 2 bought once", price, is(PriceCalculator.BOOK_PRICE+PriceCalculator.BOOK_PRICE*2*0.95));

    }

    @Test
    public void shouldReturnDiscountOnlyOnceWhenBook1BoughtThreeTimesAndBook2BoughtOnce()
    {
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Integer> bookCounts = Arrays.asList(3,1);

        double price = priceCalculator.determineBestPriceOfBooks(bookCounts);
        assertThat("Should return price for one book bought twice and book 2 bought once", price, is(2*PriceCalculator.BOOK_PRICE+PriceCalculator.BOOK_PRICE*2*0.95));

    }

    @Test
    public void shouldReturnTwoSetsOfDiscountsWhenBook1BoughtThreeTimesAndBook2BoughtTwoTimesAndBook3BoughtOnce()
    {
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Integer> bookCounts = Arrays.asList(3,2,1);
        double price = priceCalculator.determineBestPriceOfBooks(bookCounts);
        double expectedPrice = 3* PriceCalculator.BOOK_PRICE *0.9 + 2 * PriceCalculator.BOOK_PRICE*0.95+PriceCalculator.BOOK_PRICE;
        assertThat("Should return price for one book bought thrice and book 2 bought twice and book 3 bought once", price, is(expectedPrice));
    }

    @Test
    public void shouldReturnDiscountOnlyOnceWhenBook2BoughtTwiceAndBook1BoughtOnce()
    {
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Integer> bookCounts = Arrays.asList(1,2);

        double price = priceCalculator.determineBestPriceOfBooks(bookCounts);
        assertThat("Should return price for one book bought once and book 2 bought twice", price, is(PriceCalculator.BOOK_PRICE+PriceCalculator.BOOK_PRICE*2*0.95));

    }

}
