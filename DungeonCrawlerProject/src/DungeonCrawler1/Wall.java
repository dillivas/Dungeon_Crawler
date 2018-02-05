/************************************************
 * Written By: William Mckeever    				*
 * Date: 1/28/2018       						*
 * Class: Wall      							*
 *            									*
 * The class controls a wall or block object	*
 * to act as a obstacle to the player.			*
 ************************************************/

package DungeonCrawler1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall extends GameObject {
	
	 public Wall(int x, int y, ID id) {
		 super(x, y, id);
	 }
	 
	 public Rectangle getBounds() {
		 return new Rectangle(x,y,32,32);
	 }
	 
	 public void tick() {
		
	 }
	 
	 public void render(Graphics g) {
		 
		 //Graphics2D g2d = (Graphics2D)g;
		 
		  g.setColor(Color.white);
		  g.fillRect(x, y, 32, 32);
	 }
}
