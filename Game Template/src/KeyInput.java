import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < this.handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);//finds the object and gives it name

			if (tempObject.getId() == ID.Player) {// looks at id
				
			}
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < this.handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);//finds the object and gives it name

			if (tempObject.getId() == ID.Player) {// looks at id
				if(key ==  KeyEvent.VK_W) tempObject.setY(tempObject.getY() - Game.HEIGHT/(Game.HEIGHT/50));//can do one line
				if(key ==  KeyEvent.VK_S) tempObject.setY(tempObject.getY() + Game.HEIGHT/(Game.HEIGHT/50));
				if(key ==  KeyEvent.VK_A) tempObject.setX(tempObject.getX() - Game.HEIGHT/(Game.HEIGHT/50));
				if(key ==  KeyEvent.VK_D) tempObject.setX(tempObject.getX() + Game.HEIGHT/(Game.HEIGHT/50));
			}
		}
	}
	public void keyTyped(KeyEvent e) {
		char keyC = e.getKeyChar();
	}

}
