import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Melody {
    Queue<Note> notes;
    Melody(Queue<Note> song){
        notes = song;
    }
    double getTotalDuration(){
        boolean isRepeat = false;
        double duration = 0;
        int size = 0;
        while(size<notes.size()){
            size++;
            Note n = notes.poll();
            double tempDur = n.getDuration();
            if(!isRepeat&&n.isRepeat()){
                isRepeat = true;
            }else if(isRepeat&&n.isRepeat()){
                isRepeat = false;
                tempDur*=2;
            }
            if(isRepeat){
                tempDur*=2;
            }
            duration+=tempDur;
            notes.offer(n);
        }
        return duration;
    }

    @Override
    public String toString() {
        String name = "";
        int size = 0;
        for(int i=0;i<size;i++){
            Note n = notes.poll();
            name+=n.toString()+"\n";
            notes.offer(n);
        }
        return name;
    }
    void changeTempo(double tempo){
        int size = 0;
        while(size<notes.size()){
            Note n = notes.poll();
            n.setDuration(n.getDuration()/tempo);  // should it be *
            notes.offer(n);
            size++;
        }
    }
    void reverse(){
        Stack<Note> reversed = new Stack<>();
        while(notes.size()>0){
            reversed.push(notes.poll());
        }
        while(reversed.size()>0){
            notes.offer(reversed.pop());
        }
    }
    void append(Melody other){
        while(other.notes.size()>0){
            notes.offer(other.notes.poll());
        }
    }
    void play(){
        Queue<Note> repeats = new LinkedList<>();
        boolean isRepeated = false;
        int size = 0;
        while(size<notes.size()){
            Note n = notes.poll();
            size++;
            n.play();
            if(!isRepeated&&n.isRepeat()){
                isRepeated = true;
                repeats.add(n);
            }else if(isRepeated && n.isRepeat()){
                repeats.add(n);
                isRepeated = false;
                while(repeats.size()>0){
                    repeats.poll().play();
                }
            }
            if(isRepeated && !n.isRepeat()){
                repeats.offer(n);
            }
            notes.offer(n);
        }
    }
    Queue<Note> getNotes(){
        return notes;
    }
}
