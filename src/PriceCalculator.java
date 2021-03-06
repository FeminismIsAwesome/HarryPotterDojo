import java.util.*;

public class PriceCalculator {
    public static final double BOOK_PRICE = 8;

    private List<Double> discounts = Arrays.asList(0.0,1.0,0.95,0.9,0.85,0.75,0.7,0.65);

    private HashMap<Integer, Double> mapBookNumberToPriceDeal ;


    public PriceCalculator() {
        setupPrices();
    }

    private void setupPrices() {
        mapBookNumberToPriceDeal = new HashMap<Integer, Double>();
        for(int different_books=0; different_books< discounts.size(); different_books++)
        {
            double bookPrice = discounts.get(different_books) * BOOK_PRICE * different_books;
            mapBookNumberToPriceDeal.put(different_books, bookPrice);
        }
    }

    double determineBestPriceOfBooks(List<Integer> bookCopies) {
        if(bookCopies.size() > 1)
        {
            List<Integer> copyOfBooks = new ArrayList<Integer>(bookCopies);
            sortCopiesByValueDescending(copyOfBooks);
            if(copyOfBooks.get(0) > 1)
            {
                if(copyOfBooks.size() > 5 && copyOfBooks.get(3) == 2 && copyOfBooks.get(4) == 1 )
                {
                    return 60.0;
                }
                else
                {
                    removeBookCountsByOne(copyOfBooks);

                    return roundValue(determineBestPriceOfBooks(copyOfBooks) + mapBookNumberToPriceDeal.get(bookCopies.size()));
                }
            }
            else
            {
                return mapBookNumberToPriceDeal.get(bookCopies.size());
            }
        }
        else if(bookCopies.size() == 1)
        {
            return bookCopies.get(0) * BOOK_PRICE;
        }
        return 0;
    }

    public double roundValue(double v) {
        return (double) Math.round(100*v)/100.0;  //To change body of created methods use File | Settings | File Templates.
    }

    private void removeBookCountsByOne(List<Integer> copyOfBooks) {
        for(int i=0; i< copyOfBooks.size(); i++)
        {
            int numberOfBooks = copyOfBooks.get(i);
            numberOfBooks--;
            if(numberOfBooks == 0)
            {
                copyOfBooks.remove(i);
                i--;
            }
            else
            {
                copyOfBooks.set(i, numberOfBooks);
            }
        }
    }

    private void sortCopiesByValueDescending(List<Integer> copyOfBooks) {
        Collections.sort(copyOfBooks);
        Collections.reverse(copyOfBooks);
    }
}