public class MinHeapGeneric<T extends Comparable<T>> {
    private T[] heap;
    int size = 0;
    static final int DEFAULT_CAPACITY = 8;

    public MinHeapGeneric(){
        this(DEFAULT_CAPACITY);
    }

    public MinHeapGeneric(int num) {
        heap = (T[])new Comparable[num];
    }

    public MinHeapGeneric(T ... nums){
        for(T i:nums){
            insert(i);
        }
    }

    public void buildHeap(int n){
        for(int i=1;i<=n;i++){
            heap[i-1] = (T)new Integer(i);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){return size==0;}

    public T peekMinimum(){
        return heap[0];
    }

    private int getLeftChildIndex(int index){
        return index*2+1>=size?-1:index*2+1;
    }

    private int getRightChildIndex(int index){
        return index*2+2>=size?-1:index*2+2;
    }

    private int getParentIndex(int index){
        return (index-1)/2;
    }
    private void doubleCapacity(){
        T[] tmp = (T[]) new Comparable[2*heap.length];
        System.arraycopy(heap,0,tmp,0,heap.length);
        heap = tmp;
    }
    public void insert(T value){
        if(size==heap.length){
            doubleCapacity();
        }
        heap[size] = value;
        size++;
        bubbleUp(size-1);
    }
    private void bubbleUp(int index){
        int index2 = getParentIndex(index);
        if(heap[index].compareTo(heap[index2])<0){
            T temp = heap[index2];
            heap[index2] = heap[index];
            heap[index] = temp;
            bubbleUp(index2);
        }else{
            return;
        }
    }

    T popMinimum(){
        T x = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = null;
        size--;
        siftDown(0);
        return x;
    }
    private void siftDown(int index){
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);
        int repDex = -1;
        if(left>-1&&right>-1){
            repDex = heap[left].compareTo(heap[right])>0?right:left;
        }else{
            repDex = left>-1?left:right;
        }
        if(repDex==-1){
            return;
        }
        T temp = heap[repDex];
        heap[repDex] = heap[index];
        heap[index] = temp;
        siftDown(repDex);
    }
    @Override
    public String toString()
    {
        String output = "";

        for (int i = 0; i < getSize(); i++)
            output += heap[i] + ", ";

        return output.substring(0, output.lastIndexOf(",")); //lazily truncate last comma
    }

    /** method borrowed with minor modifications from the internet somewhere, for printing */
    public void display() {
        int nBlanks = 32, itemsPerRow = 1, column = 0, j = 0;
        String dots = "...............................";
        System.out.println(dots + dots);
        while (j < this.getSize())
        {
            if (column == 0)
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');

            System.out.print((heap[j] == null)? "" : heap[j]);

            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            }
            else
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' ');

            j++;
        }
        System.out.println("\n" + dots + dots);
    }

}