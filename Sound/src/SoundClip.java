import java.util.Arrays;

public class SoundClip
{
    double[] clip;
    public static void main(String[] args){
    }

    public SoundClip() {
        clip = null;
    }

    public SoundClip(double[] s) {
        clip = s;
    }

    void adjustVolume(double factor) {
        for(int i = 0; i < clip.length; i++) {
            clip[i]*=factor;
        }
    }

    void mix(double[] clip1, double[] clip2) {
        clip = new double[Math.max(clip1.length,clip2.length)];
        for(int i=0;i<clip1.length;i++){
            clip[i]+=clip1[i];
        }
        for(int i=0;i<clip2.length;i++){
            clip[i]+=clip2[i];
        }
    }

    void append(double[] other) {
        double[] result = new double[clip.length + other.length];
        for(int i = 0; i < clip.length; i++) {
            result[i] = clip[i];
        }
        int initial = 0;
        for(int i = clip.length; i < result.length; i++) {
            result[i] = other[initial];
            initial++;
        }
        clip = result;
        System.out.println(Arrays.toString(clip));
    }


    void fadeIn(double seconds) {
        double samples = Sound.toNumSamples(seconds);
        for(int i = 0; i < samples; i++) {
            clip[i] = clip[i] * i/samples;
        }
        return;
    }

    void fadeOut(double seconds) {
        int samples = Sound.toNumSamples(seconds);
        int subtract = 0;
        for(int i = clip.length-samples; i < clip.length; i++) {
            clip[i] = clip[i] * (samples - subtract)/samples;
            subtract++;
        }
        return;
    }

    void reverse() {
        double[] copy = new double[clip.length];
        for (int i = 0; i < clip.length; i++) {
            copy[i] = clip[i];
        }
        int initial = 0;
        for (int i = clip.length-1; i >= 0; i--) {
            clip[initial] = copy[i];
            initial++;
        }
        return;

    }

    void speedUp (double factor) {
        double length = clip.length/factor;
        int intlength = (int) length;
        double[] copy = new double[intlength];

        for(int i = 0; i < copy.length; i++) {
            copy[i] = clip[i];
        }
        clip = copy;
        return;
    }
}
