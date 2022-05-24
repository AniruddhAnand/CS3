public class Boomerangs {

    public void countBoomerangs(int[] x) {
        //This initializes a count variable
        int count = 0;
        //This iterates throughout the loop excluding the last two elements
        for (int i = 0; i < x.length - 2; i++) {
            //This verifies if an element is within a boomerang pair
            if ((x[i] == x[i + 2]) && (x[i] != x[i + 1])) count++;
        }
        //This displays the boomerang count
        System.out.println(count);
    }
}
