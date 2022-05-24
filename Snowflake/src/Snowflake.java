import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
	public SnowFlakePanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g)
	{
		int width  = getWidth();
		int height = getHeight();

		super.paintComponent(g);

		/*
		 * DRAWING CODE BELOW
		 */
		g.setColor(Color.BLUE);
		//drawstar(g,width/2,height/2,100);
		//snowflake(g,width/2,height/2,100,3);
		blizzard(g,15,3);
		//sierpinskiRight(g,400,0,0);
		//sierpinski(g,400,0,400,true);
		//sierpinskisBlizard(g,15,3,400,0,400,true);
	}
	public void drawstar(Graphics g, int x, int y, int radius){
		g.drawLine(x+radius,y,x-radius,y);
		g.drawLine(x+(int)(radius*Math.cos(45)),y+(int)(radius*Math.sin(45)),x-(int)(radius*Math.cos(45)),y-(int)(radius*Math.sin(45)));
		g.drawLine(x-(int)(radius*Math.cos(45)),y+(int)(radius*Math.sin(45)),x+(int)(radius*Math.cos(45)),y-(int)(radius*Math.sin(45)));

	}
	public void snowflake(Graphics g,int x, int y, int radius, int extent){
		if(radius==0){
			return;
		}
		drawstar(g,x,y,radius);
		snowflake(g,x+radius,y,radius/extent,extent);
		snowflake(g,x-radius,y,radius/extent,extent);
		snowflake(g,x+(int)(radius*Math.cos(45)),y+(int)(radius*Math.sin(45)),radius/extent,extent);
		snowflake(g,x-(int)(radius*Math.cos(45)),y-(int)(radius*Math.sin(45)),radius/extent,extent);
		snowflake(g,x-(int)(radius*Math.cos(45)),y+(int)(radius*Math.sin(45)),radius/extent,extent);
		snowflake(g,x+(int)(radius*Math.cos(45)),y-(int)(radius*Math.sin(45)),radius/extent,extent);
	}
	public void blizzard(Graphics g, int count, int extent){
		for(int i=0;i<count;i++){
			int x = (int)(Math.random()*getWidth());
			int y = (int)(Math.random()*getHeight());
			g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
			snowflake(g,x,y,(int)(Math.random()*Math.min(x,Math.abs(getWidth()-x))),extent);
		}
	}
	public void sierpinski(Graphics g,int radius,int x, int y,boolean rgb){
		if(radius==0){
			return;
		}
		change(g,rgb);
		g.drawLine(x,y,x+radius,y);
		g.drawLine(x,y,x+radius/2,y-(int)(radius*Math.sqrt(3)/2.0));
		g.drawLine(x+radius/2,y-(int)(radius*Math.sqrt(3)/2.0),x+radius,y);
		sierpinski(g,radius/2,x,y,rgb);
		sierpinski(g,radius/2,x+radius/4,y-(int)(radius*Math.sqrt(3)/4.0),rgb);//Fix
		sierpinski(g,radius/2,x+radius/2,y,rgb);//Fix
	}
	public void sierpinskiRight(Graphics g,int radius,int x, int y){
		if(radius==0){
			return;
		}
		g.drawLine(x,y,x,y+radius);
		g.drawLine(x,y,x+radius,y);
		g.drawLine(x,y+radius,x+radius,y);
		sierpinskiRight(g,radius/2,x,y);
		sierpinskiRight(g,radius/2,x,y+radius/2);//Fix
		sierpinskiRight(g,radius/2,x+radius/2,y);//Fix
	}
	public void sierpinskisBlizard(Graphics g, int count, int extent,int radius,int x, int y,boolean rgb){
		blizzard(g,count,extent);
		sierpinski(g,radius,x,y,rgb);
	}
	public void change(Graphics g,boolean rgb){
		if(rgb){
			g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
		}
	}
}

public class Snowflake
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
