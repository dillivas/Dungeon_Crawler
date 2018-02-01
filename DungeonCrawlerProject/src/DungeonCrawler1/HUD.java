/********************************************
 * Written By: William Mckeever    			*
 * Date: 1/28/2018       					*
 * Class: HUD       	 					*
 *            								*
 * The class keeps track of player HUD  	*
 ********************************************/
package DungeonCrawler1;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	 
	 public static int HEALTH = 100;
	 
	 //Change to not drain health constantly
	 public void tick() {
		  HEALTH--;
		  
		  HEALTH = Game.clamp(HEALTH,0,100);
		  
	 }
	 
	 public void render(Graphics g) {
		  g.setColor(Color.gray);
		  g.fillRect(15 , 15, 200, 32);
		  g.setColor(Color.red);
		  g.fillRect(15 , 15, HEALTH * 2, 32);
		  g.setColor(Color.white);
		  g.drawRect(15 , 15, 200, 32);
	 }
}