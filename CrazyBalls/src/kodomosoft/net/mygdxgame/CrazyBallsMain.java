package kodomosoft.net.mygdxgame;

import kodomosoft.net.mygdxgame.screen.AbstractScreen;
import kodomosoft.net.mygdxgame.screen.Instructions;
import kodomosoft.net.mygdxgame.screen.LevelScreen;
import kodomosoft.net.mygdxgame.screen.MainScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Esta es la clase Principal o el Game;
 * de aqui e de donde tomamos todo lo necesario para nustro juego
 * */

public class CrazyBallsMain extends Game {
	
	/****************VARIABLES DE INSTANCIA****************/
	public static AssetManager MANAGER = new AssetManager();
	private SpriteBatch batch;
	public final AbstractScreen LEVELS, MENU, INSTRUCTIONS;
	private int Level=0;
	/******************************************************/
	
	/*CONSTRUCTOR DE LA CLASE PRINCIPAL (EL GAME)*/
	public CrazyBallsMain() {
		LEVELS = new LevelScreen(this);
		MENU = new MainScreen(this);
		INSTRUCTIONS = new Instructions(this);
	}
	
	@Override
	public void create() {
		
		//Iniciamos nuestro Spritebatch, el que 
		//vamos a usar en todo nuestro juego
		batch = new SpriteBatch();
		
		//Cargamos todos los recursos que nesesitaremos en el juego a nuestro AssetManager
		MANAGER.load("btnPlay.png", Texture.class);
		MANAGER.load("face1.png", Texture.class);
		MANAGER.load("backButton.png", Texture.class);
		MANAGER.load("background.png", Texture.class);
		MANAGER.load("btnExit.png", Texture.class);
		MANAGER.load("btnOptions.png", Texture.class);
		MANAGER.load("levels.png", Texture.class);
		MANAGER.load("instructions.png", Texture.class);
		MANAGER.load("l1.png", Texture.class);
		MANAGER.load("l2.png", Texture.class);
		MANAGER.load("l3.png", Texture.class);
		MANAGER.load("l4.png", Texture.class);
		MANAGER.load("l5.png", Texture.class);
		MANAGER.load("l6.png", Texture.class);
		MANAGER.load("l7.png", Texture.class);
		MANAGER.load("l8.png", Texture.class);
		MANAGER.load("l9.png", Texture.class);
		MANAGER.load("l10.png", Texture.class);
		MANAGER.load("l11.png", Texture.class);
		MANAGER.load("l12.png", Texture.class);
		
		
		
		while(!MANAGER.update()){
			//Todo lo que sea
		}
		
		setScreen(MENU);
				
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		MANAGER.dispose();
	}
	
	/**
	 * Instancia el ivel Seleccionado por el Usuario segun el Boton Tocado
	 * @this.Level=Level;
	 * */
	public void setLevel(int Level){
		this.Level=Level;
	}
	
	/**
	 * Recupera el Nivel en el Que se encuentra el Juego, 
	 * para poder setear las reglas necesarias de cada nivel
	 * y asi saber en que nivel estamos
	 * @return Level;
	 * */
	public int getLevel(){
		return Level;
	}
	
	public int getBallLevel(){
		int balls;
			balls = this.Level*5;
		return balls;
	}
	
	/**
	 * Recupera la instancia compartida de SpriteBatch
	 * @return SpriteBatch en uso por el juego
	 */
	public SpriteBatch getSpriteBatch(){
		return this.batch;
	}
	
//	public void onBackPressed(){
//	     // do something here and don't write super.onBackPressed()
//	}
}
