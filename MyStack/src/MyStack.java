import java.util.EmptyStackException;

public class MyStack {
    Integer [] stack;
    int size;
    MyStack(){
        this(10);
    }
    MyStack(int initCap){
        stack = new Integer[initCap];
        size = 0;
    }
    boolean isEmpty(){
        return size==0;
    }
    public Integer peek() throws EmptyStackException{
        if(size>0){
            return stack[size-1];
        }else{
            throw new EmptyStackException();
        }
    }
    public Integer pop() throws EmptyStackException{
        if(size>0){
            Integer value = stack[size-1];
            stack[size-1] = null;
            size--;
            return value;
        }else{
            throw new EmptyStackException();
        }
    }
    public void push(Integer item){
        if(size==stack.length){
            doubleCapacity();
        }
        stack[size] = item;
        size++;
    }

    private void doubleCapacity(){
        Integer[] newArray = new Integer[size*2];
        for(int i=0;i<size;i++){
            newArray[i] = stack[i];
        }
        stack = newArray;
    }
    public String toString(){
        String s = "";
        for(int i=size-1;i>-1;i--){
            s+=stack[i];
            if(i==size-1){
                s+="-------- TOP";
            }
            s+="\n";
        }
        s+="________________";
        return s;
    }
}
