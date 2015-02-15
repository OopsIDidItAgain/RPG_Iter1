package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.AvatarCreationGameState;
import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.PlayGameState;
import com.oopsididitagain.gui.View;
import com.oopsididitagain.io.KeyboardInput;

public class GameLoop {

	private static GameLoop instance;

	private static GameState state;
	private static Controller controller;
	private KeyboardInput keyboardInput;
	private static View view;

	private GameLoop() {
		state = AvatarCreationGameState.getInstance();
		this.keyboardInput = new KeyboardInput();
		view = new View();
		view.addKeyListener(keyboardInput);
		view.requestFocus();
	}

	public static GameLoop getInstance() {
		if (instance == null) {
			instance = new GameLoop();
		}
		return instance;
	}

	public void playGame() {
		  double nextTime = (double)System.nanoTime() / 1000000000.0;
	      double maxTimeDiff = 0.5;
	      int skippedFrames = 1;
	      int maxSkippedFrames = 5;
	      double delta = .005;
		while (!state.equals(ExitGameState.getInstance())) {
			double currTime = (double)System.nanoTime() / 1000000000.0;
			 if((currTime - nextTime) > maxTimeDiff) nextTime = currTime;
	            if(currTime >= nextTime)
	            {
	                // assign the time for the next update
	                nextTime += delta;
	                controller = state.getController();
	    			int command = keyboardInput.getInput();
	    			state = controller.handleInputAndUpdate(state, command);
	                if((currTime < nextTime) || (skippedFrames > maxSkippedFrames))
	                {
	                	
	                	view.render(state);
	                    skippedFrames = 1;
	                }
	                else
	                {
	                    skippedFrames++;
	                }
	            }else{
	                // calculate the time to sleep
	                int sleepTime = (int)(1000.0 * (nextTime - currTime));
	                // sanity check
	                if(sleepTime > 0)
	                {
	                    // sleep until the next update
	                    try
	                    {
	                        Thread.sleep(sleepTime);
	                    }
	                    catch(InterruptedException e)
	                    {
	                        // do nothing
	                    }
	                }
	            }
	        }
			
		}
	
	public void setView(View view) {
		GameLoop.view = view;
	}

	public View getView() {
		return view;
	}
}
