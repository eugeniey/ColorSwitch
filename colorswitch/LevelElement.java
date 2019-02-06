package colorswitch;

/**
 * �l�ments qui composent un niveau.
 *
 * Le joueur peut interagir avec toutes les objets de ce type en entrant en
 * collision avec.
 */
public abstract class LevelElement extends Entity {

	/**
	 * Constructeur
	 * 
	 * @param x
	 * @param y
	 */
	public LevelElement(double x, double y) {
		super(x, y);
	}

	/**
	 * Fonction abstraite pour l'interaction entre un �l�ment et le joueur
	 * 
	 * @param player
	 *            joueur
	 * @return boolean
	 */
	public abstract boolean intersects(Player player);

	/**
	 * Fonction abstraite qui d�finit interaction entre �l�ment et joueur
	 * 
	 * @param player
	 *            joueur
	 * @param game
	 *            jeu
	 */
	public abstract void handleCollision(Player player, Game game);

}
