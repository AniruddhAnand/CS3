/*****************************************************************************
 *  Compilation:  javac GuitarHeroLite.java
 *  Execution:    java  GuitarHeroLite
 *  Dependencies: StdAudio.java StdDraw.java GuitarString.java
 *
 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the
 *  standard drawing window.
 *
 ****************************************************************************/

public class GuitarHero {

    public static void main(String[] args) {
        StdDraw.setCanvasSize(500,500);
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString [] strings = new GuitarString[37];
        for(int i=0;i<37;i++){
            strings[i]= new GuitarString(440*Math.pow(1.05956,i-24));
        }
        // Create two guitar strings, for concert A and C


        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                try {
                    strings[keyboard.indexOf(key)].pluck();
                }catch (ArrayIndexOutOfBoundsException e){
                }
            }

            // compute the superposition of the samples
            double sample = 0.0;
            for(GuitarString s:strings){
                sample+=s.sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(GuitarString s:strings){
                s.tic();
            }
        }
    }

}