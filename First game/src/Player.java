import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

//this is an enumeration of our game objects
public class Player extends GameObject{
	
	public Player(int x, int y, ID id) {
		super(x, y, id);//idk what super is yet
		
		//Random r = new Random();
		

	}

	public void tick() {
		x += speedX;
		y += speedY;//already declared in game object
		//tick method is being constantly updated
	}
	public void render(Graphics g) {
		if(id == ID.Player) {
		g.setColor(Color.magenta);//use color class to set color
		g.fillRect(x, y, 32, 32);//this way always same size but place determined by fields, rn it's a square of 32 by 32
		}
		if(id == ID.Player2) {
			g.setColor(Color.white);//use color class to set color
			g.fillRect(x, y, 32, 32);//this way always same size but place determined by fields, rn it's a square of 32 by 32
		}
		if(id == ID.Enemy) {
			g.setColor(Color.GREEN);//use color class to set color
			g.fillRect(x, y, 50, 50);//this way always same size but place determined by fields, rn it's a square of 32 by 32
		}
	}
 
}
