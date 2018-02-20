import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	//for each pokemon
	private MyPokemon myPokemon;//for their levels, names, and health
	private EnemyPokemon enemyPokemon;
	public HUD(MyPokemon myPokemon, EnemyPokemon enemyPokemon) {
		this.myPokemon = myPokemon;
		this.enemyPokemon = enemyPokemon;
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		//myPokemon
		g.setColor(Color.WHITE);
		g.fillRect(370, 321, 175, 120);
	}

}
