package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'un Player sur l'écran en dessinant un cercle coloré
 */
public class PlayerRenderer extends Renderer {

	private Player player;

	/**
	 * Constructeur
	 * 
	 * @param player
	 *            joueur
	 */
	public PlayerRenderer(Player player) {
		this.player = player;
	}

	/**
	 * Affichage du Player
	 */
	@Override
	public void draw(Level level, GraphicsContext context) {

		// Position y dans canvas
		double canvasY = Renderer.computeScreenY(level, player.getY());

		// Couleur du joueur
		context.setFill(Renderer.convertColor(player.getColor()));

		// Dessine joueur
		context.fillOval(player.getX() - player.getRadius(), canvasY - player.getRadius(), 2 * player.getRadius(),
				2 * player.getRadius());
	}

}
