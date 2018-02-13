import java.awt.Color;
import java.awt.Graphics;

public class Menu {
	public Menu() {
		
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 350, 639, 180);
		g.fillRect(400,250,239,127);
		g.setColor(Color.WHITE);
		g.drawRect(0, 350, 639, 180);
		g.drawRect(400,250,239,127);
	}

}
