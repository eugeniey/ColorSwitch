package colorswitch;

/**
 * Création du level 3
 */
public class Level3 extends Level {

	/**
	 * Constructeur
	 * @param screenWidth largeur de l'écran
	 * @param screenHeight hauteur de l'écran
	 */
    public Level3(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        
        VerticalBar obstacle1 = new VerticalBar(x, 0.8 * screenHeight,450,30,70);
        
        Shield shield1 = new Shield(x, 1.5 * screenHeight);

        GrowingCircle obstacle2 = new GrowingCircle(x-60, 2 * screenHeight,300,100,20);
        GrowingCircle obstacle3 = new GrowingCircle(x+60, 2 * screenHeight,300,100,20);   
        GrowingCircle obstacle14 = new GrowingCircle(x, 2.2 * screenHeight,300,100,20);
        
        VerticalBar obstacle4 = new VerticalBar(x-0.05*380,3*screenHeight,100,100,24);
        VerticalBar obstacle5 = new VerticalBar(x-0.05*380,3.10*screenHeight,100,90,24);
        VerticalBar obstacle6 = new VerticalBar(x-0.10*380,3.20*screenHeight,100,80,24);
        VerticalBar obstacle7 = new VerticalBar(x-0.15*380,3.30*screenHeight,100,70,24);
        VerticalBar obstacle8 = new VerticalBar(x-0.20*380,3.40*screenHeight,100,60,24);
        VerticalBar obstacle9 = new VerticalBar(x-0.25*380,3.50*screenHeight,100,50,24);
        VerticalBar obstacle10 = new VerticalBar(x-0.30*380,3.60*screenHeight,100,40,24);

        Square obstacle11 = new Square(x,4.5*screenHeight,80);
        RotatingCircle obstacle12 = new RotatingCircle(x,4.5*screenHeight,3.5,85,30);
        RotatingCircle obstacle13 = new RotatingCircle(x,4.5*screenHeight,3.5,150,30);
        RotatingCircle obstacle15 = new RotatingCircle(x,4.5*screenHeight,3.5,215,30);
        
       
        Square obstacle16 = new Square(x+60,5.5*screenHeight,80);
        GrowingCircle obstacle18 = new GrowingCircle(x, 5.5*screenHeight,230,110,0);
        Square obstacle17 = new Square(x-60,5.5*screenHeight,80);
        
        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);
        obstacles.add(obstacle5);
        obstacles.add(obstacle6);
        obstacles.add(obstacle7);
        obstacles.add(obstacle8);
        obstacles.add(obstacle9);
        obstacles.add(obstacle10);
        obstacles.add(obstacle11);
        obstacles.add(obstacle12);
        obstacles.add(obstacle13);
        obstacles.add(obstacle14);
        obstacles.add(obstacle15);
        obstacles.add(obstacle16);
        obstacles.add(obstacle17);
        obstacles.add(obstacle18);

        // Création des items  
        Potion potion2 = new Potion(x, 2.6 * screenHeight);

        items.add(shield1);
        items.add(potion2);

        victoryMushroom = new Mushroom(screenWidth / 2, 6.3 * screenHeight);
    }
}

