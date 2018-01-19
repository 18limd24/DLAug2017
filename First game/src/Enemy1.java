import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy1 extends GameObject{
	
	private Handler handler;

	public Enemy1(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		speedX = 5;
		speedY = 5;
	}

	public void tick() {
		x += speedX;
		y += speedY;
		if(x <= 0 || x >= Game.WIDTH - 32) speedX *= -1;//changes direction if reaches sides
		if(y <= 0 || y >= Game.HEIGHT - 32) speedY *= -1;
		
		handler.addObject(new Trail((int)x,(int) y, ID.Trail, Color.red, 16, 16, 0.03f, handler));
		
		//collision();
		
	}
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				if(getBounds().intersects(tempObject.getBounds())){
					//if the tempObject is the enemy and if it is intersecting the player
					this.speedX *= -1;
					this.speedY *= -1;
					
				}
			}
		}
	}

	public void render(Graphics g) {
		if(id == ID.Enemy1) {
			g.setColor(Color.red);
			g.fillRect((int)x,(int) y, 16, 16);
		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

}
