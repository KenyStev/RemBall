package kodomosoft.net.mygdxgame.screen;

import kodomosoft.net.mygdxgame.CrazyBallsMain;
import kodomosoft.net.mygdxgame.actor.ButtonImage;
import kodomosoft.net.mygdxgame.listener.InputDYAListener;
import kodomosoft.net.mygdxgame.listener.LevelsListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class LevelScreen extends AbstractScreen {
	
	/*****VARIABLES DE INSTANCIA*****/
	private Stage stage;
	private Image backButton;
	private int he = 0, ii = 0;
	private ButtonImage imgl1;
	private Image fondoLevels;
	/********************************/

	/*CONSTRUCTOR DE LA PANTALLA DE NIVELES*/
	public LevelScreen(CrazyBallsMain game) {
		super(game);
	}

	@Override
	public void show() {
		//Inicializamos el Stage
		stage =  new Stage(400, 800, true, game.getSpriteBatch());
		Gdx.input.setInputProcessor(stage);
		
		
		//Crear Fondo
		Texture txt = CrazyBallsMain.MANAGER.get("levels.png", Texture.class);
		txt.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion txtr = new TextureRegion(txt, 480, 800);
		fondoLevels = new Image(txtr);
		stage.addActor(fondoLevels);
		
		int level = 1;
		for (int i = 0; i < 12; i++) {
			
			int wi = ii * 105;
			
			Texture l1t = CrazyBallsMain.MANAGER.get("l"+(i+1)+".png", Texture.class);
			l1t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
			TextureRegion l1t1 = new TextureRegion(l1t, 100, 70);
			
			if(wi == 315){
				he += 83;
				wi = 0;
				ii = 0;
			}

			imgl1 = new ButtonImage(l1t1, level);
			imgl1.setPosition(80 + wi, 450 - he);
			imgl1.addListener(new LevelsListener(imgl1, level, game));
			stage.addActor(imgl1);
			level++;
			ii++;
		}
		he=0; ii=0;

		Texture bck = CrazyBallsMain.MANAGER.get("backButton.png", Texture.class);
		bck.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion bck1 = new TextureRegion(bck, 80, 54);
		backButton = new Image(bck1);
		backButton.addListener(new InputDYAListener(backButton, game, 3));
		backButton.setPosition(50, 80);
		stage.addActor(backButton);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
			
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(400, 800, true);
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void dispose() {
		stage.dispose();
	}
	
//	ButtonImage getLevelButton(int level)
//	{
//		ButtonImage button = new ButtonImage(level);
//		button.addListener(new LevelsListener(button, level, game));
//		return button;
//	}

}
