import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//This will allow users to play using the keys as controls
public class KeyInput extends KeyAdapter{
	
	private Handler handler = new Handler();
	private boolean[] keyDown = {false, false, false, false};
	
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < this.handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);//finds the object and gives it name
			
			if(tempObject.getID() == ID.Player) {//looks at id
				if(key ==  KeyEvent.VK_W) {tempObject.setSpeedY(-5 - tempObject.speedUps);keyDown[0] = true;}
				if(key ==  KeyEvent.VK_S) {tempObject.setSpeedY(5 + tempObject.speedUps);keyDown[1] = true;}
				if(key ==  KeyEvent.VK_A) {tempObject.setSpeedX(-5 - tempObject.speedUps);keyDown[2] = true;}
				if(key ==  KeyEvent.VK_D) {tempObject.setSpeedX(5 + tempObject.speedUps);keyDown[3] = true;}
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < this.handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);//finds the object and gives it name
			
			if(tempObject.getID() == ID.Player) {//looks at id
				if(key ==  KeyEvent.VK_W) keyDown[0] = false;//can do one line
				if(key ==  KeyEvent.VK_S) keyDown[1] = false;
				if(key ==  KeyEvent.VK_A) keyDown[2] = false;
				if(key ==  KeyEvent.VK_D) keyDown[3] = false;
				
				if(!keyDown[0] && !keyDown[1]) tempObject.setSpeedY(0);
				if(!keyDown[2] && !keyDown[3]) tempObject.setSpeedX(0);
			}
		}
	}

}
