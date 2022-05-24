import java.io.IOException;

public class TestCemetery {
    public static void main(String[] args) throws IOException {
        Cemetery c = new Cemetery("cemetery.txt");
        double age = 0;
        int count = 0;
        for(int i=0;i<c.getNumTombs();i++){
            if(c.getTombstone(i).getAddress().indexOf("Little Carter Lane")>=0){
                age+=c.getTombstone(i).getAge();
                count++;
            }
        }
        System.out.println((Math.round(age/(365*count))));
    }
}
