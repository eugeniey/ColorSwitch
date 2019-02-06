package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'un Square en dessinant un carré coloré sur l'écran.
 */
public class SquareRenderer extends Renderer {

	private Square carre;

	/**
	 * Constructeur
	 * 
	 * @param c
	 *            carré
	 */
	public SquareRenderer(Square c) {
		this.carre = c;
	}

	/**
	 * Affiche le carré
	 */
	@Override
	public void draw(Level level, GraphicsContext context) {

		// Position dans le canvas en y
		double canvasY = Renderer.computeScreenY(level, carre.getY());

		// Couleur
		context.setFill(Renderer.convertColor(carre.getColor()));

		// Dessine carré
		context.fillRect(carre.getX() - carre.getWidth() / 2, canvasY - carre.getWidth() / 2, carre.getWidth(),
				carre.getWidth());
	}

}
