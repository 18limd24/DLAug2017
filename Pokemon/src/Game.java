import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7036362696370216189L;
	private Thread thread;
	private boolean running = false;
	public static final int WIDTH = 640, HEIGHT = 480;
	private Handler handler;
	private Menu menu;
	public STATE gameState = STATE.Menu;
	public Game() {
		handler = new Handler();
		new Window(WIDTH, HEIGHT, "POKEMON (Showdown)", this);
		menu = new Menu(this, handler);
		handler.addObject(new MyPokemon(ID.Pikachu));
		handler.addObject(new EnemyPokemon(ID.Squirtle));
	}
	public void tick() {
		handler.tick();
		if(gameState == STATE.Menu) menu.tick();
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		handler.render(g);
		if(gameState == STATE.Menu) menu.render(g);
		
		g.dispose();
		bs.show();
	}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;	
	}
	public synchronized void stop() {
		try {
			thread.join();
		}catch(Exception e){
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

	public static float clamp(float var, float max, float min) {// if we see var go past max, return max,
		// so it never can, same w min
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else {
			return var;
		}
	}
	public static void main(String[] args) {
		new Game();
	}

}
