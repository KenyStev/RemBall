package kodomosoft.net.mygdxgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class InputDYAListener extends InputListener {
	
		Image btn;
		int num;

		public InputDYAListener(Image btn, int num) {
			this.btn = btn;
			this.num=num;
		}

		@Override
		public boolean touchDown(InputEvent e,float x, float y, int pointer, int button)
		{
			switch(this.num){
				case 1: System.out.println("TouchDown1!!" );						
						btn.setColor(Color.GRAY); return true;
				case 2: System.out.println("TouchDown2!!" );			
						btn.setColor(Color.GRAY); return true;					
				case 3: System.out.println("TouchDown3!!" );			
						btn.setColor(Color.GRAY); return true;				
				default: System.out.println("No Tocaste Nada!!" ); return false;
			}

			
		}

		@Override
		public void touchUp(InputEvent e,float x, float y, int pointer, int button)
		{
			btn.setColor(Color.WHITE);
			
		}
	}