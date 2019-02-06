package colorswitch;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui d�finit le mod�le du jeu ainsi que son �tat. <br/>
 * D�finit aussi certain �tat du joueur.
 */
public class Game {

	private Level level;
	private Player player;
	private String message;

	/**
	 * Dimensions de l'�cran
	 */
	private double screenWidth, screenHeight;

	/**
	 * Indique si la partie est termin�e/gagn�e
	 */
	private boolean gameOver = false;
	private boolean hasWon = false;

	private boolean isInvincible = false; // si player invincible
	private boolean hasShield = false; // si player a le shield
	private double compteurSec; // compteur de temps

	/**
	 * Cr�e une partie dans le niveau levelNumber.
	 *
	 * @param screenWidth
	 *            largeur de l'�cran
	 * @param screenHeight
	 *            hauteur de l'�cran
	 * @param levelNumber
	 *            num�ro du niveau
	 */
	public Game(double screenWidth, double screenHeight, int levelNumber) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.message = ""; // message String vide

		// Instancie joueur
		player = new Player(screenWidth / 2, 200, 15);

		// Selon le level entr�
		switch (levelNumber) {
		case 1:
			level = new Level1(screenWidth, screenHeight);
			break;
		case 2:
			level = new Level2(screenWidth, screenHeight);
			break;
		case 3:
			level = new Level3(screenWidth, screenHeight);
			break;
		case 4:
			level = new Level4(screenWidth, screenHeight);
			break;
		case 5:
			level = new Level5(screenWidth, screenHeight);
			break;
		default:
			throw new IllegalArgumentException("Niveau inconnu");
		}
	}

	/**
	 * Fonction appel�e � chaque frame
	 *
	 * @param dt
	 *            Delta-Temps (en secondes)
	 */
	public void tick(double dt) {
		level.tick(dt);  // renouvelle level
		player.tick(dt); // renouvelle joueur

		if (player.getY() - player.getRadius() < level.getScroll()) {
			// Emp�che la balle de sortir de l'�cran
			player.setY(level.getScroll() + player.getRadius());
		} else if (player.getY() - level.getScroll() > screenHeight / 2) {
			// Scroll le level verticalement si n�cessaire
			level.incrementScroll(player.getY() - level.getScroll() - screenHeight / 2);
		}

		// Gestion des collisions avec les �l�ments (items/obstacles/...) du niveau
		for (LevelElement element : level.getEntities()) {
			if (element.intersects(player)) {
				element.handleCollision(player, this);
			}
		}

		// Condition de temps pour le shield
		if (hasShield) {
			compteurSec += dt; // commence le compteur
			if (compteurSec >= 3.0) { // apr�s 3 secondes
				this.hasShield = false;
			}
		}
	}

	/**
	 * @return les entit�s �afficher � l'�cran
	 */
	public List<Entity> getEntities() {
		List<Entity> entities = new ArrayList<>();

		entities.addAll(level.getEntities());
		entities.add(player);

		return entities;
	}

	/**
	 * @return le level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Faire sauter le joueur
	 */
	public void jump() {
		player.jump();
	}

	/**
	 * Si le joueur perd
	 */
	public void loose() {

		// Message de fin
		message = "You loose... Too bad, you noob";

		// Si le player est invincible, on ne retourne rien. La partie continue
		if (isInvincible || hasShield) {
			return;
		}
		this.gameOver = true; // partie fini
	}

	/**
	 * Message de prochain niveau
	 * 
	 * @param levelNumber
	 */
	public void setMessageNextLevel(int levelNumber) {
		message = "You won xD You're at level " + levelNumber;
	}

	/**
	 * Message de fin de jeu
	 */
	public void setMessageWonGame() {
		message = "You win the game, champ ! :)";
	}

	/**
	 * Si le joueur gagne
	 */
	public void win() {
		this.hasWon = true;
		this.gameOver = true;
	}

	/**
	 * Indique si la partie est gagn�e
	 * 
	 * @return
	 */
	public boolean hasWon() {
		return hasWon;
	}

	/**
	 * Indique si la partie est termin�e
	 * 
	 * @return
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * Setter de si le joueur est invincible ou non
	 * 
	 * @param vraiFaux
	 */
	public void setIsInvincible(boolean vraiFaux) {
		this.isInvincible = vraiFaux;
	}

	/**
	 * @return Boolean si joueur invincible
	 */
	public boolean getIsInvincible() {
		return this.isInvincible;
	}

	/**
	 * Setter si le joueur poss�de shield
	 * 
	 * @param Boolean
	 */
	public void setHasShield(boolean vraiFaux) {
		this.hasShield = vraiFaux;
	}

	/**
	 * Getter du message courant de la partie
	 */
	public String getMessage() {
		return message;
	}

}
