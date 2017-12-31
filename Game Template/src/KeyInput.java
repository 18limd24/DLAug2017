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
				/*if(key ==  KeyEvent.VK_W) tempObject.setY(tempObject.getY() - 32);//can do one line
				if(key ==  KeyEvent.VK_S) tempObject.setY(tempObject.getY() + 32);
				if(key ==  KeyEvent.VK_A) tempObject.setX(tempObject.getX() -32);
				if(key ==  KeyEvent.VK_D) tempObject.setX(tempObject.getX() + 32);
			*/}
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < this.handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);//finds the object and gives it name

			if (tempObject.getId() == ID.Player) {// looks at id
				if(key ==  KeyEvent.VK_W) tempObject.setY(tempObject.getY() - 32);//can do one line
				if(key ==  KeyEvent.VK_S) tempObject.setY(tempObject.getY() + 32);
				if(key ==  KeyEvent.VK_A) tempObject.setX(tempObject.getX() -32);
				if(key ==  KeyEvent.VK_D) tempObject.setX(tempObject.getX() + 32);
			}
		}
	}
	public void keyTyped(KeyEvent e) {
		char keyC = e.getKeyChar();
		/*for(int i = 0; i < this.handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);//finds the object and gives it name

			if (tempObject.getId() == ID.Player) {// looks at id
				if(keyC ==  'w') tempObject.setY(tempObject.getY() - 32);//can do one line
				if(keyC ==  's') tempObject.setY(tempObject.getY() + 32);
				if(keyC ==  'a') tempObject.setX(tempObject.getX() -32);
				if(keyC ==  'd') tempObject.setX(tempObject.getX() + 32);
			}
		}*/
	}

}
