package colorswitch;

/**
 * Obstable d'une barre verticale. Barre vertical qui bouge horizontalement dans
 * le canvas. La barre ne change pas de couleur.
 */
public class VerticalBar extends Obstacle {

	private double width; // largeur
	private double height; // longueur
	private double vx; // vitesse

	/**
	 * Constructeur
	 * 
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
	 * @param vx
	 *            vitesse horizontale
	 * @param width
	 *            largueur
	 * @param height
	 *            longueur
	 */
	public VerticalBar(double x, double y, double vx, double width, double height) {
		super(x, y);

		this.width = width;
		this.height = height;
		this.vx = vx;
		this.renderer = new VerticalBarRenderer(this);

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

		// Mise à jour de la position
		double newX = x + dt * vx;

		// Quand barre arrive sur un des murs
		if (newX + width / 2 > 320 || newX - width / 2 < 0) {
			vx *= -1;
		} else {
			x = newX;
		}
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	public int getColor() {
		return color;
	}

	/**
	 * Intersection entre obstacle et joueur
	 */
	@Override
	public boolean intersects(Player player) {
		double dx = Math.abs(this.getX() - player.getX());
		double dy = Math.abs(this.getY() - player.getY());

		// Trop loin pour s'intersecter
		if (dx > (player.getRadius()) + this.getWidth() / 2)
			return false;
		if (dy > (player.getRadius()) + this.getHeight() / 2)
			return false;

		if (dx < this.getWidth() / 2 && this.color != player.getColor())
			return true;
		if (dy < this.getHeight() / 2 && this.color != player.getColor())
			return true;

		// Distance du coin
		double distX = dx - this.getWidth() / 2;
		double distY = dy - this.getHeight() / 2;
		double d2 = distX * distX + distY * distY;
		double r2 = player.getRadius() * player.getRadius();

		return d2 <= r2 && this.color != player.getColor();
	}

}
