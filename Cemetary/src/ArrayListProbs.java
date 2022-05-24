import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListProbs {
    public ArrayListProbs(){}
    public void makeListAndPrint(int num, int limit){
        ArrayList<Integer> list = new ArrayList<>();
        while(num-->0){
            list.add((int)(Math.random()*limit+1));
        }
        System.out.println(list);
    }
    public ArrayList<Integer> minToFront(ArrayList<Integer> list){
        int min = list.get(0);
        for(int i:list){
            if(i<min){
                min = i;
            }
        }
        list.remove(Integer.valueOf(min));
        list.add(0,min);
        return list;
    }
    public ArrayList<String> removeDupes(ArrayList<String> list){
        for(int i=1;i<list.size();i++){
            if(list.get(i-1).equals(list.get(i))){
                list.remove(i);
                i--;
            }
        }
        return list;
    }
    public ArrayList<Integer> swapPairs(ArrayList<Integer> list){
        for(int i=0;i<list.size()-1;i++){
            int temp = list.get(i);
            list.set(i,list.get(i+1));
            list.set(i+1,temp);
        }
        return list;
    }
    public ArrayList<String> removeLenN(ArrayList<String> list, int n){
        for(int i=0;i<list.size();i++){
            if(list.get(i).length()==n){
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public int smartestPerson(ArrayList<Person> list){
        int index = 0;
        int IQ = list.get(0).getIQ();
        for(int i=1;i<list.size();i++){
            if(list.get(i).getIQ()>IQ){
                index = i;
                IQ = list.get(i).getIQ();
            }
        }
        return index;
    }

    public Book highestPricedBook(ArrayList<Book> list){
        double price = list.get(0).getPrice();
        Book b = list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i).getPrice()>price){
                price = list.get(i).getPrice();
                b = list.get(i);
            }
        }
        return b;
    }
    public double bookstoreValue(Bookstore store){
        double total = 0;
        int i=store.numBooks();
        while(i-->0){
            total+=store.getBook(i).getPrice();
        }
        return total;
    }
}

    /**
     * convert the ageString to a number of days; age can
     * take a variety of forms in the data file
     */

