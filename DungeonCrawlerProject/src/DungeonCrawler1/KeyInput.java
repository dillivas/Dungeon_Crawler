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
	
	public int count = 0;
	
	public static boolean dead = false;

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
				
				if(key == KeyEvent.VK_Q) {
					count++;
					if (count % 2 ==0){
						handler.setPause(false);
					}
					else {
						handler.setPause(true);
					}
				}
				
				if(key == KeyEvent.VK_W) {
					handler.setUp(true);
					handler.setStop(false);
				}
				if(key == KeyEvent.VK_S) {
					handler.setDown(true);
					handler.setStop(false);
				}
				if(key == KeyEvent.VK_A) {
					handler.setLeft(true);
					handler.setStop(false);
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
				if(key == KeyEvent.VK_RIGHT) {
					handler.setRightAim(true);
					handler.addObject(new Fireball(tempObject.getX(),tempObject.getY(),5,0,ID.Attack));
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
				
				dead = true;

			}
		}
	}
}

