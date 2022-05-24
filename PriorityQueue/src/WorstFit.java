import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WorstFit {
    public static void main(String[] args) throws IOException {
        String file = "input100000.txt";
        worstFitDescending(file);
    }
    public static void worstFit(String file) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader(file));
        PriorityQueue<Disk> disks = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(f.readLine());
        double size = 0;
        while(st.hasMoreTokens()){
            int currentFile = Integer.parseInt(st.nextToken());
            size+=currentFile;
            Disk diskTemp = disks.peek();
            if(diskTemp!=null&&Disk.MAXIMUM_STORAGE-diskTemp.getCurrentStorage()>=currentFile){
                diskTemp = disks.poll();
                diskTemp.add(currentFile);

            }else{
                diskTemp = new Disk();
                diskTemp.add(currentFile);
            }
            disks.add(diskTemp);
            try{
                st = new StringTokenizer(f.readLine());}catch (Exception e){}
        }
        System.out.println("Total Size: " + size/Disk.MAXIMUM_STORAGE + " GB");
        System.out.println("Disks used:" +disks.size());
        while(disks.size()>0){
            System.out.println(disks.poll());
        }
    }
    public static void worstFitDescending(String file) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader(file));
        PriorityQueue<Disk> disks = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(f.readLine());
        double size = 0;
        ArrayList<Integer> files = new ArrayList<>();
        while(st.hasMoreTokens()){
            int currentFile =Integer.parseInt(st.nextToken());
            files.add(currentFile);
            size+=currentFile;
            try{
                st = new StringTokenizer(f.readLine());}catch (Exception e){}
        }
        Collections.sort(files, Collections.reverseOrder());
        for(int i:files){
            Disk diskTemp = disks.peek();
            if(diskTemp!=null&&Disk.MAXIMUM_STORAGE-diskTemp.getCurrentStorage()>=i){
                diskTemp = disks.poll();
                diskTemp.add(i);

            }else{
                diskTemp = new Disk();
                diskTemp.add(i);
            }
            disks.add(diskTemp);

        }
        System.out.println("Total Size: " + size/Disk.MAXIMUM_STORAGE + " GB");
        System.out.println("Disks used:" +disks.size());
        while(disks.size()>0){
            System.out.println(disks.poll());
        }
    }
}
