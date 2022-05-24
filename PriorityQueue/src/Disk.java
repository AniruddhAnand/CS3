import java.util.LinkedList;

public class Disk implements Comparable<Disk> {
    final static int MAXIMUM_STORAGE = 1000000;
    private static int currentId = 0;

    private String id;

    private int currentStorage;

    private LinkedList<Integer> files;

    public Disk() {
        currentStorage = 0;
        files = new LinkedList<>();
        id = currentId + "";
        currentId++;
    }

    @Override
    public int compareTo(Disk o) {
        return currentStorage - o.currentStorage;
    }

    public int getCurrentStorage() {
        return currentStorage;
    }

    public void add(int file) {
        files.add(file);
        currentStorage += file;
    }

    public String toString() {
        String s = id;
        s += " " + (MAXIMUM_STORAGE - currentStorage) + ":";
        for (int i : files) {
            s += i + " ";
        }
        return s;
    }
}
