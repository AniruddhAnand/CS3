
public class GuitarHeroVisualizer {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(500, 500);
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] strings = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            strings[i] = new GuitarString(440 * Math.pow(1.05956, i - 24));
        }
        int xRange = 100;
        StdDraw.setXscale(0, xRange);
        StdDraw.setYscale(-0.5, 0.5);
        double[] y = new double[xRange];
        int count = 0;

        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types this character
                char key = StdDraw.nextKeyTyped();
                try {
                    strings[keyboard.indexOf(key)].pluck();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("No note available at this key");
                }
            }

            /* Glitched Audio due to lagging
            if(count%xRange!=xRange-1) {
                int i = count%xRange;
                StdDraw.myLine(i,y[i],i+1,y[i+1]);
            }else{
                StdDraw.clear();
            }*/

            if (count % xRange == 0) {
                StdDraw.clear();
                //Custom Implementation of myLine
                StdDraw.myLine(xRange, y);
            }

            // compute the superposition of the samples
            double sample = 0.0;
            for (GuitarString s : strings) {
                sample += s.sample();
            }
            StdAudio.play(sample);
            for (GuitarString s : strings) {
                s.tic();
            }

            y[count++ % xRange] = sample;
        }
    }
}