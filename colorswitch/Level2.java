package colorswitch;

/**
 * Création du level 2
 */
public class Level2 extends Level {

	/**
	 * Constructeur
	 * @param screenWidth largeur de l'écran
	 * @param screenHeight hauteur de l'écran
	 */
    public Level2(double screenWidth, double screenHeight) {
        
    	super(screenWidth, screenHeight);
        
    	double x = screenWidth / 2;

        // Création des obstacles 
    	GrowingCircle obstacle1 = new GrowingCircle(x, 0.75*screenHeight, 50, 75, 25);
        Square obstacle2 = new Square(x,1.50*screenHeight,150);
        Square obstacle3 = new Square(x,2.25*screenHeight,150);
        VerticalBar obstacle4 = new VerticalBar(x,3*screenHeight,100,19,24);
        VerticalBar obstacle5 = new VerticalBar(x-0.05*380,3.10*screenHeight,100,19,24);
        VerticalBar obstacle6 = new VerticalBar(x-0.10*380,3.20*screenHeight,100,19,24);
        VerticalBar obstacle7 = new VerticalBar(x-0.15*380,3.30*screenHeight,100,19,24);
        VerticalBar obstacle8 = new VerticalBar(x-0.20*380,3.40*screenHeight,100,19,24);
        VerticalBar obstacle9 = new VerticalBar(x-0.25*380,3.50*screenHeight,100,19,24);
        VerticalBar obstacle10 = new VerticalBar(x-0.30*380,3.60*screenHeight,100,19,24);
        VerticalBar obstacle11 = new VerticalBar(x-0.35*380,3.70*screenHeight,100,19,24);
        VerticalBar obstacle12 = new VerticalBar(x-0.40*380,3.80*screenHeight,100,19,24);
        VerticalBar obstacle13 = new VerticalBar(x-0.45*380,3.90*screenHeight,100,19,24);
        
        
        
        VerticalBar obstacle14 = new VerticalBar(x,4.80*screenHeight,100,19,24);
        VerticalBar obstacle15 = new VerticalBar(x+0.05*380,5.00*screenHeight,100,19,24);
        VerticalBar obstacle16 = new VerticalBar(x+0.10*380,5.20*screenHeight,100,19,24);
        VerticalBar obstacle17 = new VerticalBar(x+0.15*380,5.40*screenHeight,100,19,24);
        VerticalBar obstacle19= new VerticalBar(x+0.25*380,5.80*screenHeight,100,19,24);
        VerticalBar obstacle20 = new VerticalBar(x+0.30*380,6.00*screenHeight,100,19,24);
        VerticalBar obstacle21 = new VerticalBar(x+0.35*380,6.20*screenHeight,100,19,24);

        RotatingCircle obstacle22 = new RotatingCircle(x,7.25*screenHeight,3,50,20);
        RotatingCircle obstacle23 = new RotatingCircle(x,7.25*screenHeight,-3,50,20);
        
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
        obstacles.add(obstacle19);
        obstacles.add(obstacle20);
        obstacles.add(obstacle21);
        obstacles.add(obstacle22);
        obstacles.add(obstacle23);      
        
        // Création des items
        Shield shield1 = new Shield(x, 5.60 * screenHeight);
        Potion potion1 = new Potion(x, 4.25 * screenHeight);
        Potion potion2 = new Potion(x, 6.75 * screenHeight);

        items.add(shield1);
        items.add(potion1);
        items.add(potion2);
        
        victoryMushroom = new Mushroom(screenWidth / 2, 7.25* screenHeight);
    }
}
