//Name -

import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

public class Enemies 
{
	private ArrayList<Enemy> enemies;
	private Person guy;
	private boolean check = true;
	
	public Enemies(Person p)
	{
		enemies = new ArrayList<Enemy>();
		guy = p;
	}
	
	// DRAW AND COLLISION METHOD
	public void drawAndCollision(Graphics2D g) throws IOException
	{
		// ADD ENEMIES
		if(check==true){
			addEnemy();
			check=false;
		}
		for(int x = 0; x<enemies.size(); x++){
			enemies.get(x).move();
			enemies.get(x).draw(g);
		}
		// REMOVE ENEMIES THAT GO OUT OF BOUND
		for(int x = 0; x<enemies.size(); x++){
			if(enemies.get(x).getX()>800 || enemies.get(x).getX()<0 || enemies.get(x).getY()<0 || enemies.get(x).getY()>600){
				enemies.remove(enemies.get(x));
			}
		}

		// GO THROUGH THE LIST OF ENEMIES AND CALL THEIR draw() and move() method and check if their collide with guy if so then call the GAMEOVER() METHOD
		for(int x = 0; x<enemies.size(); x++){
			if(guy.collide(enemies.get(x).getX(), enemies.get(x).getY())){
				GAMEOVER(g);
			}
		}
		// IF THE PLAYER REACHES THE GRASS ON THE BOTTOM SIDE CALL THE VICTORY() method
		for(int x = 0; x<800; x++){
			if(guy.collide(x,550)){
				VICTORY(g);
			}
		}
	}
	
	public void GAMEOVER(Graphics2D g)
	{
		Game.RUNNING = false;
		Font f = new Font("Dialog", Font.PLAIN, 24);
		g.setFont(f);
		g.drawString("GAME OVER!", 400, 300);
	}
	
	public void VICTORY(Graphics2D g)
	{
		Font f = new Font("Dialog", Font.PLAIN, 24);
		g.setFont(f);
		g.drawString("VICTORY!", 400, 300);
		Game.RUNNING = false;
	}
	
	// ADDS AN ENEMY TO THE ENEMY LIST
	public void addEnemy() throws IOException
	{
		Enemy one = new Enemy((int)(Math.random()*100),(int)(Math.random()*100), 3);
		Enemy two = new Enemy((int)(Math.random()*100+100),(int)(Math.random()*100+100), 3);
		Enemy three = new Enemy((int)(Math.random()*100+200),(int)(Math.random()*100+200), 3);
		Enemy four = new Enemy((int)(Math.random()*100+300),(int)(Math.random()*100+300), 3);
		enemies.add(one);
		enemies.add(two);
		enemies.add(three);
		enemies.add(four);
	}
	
	// RETURN HOW MANY ENEMIES THERE ARE
	public int numEnemies()
	{
		return enemies.size();
	}
}
