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
	private Spawn spawn;
	private Menu menu;
	
	public STATE gameState = STATE.End;
	
	public Game() {
		handler = new Handler();
		//should create handler before window
		hud = new HUD();
		menu = new Menu(this, handler, hud);
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "Let's Build A Game!!", this);
		/* synchronized is all about different threads reading and writing
		*to the same variables, objects and resources
		*/
		
		spawn = new Spawn(handler, hud);
		
		
		
		r = new Random();
		//should initialize in constructors 
		if(gameState ==  STATE.Game) {
			handler.addObject(new Player(WIDTH/2 -32, HEIGHT/2 -32, ID.Player, handler));//initialized at center
			handler.addObject(new Enemy1(r.nextInt(WIDTH),r.nextInt(HEIGHT), ID.Enemy1, handler));
			handler.addObject(new SmartEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT), ID.SmartEnemy, handler));
		}
		//takes the handler and adds an object at that position and that is constructed

		
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
		if(gameState == STATE.Game) {
			hud.tick();
			spawn.tick();
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End) {
			menu.tick();
		}
		
		if(hud.health == 0) {
			for(int i = 0; i< handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getID() == ID.Player) {
					handler.removeObject(tempObject);
				}
			}
			gameState = STATE.End;
		}
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
		
		if(gameState == STATE.Game) {
			hud.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End) {
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
		
		
	}
	public static float clamp(float var, float max, float min) {//if we see var go past max, return max, 
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
