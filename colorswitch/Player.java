package colorswitch;

/**
 * Classe repr�sentant l'entit� de la personne qui joue (aka, la sorci�re).
 *
 * La sorci�re est repr�sent�e par un cercle.
 */
public class Player extends Entity {

	private double radius; // rayon du cercle du joueur
	private double vy; // vitesse du joueur
	private double ay; // acc�l�ration vers le bas du joueur
	private int color = 1; // couleur du joueur

	/**
	 * Constructeur
	 * 
	 * @param x
	 *            position x
	 * @param y
	 *            position y
	 * @param r
	 *            rayon
	 */
	public Player(double x, double y, double r) {
		super(x, y);
		this.radius = r;
		this.vy = 0;
		this.ay = -400;
		this.renderer = new PlayerRenderer(this);
	}

	/**
	 * Fonction appelle � chaque frame pour mettre � jour les attributs de l'entit�
	 *
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	@Override
	public void tick(double dt) {
		// Mise � jour de la vitesse
		vy += dt * ay;

		// Mise � jour de la position
		y += dt * vy;

		// Clip la vitesse pour rester entre -300 et 300
		vy = Math.min(vy, 300);
		vy = Math.max(vy, -300);
	}

	/**
	 * Remplace la couleur actuelle par une nouvelle couleur al�atoire
	 */
	public void randomizeColor() {
		int newColor;
		do {
			newColor = (int) (Math.random() * 4);
		} while (newColor == this.color);

		this.color = newColor;
	}

	/**
	 * Fait sauter la sorci�re
	 */
	public void jump() {
		vy = Math.max(vy, 0);
		vy += 200;
	}

	/**
	 * Set position en y du joueur
	 * 
	 * @param y
	 *            position en y
	 */
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public double getWidth() {
		return this.getRadius() * 2;
	}

	@Override
	public double getHeight() {
		return this.getRadius() * 2;
	}

	public int getColor() {
		return color;
	}

	public double getRadius() {
		return radius;
	}
}
