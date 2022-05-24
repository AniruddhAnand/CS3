import java.util.*;
public class Runner {
    public static void main(String[] args) {
        SoundLabProbs q = new SoundLabProbs();

        System.out.println(q.lastIndexOf(new int[] {2, 4, 6, 12}, 8));

        System.out.println(q.range(new int[] {8, 3, 5, 7, 2, 4}));

        System.out.println(q.minDifference(new int[] {4, 8, 6, 1, 5, 9, 4}));

        System.out.println(q.reverseWords("the sky is blue and green and red"));

        System.out.println(q.priceIsRight(new int[] {1500, 1600, 2000, 2500}, 1900));

        System.out.println(Arrays.toString(q.productExceptSelf(new int[] {1, 2, 3, 4})));

//        double[] clip = {0.5, 1, 0, -1};
//        Sound.show(clip);
        double[] clip = Sound.pureTone(3.0, 1.0);
        Sound.show(clip);
        Sound.play(clip);
    }
}

