package colorswitch;

/**
 * Obstacle simple : un carré qui change de couleur à toutes les 2 secondes.
 */
public class Square extends Obstacle {

	private double width;
	private double timeSinceColorChange = 0;

	/**
	 * Constructeur
	 * 
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
	 * @param longueur
	 *            dimension du carré
	 */
	public Square(double x, double y, double longueur) {
		super(x, y);

		this.width = longueur;
		this.renderer = new SquareRenderer(this);

		this.color = (int) (Math.random() * 4);
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return width;
	}

	/**
	 * Fonction appelée à chaque frame pour mettre à jour les attributs de l'entité.
	 * Ici change la couleur
	 * 
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	@Override
	public void tick(double dt) {
		timeSinceColorChange += dt;

		if (timeSinceColorChange > 2) {
			color = (color + 1) % 4;
			timeSinceColorChange = 0;
		}
	}

	public int getColor() {
		return color;
	}

	/**
	 * Gère intersection entre joueur et carré
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

		// Biensur
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
