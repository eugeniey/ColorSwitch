package colorswitch;

/**
 * Création du level5 vide pour éviter les bugs (le level est ''vide'')
 */
public class Level5 extends Level {

	public Level5(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;

		Square obstacle1 = new Square(x, 50 * screenHeight, 500);

		obstacles.add(obstacle1);

		victoryMushroom = new Mushroom(screenWidth / 2, 100 * screenHeight);

	}

}
