import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Menu extends MouseAdapter{
	private Game game;
	private Handler handler;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx =  e.getX();
		int my = e.getY();
		if (game.gameState == STATE.Menu) {
			if (mouseOver(mx, my, Game.WIDTH / 2 - 100, 150, 200, 64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));// initialized
																												// at
																												// center
				handler.addObject(new Enemy1(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Enemy1, handler));
			}
			if (mouseOver(mx, my, Game.WIDTH / 2 - 100, 250, 200, 64)) {
				game.gameState = STATE.Help;
			}
			if (mouseOver(mx, my, Game.WIDTH / 2 - 100, 350, 200, 64)) {
				System.exit(1);
			}
		}else if(game.gameState == STATE.Help) {
			if(mouseOver(mx,my,25, 25, 150, 64)) {
				game.gameState = STATE.Menu;
			}
		}
	}
	public void mouseReleased(MouseEvent e) {
		
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
		Font fnt = new Font("arial", 1, 50);
		if (game.gameState == STATE.Menu) {
			
			g.setColor(Color.WHITE);
			g.setFont(fnt);
			g.drawString("MENU", Game.WIDTH / 2 - 80, 100);
			// play button
			g.drawRect(Game.WIDTH / 2 - 100, 150, 200, 64);
			g.drawString("Play", (Game.WIDTH / 2 - 100) + 50, 200);
			// help button
			g.drawRect(Game.WIDTH / 2 - 100, 250, 200, 64);
			g.drawString("Help", (Game.WIDTH / 2 - 100) + 50, 300);
			// quit button
			g.drawRect(Game.WIDTH / 2 - 100, 350, 200, 64);
			g.drawString("Quit", (Game.WIDTH / 2 - 100) + 50, 400);
		}
		if(game.gameState == STATE.Help) {
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("HELP", Game.WIDTH/2 - 80,  100);
			//back button
			g.drawRect(25, 25, 150, 64);
			g.drawString("BACK", 30, 72);
			
			Font fnt2 = new Font("arial", 1, 20);
			g.setFont(fnt2);
			g.drawString("To play this game, use WASD to move and avoid enemies.", 15, 200);
			g.drawString("Collect yellow speedups to be fasterHit escape to quit game", 15, 230);
			
		}
	}

}
