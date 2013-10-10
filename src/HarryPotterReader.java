import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class HarryPotterReader {
    PrintStream printStream;
    BufferedReader bufferedReader;

    public HarryPotterReader(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    List<Integer> readAmountsFromUser() throws IOException {
        printStream.println("Amount of Book 1 requested: ");
        int book1Copies = readBookCountFromUser(bufferedReader.readLine());

        printStream.println("Amount of Book 2 requested: ");

        int book2Copies = readBookCountFromUser(bufferedReader.readLine());
        List<Integer> bookCopies = new ArrayList<Integer>();
        if (book1Copies != 0)
            bookCopies.add(book1Copies);
        if (book2Copies != 0)
            bookCopies.add(book2Copies);
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