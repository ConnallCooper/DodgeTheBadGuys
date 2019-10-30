//Name -

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Ground 
{
	private ArrayList<Image> tiles;
	
	public Ground() throws IOException
	{
		tiles = new ArrayList<>();
		Image grass = ImageIO.read(new File("grass.gif"));
		tiles.add(grass);
		Image road = ImageIO.read(new File("road.gif"));
		tiles.add(road);
		Image gtoroad = ImageIO.read(new File("gtoroad.gif"));
		tiles.add(gtoroad);
		Image rtograss = ImageIO.read(new File("rtograss.gif"));
		tiles.add(rtograss);
		//point the tiles at new array list
		//add in each of the images for the grass.gif, gtoroad.gif, road.gif, rtograss.gif
		//tiles.add( ImageIO.read(new File("grass.gif")) );
	}
	
	public void drawGround(Graphics2D g)
	{
		for(int x = 0; x<=750; x+=50){
			for(int y = 0; y<=550; y+=50){
				if(y<=50){
					g.drawImage(tiles.get(0),x,y,null);
				}
				else if(y==100){
					g.drawImage(tiles.get(2),x,y,null);
				}
				else if(y==500){
					g.drawImage(tiles.get(3),x,y,null);
				}
				else if(y==550){
					g.drawImage(tiles.get(0),x,y,null);
				}
				else{
					g.drawImage(tiles.get(1),x,y,null);
				}
			}
		}
		//draw the ground on the screen	
	}	
}