package colorswitch;

/**
 * Définit l'obstacle GrowingCircle. C'est un cercle qui grossit est rapetisse.
 * Le cercle à un rayon maximum et minimal
 */
public class GrowingCircle extends Obstacle {

	private double rayon; // rayon actuel du cercle
	/**
	 * Les bornes minimum et maximum sur le rayon du cercle
	 */
	private double rayonMin;
	private double rayonMax;
	private double v; // vitesse de changement de rayon
	private double timeSinceColorChange = 0; // compteur pour changement couleur

	/**
	 * Constructeur position du centre
	 * 
	 * @param x
	 * @param y
	 *            vitesse du rayon
	 * @param vitesse
	 *            bornes
	 * @param rayonMax
	 *            borne supérieure sur le rayon
	 * @param rayonMin
	 *            borne inférieure sur le rayon et rayon initial.
	 */
	public GrowingCircle(double x, double y, double vitesse, double rayonMax, double rayonMin) {
		super(x, y);
		this.rayon = rayonMin;
		this.rayonMin = rayonMin;
		this.rayonMax = rayonMax;
		this.v = vitesse;
		this.renderer = new GrowingCircleRenderer(this);
		this.color = (int) (Math.random() * 4);
	}

	/**
	 * Fonction appelle à chaque frame pour mettre à jour les attributs de l'entité
	 *
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	@Override
	public void tick(double dt) {
		timeSinceColorChange += dt;

		// Changement de couleur
		if (timeSinceColorChange > 2) {
			color = (color + 1) % 4;
			timeSinceColorChange = 0;
		}

		// Mise à jour de la position
		double newR = rayon + dt * v;

		// Si les bornes sur les rayons sont atteintes
		if (newR >= rayonMax || newR <= rayonMin) {
			v *= -1;
		} else {
			rayon = newR;
		}
	}

	// Les deux getteurs retournent le diamètre
	@Override
	public double getWidth() {
		return rayon * 2; // diamètre
	}

	@Override
	public double getHeight() {
		return this.getWidth(); // diamètre
	}

	/**
	 * @return la couleur
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Intersection entre obstacle et joueur
	 */
	@Override
	public boolean intersects(Player player) {
		double dx = this.x - player.getX();
		double dy = this.y - player.getY();
		double distRayonCarre = dx * dx + dy * dy;

		return this.color != player.getColor() && distRayonCarre < (this.getHeight() / 2 + player.getRadius())
				* (this.getHeight() / 2 + player.getRadius());
	}

}
