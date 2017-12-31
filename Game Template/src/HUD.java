import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD{
	private int score = 0;
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(16, 16, 100, 24);
		
		g.setColor(Color.BLUE);
		g.drawString("CROSSY ROAD", 16, 32);
		
		g.setColor(Color.WHITE);
		g.drawString("SCORE: " + score, 16, 56);
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}

}
