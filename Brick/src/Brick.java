public class Brick {
    public void doesBrickFit(int height, int width, int depth, int wallHeight, int wallWidth){
        /*This uses a boolean variable to store all the 6 possible permutations of rotating a brick
        inorder to fit the brick into a wall with a given width and height
         */
        boolean doesItFit=(height<=wallHeight&&width<=wallWidth)||
                (height<=wallHeight&&depth<=wallWidth)||
                (width<=wallHeight&&height<=wallWidth)||
                (width<=wallHeight&&depth<=wallWidth)||
                (depth<=wallHeight&&height<=wallWidth)||
                (depth<=wallHeight&&width<=wallWidth);

        //This displays whether it is possible for the brick to fit as calculated above
        System.out.println(doesItFit);
    }
}
