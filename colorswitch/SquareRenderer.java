package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'un Square en dessinant un carr� color� sur l'�cran.
 */
public class SquareRenderer extends Renderer {

	private Square carre;

	/**
	 * Constructeur
	 * 
	 * @param c
	 *            carr�
	 */
	public SquareRenderer(Square c) {
		this.carre = c;
	}

	/**
	 * Affiche le carr�
	 */
	@Override
	public void draw(Level level, GraphicsContext context) {

		// Position dans le canvas en y
		double canvasY = Renderer.computeScreenY(level, carre.getY());

		// Couleur
		context.setFill(Renderer.convertColor(carre.getColor()));

		// Dessine carr�
		context.fillRect(carre.getX() - carre.getWidth() / 2, canvasY - carre.getWidth() / 2, carre.getWidth(),
				carre.getWidth());
	}

}
