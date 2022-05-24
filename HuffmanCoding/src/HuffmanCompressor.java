import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class HuffmanCompressor {
    void compress(String fileName){
        try {
            boolean first = false;
            String file = "";
            BufferedReader f = new BufferedReader(new FileReader(fileName));
            Scanner console = new Scanner(f);
            String outFile = fileName.substring(0, fileName.indexOf("."));
            int[] alphabet = new int[256];
            while(console.hasNextLine()) {
                String s = console.nextLine();
                if(first){
                    s = "\n" + s;
                }
                file+=s;
                first = true;
                for (int i = 0; i < s.length(); i++) {
                    alphabet[s.charAt(i)]++;
                }
            }
            HuffmanTree tree = new HuffmanTree(alphabet);
            tree.write(outFile + ".code");
            convert(tree, new BitOutputStream(outFile + ".short"),file);
        }catch (Exception e){

        }
    }

    private void convert(HuffmanTree tree, BitOutputStream p, String file){
        for(int i=0;i<file.length();i++){
            String code = tree.codes.get(file.charAt(i));
            for(int j=0;j<code.length();j++){
                p.writeBit(Integer.parseInt(code.charAt(j)+""));
            }
        }
        String code = tree.codes.get((char)256);
        for(int i=0;i<code.length();i++){
            p.writeBit(Integer.parseInt(code.charAt(i)+""));
        }
        p.close();
    }
    void expand(String codeFile, String fileName){
        HuffmanTree tree = new HuffmanTree(codeFile);
        BitInputStream in = new BitInputStream(fileName);
        tree.decode(in,fileName.substring(0,fileName.indexOf("."))+".new");
    }
    public static void main(String[] args) {
        int [] charsExample = new int[256];
        charsExample[97] = 3;
        charsExample[98] = 3;
        charsExample[99] = 1;
        charsExample[120] = 1;
        charsExample[121] = 2;
        HuffmanTree tree = new HuffmanTree(new int []{});
        String name = "Hamlet";
        HuffmanCompressor compressor = new HuffmanCompressor();
        compressor.compress(name + ".txt");
        compressor.expand(name + ".code",name + ".short");
    }
}
