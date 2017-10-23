/**
	ASCII-bullet "-" moves from the left side(player) of the screen to the right side(enemy).
	To pull the trigger, the player hits the "f" button on the keyboard and sets boolean "visible" to "true".
	Once the bullet is fired, in each cicle, the bullet moves one pixel at a time.
	If the "-" reaches the enemy side and overlaps with the enemy at the same time,
	the enemy is hit and the game is won.
*/

public class Bullet{ 

	private int x;
	private int y;
	private char c;
	private boolean visible = false;
	private boolean forward = true;

	public Bullet(int x, int y, char c){
		this.x = x;
		this.y = y;
		this.c = c;
	}

        public int getX(){
                return this.x;
        }

        public int getY(){
                return this.y;
        }

	public char getC(){
		return this.c;
	}

	public boolean getVisible(){
		return this.visible;
	}

        public void setX(int x){
                this.x = x;
        }

        public void setY(int y){
                this.y = y;
        }

	public void setVisible(boolean t){
		this.visible = t;
	}

	public boolean getForward(){
		return forward;
	}

	public void reset(){
		x = 1;
		y = 3;
	}

	public void reset(Player p){
		x = 1;
		y = p.getY();
	}
	
	/* 
	   checks if the bullet position on screen
	   if the bullet reaches the end of screen, reset the bullet
	   else the position gets incremented by one position
	*/
        public void actual(Field f){

		if(x == f.getWidth()-1){
			reset();
			visible = false;			
		}else if(visible){
                	x++;
		}
	}			
}
