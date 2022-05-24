public class NumberList {
    private Integer[] list;
    private int size;
    public NumberList(){
        list = new Integer[2];
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public String toString(){
        String s = "[";
        for(int i=0;i<size;i++){
            s+=list[i];
            if(i!=size-1) {
             s+=", ";
            }
        }
        s+="]";
        return s;
    }
    private void doubleCapacity(){
        Integer[] newArray = new Integer[size*2];
        for(int i=0;i<size;i++){
            newArray[i] = list[i];
        }
        list = newArray;
    }
    public void add(int index, Integer value) throws IndexOutOfBoundsException{
        if(size==list.length) {
            doubleCapacity();
        }
        if(index>size||index<0){
            throw new IndexOutOfBoundsException();
        }
        size++;
        Integer storedValue = list[index];
        for(int i=index+1;i<size;i++){
            Integer temp = list[i];
            list[i] = storedValue;
            storedValue = temp;
        }
        list[index] = value;
    }
    public boolean add(Integer value){
        add(size,value);
        return true;
    }
    public Integer get(int index) throws IndexOutOfBoundsException{
        if(index>=size||index<0){
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }
    public Integer set(int index, Integer value) throws IndexOutOfBoundsException{
        if(index>=size||index<0){
            throw new IndexOutOfBoundsException();
        }
        Integer replaced = list[index];
        list[index] = value;
        return replaced;
    }
    public Integer remove(int index) throws IndexOutOfBoundsException{
        if(index>=size||index<0){
            throw new IndexOutOfBoundsException();
        }
        Integer value = list[index];
        for(int i=index;i<size-1;i++){
            list[index] = list[index+1];
            list[index+1] = null;
        }
        size--;
        return value;
    }

}
