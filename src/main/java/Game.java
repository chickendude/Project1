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
    	String[] menuChoices = {"New Game","Exit"};
		int choice = prompter.showMenu("Please select your game type:",menuChoices);
    	switch (choice) {
    	case 1:
    		newGame(prompter);
    		break;
    	case 2:
    		return false;
    	default:
    		System.out.println("Invalid number, please try again");
    	}
    	return true;
    }

    public static void newGame(Prompter prompter) {
    	// administrator
    	prompter.printTitle("Administrator");
    	System.out.print("What type of item? ");
    	String itemName = prompter.getString();

    	int maxItems = -1;
    	while(maxItems < 1) {
	    	System.out.printf("What is the maximum number of %ss? ",itemName);
	    	maxItems = prompter.getInt();
	    	if (maxItems < 1)
	    		System.out.println("Please enter a positive number");
    	}
    	Jar jar = new Jar(itemName,maxItems);
    	// start of player's turn
    	prompter.printTitle("Player");
    	System.out.printf("Welcome, player! Your goal is to guess how many %ss there are in the jar. It is a number between 1 and %d.%nAre you ready?%n",jar.getItemType(), jar.getMaxItems());
    	boolean correct = false;
    	while(!correct) {
    		int guess = prompter.getGuess(jar.getNumGuesses(),jar.getMaxItems());
    		correct = jar.makeGuess(guess);
    	}
    	// display how many attempts it took
    	String attempts = "attempt";
    	if (jar.getNumGuesses() > 1)
    		attempts = "attempts";
    	System.out.printf("You got it in %d %s!%n",jar.getNumGuesses(),attempts);
    	prompter.pause();
    }
}
