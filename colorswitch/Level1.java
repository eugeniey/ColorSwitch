package colorswitch;

/**
 * Création du level 1
 */
public class Level1 extends Level {

	/**
	 * Constructeur
	 * 
	 * @param screenWidth
	 *            largeur de l'écran
	 * @param screenHeight
	 *            hauteur de l'écran
	 */
	public Level1(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;

		// Création des obstacles
		Square obstacle1 = new Square(x, 0.75 * screenHeight, 75);
		Square obstacle2 = new Square(x, 1.5 * screenHeight, 125);
		VerticalBar obstacle3 = new VerticalBar(x, 2.25 * screenHeight, 100, 50, 50);
		VerticalBar obstacle4 = new VerticalBar(x, 2.25 * screenHeight, -100, 50, 50);
		Square obstacle5 = new Square(x + 50, 3.50 * screenHeight, 100);
		Square obstacle6 = new Square(x - 50, 3.50 * screenHeight, 100);
		VerticalBar obstacle7 = new VerticalBar(x, 4.75 * screenHeight, 25, 25, 200);
		VerticalBar obstacle8 = new VerticalBar(x, 5 * screenHeight, 25, 100, 25);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		obstacles.add(obstacle6);
		obstacles.add(obstacle7);
		obstacles.add(obstacle8);

		// Création des items
		Shield shield1 = new Shield(x, 3 * screenHeight);
		Potion potion2 = new Potion(x, 4.00 * screenHeight);

		items.add(shield1);
		items.add(potion2);

		victoryMushroom = new Mushroom(screenWidth / 2, 5.75 * screenHeight);
	}
}
