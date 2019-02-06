package colorswitch;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Fait le rendu d'une Entity sur l'écran en affichant une image
 */
public class ImageRenderer extends Renderer {

	private Image img;
	private Entity entity;

	/**
	 * Constructeur
	 * 
	 * @param name
	 *            nom du fichier de l'image
	 * @param e
	 *            Entité
	 */
	public ImageRenderer(String name, Entity e) {
		img = new Image("/" + name + ".png");
		this.entity = e;
	}

	/**
	 * Affichage du GrowingCircle
	 */
	@Override
	public void draw(Level level, GraphicsContext context) {

		// Position x,y
		double x = entity.getX();
		double y = Renderer.computeScreenY(level, entity.getY());

		// Affiche image
		context.drawImage(img, x - entity.getWidth() / 2, y - entity.getHeight() / 2, entity.getWidth(),
				entity.getHeight());
	}

}
