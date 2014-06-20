package kodomosoft.net.mygdxgame.listener;

import kodomosoft.net.mygdxgame.CrazyBallsMain;
import kodomosoft.net.mygdxgame.actor.RemsBallActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * InputDYAListener es una Clase que añade un listener a los botones del menu principal
 * o a las pelotipas del Juego, segun sea el indice; siendo:
 * -1: el listener para las pelotitas (las Destrulle)
 * 0: Cambia a la Screen de Niveles
 * 1: Cambia a la Screen de Instrucciones (INSTRUCTIONS)
 * 2: Sale de la Aplicacion (Boton Exit)
 * 3: Cambia a la Screen del Menu Principal (MENU)
 * */

public class InputDYAListener extends InputListener {
	
	/******VARIABLES DE INSTANCIA******/
	private CrazyBallsMain game;
	private int selector; 
	private RemsBallActor ball;
	private Actor btn;
	/**********************************/

	//Constructor cuando es una pelota
		public InputDYAListener(RemsBallActor ball, int slc) {
			this.ball = ball;
			this.selector=slc;
		}
		
	//Constructor Cuando es un Boton del Menu Principal (Actor)
		public InputDYAListener(Actor btn,CrazyBallsMain game , int slc) {
			this.btn=btn;
			this.game=game;
			this.selector=slc;
		}

		@Override
		public boolean touchDown(InputEvent e,float x, float y, int pointer, int button)
		{
			if(selector!=-1){
				this.btn.setColor(1f, 0f, 0f, 0.5f);
			}else{
				this.ball.setColor(1f, 0f, 0f, 0.5f);
			}
			return true;
		}

		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer,
				int button) {
			switch(selector){
			case -1: ball.remove(); break;
			case 0: game.setScreen(game.LEVELS); break;
			case 1: game.setScreen(game.INSTRUCTIONS); break;
			case 2: Gdx.app.exit(); break;
			case 3: game.setScreen(game.MENU); break;
			}
			super.touchUp(event, x, y, pointer, button);
		}
		}