package colorswitch;

/**
 * Classe abstraite repr�sentant un item (powerup/champignon/...)
 */
public abstract class Item extends LevelElement {

	/**
	 * Constructeur
	 * 
	 * @param x
	 *            Position en x
	 * @param y
	 *            Position en y
	 */
	public Item(double x, double y) {
		super(x, y);
	}
}
