package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu de l'obstacle GrowingCircle sur l'écran en dessinant un cercle
 * coloré de différents rayons
 */
public class GrowingCircleRenderer extends Renderer {

	private GrowingCircle cercle;
	private Level level;

	/**
	 * Constructeur
	 * 
	 * @param c
	 *            GrowingCircle
	 */
	public GrowingCircleRenderer(GrowingCircle c) {
		this.cercle = c;
	}

	/**
	 * Affichage du GrowingCircle
	 */
	@Override
	public void draw(Level level, GraphicsContext context) {

		this.level = level;

		// Position y dans canvas
		double canvasY = Renderer.computeScreenY(level, cercle.getY());

		// Couleur
		context.setFill(Renderer.convertColor(cercle.getColor()));

		// Dessine cercle
		context.fillOval(cercle.getX() - cercle.getWidth() / 2, // on divise par deux pour avoir le rayon
				canvasY - cercle.getWidth() / 2, cercle.getWidth(), cercle.getHeight());
	}

	/**
	 * @return le largeur de l'écran
	 */
	public double getScreenWidth() {
		return level.getScreenWidth();
	}

}
