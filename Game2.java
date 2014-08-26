import java.util.Scanner;

public class Game2{
	
	public Game2(){}

	public static boolean end = false;
	public static boolean win = false;
	public static boolean lose = false;
	public static int count = 0;
	public static int round = 0;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		Field f1 = new Field();
		String command = "";
		f1.clear();
		Player p1 = new Player(0,5, 'C');
		Enemy e1 = new Enemy(19,9,'D');
		Enemy e2 = new Enemy(19,0,'F');


		Bullet b1 = new Bullet(1, p1.getY(), '-');
//		Bullet b2 = new Bullet();
//		b2.forward = false;

		f1.setPlayer(p1, e1);
		System.out.println("Game2 start!");

		while(end == false){
			command = "l";
			while(end == false && win == false){
				f1.clear();
				f1.setPlayer(p1, e1);
				f1.setEnemy(e1);
				if(b1.getVisible())
					f1.setBullet(b1, e1);
				System.out.println(f1.getField());

//				p1.actual(f1);
				e1.actual(f1);
				if(b1.getVisible())
					b1.actual(p1, e1, f1);
//				f1.setPlayer(p1, e1);
//				f1.setEnemy(e1);
//				if(b1.getVisible())
//					f1.setBullet(b1, e1);
//				System.out.println(f1.getField());
				command = sc.next();

				if(command.equals("q")){
					end = true;
					lose = true;
				}

				if(command.equals("f")){
					f1.setBullet(b1, e1);
					b1.setVisible(true);
					b1.reset(p1);
				}
				count++;
			}
			if(lose)
				System.out.println("Game over!");
			else if(win)
				System.out.println("You win!");
		}
	}	
}	
