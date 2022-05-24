import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

/** The view (graphical) component */
public class LifeView extends JPanel
{
    private static final long serialVersionUID = 1L;
	private static int SIZE = 60;
	private static Color color;
	private static boolean isRandom;

	/** store a reference to the current state of the grid */
    private LifeCell[][] grid;

    public LifeView()
    {
        grid = new LifeCell[SIZE][SIZE];
        color = Color.BLUE;
        isRandom = false;
    }

    /** entry point from the model, requests grid be redisplayed */
    public void updateView( LifeCell[][] mg )
    {
        grid = mg;
        repaint();
    }

    public void randomizeColor(){
        isRandom = !isRandom;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int testWidth = getWidth() / (SIZE+1);
        int testHeight = getHeight() / (SIZE+1);
        // keep each life cell square
        int boxSize = Math.min(testHeight, testWidth);

        for ( int r = 0; r < SIZE; r++ )
        {
            for (int c = 0; c < SIZE; c++ )
            {
                if (grid[r][c] != null)
                {
                    if ( grid[r][c].isAliveNow() ) {
                        if(isRandom){
                            float color1 = (float)Math.random();
                            float color2 = (float)Math.random();
                            float color3 = (float)Math.random();
                            while(color1==235&&color2==235&&color3==255){
                                color1 = (float)Math.random();
                                color2 = (float)Math.random();
                                color3 = (float)Math.random();
                            }
                            color = new Color(color1,color2,color3);
                        }else{
                            color = Color.BLUE;
                        }
                        g.setColor(color);
                    }
                    else
                        g.setColor( new Color(235,235,255) );

                    g.fillRect( (c+1)*boxSize, (r+1)* boxSize, boxSize-2, boxSize-2);
                }
            }
        }
    }
}
