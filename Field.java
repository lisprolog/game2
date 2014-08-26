public class Field{

        static int width;
        static int height;
        static char[][] field;


	public Field(){
		width = 20;
		height = 10;
		field = new char[height][width];	
	}

	public static char getPixel(int x, int y){
		return field[y][x];
	}

	public static void setPixel(int x, int y, char c, Enemy e){
		if(getPixel(x,y) == e.getC()){
			field[y][x]= '+';
			Game2.win = true;
			Game2.end = true;
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

        public void setPlayer(Player p, Enemy e){
		setPixel(p.getX(), p.getY(), p.getC(), e);
        }

        public void setEnemy(Enemy e){
		setPixel(e.getX(), e.getY(), e.getC(), e);

        }

	public void setBullet(Bullet b, Enemy e){
		setPixel(b.getX(), b.getY(), b.getC(), e);
	}
}
