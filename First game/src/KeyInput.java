import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//This will allow users to play using the keys as controls
public class KeyInput extends KeyAdapter{
	
	private Handler handler = new Handler();
	
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < this.handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);//finds the object and gives it name
			
			if(tempObject.getID() == ID.Player) {//looks at id
				if(key ==  KeyEvent.VK_W) tempObject.setSpeedY(-5);//can do one line
				if(key ==  KeyEvent.VK_S) tempObject.setSpeedY(5);
				if(key ==  KeyEvent.VK_A) tempObject.setSpeedX(-5);
				if(key ==  KeyEvent.VK_D) tempObject.setSpeedX(5);
			}
			if(tempObject.getID() == ID.Player2) {//looks at id
				if(key ==  KeyEvent.VK_UP) tempObject.setSpeedY(-5);//can do one line
				if(key ==  KeyEvent.VK_DOWN) tempObject.setSpeedY(5);
				if(key ==  KeyEvent.VK_LEFT) tempObject.setSpeedX(-5);
				if(key ==  KeyEvent.VK_RIGHT) tempObject.setSpeedX(5);
			}
			if(tempObject.getID() == ID.Enemy) {
				if(key == KeyEvent.VK_SPACE) tempObject.setSpeedY(3);
				if(key == KeyEvent.VK_B) tempObject.setSpeedY(-3);
				if(key == KeyEvent.VK_N) tempObject.setSpeedX(3);
				if(key == KeyEvent.VK_V) tempObject.setSpeedX(-3);
			}
		}
		
	}
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < this.handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);//finds the object and gives it name
			
			if(tempObject.getID() == ID.Player) {//looks at id
				if(key ==  KeyEvent.VK_W) tempObject.setSpeedY(0);//can do one line
				if(key ==  KeyEvent.VK_S) tempObject.setSpeedY(0);
				if(key ==  KeyEvent.VK_A) tempObject.setSpeedX(0);
				if(key ==  KeyEvent.VK_D) tempObject.setSpeedX(0);
			}
			if(tempObject.getID() == ID.Player2) {//looks at id
				if(key ==  KeyEvent.VK_UP) tempObject.setSpeedY(0);//can do one line
				if(key ==  KeyEvent.VK_DOWN) tempObject.setSpeedY(0);
				if(key ==  KeyEvent.VK_LEFT) tempObject.setSpeedX(0);
				if(key ==  KeyEvent.VK_RIGHT) tempObject.setSpeedX(0);
			}
			if(tempObject.getID() == ID.Enemy) {
				if(key == KeyEvent.VK_SPACE) tempObject.setSpeedY(0);
				if(key == KeyEvent.VK_B) tempObject.setSpeedY(0);
				if(key == KeyEvent.VK_N) tempObject.setSpeedX(0);
				if(key == KeyEvent.VK_V) tempObject.setSpeedX(0);
			}
		}
	}

}
