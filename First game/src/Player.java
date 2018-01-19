import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

//this is an enumeration of our game objects
public class Player extends GameObject{
	
	private Handler handler;
	
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);//idk what super is yet
		this.handler = handler;
		this.speedUps = 0;
		//Random r = new Random();
		

	}

	public void tick() {
		x += speedX;
		y += speedY;//already declared in game object
		//tick method is being constantly updated
		
		x = Game.clamp(x, Game.WIDTH - 38, 0);
		y = Game.clamp(y, Game.HEIGHT - 60, 0);
		
		collision();
		
		//handler.addObject(new Trail( x, y, ID.Trail, Color.white, 32, 32, 0.1f, handler));
	}
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Enemy1) {
				if(getBounds().intersects(tempObject.getBounds())){
					//if the tempObject is the enemy and if it is intersecting the player
					HUD.health -= 2;
					
				}
			}
			if(tempObject.getID() == ID.SmartEnemy) {
				if(getBounds().intersects(tempObject.getBounds())){
					//if the tempObject is the enemy and if it is intersecting the player
					HUD.health -= 1;
					
				}
			}
			if(tempObject.getID() == ID.SpeedUp) {
				if(getBounds().intersects(tempObject.getBounds())) {
					this.speedUps ++;
					handler.removeObject(tempObject);
				}
			}
		}
	}
	public void render(Graphics g) {
		if(id == ID.Player) {
		g.setColor(Color.magenta);//use color class to set color
		g.fillRect((int)x,(int)y, 32, 32);//this way always same size but place determined by fields, rn it's a square of 32 by 32
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 32, 32);//sets bounds to same as the player
	}
	
	
 
}
