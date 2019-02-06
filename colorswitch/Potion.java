package colorswitch;

/**
 * Item : Potion magique. Repr�sent� par une image de potion qui change lorsque
 * joueur interagit Fait changer la sorci�re de couleur
 */
public class Potion extends Item {

	private boolean used = false; // boolean d'utilisation

	/**
	 * Constructeur
	 * 
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
	 */
	public Potion(double x, double y) {
		super(x, y);

		this.renderer = new ImageRenderer("potion", this);
	}

	// Ne fait rien
	@Override
	public void tick(double dt) {
	}

	@Override
	public double getWidth() {
		return 48;
	}

	@Override
	public double getHeight() {
		return 48;
	}

	/**
	 * G�re collision avec joueur, affiche le potion renvers�
	 */
	@Override
	public void handleCollision(Player player, Game game) {
		used = true;
		this.renderer = new ImageRenderer("empty-potion", this);
		player.randomizeColor();
	}

	/**
	 * V�rifie si collision enter potion et joueur
	 */
	@Override
	public boolean intersects(Player player) {
		return !used && player.getX() - player.getRadius() < this.getX() + this.getWidth() / 2
				&& player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
				&& player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
				&& player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
	}

}
