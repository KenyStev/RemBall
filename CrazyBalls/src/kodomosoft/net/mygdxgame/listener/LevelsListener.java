package kodomosoft.net.mygdxgame.listener;

import kodomosoft.net.mygdxgame.CrazyBallsMain;
import kodomosoft.net.mygdxgame.actor.ButtonImage;
import kodomosoft.net.mygdxgame.screen.levels.PlayScreen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class LevelsListener extends InputListener {

	/*VARIABLES DE INSTANCIA*/
	private ButtonImage button;
	private CrazyBallsMain game;
	
	/*CONSTRUCTOR DEL LISTENER PARA LOS BOTONES DEL MENU DE NIVELES*/
	public LevelsListener(ButtonImage imgl1,int Level, CrazyBallsMain game) {
		this.button=imgl1;
		this.game=game;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		this.button.setColor(1f, 1f, 1f, 0.5f);
		
		return true;
		
	}

	@Override
	public void touchUp(InputEvent event, float x, float y, int pointer,
			int button) {
		game.setLevel(this.button.getLevel());
		game.setScreen(new PlayScreen(game));
		
	}

}
