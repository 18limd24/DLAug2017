import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
	}
	public void tick() {
		x += speedX;
		y += speedY;
		
		x = Game.clamp(x, Game.WIDTH - 38, 0);
		y = Game.clamp(y, Game.HEIGHT - 60, 0);
		
		collision();
	}
	public void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player) {
				if(getBounds().intersects(tempObject.getBounds())) {
					
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 32, 32);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y,32,32);
	}

}
