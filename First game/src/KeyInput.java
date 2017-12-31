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
				if(key ==  KeyEvent.VK_W) tempObject.setSpeedY(-5 - tempObject.speedUps);//can do one line
				if(key ==  KeyEvent.VK_S) tempObject.setSpeedY(5 + tempObject.speedUps);
				if(key ==  KeyEvent.VK_A) tempObject.setSpeedX(-5 - tempObject.speedUps);
				if(key ==  KeyEvent.VK_D) tempObject.setSpeedX(5 + tempObject.speedUps);
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
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
		}
	}

}
