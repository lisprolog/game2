public class Player{

	int x;
	int y;
	char c;
	boolean down = true;
	Field f1;

	public Player(int x, int y, char c){
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

	public void fire(){
		Bullet b1 = new Bullet(getY(),1,'-');
	}

	public void actual(Field f){

		this.f1 = f;

		if( down && getY() == f.getHeight()-1)
			down = false;
		if( down == false && getY() == 0)
			down = true;

		
		if(down)
			y++;
		else
			y--;
	}
}
