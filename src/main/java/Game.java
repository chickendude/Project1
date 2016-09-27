public class Game {
    public static void main(String[] args) {
    	System.out.printf("Welcome to Jar Game!%n"
    					+  "====================%n");
    	// keep track of whether or not we should continue playing
    	boolean playing = true;
    	// repeat main game loop until exit
    	while(playing) {
    		playing = playGame();
    	}
    }

    public static boolean playGame() {
    	Prompter prompter = new Prompter();
    	String[] menuChoices = {"Single-round game","Multi-round game","Exit"};  
		int choice = prompter.showMenu("Please select your game type:",menuChoices);
    	switch (choice) {
    	case 1:
    		singleRound();
    		break;
    	case 2:
    		multiRound();
    		break;
    	case 3:
    		return false;
    	default:
    		System.out.println("Invalid number, please try again");
    	}
    	return true;
    }

    public static void singleRound() {
    	Jar jar = new Jar("blocks",10);

    }

    public static void multiRound() {

    }
}
