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
		car = new Car(Game.WIDTH, y - 40, ID.Car, handler);
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return this.y;
	}
	public void tick() {
		this.y = b.getY() - height;
		car.tick();
		if(car.getX() == 0 - car.carWidth) {
			car.setX(Game.WIDTH);
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, y, Game.WIDTH, height);//what do I set x to? not showing up
		g.setColor(Color.WHITE);
		g.drawRect(0, y, Game.WIDTH, height);
		g.setColor(Color.yellow);
		for(int i = 0; i < Game.WIDTH; i += gap + 30) {
			g.fillRect(i, y + 20, 30, 10);
		}
		car.render(g);
	}

}
