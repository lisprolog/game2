public class Field{

        static int width;
        static int height;
        static char[][] field;
	static Player p1;
	static Enemy e1;
	static Enemy e2;
	static Bullet b1;
	static Rocket r1;

	static int enemies = 2;

	public Field(Player p, Enemy en1, Enemy en2, Bullet b){
		this.p1 = p;
		this.e1 = en1;
		this.e2 = en2;
		this.b1 = b;
		width = 20;
		height = 10;
		field = new char[height][width];	
	}

	public Field(Player p, Enemy en1, Enemy en2, Rocket r){
		this.p1 = p;
		this.e1 = en1;
		this.e2 = en2;
		this.r1 = r;
		width = 20;
		height = 10;
		field = new char[height][width];	
	}

	public static char getPixel(int x, int y){
		return field[y][x];
	}

	public static void setPixel(int x, int y, char c){
		if(getPixel(x,y) == e1.getC()){
			field[y][x]= '+';
			e1.setVisible(false);
			enemies--;
		}else if(getPixel(x,y) == e2.getC()){
			field[y][x]= '+';
			e2.setVisible(false);
			enemies--; 
		}else		
			field[y][x] = c;
	}

	public static int getHeight(){
		return height;
	}

	public static int getWidth(){
		return width;
	}

        public static String getField(){

                String result = "";
                for(int h = 0; h< height; h++){
                        for(int w = 0; w< width; w++ ){
                                result += field[h][w];
				result += ' ';
                        }
                        result += '\n';
                }
                return result;
        }

        public static void clear(){
                
                for(int h = 0; h< height; h++){
                        for(int w = 0; w< width; w++ ){
                                field[h][w] = '.';
                        }
                }
        }

        public void setPlayer(Player p){
		setPixel(p.getX(), p.getY(), p.getC());
        }

        public void setEnemy(Enemy e){
		setPixel(e.getX(), e.getY(), e.getC());
        }

	public void setBullet(Bullet b){
		setPixel(b.getX(), b.getY(), b.getC());
	}

	public void setRocket(Rocket r){
		setPixel(r.getX(), r.getY(), r.getC());
	}

	public int getEnemies(){
		return enemies;
	}
}
