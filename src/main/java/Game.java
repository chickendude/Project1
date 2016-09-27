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
    		singleRound(prompter);
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

    public static void singleRound(Prompter prompter) {
    	// administrator
    	prompter.printTitle("Administrator");
    	System.out.print("What type of item? ");
    	String itemName = prompter.getString();
    	System.out.printf("What is the maximum number of %ss? ",itemName);
    	int maxItems = prompter.getInt();
    	Jar jar = new Jar(itemName,maxItems);
    	// start of player's turn
    	prompter.printTitle("Player");
    	System.out.printf("Welcome, player! Your goal is to guess how many %ss there are in the jar. It is a number between 1 and %d.%nAre you ready?%n",jar.getItemType(), jar.getMaxItems());
    	prompter.pause();

    	boolean correct = false;
    	while(!correct) {
    		int guess = prompter.getGuess();
    		correct = jar.makeGuess(guess);
    	}
    	System.out.println("You win!");
    	prompter.pause();
    }

    public static void multiRound() {

    }
}
