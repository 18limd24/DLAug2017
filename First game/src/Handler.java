import java.awt.Graphics;
import java.util.LinkedList;

//This will maintain update and render objects.
//need to create a list of game objects
/*A linked list is a linear data structure where each element is a separate object.
 *  Each element (we will call it a node) of a list is comprising of two items
 *   - the data and a reference to the next node.
 *  The last node has a reference to null.
 *  The entry point into a linked list is called the head of the list.
 * 
 */
public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		for(int i = 0; i< object.size(); i++) {
			GameObject tempObject = object.get(i);
			//same object, new reference
			
			tempObject.tick();//run through all objects and update them
			
		}
	}
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {//if you want to add another object
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
//if you want to remove
	
}

