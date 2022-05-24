import java.util.Comparator;
import java.util.Locale;

public class Term implements Comparable<Term>
{

    String query;
    long weight;
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight){
        this.query = query;
        this.weight = weight;
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                return Long.compare(o2.weight,o1.weight);
            }
        };
    }

    // Compares the two terms in lexicographic order, for the first r characters
    public static Comparator<Term> byPrefixOrder(int r){
        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                return o1.query.substring(0,r).toLowerCase(Locale.ROOT).compareTo(o2.query.substring(0,r).toLowerCase(Locale.ROOT));
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term other){
        return query.toLowerCase(Locale.ROOT).compareTo(other.query.toLowerCase(Locale.ROOT));
    }

    // Returns a string representation of this term in the following format:
    //  the weight, followed by a tab, followed by the query.
    //   (the GIU requires the format specified above)
    public String toString(){
        return weight + "\t" + query;
    }

    // unit testing (required)
    public static void main(String[] args){

    }
}
