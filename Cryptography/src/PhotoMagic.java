import java.awt.*;

class PhotoMagic {

    public static Picture transform(Picture pic, LFSR lfsr){
        for(int i=0;i<pic.width();i++){
            for(int j=0;j< pic.height();j++){
                Color c = pic.get(i,j);
                pic.set(i,j,new Color(c.getRed()^lfsr.generate(8),c.getGreen()^lfsr.generate(8),c.getBlue()^lfsr.generate(8)));
            }
        }
        return pic;
    }

    public static void main(String[] args){

    }
}