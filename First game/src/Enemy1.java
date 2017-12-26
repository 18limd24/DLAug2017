import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy1 extends GameObject{

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
		
	}

	public void render(Graphics g) {
		if(id == ID.Enemy1) {
			g.setColor(Color.red);
			g.fillRect(x, y, 16, 16);
		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

}
