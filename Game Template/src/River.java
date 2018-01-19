import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class River {
	private Random r;
	private Background b;
	private int y;
	private int originalY;
	private int gap = 30;
	private int height = 50;
	private Handler handler;
	private Log log;
	
	public River(Background b, Handler handler) {
		this.b = b;
		this.y = b.getY() - this.height - 10;
		this.originalY = this.y;
		this.handler = handler;
		log = new Log(Game.WIDTH, y + height - 40, ID.Log, handler);
	}
	public River(Background b,int y, Handler handler) {
		this.b = b;
		this.y = b.getY() - y - this.height - 10;
		this.originalY = this.y;
		this.handler = handler;
		log = new Log(Game.WIDTH, y + height - 40, ID.Log, handler);
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return this.y;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	public void tick() {
		this.y = b.getY() - this.height - 10;// - height/2;
		if(this.y == (Game.WIDTH % Game.SPEED) - height/2) {
			log = new Log(log.getX(), this.y + height - 40, ID.Log, handler);
			this.y = originalY;
		}
		log.tick();
		if(log.getX() == Game.WIDTH + log.getLogWidth()) {
			log.setX(0 - log.getLogWidth());
		}
		
	}
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, y, Game.WIDTH, height);//what do I set x to? not showing up
		g.setColor(Color.WHITE);
		g.drawRect(-1, y, Game.WIDTH + 2, height);
		log.render(g);
	}

}
