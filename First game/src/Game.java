/*Darren Lim
 * Attempt at my first game
 * December 13, 2017
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
//Canvas is the blank rectangular area to be painted over
//and to trap inputs

public class Game extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2152036918910598259L;

	private Thread thread;
	//java.lang.Thread class is a thread of execution in a program.
	//The Java Virtual Machine allows an application to have 
	//multiple threads of execution running concurrently.
	private boolean running = false;
	
	private Random r;//random
	private Handler handler;
	
	private HUD hud;
	
	public Game() {
		handler = new Handler();
		//should create handler before window
		
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Let's Build A Game!!", this);
		/* synchronized is all about different threads reading and writing
		*to the same variables, objects and resources
		*/
		
		
		
		r = new Random();
		//should initialize in constructors 
		
		handler.addObject(new Player(WIDTH/2 -32, HEIGHT/2 -32, ID.Player, handler));//initialized at center
		handler.addObject(new Enemy1(0, 0, ID.Enemy1, handler));//initialized at center
		//takes the handler and adds an object at that position and that is constructed

		hud = new HUD();
	}
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	//set the dimensions and proportions
	//final keyword stops the value from being changed
	
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;	
	}
	
	public synchronized void stop() {
		try {
			thread.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
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
	private void tick() {
		handler.tick();
		hud.tick();
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		hud.render(g);
		
		g.dispose();
		bs.show();
		
		
	}
	public static int clamp(int var, int max, int min) {//if we see var go past max, return max, 
														//so it never can, same w min
		if(var >= max) {
			return var = max;
		}else if (var <= min) {
			return var = min;
		}else {
			return var;
		}
	}
	
	public static void main(String[] args) {
		new Game();
	}

}
