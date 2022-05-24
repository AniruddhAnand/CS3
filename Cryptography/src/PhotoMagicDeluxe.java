import java.awt.*;

public class PhotoMagicDeluxe {
    static final String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static Picture transform(Picture pic, String password, int tap){
        String s = "";
        for(int i=0;i<password.length();i++){
            s+=convertToBin(base64.indexOf(password.charAt(i)));
        }
        //System.out.println(s);
        return PhotoMagic.transform(pic,new LFSR(s,tap));
    }
    private static String convertToBin(int x){
        String s = "";
        int count  = (int)Math.pow(2,5);
        while(count>0){
            if(x/count==0){
                s+="0";
            }else{
                x-=count;
                s+="1";
            }
            count/=2;
        }
        return s;
    }
}