import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	private int scoreKeep;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep ++;
		
		if(scoreKeep >= 200) {
			scoreKeep = 0;
			this.hud.setLevel(this.hud.getLevel() + 1);
			if(hud.getLevel() == 2)
				handler.addObject(new Enemy1(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.Enemy1, handler));
			else if(hud.getLevel() == 3) {
				handler.addObject(new Enemy1(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.Enemy1, handler));
				handler.addObject(new Enemy1(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.Enemy1, handler));
				handler.addObject(new FastVerticalEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.Enemy1, handler));
				handler.addObject(new SpeedUp(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SpeedUp, handler));

			}else if(hud.getLevel() % 2 == 0) {
				handler.addObject(new Enemy1(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.Enemy1, handler));
			}
			if(hud.getLevel() % 5 == 0) {
				handler.addObject(new FastHorizontalEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.Enemy1, handler));
				handler.addObject(new FastVerticalEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.Enemy1, handler));
				handler.addObject(new SpeedUp(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SpeedUp, handler));


			}

		}
	}

}
