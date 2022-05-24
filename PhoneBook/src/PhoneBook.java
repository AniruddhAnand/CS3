/*
    Basically an array of linked lists
    The array stores the x values, and the linked list stroes all the collisions
 */

import java.util.Objects;

public class PhoneBook implements IMap{
    Entry[] entries;
    int size = 0;
    class Entry{
        Person person;
        PhoneNumber number;
        Entry next;
        Entry(Person p, PhoneNumber n){
            person = p;
            number = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return Objects.equals(person, entry.person) && Objects.equals(number, entry.number);
        }

        @Override
        public int hashCode() {
            return Objects.hash(person, number, next);
        }
    }
    public PhoneBook(int num){
        entries = new Entry[num];
    }
    public PhoneBook(){
        this(10000);
    }
    @Override
    public PhoneNumber put(Person person, PhoneNumber phone) {
        int index = getIndex(person.hashCode());
        Entry entry = new Entry(person,phone);
        if(entries[index]==null){
            entries[index] = entry;
            size++;
        }else{
            Entry root = entries[index];
            while(root!=null){
                if(root.person.equals(person)){
                    PhoneNumber number = root.number;;
                    root.number = phone;
                    return number;
                }
                if(root.next==null){
                    root.next = entry;size++;
                    return null;
                }
                root = root.next;
            }
        }
        return phone;
    }

    @Override
    public PhoneNumber get(Person person) {
        int index = getIndex(person.hashCode());
        Entry root = entries[index];
        while(root!=null){
            if(root.person.equals(person)){
                break;
            }
            root = root.next;
        }
        return root==null?null:root.number;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public PhoneNumber remove(Person person) {
        int index = getIndex(person.hashCode());
        Entry root = entries[index];
        PhoneNumber number = null;
        if(root==null)return null;
        if(root.person.equals(person)){
            size--;
            entries[index] = root.next;
            return root.number;
        }
        while(root.next!=null){
            if(root.next.person.equals(person)){
                size--;
                number = root.next.number;
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
