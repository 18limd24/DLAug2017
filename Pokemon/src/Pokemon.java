import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pokemon extends GameObject{
	private float x = 400;
	private float y = 100;

	public Pokemon(ID id) {
		super(id);
		}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x,(int) y, 64, 64);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 64, 64);
	}

}
