import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HuffmanTree {
    Node root;
    HashMap<Character, String> codes = new HashMap<>();

    HuffmanTree(String fileName){
        try {
            BufferedReader f = new BufferedReader(new FileReader(fileName));
            StringTokenizer st = new StringTokenizer(f.readLine());
            root = new Node((char) -1,-1);
            while(st.hasMoreTokens()){
                Node newNode = new Node((char)Integer.parseInt(st.nextToken()),-1);
                st = new StringTokenizer(f.readLine());
                String location = st.nextToken();
                place(root,location,newNode);
                try {
                    st = new StringTokenizer(f.readLine());
                }catch (Exception i){
                     break;
                }
            }
            map(root,"");
          //  TreePrinter.printTree(root);
        }catch (Exception e){}
    }

    private void place(Node n, String route, Node newNode){
        if(route.charAt(0)=='0'){
            if(route.length()==1){
                n.left = newNode;
                return;
            }
            if(n.left==null){
                n.left = new Node((char)-1,-1);
            }
            place(n.left,route.substring(1),newNode);
        }else{
            if(route.length()==1){
                n.right = newNode;
                return;
            }
            if(n.right==null){
                n.right = new Node((char)-1,-1);
            }
            place(n.right,route.substring(1),newNode);
        }
    }

    HuffmanTree(int [] count){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<count.length;i++){
            if(count[i]>0){
                priorityQueue.add(new Node((char) i,count[i]));
            }
        }
        priorityQueue.add(new Node((char)256,1));
        while(priorityQueue.size()>1){
            Node n1 = priorityQueue.poll();
            Node n2 = priorityQueue.poll();
            Node n3 = new Node((char)-1,n1.weight+n2.weight);
            n3.left = n1;
            n3.right = n2;
            priorityQueue.add(n3);
        }
        root = priorityQueue.poll();
        map(root,"");
        //TreePrinter.printTree(root);
    }

    void map(Node n, String s){
        if(n==null){
            return;
        }
        map(n.left,s+"0");
        if(n.c>0&&n.c!=65535) {
            codes.put(n.c,s);
        }
        map(n.right,s+"1");
    }

    void write (String fileName) {
        try {
            PrintWriter p = new PrintWriter(fileName);
            for(Character key:codes.keySet()){
                p.println((int)key);
                p.println(codes.get(key));
            }
            p.close();
        }catch (Exception e){
            System.out.println("Invalid File");
        }
    }

//    void write(PrintWriter p, Node n, String s){
//        if(n==null){
//            return;
//        }
//        write(p,n.left,s+"0");
//        if(n.c>0&&n.c!=65535) {
//            p.println((int)n.c);
//            p.println(s);
//        }
//        write(p,n.right,s+"1");
//    }

    void decode(BitInputStream in, String outFile){
        try {
            PrintWriter p = new PrintWriter(outFile);
            Node n = root;
            while (true) {
                if (n.left == null && n.right == null) {
                    if ((int) n.c == 256) {
                        break;
                    }
                    p.print(n.c);
                    n = root;
                }
                int temp = in.readBit();
                if(temp==-1){
                    break;
                }
                if (temp == 0) {
                    n = n.left;
                } else {
                    n = n.right;
                }
            }
            p.close();
        }catch (Exception e){}
    }
}

class Node implements Comparable<Node>{
    Node left;
    Node right;
    char c;
    int weight;
    public Node(char c, int weight){
        this.c = c;
        this.weight = weight;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        String s = c+"";// + ":" + weight;
        return s;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(weight,o.weight);
    }
}
