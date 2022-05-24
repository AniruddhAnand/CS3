public class MyLinkedList<T>{
    private ListNode head;
    private ListNode tail;
    private int size;

    private class ListNode<T>
    {
        T val; //does a private inner class need private instance variables?
        ListNode next;

        public ListNode(T val) { this.val = val; }

        @Override
        public String toString() { return "" + this.val; } //for printing / debug
    }
    MyLinkedList(){
        head = null;
        size = 0;
    }
    MyLinkedList(T val){
        head = new ListNode(val);
        tail = head;
        size = 1;
    }
    MyLinkedList(T ... args){
        for(T t:args){
            add(t);
        }
    }
    public void add(T newVal){
        if(size==0){
            head = new ListNode(newVal);
            tail = head;
            size++;
            return;
        }
        tail.next = new ListNode(newVal);
        tail = tail.next;
        size++;
    }
    public boolean contains(T target){
        ListNode temp = head;
        while(temp!=null){
            if(temp.val==target){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public T get(int index){
        if(index>=size||index<0){
            throw new IndexOutOfBoundsException();
        }
        ListNode temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return (T)temp.val;
    }
    public int indexOf(T target){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            if(temp.val==target){
                return count;
            }
            count++;
            temp = temp.next;
        }
        return -1;
    }
    public void set(T newVal, int index){
        if(index<0||index>=size){
            return;
        }
        ListNode temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        temp.val = newVal;
    }
    public int size(){
        return size;
        //return sizeRecursive(head);
    }
    public int sizeRecursive(ListNode current){
        if(current==null){
            return 0;
        }
        return 1+sizeRecursive(current.next);
    }
    public boolean isEmpty(){
        return size==0;
        //return head==null;
    }
    public T remove(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
        size--;
        if(index==0){
            T value = (T)head.val;
            head = head.next;
            return value;
        }
        ListNode temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        T value = (T)temp.next.val;
        temp.next = temp.next.next;
        return value;
    }
    public void add(T newVal, int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        ListNode x = new ListNode(newVal);
        if(index==0){
            x.next = head;
            head = x;
            return;
        }else if(index==size){
            add(newVal);
            return;
        }
        size++;
        ListNode temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        x.next = temp.next;
        temp.next = x;
    }
    public String toString(){
        ListNode temp = head;
        String s = "[";
        while(temp!=null){
            s+=temp.toString();
            temp = temp.next;
            if(temp!=null){
                s+=", ";
            }
        }
        s+="]";
        return s;
    }
}
