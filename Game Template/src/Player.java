import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{
	private boolean hit = false;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
	}
	public void tick() {
		x += speedX;
		y += speedY + Game.SPEED;
		
		x = Game.clamp(x, Game.WIDTH - 38, 0);
		//y = Game.clamp(y, Game.HEIGHT - 60, 0);
		
		//collision();
	}
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Car) {
				if(getBounds().intersects(tempObject.getBounds())) {
					this.hit = true;
				}
			}
			if(tempObject.getId() == ID.Log) {
				if(getBounds().intersects(tempObject.getBounds())) {
					speedX = 2;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 32);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y,32,32);
	}
	public void setHit(boolean hit) {
		this.hit = hit;
	}
	public boolean getHit() {
		return hit;
	}

}
