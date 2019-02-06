package colorswitch;

import java.util.List;

/**
 * Controleur pour le jeu : fait le pont entre la vue et les mod�les.
 */
public class Controller {

	private Game game; // jeu de classe Game (le mod�le)
	private int level; // level dans lequel le jeu commence
	private double compteur = 0; // agit comme un chronom�tre
	private Boolean starter = false; // pour d�marrer chronom�tre

	/**
	 * Constructeur
	 */
	public Controller() {
		this.level=1;
		// Instancie un jeu
		this.game = new Game(ColorsWitch.WIDTH, ColorsWitch.HEIGHT, level);		
	}

	/**
	 * Getter des entit�s du jeu
	 * 
	 * @return
	 */
	public List<Entity> getEntities() {
		return this.game.getEntities();
	}

	/**
	 * Fonction appel�e � chaque frame du jeu.
	 * 
	 * @param dt
	 *            Delta-temps exprim� en secondes
	 */
	public void tick(double dt) {

		// Si la partie est finie
		if (this.game.isGameOver()) {
			// Si gagne le niveau
			if (this.game.hasWon()) {
				level++;

				// Si le jeu est finit
				if (level > 4) {
					game.setMessageWonGame(); // message de partie gagn�
				} else {
					game.setMessageNextLevel(level); // message de prochain level
				}
			}
			// La vue doit chang� de message
			ColorsWitch.setMessage(game.getMessage());

			// On change une action dans le message, on peut commencer le chronom�tre
			starter = true;

			// Nouvelle partie avec prochain niveau
			this.game = new Game(ColorsWitch.WIDTH, ColorsWitch.HEIGHT, level);

		} else { // Partie continue, rien de gagn� ou perdu
			this.game.tick(dt);
		}

		// Chronom�tre pour changer le message apr�s 2 secondes
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
	 * Fonction appel�e lorsque la barre espace est enfonc�e.
	 */
	public void spaceTyped() {
		this.game.jump();
	}

	/**
	 * Getter de l'inviciblit� de joueur
	 * 
	 * @return Boolean
	 */
	public boolean getPlayerInvincible() {
		return this.game.getIsInvincible();
	}

	/**
	 * Setter de l'inviciblit� du joueur
	 * 
	 * @param vraifaux
	 */
	public void setPlayerInvicible(boolean vraifaux) {
		this.game.setIsInvincible(vraifaux);
	}
	
}
