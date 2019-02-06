package colorswitch;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite pour représenter un niveau.
 */
public abstract class Level {

	/**
	 * À quel point on est avancés dans le level
	 */
	protected double scroll;

	/**
	 * Dimensions du niveau visible à l'écran
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
	 *            largueur écran
	 * @param screenHeight
	 *            hauteur écran
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
	 * Fonction appelle à chaque frame pour mettre à jour
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
	 * Retourne les entités dans le niveau (obstacles, items et champignon)
	 *
	 * @return List des entités
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
