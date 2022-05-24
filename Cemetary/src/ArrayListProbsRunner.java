import java.io.IOException;
import java.util.ArrayList;

public class ArrayListProbsRunner {
    public static void main(String []args) throws IOException {
        ArrayListProbs probs = new ArrayListProbs();
        probs.makeListAndPrint(10,10);
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);test.add(1);test.add(1);test.add(0);
        System.out.println(probs.minToFront(test));
        Bookstore bs = new Bookstore();
        bs.addBook(new Book("","",5));bs.addBook(new Book("","",5.25));
        System.out.println(probs.bookstoreValue(bs));
    }
}
