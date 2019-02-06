package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu de l'obstacle RotatingCircle sur l'écran en dessinant un cercle
 * coloré
 */
public class RotatingCircleRenderer extends Renderer {

	private RotatingCircle cercle;
	private Level level;

	/**
	 * Constructeur
	 * 
	 * @param c
	 *            RotatingCircle
	 */
	public RotatingCircleRenderer(RotatingCircle c) {
		this.cercle = c;
	}

	/**
	 * Affichage de l'obstacle (un cercle)
	 */
	@Override
	public void draw(Level level, GraphicsContext context) {

		this.level = level;

		// Position y dans le canvas
		double canvasY = Renderer.computeScreenY(level, cercle.getY());

		// Définit couleur
		context.setFill(Renderer.convertColor(cercle.getColor()));

		// Dessine l'obstacle
		context.fillOval(cercle.getX() - cercle.getWidth() / 2, canvasY - cercle.getWidth() / 2, cercle.getWidth(),
				cercle.getHeight());
	}

	public double getScreenWidth() {
		return level.getScreenWidth();
	}

}
