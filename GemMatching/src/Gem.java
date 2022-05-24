import java.awt.*;

enum GemType {
    GREEN, BLUE, ORANGE;
    static GemType random(){
    	int rng = (int)(Math.random()*3);
    	switch(rng){
			case 0:return GREEN;
			case 1: return BLUE;
			case 2: default: return ORANGE;
		}
	}
}

public class Gem 
{
	GemType type;
	int points;
	final static int [] POINT_SET = new int[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
	Gem(){
		this(GemType.random(), POINT_SET[(int)(Math.random()*POINT_SET.length)]);
	}
	Gem(GemType gemType, int points){
		this.type = gemType;
		this.points = points;
	}
	public String toString(){
		return type.toString() +", "+ points;
	}

	public GemType getType() {
		return type;
	}

	public int getPoints() {
		return points;
	}

	void draw(double x, double y){
		StdDraw.picture(x,y, "gem_" + type.name().toLowerCase() + ".png");
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(x,y,points + "");
	}

	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;

		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);

		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
