package colorswitch;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Classe qui permet d'animer des objets par succession d'images. <br/>
 * Cette classe servira à animer le champignon.
 */
public class AnimationRenderer extends Renderer {

	private String prefix; // nom des images
	private int number; // nombre d'image pour l'animation
	private double frameRate; // nombre d'images affichées par seconde
	private Entity entity; // entité de classe Entity
	private Image[] frames; // tableau des images

	/**
	 * Constructeur
	 * 
	 * @param entity
	 *            entité de classe Entity
	 * @param number
	 *            nombre d'image pour l'animation
	 * @param prefix
	 *            nom des images
	 * @param framerate
	 *            nombre d'images affichées par seconde
	 */
	public AnimationRenderer(Entity entity, int number, String prefix, double framerate) {

		// Initialisation
		this.prefix = prefix;
		this.entity = entity;
		this.number = number;
		this.frameRate = framerate;

		// Créer tableau de frame de grandeur du nombre d'image
		this.frames = new Image[number];

		// Rempli le tableau frames des images d'animation
		for (int i = 1; i <= number; i++) {
			String s = String.valueOf(i); // met le nombre en String
			frames[i - 1] = new Image(this.prefix + s + ".png");
		}
	}

	/**
	 * Permet d'afficher l'animation
	 */
	@Override
	public void draw(Level level, GraphicsContext context) {

		// Frame à chaque delta temps
		int frame = (int) (System.nanoTime() * frameRate);

		// Image qui s'affiche selon la vitesse requise
		Image img = frames[frame % frames.length];

		// Position en x et y
		double x = entity.getX();
		double y = Renderer.computeScreenY(level, entity.getY());

		// Dessiner objet selon position et dimension avec l'image requise
		context.drawImage(img, x - entity.getWidth() / 2, y - entity.getHeight() / 2, entity.getWidth(),
				entity.getHeight());
	}

}
