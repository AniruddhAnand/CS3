import java.util.Comparator;

public class Searcher
{
    // Returns index of first term in a that equals the search key, or -1 if none
    public static int firstIndexOf(Term[] a, Term key, Comparator<Term> comp){
        for (int i = 0; i < a.length; i++) {
            if(comp.compare(a[i],key)==0)return i;
        }
        return -1;
    }

    // Returns index of last term in a that equals the search key, or -1 if none
    public static int lastIndexOf(Term[] a, Term key, Comparator<Term> comp){
        for (int i = a.length-1; i>-1; i--) {
            if(comp.compare(a[i],key)==0)return i;
        }
        return -1;
    }

    // unit testing (required)
    public static void main(String[] args){

    }
}

