package colorswitch;

/**
 * Classe abstraite pour représenter une entité sur le jeu.
 *
 * Une entité possède minimalement un Renderer et une position (x, y) définie
 * par rapport au niveau (où y=0 est tout en bas).
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
	 * @return la largeur totale de l'entité
	 */
	public abstract double getWidth();

	/**
	 * @return la hauteur totale de l'entité
	 */
	public abstract double getHeight();

	/**
	 * @return le renderer de type Renderer
	 */
	public Renderer getRepresentation() {
		return renderer;
	}

	/**
	 * Fonction appelée à chaque frame pour mettre à jour les attributs de l'entité.
	 *
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	public abstract void tick(double dt);
}
