import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Log extends GameObject{
	private Random r = new Random();
	private int logWidth = 64;
	public int getLogWidth() {
		return logWidth;
	}

	public void setLogWidth(int logWidth) {
		this.logWidth = logWidth;
	}

	public int getLogHeight() {
		return logHeight;
	}

	public void setLogHeight(int logHeight) {
		this.logHeight = logHeight;
	}
	private int logHeight = 32;
	public Log(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
	}

	public void tick() {
		x += 2;
		y += Game.SPEED;
		
		
	}

	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(x, y, logWidth, logHeight);
		g.setColor(Color.black);
		g.drawRect(x, y, logWidth, logHeight);
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 32);
	}

	
	

}
