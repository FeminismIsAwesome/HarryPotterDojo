import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class HarryPotterReader {
    public static final int AMOUNT_OF_SERIES_BOOKS_FOR_SALE = 2;
    PrintStream printStream;
    BufferedReader bufferedReader;

    public HarryPotterReader(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    List<Integer> readAmountsFromUser() throws IOException {
        List<Integer> bookCopies = new ArrayList<Integer>();
        for(int series_number=1; series_number <= AMOUNT_OF_SERIES_BOOKS_FOR_SALE; series_number++)
        {
            printStream.println("Amount of Book " + series_number + " requested: ");
            int bookCopyAmount = readBookCountFromUser(bufferedReader.readLine());
            if(bookCopyAmount != 0)
            {
                bookCopies.add(bookCopyAmount);
            }

        }
        return bookCopies;
    }

    int readBookCountFromUser(String output) throws IOException {
        int copyNumber;
        if (output.equals(""))
            copyNumber = 0;
        else
            copyNumber = Integer.parseInt(output);
        return copyNumber;
    }
}