/*
    Basically an array of linked lists
    The array stores the x values, and the linked list stroes all the collisions
 */

import java.util.Objects;

public class MyHashTable<K,V> {
    Object[] entries;
    int size = 0;
    class Entry{
        K key;
        V value;
        Entry next;
        Entry(K k, V v){
            key = k;
            value = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, key, next);
        }
    }
    public MyHashTable(int num){
        entries = new Object[num];
    }
    public MyHashTable(){
        this(10000);
    }

    public V put(K key, V value) {
        int index = getIndex(key.hashCode());
        Entry entry = new Entry(key,value);
        if(entries[index]==null){
            entries[index] = entry;
            size++;
            return null;
        }else{
            Entry root = (Entry) entries[index];
            while(root!=null){
                if(root.key.equals(key)){
                    V number = root.value;
                    root.value = value;
                    return number;
                }
                if(root.next==null){
                    root.next = entry;size++;
                    return null;
                }
                root = root.next;
            }
        }
        return value;
    }

    public V get(K key) {
        int index = getIndex(key.hashCode());
        Entry root = (Entry) entries[index];
        while(root!=null){
            if(root.key.equals(key)){
                break;
            }
            root = root.next;
        }
        return root==null?null:root.value;
    }

    public int size() {
        return size;
    }

    public V remove(K key) {
        int index = getIndex(key.hashCode());
        Entry root =(Entry) entries[index];
        V number = null;
        if(root==null)return null;
        if(root.key.equals(key)){
            size--;
            entries[index] = root.next;
            return root.value;
        }
        while(root.next!=null){
            if(root.next.key.equals(key)){
                size--;
                number = root.next.value;
                root.next = root.next.next;
                break;
            }
            root = root.next;
        }
        return number;
    }
    private int getIndex(int num){
        return Math.abs(num% entries.length);
    }
}
