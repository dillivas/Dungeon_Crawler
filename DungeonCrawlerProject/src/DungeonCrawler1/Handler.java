/************************************************
 * Written By: William Mckeever     			*
 * Date: 1/28/2018        						*
 * Class: Handler        						*
 *             									*
 * This class handles all of the game objects 	*
 ************************************************/
package DungeonCrawler1;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
		
	 LinkedList<GameObject> object = new LinkedList<GameObject>();
	 
	 /**
	  * Controls the game object tick
	  */
	 public void tick() {
		  for(int i = 0; i < object.size(); i++) {
			   GameObject tempObject = object.get(i);
			   tempObject.tick();
			   if(tempObject.getRemove() == true) {
				   removeObject(tempObject);
			   }
		  }
	 }
	 
	 /**
	  * Controls adding object rendering
	  * @param g graphics to render
	  */
	 public void render (Graphics g) {
		  for(int i = 0; i < object.size(); i++) {
			   GameObject tempObject = object.get(i);
			   tempObject.render(g);
		  }
	 }
	 
	 /**
	  * Adds the object to the list
	  * @param object to add to list
	  */
	 public void addObject(GameObject object) {
		 this.object.add(object);
	 }
	 
	 /**
	  * Removes the object from the list
	  * @param object to remove from the list
	  */
	 public void removeObject(GameObject object) {
		 this.object.remove(object);
	 }

}
