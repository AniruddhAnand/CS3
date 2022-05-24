import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class Autocomplete
{
    Term [] terms;
// Initializes the data structure from the given array of terms.
//terms will contain all the terms used for matching what the user enters
//to autocompleted suggestions
    public Autocomplete(Term[] terms){
        this.terms = terms;
    }
// Returns all terms that start with prefix , in descending order of weight.
    public Term[] allMatches(String prefix){
        return Arrays.stream(terms)
                .filter(a->a.query
                        .toLowerCase(Locale.ROOT)
                        .startsWith(prefix.toLowerCase(Locale.ROOT)))
                .sorted(Term.byReverseWeightOrder())
                .toArray(Term[]::new);
    }
    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix){
        return (int) Arrays.stream(terms)
                .filter((a)->a.query
                        .toLowerCase(Locale.ROOT)
                        .startsWith(prefix.toLowerCase(Locale.ROOT)))
                .count();
    }
    // unit testing (required)
    public static void main(String[] args){

    }
}