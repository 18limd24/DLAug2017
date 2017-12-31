import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Car extends GameObject{
	private Random r = new Random();
	public Car(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
	}

	public void tick() {
		x += speedX;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 64, 32);
		g.setColor(Color.black);
		g.drawRect(x, y, 64, 32);
	}

}
