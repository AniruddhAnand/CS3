import java.util.EmptyStackException;

public class MyStack<T> implements StackADT {
    T [] stack;
    int size;
    MyStack(){
        this(10);
    }
    MyStack(int initCap){
        stack = (T[]) new Object[initCap];
        size = 0;
    }
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public void clear() {
        size=0;
        stack = (T[]) new Object[0];
    }

    public T peek() throws EmptyStackException{
        if(size>0){
            return stack[size-1];
        }else{
            throw new EmptyStackException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    public T pop() throws EmptyStackException{
        if(size>0){
            T value = stack[size-1];
            stack[size-1] = null;
            size--;
            return value;
        }else{
            throw new EmptyStackException();
        }
    }

    @Override
    public void push(Object item) {
        if(size==stack.length){
            doubleCapacity();
        }
        stack[size] = (T)item;
        size++;
    }

    private void doubleCapacity(){
        T[] newArray = (T[]) new Object[size*2];
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
