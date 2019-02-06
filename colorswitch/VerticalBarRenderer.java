package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu de l'obstacle VerticalBar sur l'écran en dessinant un cercle
 * coloré
 */
public class VerticalBarRenderer extends Renderer {

	private VerticalBar barre;
	private Level level;

	/**
	 * Constructeur
	 * 
	 * @param b
	 *            VerticalBar
	 */
	public VerticalBarRenderer(VerticalBar b) {
		this.barre = b;
	}

	/**
	 * Affiche l'obstacle
	 */
	@Override
	public void draw(Level level, GraphicsContext context) {

		this.level = level;

		// Position en y dans le canvas
		double canvasY = Renderer.computeScreenY(level, barre.getY());

		// Couleur
		context.setFill(Renderer.convertColor(barre.getColor()));

		// Dessine le rectangle
		context.fillRect(barre.getX() - barre.getWidth() / 2, canvasY - barre.getHeight() / 2, barre.getWidth(),
				barre.getHeight());
	}

	public double getScreenWidth() {
		return level.getScreenWidth();
	}

}
