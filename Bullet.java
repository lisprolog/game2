public class Bullet{

	int x;
	int y;
	char c;
	boolean visible = false;
	boolean forward = true;

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
		return visible;
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

	public void reset(Player p){
		x = 1;
		y = p.getY();
	}

	public void reset(Enemy e, Field f){
		x = f.getWidth()-1;
		y = e.getY();
	}

        public void actual(Player p, Enemy e, Field f){

		if(forward && x == f.getWidth()-1)
			visible = false;
//		}if(forward == false && getX() == 0)
//			visible = false;
//			reset(e, f);
		else if(forward && visible)
                	x++;
		else if (forward == false && visible)
			x--;
	}			
}
