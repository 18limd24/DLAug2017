import java.awt.Color;
import java.awt.Graphics;

//this is heads up display
public class HUD {
	
	public static int health = 100;
	
	
	public void tick() {
		
		health = Game.clamp(health, 100, 0);//don't forget to set equal to health
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(16, 16, 200, 16);//total health
		g.setColor(Color.green);
		g.fillRect(16, 16, health * 2, 16);//displays health
		g.setColor(Color.white);
		g.drawRect(16, 16, 200, 16);//outline
	}

}
