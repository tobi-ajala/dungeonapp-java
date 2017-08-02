import java.util.Scanner;

public class DungeonApp {
	Scanner scannerIn = new Scanner(System.in);
	String name="Tupac";
	int age=250;
	Monster monster1;
	Troll troll1;
	Witch witch1;
	Location [][] locations = new Location [10][10];
	Player player = new Player (2,2);

	public static void main(String[] args) {
		new DungeonApp();
	}

	public DungeonApp() {

		do {
			System.out.println("Enter play details");
		}
		while(!enterDetails());

		monster1=new Monster ("Young Thug",99,true);
		monster1.display();

		troll1=new Troll("Gucci Mane",32,true);
		troll1.display();

		witch1=new Witch("Trinidad James",32,true);
		witch1.display();
		witch1.castSpell();
		witch1.fly();

		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				locations [i][j]=new Location("Nothing to really see here " ,i,j);
		locations[5][5].display();

		locations[1][1]=new Location("You're in the trap house",1,1);
		locations[3][3]=new Location("You're in the studio",3,3);
		locations[5][5]=new Location("You're at the new video shoot",1,1);

		locations[3][3].monster=monster1;
		locations[2][7].monster=troll1;
		Monster wicth1;
		locations[8][1].monster=wicth1;

		displayMap();

		do {
			System.out.println("Take a turn!");
		}
		while(takeTurn());
		System.out.println("Bye!");
	}

	private void displayMap() {
		// TODO Auto-generated method stub
		
	}

	private boolean takeTurn() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean enterDetails() {
		// TODO Auto-generated method stub
		return false;
	}

	boolean enterDeatils()
	{
		System.out.println("What's your name?");

		name = scannerIn.nextLine();

		System.out.println("Hello " + name);

		System.out.println("How old are you?");

		String ageString = scannerIn.nextLine();

		try {
			age=Integer.parseInt(ageString);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	boolean takeTrun()
	{
		System.out.println("Enter N, S, E or W or Q to exit the game.");

		String turn = scannerIn.nextLine();

		if(turn.equals("N"))
			player.i--;
		else if(turn.equals("S"))
			player.i++;
		else if(turn.equals("W"))
			player.j--;
		else if(turn.equals("E"))
			player.j++;
		else if(turn.equals("Q"))
			return false;
		displayMap();
		locations[player.i][player.j].display()	
		return true;
	}

	void displayMAp()
	{
		for(int i=0;i<10,i++) {
			for(int j=0;j<10,j++) {
				if(player.i==i && player.j==j)
					System.out.println("P");
				else if(locations[i][j].monster!=null)
					System.out.println("M");
				else
					System.out.println("_");
			}
			System.out.println();
		}
	}
}

class Monster {
	protected String name;
	private int age;
	private boolean male;

	public Monster(String name, int age, boolean male) {
		super();
		this.name = name;
		this.age = age;
		this.male = male;
	}
	public void display()
	{
		System.out.println("You see a monster named " + name + ", age= "+ age);
		if(male)
			System.out.println("Is a male");
		else
			System.out.println("Is a female");

	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

}

class Troll extends Monster {

	public Troll(String name, int age, boolean male) {
		super(name, age, male);
	}
	
	public void display()
	{
		System.out.println("Errreerrrr I'm a troll that lives in the trap house");
		super.display();
	}
}

interface Magic {
	int castSpell();	
}

interface Flying {
	int fly();
}


class Witch extends Monster implements Magic, Flying {

	public Witch(String name, int age, boolean male) {
		super(name, age, male);
	}

	public void display() 
	{
		System.out.println("Cackle, I'm a witch!");
		super.display();
	}

	public void doMagic() 
	{
		System.out.println("Haha! I have a deadly potion for you to drink.");
		return 0;
	}

	public void fly() 
	{
		System.out.println("Cackle cackle, cackle. I'm going to fly you away");	
	}
	
	public int castSpell()
	{
		System.out.println("Cackle.. I'm going to hypnotize you with my gold grills");
	}
}

class Location {
	String description;
	int north=0, east=0
	Monster monster=null
	
	public Location(String description, int north, int east)
	{
		this.description=description;
		this.north=north;
		this.east=east;
	}
	public void display()
	{
		System.out.println(description + " north=" + north + " east=" + east);
		if(monster!=null) {
			monster.display();
			if(monster instanceof Magic)
				((Magic) monster).castSpell();
			if(monster instanceof Flying)
				((Flying) monster).fly();
		}
	}
}

class Player {
	int i, j;
	public Player(int k, int l) {
		// TODO Auto-generated constructor stub
	}
	public Palyer(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
	
	
	
	
	
	
	
