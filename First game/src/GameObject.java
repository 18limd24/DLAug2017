import java.awt.Graphics;
import java.awt.Rectangle;

//This will be class for all objects(like enemies and players)
public abstract class GameObject {
	
	protected float x, y; //position
	protected ID id;
	protected float speedX, speedY;
	protected Handler handler;
	protected int speedUps = 0;
	
	//Constructor
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	//tick method to update 
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return this.y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public ID getID() {
		return this.id;
	}
	public void setID(ID id) {
		this.id = id;
	}
	public float getSpeedX() {
		return this.speedX;
	}
	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}
	public float getSpeedY() {
		return this.speedY;
	}
	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	public int getSpeedUps() {
		return speedUps;
	}
	public void setSpeedUps(int speedUps) {
		this.speedUps = speedUps;
	}
//that should be it for gameObject
}
