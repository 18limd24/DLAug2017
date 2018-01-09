import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3412493141571965197L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	private Random r;
	private String title;
	
	private Handler handler;
	private HUD hud;
	public static int SPEED = 1;
	private static Background background1 = new Background(0, SPEED);
	private static Background background2 = new Background(HEIGHT, SPEED);
	
	private Road road = new Road(background1, handler);
	
	public Game() {
		handler = new Handler();
		
		title = "Frogger/Crossy Road";
		
		hud = new HUD();
		
		
		handler.addObject(new Player(WIDTH/2 -32, HEIGHT - 60, ID.Player, handler));
		handler.addObject(new Car(WIDTH, HEIGHT - 310, ID.Car, handler));
		
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, title, this);
	}


	public void run() {
		this.requestFocus();
		//game loop
		long lastTime = System.nanoTime();//returns time in nanoseconds
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();//returns time in milliseconds
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	
	public void tick() {
		handler.tick();
		hud.tick();
		background1.tick();
		background2.tick();
		road.tick();
		/*for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player) {
				if(tempObject.getY() == HEIGHT - 60) {
					stop();
				}
			}
		}*/
	}
	
	public static int clamp(int var, int max, int min) {
		if(var >= max) {
			return var = max;
		}else if (var <= min) {
			return var = min;
		}else {
			return var;
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		background1.render(g);
		background2.render(g);
		
		road.render(g);
		
		handler.render(g);
		hud.render(g);

		
		g.dispose();
		bs.show();
	}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Game();
	}

}
