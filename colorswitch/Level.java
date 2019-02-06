package colorswitch;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite pour repr�senter un niveau.
 */
public abstract class Level {

	/**
	 * � quel point on est avanc�s dans le level
	 */
	protected double scroll;

	/**
	 * Dimensions du niveau visible � l'�cran
	 */
	protected double screenWidth, screenHeight;

	/**
	 * Obstacles du niveau
	 */
	protected List<Obstacle> obstacles;
	/**
	 * Items et champignon final
	 */
	protected List<Item> items;
	protected Mushroom victoryMushroom;

	/**
	 * Constructeur
	 * 
	 * @param screenWidth
	 *            largueur �cran
	 * @param screenHeight
	 *            hauteur �cran
	 */
	public Level(double screenWidth, double screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;

		obstacles = new ArrayList<>(); // liste des obstacles
		items = new ArrayList<>(); // liste des items
	}

	public double getScroll() {
		return scroll;
	}

	public double getScreenWidth() {
		return screenWidth;
	}

	public double getScreenHeight() {
		return screenHeight;
	}

	public List<Obstacle> getObstacles() {
		return obstacles;
	}

	public List<Item> getPowerUps() {
		return items;
	}

	/**
	 * Fonction appelle � chaque frame pour mettre � jour
	 *
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	public void tick(double dt) {
		for (Obstacle o : obstacles) {
			o.tick(dt);
		}
		for (Item p : items) {
			p.tick(dt);
		}
	}

	/**
	 * Permet de scroll le level
	 * 
	 * @param scroll
	 */
	public void incrementScroll(double scroll) {
		this.scroll += scroll;
	}

	/**
	 * Retourne les entit�s dans le niveau (obstacles, items et champignon)
	 *
	 * @return List des entit�s
	 */
	public List<LevelElement> getEntities() {
		List<LevelElement> entities = new ArrayList<>();

		for (LevelElement e : this.obstacles) {
			entities.add(e);
		}
		for (LevelElement e : this.items) {
			entities.add(e);
		}
		entities.add(victoryMushroom);

		return entities;
	}

}
