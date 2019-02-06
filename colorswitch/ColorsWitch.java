package colorswitch;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import java.util.List;
import javafx.scene.effect.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.lang.String;
import java.lang.Exception;
import javafx.scene.control.Button;

/**
 * Classe principale qui d�finit la vue. <br/>
 * C'est ici que tout l'affichage graphique se fait.
 * 
 * @author Eug�nie Yockell
 */
public class ColorsWitch extends Application {

	public static final double WIDTH = 320, HEIGHT = 480; // dimensions
	private Controller controller;   // controleur de classe Controleur
	private GraphicsContext context; // pour l'affichage graphique
	private static Text messageFin;  // message affich� fin d'une partie

	/**
	 * Classe main qui enclenche le jeu.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * D�finit les bases du jeu
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		controller = new Controller();

		// SplashScreen: affichage de d�but de partie
		HBox splashScreenRoot = new HBox();
		Scene splashScreenScene = new Scene(splashScreenRoot, WIDTH, HEIGHT);
		ImageView splashView = new ImageView(new Image("/splashScreen.png"));
		splashView.setFitHeight(HEIGHT + 10);
		splashView.setFitWidth(WIDTH + 10);
		splashScreenRoot.getChildren().add(splashView);

		Text messageBienvenue1 = new Text("Welcome to Colors Witch");
		Text messageBienvenue2 = new Text("Press any key to start");
		messageBienvenue1.setFill(Color.BLACK);
		messageBienvenue1.setFont(Font.font(null, FontWeight.BLACK, 25));
		Reflection r1 = new Reflection(); // met r�flection sur le texte
		r1.setFraction(0.8f);
		messageBienvenue1.setEffect(r1);
		messageBienvenue2.setFill(Color.BLACK);
		messageBienvenue2.setFont(Font.font(null, FontWeight.BOLD, 18));

		StackPane pane = new StackPane();
		pane.getChildren().add(splashView);
		pane.getChildren().add(messageBienvenue1);
		pane.getChildren().add(messageBienvenue2);
		StackPane.setAlignment(messageBienvenue1, Pos.TOP_CENTER);
		StackPane.setAlignment(messageBienvenue2, Pos.CENTER);
		splashScreenRoot.getChildren().add(pane);
		
		// Cr�ation du message de fin
		messageFin = new Text("");
		messageFin.setCache(true);
		messageFin.setFill(Color.CHARTREUSE);
		messageFin.setFont(Font.font(null, FontWeight.BOLD, 18));
		Reflection r = new Reflection(); // met r�flection sur le texte
		r.setFraction(0.6f);
		messageFin.setEffect(r);
		messageFin.setX(13); // position du message en x
		messageFin.setY(37); // position du message en y

		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		Pane root = new Pane(canvas);
		context = canvas.getGraphicsContext2D(); // retourne le GraphicContext

		// G�re mouvement des obstacles et du joueur
		AnimationTimer timer = new AnimationTimer() {
			private long lastTime = System.nanoTime();

			@Override
			public void handle(long now) {
				controller.tick((now - lastTime) * 1e-9);

				context.setFill(Color.BLACK);
				context.fillRect(0, 0, WIDTH, HEIGHT);

				List<Entity> entities = controller.getEntities();

				// Dessiner chaque entit� de jeu
				for (Entity e : entities) {
					e.getRepresentation().draw(controller.getCurrentLevel(), context);
				}
				lastTime = now;
			}
		};
		timer.start();

		// D�finit sc�ne du jeu
		Scene scene = new Scene(root, WIDTH, HEIGHT);

		// �v�nement de utilisateur qui influence jeu
		scene.setOnKeyPressed((event) -> {
			// Lorsque Space Bar enclench�, mouvement du joueur
			if (event.getCode() == KeyCode.SPACE) {
				controller.spaceTyped();
			}

			// Touche Tab change invincibilit�
			if (event.getCode() == KeyCode.TAB) {
				// Si joueur d�j� invincible, ne l'est plus
				if (controller.getPlayerInvincible()) {
					controller.setPlayerInvicible(false);
				}
				// Sinon devient invincible
				else {
					controller.setPlayerInvicible(true);
				}
			}
		});

		// Lorsqu'une touche activ� sur splashScreen, le jeu commence
		splashScreenScene.setOnKeyPressed((event) -> {
			primaryStage.setScene(scene);
		});
		
		// Setting de la sc�ne
		root.getChildren().add(messageFin);
		primaryStage.setTitle("Colors Witch");
		primaryStage.setScene(splashScreenScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	/**
	 * Permet de modifier le message affich�
	 * 
	 * @param phrase
	 *            String
	 */
	public static void setMessage(String phrase) {
		messageFin.setText(phrase);
	}

}
