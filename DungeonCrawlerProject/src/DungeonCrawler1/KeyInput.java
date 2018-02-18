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
<<<<<<< HEAD
	
	public int count = 0;
	
	public static boolean dead = false;
=======
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
	public static boolean space = false;


>>>>>>> refs/remotes/origin/master

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
<<<<<<< HEAD
				
				if(key == KeyEvent.VK_Q) {
					count++;
					if (count % 2 ==0){
						handler.setPause(false);
					}
					else {
						handler.setPause(true);
					}
				}
				
=======
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
>>>>>>> refs/remotes/origin/master
				if(key == KeyEvent.VK_W) {
<<<<<<< HEAD
					handler.setUp(true);
					handler.setStop(false);
=======
					tempObject.setSpeedY(-5);
					up = true;
					down = false;
					left = false; 
					right = false; 
					stop = false;
					space = false;

>>>>>>> refs/remotes/origin/master
				}
				if(key == KeyEvent.VK_S) {
<<<<<<< HEAD
					handler.setDown(true);
					handler.setStop(false);
=======
					tempObject.setSpeedY(5);
					up = false;
					down = true;
					left = false; 
					right = false; 
					stop = false;
					space = false;
				}
				if(key == KeyEvent.VK_D) {
					tempObject.setSpeedX(5);
					up = false;
					down = false;
					left = false; 
					right = true; 
					stop = false;
					space = false;
>>>>>>> refs/remotes/origin/master
				}
				if(key == KeyEvent.VK_A) {
<<<<<<< HEAD
					handler.setLeft(true);
					handler.setStop(false);
=======
					tempObject.setSpeedX(-5);
					up = false;
					down = false;
					left = true; 
					right = false; 
					stop = false;
					space = false;
>>>>>>> refs/remotes/origin/master
				}
				if(key == KeyEvent.VK_D) {
					handler.setRight(true);
					handler.setStop(false);
				}
				if(key == KeyEvent.VK_UP) {
					handler.setUpAim(true);
					//Set Attack Direction
					handler.addObject(new Fireball(tempObject.getX(),tempObject.getY(),0,-5,ID.Attack));
				}
				if(key == KeyEvent.VK_DOWN) {
					handler.setDownAim(true);
					handler.addObject(new Fireball(tempObject.getX(),tempObject.getY(),0,5,ID.Attack));
				}
				if(key == KeyEvent.VK_LEFT) {
					handler.setLeftAim(true);
					handler.addObject(new Fireball(tempObject.getX(),tempObject.getY(),-5,0,ID.Attack));
				}
<<<<<<< HEAD
				if(key == KeyEvent.VK_RIGHT) {
					handler.setRightAim(true);
					handler.addObject(new Fireball(tempObject.getX(),tempObject.getY(),5,0,ID.Attack));
=======
				if(key == KeyEvent.VK_SPACE) {
					space = true;
					handler.addObject(new Fireball(tempObject.getX(),tempObject.getY(),ID.Attack));
>>>>>>> refs/remotes/origin/master
				}
				if(key == KeyEvent.VK_SPACE) handler.setSpace(true);
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
<<<<<<< HEAD
				
				if(key == KeyEvent.VK_W) handler.setUp(false);
				if(key == KeyEvent.VK_S) handler.setDown(false);
				if(key == KeyEvent.VK_A) handler.setLeft(false);
				if(key == KeyEvent.VK_D) handler.setRight(false);
				if(key == KeyEvent.VK_UP) handler.setUpAim(false);
				if(key == KeyEvent.VK_DOWN) handler.setDownAim(false);
				if(key == KeyEvent.VK_LEFT) handler.setLeftAim(false);
				if(key == KeyEvent.VK_RIGHT) handler.setRightAim(false);
				if(key == KeyEvent.VK_SPACE) handler.setSpace(false);
				handler.setStop(true);
				
=======
				//Key events for player
				up = false;
				down = false;
				left = false; 
				right = false; 
				stop = true;
>>>>>>> refs/remotes/origin/master
				dead = true;

			}
		}
	}
}

