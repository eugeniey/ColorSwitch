package colorswitch;

/**
 * Définit l'obstacle RotatingCircle. C'est un cercle qui tourne autour d'un
 * certain rayon.
 */
public class RotatingCircle extends Obstacle {

	private double vAngulaire, angle = 0; // angle que forme le cercle avec le centre
	private double timeSinceColorChange = 0;
	private double rayon, xi, yi; // définition du rayon de l'obstacle et sa position
	private double rayonRotation; // obstacle tourne autour de ce rayon

	/**
	 * @param x
	 *            coordonnées initiales du centre de rotation.
	 * @param y
	 * @param v
	 *            vitesse angulaire
	 * @param rayonRotation
	 * @param rayon
	 * 
	 *            Notez que le centre de la rotation est décalé d'une fois le rayon
	 *            de rotation.
	 */
	public RotatingCircle(double x, double y, double v, double rayonRotation, double rayon) {
		super(x, y);
		this.xi = x;
		this.yi = y;
		this.rayonRotation = rayonRotation;
		this.rayon = rayon;
		this.vAngulaire = v;
		this.renderer = new RotatingCircleRenderer(this);
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

		angle += dt * vAngulaire; // angle change à chaque dt selon vitesse

		// Rédéfinition de la position en x et y selon l'angle
		x = xi + rayonRotation * Math.cos(angle);
		y = yi + rayonRotation * Math.sin(angle);
	}

	@Override
	public double getWidth() {
		return this.rayon * 2;
	}

	@Override
	public double getHeight() {
		return this.getWidth();
	}

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
