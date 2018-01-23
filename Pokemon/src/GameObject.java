import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected float x;
	protected float y;
	protected ID id;
	protected Handler handler;
	
	public GameObject( ID id) {
		this.id = id;
	}
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

}
