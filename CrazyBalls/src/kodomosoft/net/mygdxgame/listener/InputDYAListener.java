package kodomosoft.net.mygdxgame.listener;

<<<<<<< HEAD
import javax.xml.bind.ParseConversionEvent;

import kodomosoft.net.mygdxgame.CrazyBallsMain;
import kodomosoft.net.mygdxgame.actor.RemsBallActor;
import kodomosoft.net.mygdxgame.screen.LevelScreen;
import kodomosoft.net.mygdxgame.screen.levels.PlayScreen;

import com.badlogic.gdx.Gdx;

=======
import kodomosoft.net.mygdxgame.CrazyBallsMain;
import kodomosoft.net.mygdxgame.actor.RemsBallActor;

import com.badlogic.gdx.Gdx;
>>>>>>> 033bf79e1c5746ec0ba0a533c76a6f1d8c905421
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
<<<<<<< HEAD
 * InputDYAListener es una Clase que aï¿½ade un listener a los botones del menu principal
=======
 * InputDYAListener es una Clase que añade un listener a los botones del menu principal
>>>>>>> 033bf79e1c5746ec0ba0a533c76a6f1d8c905421
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
<<<<<<< HEAD
	private int ballNumber;
	private Actor btn;
	private static int countRemoveBalls = 0;
	private static int rulesArray = 0;
	/**********************************/

	//Constructor cuando es una pelota
		public InputDYAListener(RemsBallActor ball, int slc, int _ballNumber,CrazyBallsMain game ) {
			this.ball = ball;
			this.selector=slc;	
			this.ballNumber = _ballNumber;
			this.game=game;
=======
	private Actor btn;
	/**********************************/

	//Constructor cuando es una pelota
		public InputDYAListener(RemsBallActor ball, int slc) {
			this.ball = ball;
			this.selector=slc;
>>>>>>> 033bf79e1c5746ec0ba0a533c76a6f1d8c905421
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
<<<<<<< HEAD
			if(selector!=-1 || selector == 4){
				this.btn.setColor(1f, 0f, 0f, 0.5f);
			}else{
				
				CrazyBallsMain.wavSound.play();
				ball.remove(); 
				InputDYAListener.countRemoveBalls++; //acumulo las pelotas que se van quitando 
				
				String comprension = LevelScreen.levelRules[(CrazyBallsMain.levelx - 1)];
				String amor[] = comprension.split(",");
				
				System.out.print(Integer.parseInt(amor[rulesArray]));
				System.out.print(rulesArray);
				System.out.print(selector);
				if(Integer.parseInt(amor[rulesArray]) == ballNumber)
				{				
					if(rulesArray == (amor.length - 1))
					{
						CrazyBallsMain.prefs.putBoolean("Level"+(CrazyBallsMain.levelx+1),true);
						CrazyBallsMain.prefs.flush();
						rulesArray = 0;
						game.setScreen(game.LEVELS); 				
					}						
					rulesArray++;
				}else
				{
					game.setScreen(new PlayScreen(game));
					rulesArray = 0;
				}
			}
			
=======
			if(selector!=-1){
				this.btn.setColor(1f, 0f, 0f, 0.5f);
			}else{
				this.ball.setColor(1f, 0f, 0f, 0.5f);
			}
>>>>>>> 033bf79e1c5746ec0ba0a533c76a6f1d8c905421
			return true;
		}

		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer,
				int button) {
			switch(selector){
<<<<<<< HEAD
		
			case 0: game.setScreen(game.LEVELS); break;
			case 1: game.setScreen(game.INSTRUCTIONS); break;
			//case 2: Gdx.app.exit(); break;
			case 3: game.setScreen(game.MENU); break;
			case 4: 
				game.setLevel(CrazyBallsMain.levelx);
				game.setScreen(new PlayScreen(game));
				break;
=======
			case -1: ball.remove(); break;
			case 0: game.setScreen(game.LEVELS); break;
			case 1: game.setScreen(game.INSTRUCTIONS); break;
			case 2: Gdx.app.exit(); break;
			case 3: game.setScreen(game.MENU); break;
>>>>>>> 033bf79e1c5746ec0ba0a533c76a6f1d8c905421
			}
			super.touchUp(event, x, y, pointer, button);
		}
		}