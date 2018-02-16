/********************************************
 * Written By: William Mckeever    			*
 * Date: 1/28/2018       					*
 * Class: KeyInput       					*
 *            								*
 * The class reads player inputs   			*
 ********************************************/

package DungeonCrawler1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	
	private Handler handler;
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	public static boolean stop = true;
	public static boolean pause = false;
	public static boolean dead = false;


	public static boolean upAim = true;
	public static boolean downAim = false;
	public static boolean leftAim = false;
	public static boolean rightAim = false;
	public int count = 0;



	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	/**
	 * Make action happen based of character movement
	 * @param e is a KeyEvent
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		//System.out.println(key);
		//introduce walking by including counter, everyfour switches picture

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ID.Player) {
				//Get movement direction////////////////////////////////////////////////////////
				if(key == KeyEvent.VK_Q) {
					count++;
					if (count % 2 ==0){
						pause = false;
					}
					else {
						pause = true;
					}
				}
				if(key == KeyEvent.VK_W) {
					tempObject.setSpeedY(-5);
					up = true;
					down = false;
					left = false; 
					right = false; 
					stop = false;

				}
				if(key == KeyEvent.VK_S) {
					tempObject.setSpeedY(5);
					up = false;
					down = true;
					left = false; 
					right = false; 
					stop = false;
				}
				if(key == KeyEvent.VK_D) {
					tempObject.setSpeedX(5);
					up = false;
					down = false;
					left = false; 
					right = true; 
					stop = false;
				}
				if(key == KeyEvent.VK_A) {
					tempObject.setSpeedX(-5);
					up = false;
					down = false;
					left = true; 
					right = false; 
					stop = false;
				}
				//Get aim direction////////////////////////////////////////////////////////////////
				if(key == KeyEvent.VK_UP) {

					upAim = true;
					downAim = false;
					leftAim = false; 
					rightAim = false; 

				}
				if(key == KeyEvent.VK_DOWN) {
					upAim = false;
					downAim = true;
					leftAim = false; 
					rightAim = false; 
				}
				if(key == KeyEvent.VK_RIGHT) {
					upAim = false;
					downAim = false;
					leftAim = false; 
					rightAim = true; 
				}
				if(key == KeyEvent.VK_LEFT) {
					upAim = false;
					downAim = false;
					leftAim = true; 
					rightAim = false; 
				}
				if(key == KeyEvent.VK_SPACE) {
					handler.addObject(new Fireball(tempObject.getX(),tempObject.getY(),ID.Attack));
				}
			}
		}

		if(key == KeyEvent.VK_ESCAPE) System.exit(1);

	}

	/**
	 * Make action happen based of character movement
	 * @param e is a KeyEvent
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getID() == ID.Player) {
				//Key events for player
				up = false;
				down = false;
				left = false; 
				right = false; 
				stop = true;
				dead = true;

				if(key == KeyEvent.VK_W) tempObject.setSpeedY(0);
				if(key == KeyEvent.VK_S) tempObject.setSpeedY(0);
				if(key == KeyEvent.VK_D) tempObject.setSpeedX(0);
				if(key == KeyEvent.VK_A) tempObject.setSpeedX(0);
			}
		}
	}
}

