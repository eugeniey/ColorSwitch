package colorswitch;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Classe abstraite
 *
 * D�finit quelques fonctions statiques utiles lors du rendu
 */
public abstract class Renderer {

	/**
	 * Fonction abstraite qui permet dessiner l'objet
	 * 
	 * @param level
	 * @param context
	 */
	public abstract void draw(Level level, GraphicsContext context);

	/**
	 * Converti un num�ro de couleur 0 � 3 en une couleur de JavaFX
	 *
	 * @param color
	 *            le num�ro de couleur
	 * @return la couleur associ�e
	 */
	public static Color convertColor(int color) {
		switch (color) {
		case 0:
			return Color.LIGHTCORAL;
		case 1:
			return Color.SPRINGGREEN;
		case 2:
			return Color.DODGERBLUE;
		case 3:
			return Color.ORANGE;
		}

		throw new IllegalArgumentException("Couleur inconnue");
	}

	/**
	 * Calcule la position sur l'�cran d'une entit� � partir de sa position Y dans
	 * le niveau.
	 *
	 * @param level
	 *            Niveau actuel
	 * @param levelY
	 *            Coordonn�e Y dans le niveau
	 * @return La coordonn�e Y dans le syst�me de coordonn�es de la fen�tre JavaFX
	 */
	public static double computeScreenY(Level level, double levelY) {

		double y = levelY - level.getScroll();

		return level.getScreenHeight() - y;
	}
}
