import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter{
	private Game game;
	private Handler handler;
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx, my, 400, 351, 233/2, 99/2)) {//first box(top left)
			
		}
		if(mouseOver(mx, my, 400 + 233/2, 351, 233/2, 99/2)) {//top right
			
		}
		if(mouseOver(mx, my, 400, 351 + 99/2, 233/2, 99/2)) {//bottom left
			
		}
		if(mouseOver(mx, my, 400 + 233/2, 351 + 99/2, 233/2, 99/2)) {//bottom right
			
		}
		
	}
	public boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 350, 639, 180);//words
		g.fillRect(400,351,233,99);//whole rect
		
		g.setColor(Color.WHITE);
		g.drawRect(0, 350, 639, 180);
		g.drawRect(400,351,233,99);
		
		//need to divide into 4 rectangles for the choices.
		g.setColor(Color.blue);//temp, will be black later
		g.drawRect(400, 351, 233/2, 99/2);
		g.drawRect(400 + 233/2, 351 + 99/2, 233/2, 99/2);
	}

}
