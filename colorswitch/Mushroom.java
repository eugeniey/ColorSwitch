package colorswitch;

/**
 * Définit les actions et caractérisque du champignon. <br/>
 * Ramasser un champignon permet de gagner le niveau actuel.
 */
public class Mushroom extends Item {

	/**
	 * Constructeur
	 * 
	 * @param x
	 * @param y
	 */
	public Mushroom(double x, double y) {
		super(x, y);

		// Le champignon est animé
		this.renderer = new AnimationRenderer(this, 26, "mushroom_animation", 15 * 1e-9);
	}

	/**
	 * Champignon ne fait rien
	 */
	@Override
	public void tick(double dt) {
	}

	@Override
	public double getWidth() {
		return 64;
	}

	@Override
	public double getHeight() {
		return 64;
	}

	/**
	 * Quand joueur à le champignon, gagne le level
	 */
	@Override
	public void handleCollision(Player player, Game game) {
		game.win();
	}

	/**
	 * Définit l'intersection
	 */
	@Override
	public boolean intersects(Player player) {
		return player.getX() - player.getRadius() < this.getX() + this.getWidth() / 2
				&& player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
				&& player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
				&& player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
	}

}
