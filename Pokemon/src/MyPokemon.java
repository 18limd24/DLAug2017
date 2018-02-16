import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MyPokemon extends Pokemon{
	private float x = 100;
	private float y = 250;
	public MyPokemon( ID id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	public void render(Graphics g) {
		//just for dimensions right now
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, 128, 128);
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,128,128);
	}

}
