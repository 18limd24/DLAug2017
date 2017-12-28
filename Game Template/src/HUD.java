import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD{
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(16, 16, 100, 32);
		
		g.setColor(Color.BLUE);
		g.drawLine(16, 16, 116, 16);
		g.setFont(Font.getFont("a"));
		g.drawString("CROSSY ROAD", 16, 32);
		
		
	}

}
