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
		
		x = Game.clamp(x, Game.WIDTH - 38, 0);
		y = Game.clamp(y, Game.HEIGHT - 60, 0);
		
	}
	public void render(Graphics g) {
		if(id == ID.Player) {
		g.setColor(Color.magenta);//use color class to set color
		g.fillRect(x, y, 32, 32);//this way always same size but place determined by fields, rn it's a square of 32 by 32
		}
	}

	public void Rectangle() {
		return new Rectangle(x, y, )
		
	}
	
	
 
}
