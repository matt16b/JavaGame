package main;

import main.entity.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

//It seems we don't need this.  We'll see about that later.
//import javax.swing.Timer;

public class ControlManager {
	
	//declaration of characters to watch for 
	private static char KEY_MOVE_NORTH = "W".charAt(0);
	private static char KEY_MOVE_SOUTH = "S".charAt(0);
	private static char KEY_MOVE_EAST = "D".charAt(0);
	private static char KEY_MOVE_WEST = "A".charAt(0);
	private static float smoothTickX = 0, smoothTickY = 0;
	private static boolean anyKeysPressed = false;
	static boolean[] keys = new boolean[525];
	static boolean[] keyPressed =  new boolean[keys.length];
	
	public static int shake_time = 0;
	
	public static int delta;
	
	public static Entity currentEntity;
		
	public static void init() {
		
	}
	
	public static void update(int newdelta) {
		delta = newdelta;
		
		updatePlayerCtrls();
	}
	
	public static int getDelta() {
		return delta;
	}

	/**
	 * Manually set mouse position
	 * @param nx - new pos x
	 * @param ny - new pos y
	 */
	
	
	/** @return Mouse x position */
	public static float getMouseX() {
		return Mouse.getX();
	}
	
	
	/** @return Mouse y position */
	public static float getMouseY() {
		return Mouse.getY();
	}
	
	/**
	 * Function fired regardless of keys pressed; keys are additively combined
	 */
	public static void updatePlayerCtrls() {
		//dx and dy are distance x and y respectively - these are sent to the player.
		float dx=0, dy=0;

		//Get keys pressed.
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			dy = dy - 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			dy = dy + 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			dx = dx + 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			dx = dx - 1;
		}

		//movement and movement speed controls.
		if(dx == 0 && smoothTickX > 0)
			smoothTickX-=0.2;
		else if(dx != 0 && smoothTickX<1)
			smoothTickX+=0.2;
		
		if(dy == 0 && smoothTickY > 0) 
			smoothTickY-=0.2;
		else if(dy != 0 && smoothTickY<1)
			smoothTickY+=0.2;
		
		//Reduce dx and dy by smoothing factors.
		dx *= smoothTickX;
		dy *= smoothTickY;
		
		//Reset smoothing if you're at a standstill.
		if(!anyKeysPressed) {
	//		playerMoveClk.stop();
			smoothTickX = 0;
			smoothTickY = 0;
		}
	//	DEBUG: System.out.println("Player asked to move by "+dx+", "+dy);
		
		//Slow the player down if diagonal
		if(dx != 0 && dy != 0) {
			dx *= 0.7;
			dy *= 0.7;
		}
		EntityManager.getPlayer().move(dx * EntityManager.getPlayer().getMoveSpeed() * delta, dy * EntityManager.getPlayer().getMoveSpeed() * delta);
	
	}
	
	
	
	/**
	 * Hack method for 0 and 9 for the fade function only
	 */
	public static void updateUtilKeys() {
		if(keys["0".charAt(0)]) 
			GraphicsManager.setFade(false);
		
		if(keys["9".charAt(0)])
			GraphicsManager.setFade(true);
	}
	
	
	/**
	 * Get key status of selected key char value, 0-500.
	 * @param kC - char value of key in question
	 * @return boolean key status: true is down, false is up
	 */
	public static boolean getKeyStatus(int kC) {
		return keys[kC];
	}
	
	
	
	public static void setKeyStatus(int kC, boolean newState) {
		keys[kC] = newState;
	}
	
	public static char getKeyN() {return KEY_MOVE_NORTH;}
	public static char getKeyS() {return KEY_MOVE_SOUTH;}
	public static char getKeyE() {return KEY_MOVE_EAST;}
	public static char getKeyW() {return KEY_MOVE_WEST;}
	
	/**
	 * Clamp a number i between high and low limits
	 * @param i - number to clamp
	 * @param high - upper limit
	 * @param low - lower limit
	 * @return clamped value
	 */
	public static double clamp(double i, double high, double low) {
		return Math.max(high, Math.min(i, low));
	}
	
	public static float clamp(float i, float high, float low) {
		return Math.max(high, Math.min(i, low));
	}
	
	public static int clamp(int i, int high, int low) {
		return Math.max(high, Math.min(i, low));
	}

	
	
	
}
