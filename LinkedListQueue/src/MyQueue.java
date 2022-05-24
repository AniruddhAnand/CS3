public class MyQueue <T> extends MyLinkedList{
    public MyQueue(){
        super();
    }
    public MyQueue(int size){
        super(size);
    }
    //Is Empty is inherited
    //size is inherited
    public void offer(T item){
        add(item);
    }
    public T poll() {
        return (T) remove(0);
    }
    public void clear(){
        while (!isEmpty()){
            remove(0);
        }
    }
}
