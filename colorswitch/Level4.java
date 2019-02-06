package colorswitch;

/**
 * Création du level 4
 */
public class Level4 extends Level {

	/**
	 * Constructeur
	 * 
	 * @param screenWidth
	 *            largeur de l'écran
	 * @param screenHeight
	 *            hauteur de l'écran
	 */
	public Level4(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;

		// Création des obstacles
		VerticalBar obstacle1 = new VerticalBar(x - 130, 0.7 * screenHeight, 280, 50, 60);
		VerticalBar obstacle2 = new VerticalBar(x + 130, 0.7 * screenHeight, 280, 50, 60);
		VerticalBar obstacle3 = new VerticalBar(x, 0.7 * screenHeight, 50, 50, 60);

		RotatingCircle obstacle4 = new RotatingCircle(x, 1.5 * screenHeight, 7.5, 135, 30);
		RotatingCircle obstacle5 = new RotatingCircle(x, 1.5 * screenHeight, -7.5, 135, 30);
		RotatingCircle obstacle6 = new RotatingCircle(x, 1.5 * screenHeight, 3, 135, 30);
		RotatingCircle obstacle7 = new RotatingCircle(x, 1.5 * screenHeight, -3, 135, 30);

		VerticalBar obstacle8 = new VerticalBar(x, 2.5 * screenHeight, 0, screenWidth, 480);

		GrowingCircle obstacle9 = new GrowingCircle(x - 100, 3.8 * screenHeight, 200, 180, 0);
		GrowingCircle obstacle10 = new GrowingCircle(x + 100, 3.8 * screenHeight, 200, 180, 0);

		VerticalBar obstacle11 = new VerticalBar(x - 100, 4.5 * screenHeight, 200, 110, 20);
		VerticalBar obstacle12 = new VerticalBar(x + 100, 4.5 * screenHeight, 200, 110, 20);

		Square obstacle13 = new Square(x, 4.9 * screenHeight, 80);

		RotatingCircle obstacle14 = new RotatingCircle(x - 50, 5.5 * screenHeight, 3.5, 10, 10);
		RotatingCircle obstacle15 = new RotatingCircle(x - 50, 5.5 * screenHeight, 3.5, 30, 10);
		RotatingCircle obstacle16 = new RotatingCircle(x - 50, 5.5 * screenHeight, 3.5, 50, 10);
		RotatingCircle obstacle17 = new RotatingCircle(x - 50, 5.5 * screenHeight, 3.5, 70, 10);
		RotatingCircle obstacle22 = new RotatingCircle(x - 50, 5.5 * screenHeight, 3.5, 90, 10);
		RotatingCircle obstacle25 = new RotatingCircle(x - 50, 5.5 * screenHeight, 3.5, 110, 10);
		RotatingCircle obstacle18 = new RotatingCircle(x + 50, 5.5 * screenHeight, -3.5, 10, 10);
		RotatingCircle obstacle19 = new RotatingCircle(x + 50, 5.5 * screenHeight, -3.5, 30, 10);
		RotatingCircle obstacle20 = new RotatingCircle(x + 50, 5.5 * screenHeight, -3.5, 50, 10);
		RotatingCircle obstacle21 = new RotatingCircle(x + 50, 5.5 * screenHeight, -3.5, 70, 10);
		RotatingCircle obstacle23 = new RotatingCircle(x + 50, 5.5 * screenHeight, -3.5, 90, 10);
		RotatingCircle obstacle24 = new RotatingCircle(x + 50, 5.5 * screenHeight, -3.5, 110, 10);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		obstacles.add(obstacle6);
		obstacles.add(obstacle7);
		obstacles.add(obstacle8);
		obstacles.add(obstacle9);
		obstacles.add(obstacle10);
		obstacles.add(obstacle11);
		obstacles.add(obstacle12);
		obstacles.add(obstacle13);
		obstacles.add(obstacle14);
		obstacles.add(obstacle15);
		obstacles.add(obstacle16);
		obstacles.add(obstacle17);
		obstacles.add(obstacle18);
		obstacles.add(obstacle19);
		obstacles.add(obstacle20);
		obstacles.add(obstacle21);
		obstacles.add(obstacle22);
		obstacles.add(obstacle23);
		obstacles.add(obstacle24);
		obstacles.add(obstacle25);

		// Création des items
		Shield shield1 = new Shield(x, 1.5 * screenHeight);
		Potion potion2 = new Potion(x, 3.3 * screenHeight);

		items.add(shield1);
		items.add(potion2);

		victoryMushroom = new Mushroom(screenWidth / 2, 6 * screenHeight);
	}
}
