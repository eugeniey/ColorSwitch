package colorswitch;

import java.util.List;

/**
 * Controleur pour le jeu : fait le pont entre la vue et les modèles.
 */
public class Controller {

	private Game game; // jeu de classe Game (le modèle)
	private int level; // level dans lequel le jeu commence
	private double compteur = 0; // agit comme un chronomètre
	private Boolean starter = false; // pour démarrer chronomètre

	/**
	 * Constructeur
	 */
	public Controller() {
		this.level=1;
		// Instancie un jeu
		this.game = new Game(ColorsWitch.WIDTH, ColorsWitch.HEIGHT, level);		
	}

	/**
	 * Getter des entités du jeu
	 * 
	 * @return
	 */
	public List<Entity> getEntities() {
		return this.game.getEntities();
	}

	/**
	 * Fonction appelée à chaque frame du jeu.
	 * 
	 * @param dt
	 *            Delta-temps exprimé en secondes
	 */
	public void tick(double dt) {

		// Si la partie est finie
		if (this.game.isGameOver()) {
			// Si gagne le niveau
			if (this.game.hasWon()) {
				level++;

				// Si le jeu est finit
				if (level > 4) {
					game.setMessageWonGame(); // message de partie gagné
				} else {
					game.setMessageNextLevel(level); // message de prochain level
				}
			}
			// La vue doit changé de message
			ColorsWitch.setMessage(game.getMessage());

			// On change une action dans le message, on peut commencer le chronomètre
			starter = true;

			// Nouvelle partie avec prochain niveau
			this.game = new Game(ColorsWitch.WIDTH, ColorsWitch.HEIGHT, level);

		} else { // Partie continue, rien de gagné ou perdu
			this.game.tick(dt);
		}

		// Chronomètre pour changer le message après 2 secondes
		if (starter) {
			compteur += dt;
			if (compteur > 2) {
				ColorsWitch.setMessage("");
				compteur = 0;
				starter = false;
			}
		}
	}

	/**
	 * Getter du level
	 * 
	 * @return level
	 */
	public Level getCurrentLevel() {
		return this.game.getLevel();
	}

	/**
	 * Fonction appelée lorsque la barre espace est enfoncée.
	 */
	public void spaceTyped() {
		this.game.jump();
	}

	/**
	 * Getter de l'inviciblité de joueur
	 * 
	 * @return Boolean
	 */
	public boolean getPlayerInvincible() {
		return this.game.getIsInvincible();
	}

	/**
	 * Setter de l'inviciblité du joueur
	 * 
	 * @param vraifaux
	 */
	public void setPlayerInvicible(boolean vraifaux) {
		this.game.setIsInvincible(vraifaux);
	}
	
}
