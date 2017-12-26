import java.awt.Color;
import java.awt.Graphics;

public class Enemy1 extends GameObject{

	public Enemy1(int x, int y, ID id) {
		super(x, y, id);
		
		
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

}
