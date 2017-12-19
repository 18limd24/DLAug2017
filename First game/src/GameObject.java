import java.awt.Graphics;

//This will be class for all objects(like enemies and players)
public abstract class GameObject {
	
	protected int x, y; //position
	protected ID id;
	protected int speedX, speedY;
	
	//Constructor
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	//tick method to update 
	public abstract void tick();
	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ID getID() {
		return this.id;
	}
	public void setID(ID id) {
		this.id = id;
	}
	public int getSpeedX() {
		return this.speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public int getSpeedY() {
		return this.speedY;
	}
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
//that should be it for gameObject
}