import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	public static BufferedImage img;
	private int y;
	private int originalY;
	private int speed;
	
	public Background(int y, int speed) {
		try {
			img = ImageIO.read(getClass().getResource("/Background for frogger.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.y = -y;
		originalY = -y;
		this.speed = speed;
		
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return this.y;
	}
	public void tick() {
		y += speed;
		if(Math.abs(y) % Game.HEIGHT == 0) {
			y = originalY;
		}
	}
	public void render(Graphics g) {
		g.drawImage(img, 0, y, null);
		
	}
	

}
