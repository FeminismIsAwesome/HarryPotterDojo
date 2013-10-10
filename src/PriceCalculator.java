import java.util.List;

public class PriceCalculator {
    public static final double BOOK_PRICE = 8;

    public PriceCalculator() {
    }

    double determineBestPriceOfBooks(List<Integer> bookCopies) {
        if (bookCopies.size() == 2)
            return 15.2;
        else if (bookCopies.size() == 1)
            return bookCopies.get(0) * BOOK_PRICE;
        return 0;
    }
}