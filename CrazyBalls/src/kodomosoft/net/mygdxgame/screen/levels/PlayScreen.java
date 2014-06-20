package kodomosoft.net.mygdxgame.screen.levels;

import kodomosoft.net.mygdxgame.CrazyBallsMain;
import kodomosoft.net.mygdxgame.actor.RemsBallActor;
import kodomosoft.net.mygdxgame.listener.InputDYAListener;
import kodomosoft.net.mygdxgame.screen.AbstractScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PlayScreen extends AbstractScreen {
	
	private Stage stage;
	private float 	x = 0,
					y = 0;
	private int cantidad = 0,
				contador = 0;
	

	public PlayScreen(CrazyBallsMain game) {
		super(game);
	}

	@Override
	public void show() {
		stage =  new Stage(400, 800, true, game.getSpriteBatch());
		Gdx.input.setInputProcessor(stage);
		
		//Crear Fondo
		Texture txt = CrazyBallsMain.MANAGER.get("background.png", Texture.class);
		txt.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion txtr = new TextureRegion(txt, 480, 800);
		Image img = new Image(txtr);
		stage.addActor(img);
		
		cantidad = game.getLevel()*5;
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		
		if(contador<cantidad){
			createBall();
			contador++;
		}
		
		stage.draw();
	}

//	private void createBall2() {
//		try{
//			x = ((0.03f * stage.getWidth() + 
//					0.07f * stage.getWidth() * (float) Math.random()));
//				
//			y = ((0.016f * stage.getHeight() + 
//					0.8f * stage.getHeight() * (float) Math.random()));
//			}catch(Exception e){
//				
//			}
//			RemsBallActor ball = new RemsBallActor(x, y);
//			ball.setVelocidad(-200, 200);
//			stage.addActor(ball);
//	}

	//Metodo para crea nuevas pelotas
	private void createBall(){
		
		try{
		x = ((0.01f * stage.getWidth() + 
				0.8f * stage.getWidth() * (float) Math.random()));
			
		y = ((0.01f * stage.getHeight() + 
				0.8f * stage.getHeight() * (float) Math.random()));
		}catch(Exception e){
			
		}
		if(y>stage.getHeight()-100){
			y -= 110;
		}else if(y<100){
			y += 110;
		}
		RemsBallActor ball = new RemsBallActor(x, y);
		ball.setVelocidad(-300, 300);
		stage.addActor(ball);
		ball.addListener(new InputDYAListener(ball, -1));
		
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
		super.dispose();
		stage.dispose();
	}

}
