import java.util.Scanner;

public class Game2{
	
	public Game2(){}

	public static boolean end = false;
	public static boolean win = false;
	public static boolean lose = false;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		String command = "";

		Player p1 = new Player(0,5, 'C');
		Enemy e1 = new Enemy(19,9,'X');
		Enemy e2 = new Enemy(19,0,'X');
		Bullet b1 = new Bullet(1, p1.getY(), '-');
		Rocket r1 = new Rocket(1, p1.getY(), '>');
		Field f1 = new Field(p1, e1, e2, b1);
		f1.clear();

		f1.setPlayer(p1);
		System.out.println("Game2 start!");

		while(end == false){
			command = "l";
			while(end == false && win == false){
				f1.clear();
				f1.setPlayer(p1);
				if(e1.getVisible())
					f1.setEnemy(e1);
				if(e2.getVisible())
					f1.setEnemy(e2);
				if(b1.getVisible())
					f1.setBullet(b1);
				if(r1.getVisible())
					f1.setRocket(r1);
				
				System.out.println("\033[1;1H");
				System.out.println("\033[2J");
				System.out.println(f1.getField());
		
				if(e1.getVisible())
					e1.actual(f1);
				if(e2.getVisible())
					e2.actual(f1);
				if(b1.getVisible())
					b1.actual(f1);
				if(r1.getVisible())
					r1.actual(f1);
				
				if(f1.getEnemies() == 0){
					end = true;
					win = true;
				}
				command = sc.next();

				if(command.equals("q")){
					end = true;
					lose = true;
				}

				if(command.equals("f")){
					f1.setBullet(b1);
					b1.reset(p1);
					b1.setVisible(true);
//					b1.reset(p1);
				}

				if(command.equals("r")){
					f1.setRocket(r1);
					r1.reset(p1);
					r1.setVisible(true);
//					r1.reset(p1);
				}

				if(command.equals("w"))
					p1.up();	
				if(command.equals("z"))
					p1.down(f1);
			}
			if(lose)
				System.out.println("Game over!");
			else if(win)
				System.out.println("You win!");
		}
	}	
}	
