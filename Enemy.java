/**
	Enemy moves on the right side of the screen (up or down) one step at a time.
	 
*/
public class Enemy{

	private int x;
	private int y;
	private char c;
	private boolean down = true;
	private boolean visible = true;
	Field f1;

	public Enemy(int x, int y, char c){
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

	public void setX(int x){
                this.x = x;
        }

        public void setY(int y){
                this.y = y;
        }

	public boolean getDown(){
		return down;
	}

	public void setVisible(boolean t){
		this.visible = t;
	}

	public boolean getVisible(){
		return visible;
	}

	public void fire(){
		Bullet b2 = new Bullet(getY(),8,'~');
	}

	public void actual(Field f){

		this.f1 = f;

		if( down && getY() == f.getHeight()-1){
			down = false;
		}
		if( down == false && getY() == 0){
			down = true;
		}
		
		if(down){
			y++;
		}else{
			y--;
		}
	}

        public void actual(Bullet b, Enemy e, Field f){

		if(b.getX() == f.getWidth()-1 && e.getY() == b.getY()){
                        this.visible = false;
		}
       } 
}
