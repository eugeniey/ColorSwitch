package colorswitch;

/**
 * Item : Shield protecteur. Repr�sent� par une image de sorci�re sur un b�ton
 * (?) qui dispara�t lorsque joueur interagit La sorci�re devient invincible
 * pendant 3 secondes
 */
public class Shield extends Item {

	private boolean used = false; // bolean d'utilisation
	private int rayonShield; // rayon de l'image blanche ronde

	public Shield(double x, double y) {
		super(x, y);

		this.rayonShield = 32; // 32 pixel de rayon

		this.renderer = new ImageRenderer("shield", this);
	}

	/**
	 * V�rifie si collision enter potion et joueur
	 */
	@Override
	public boolean intersects(Player player) {
		return !used && player.getX() - player.getRadius() < this.getX() + rayonShield
				&& player.getX() + player.getRadius() > this.getX() - rayonShield
				&& player.getY() - player.getRadius() < this.getY() + rayonShield
				&& player.getY() + player.getRadius() > this.getY() - rayonShield;
	}

	@Override
	public void handleCollision(Player player, Game game) {
		used = true;
		this.renderer = new ImageRenderer("noir", this);

		game.setHasShield(true);
	}

	@Override
	public double getWidth() {
		return 48;
	}

	@Override
	public double getHeight() {
		return 48;
	}

	// Ne fait rien
	@Override
	public void tick(double dt) {
	}

}
