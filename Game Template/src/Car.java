import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Car extends GameObject{
	private Random r = new Random();
	private int carWidth = 64;
	public int getCarWidth() {
		return carWidth;
	}

	public void setCarWidth(int carWidth) {
		this.carWidth = carWidth;
	}

	public int getCarHeight() {
		return carHeight;
	}

	public void setCarHeight(int carHeight) {
		this.carHeight = carHeight;
	}
	private int carHeight = 32;
	public Car(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
	}

	public void tick() {
		x -= 2;
		y += Game.SPEED;
		
		
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, carWidth, carHeight);
		g.setColor(Color.black);
		g.drawRect(x, y, carWidth, carHeight);
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 32);
	}

	
	

}
