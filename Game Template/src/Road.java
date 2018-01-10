import java.awt.Color;
import java.awt.Graphics;

public class Road {
	private Background b;
	private int y;
	private int gap = 30;
	private int height = 50;
	private Handler handler;
	private Car car;
	
	public Road(Background b, Handler handler) {
		this.b = b;
		this.y = b.getY();
		this.handler = handler;
		car = new Car(Game.WIDTH, y + height - 40, ID.Car, handler);
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return this.y;
	}
	public void tick() {
		this.y = b.getY();// - height/2;
		if(this.y == (Game.WIDTH % Game.SPEED) - height/2) {
			car = new Car(Game.WIDTH, this.y + height - 40, ID.Car, handler);
		}
		car.tick();
		if(car.getX() == 0 - car.getCarWidth()) {
			car.setX(Game.WIDTH);
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, y, Game.WIDTH, height);//what do I set x to? not showing up
		g.setColor(Color.WHITE);
		g.drawRect(-1, y, Game.WIDTH + 2, height);
		g.setColor(Color.yellow);
		for(int i = 0; i < Game.WIDTH; i += gap + 30) {
			g.fillRect(i, y + 20, 30, 10);
		}
		car.render(g);
	}

}
