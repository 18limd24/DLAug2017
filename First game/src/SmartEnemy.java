import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
	
	private Handler handler;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getID() == ID.Player) player = handler.object.get(i);
		}
	}

	public void tick() {
		x += speedX;
		y += speedY;
		
		float diffX = x - player.getX();
		float diffY = y - player.getY();
		float difference = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		
		speedX = (int) (-1.0/difference)*(diffX);
		speedY = (int) (-1.0/difference)*(diffY);
		
		if(x <= 0 || x >= Game.WIDTH - 32) speedX *= -1;//changes direction if reaches sides
		if(y <= 0 || y >= Game.HEIGHT - 32) speedY *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.03f, handler));
		
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
		if(id == ID.SmartEnemy) {
			g.setColor(Color.green);
			g.fillRect(x, y, 16, 16);
		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

}
