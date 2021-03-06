import java.awt.Color;
import java.awt.Graphics;

//this is heads up display
public class HUD {
	
	public static float health = 100;
	private int greenValue = 255;
	private int score = 0;
	private int level = 1;
	
	
	public void tick() {
		
		health = Game.clamp(health, 100, 0);//don't forget to set equal to health
		
		greenValue = (int)Game.clamp(greenValue, 255, 0);
		greenValue = (int)health *2;
		if(health > 0) {
			score++;
		}
		
		
	}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(16, 16, 200, 16);//total health
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(16, 16, (int)(health * 2), 16);//displays health
		g.setColor(Color.white);
		g.drawRect(16, 16, 200, 16);//outline
		
		g.setColor(Color.white);
		g.drawString("SCORE: " + score, 16, 48);
		g.drawString("LEVEL: " + level, 16, 64);
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	public void reset() {
		health = 100;
		this.score = 0;
		this.level = 1;
	}

}
