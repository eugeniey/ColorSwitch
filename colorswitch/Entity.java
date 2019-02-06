package colorswitch;

/**
 * Classe abstraite pour repr�senter une entit� sur le jeu.
 *
 * Une entit� poss�de minimalement un Renderer et une position (x, y) d�finie
 * par rapport au niveau (o� y=0 est tout en bas).
 */
public abstract class Entity {

	protected double x, y; // position
	protected Renderer renderer; // renderer de type Renderer

	/**
	 * Constructeur
	 * 
	 * @param x
	 * @param y
	 */
	public Entity(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	/**
	 * @return la largeur totale de l'entit�
	 */
	public abstract double getWidth();

	/**
	 * @return la hauteur totale de l'entit�
	 */
	public abstract double getHeight();

	/**
	 * @return le renderer de type Renderer
	 */
	public Renderer getRepresentation() {
		return renderer;
	}

	/**
	 * Fonction appel�e � chaque frame pour mettre �jour les attributs de l'entit�.
	 *
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	public abstract void tick(double dt);
}
