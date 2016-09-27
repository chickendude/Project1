import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompter {
	// for string input
	BufferedReader mBr;
	
	public Prompter() {
		 mBr = new BufferedReader(new InputStreamReader(System.in));
	}

	// prints a menu with options and returns an integer of the selected option
	public int showMenu(String title, String[] options) {
		printTitle(title);
		for (int x = 0; x < options.length; x++) {
			System.out.printf("%d. %s%n",x+1,options[x]);
		}
		return getInt();
	}

	public void printTitle(String title) {
		clearScreen();
		System.out.println(title);
		for(int x = 0; x < title.length(); x++) {
			System.out.print("=");
		}
		System.out.println();
	}

	public int getGuess() {
		System.out.print("Guess: ");
		return getInt();
	}
	
	public void pause() {
		System.out.print("Press [enter] to continue...");
		getString();
	}
	
	// method to clear the screen (http://stackoverflow.com/a/32295974)
	private void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}

	public String getString() {
		String input = "";
		try {
			input = mBr.readLine();
		} catch(IOException ioe) {
			System.out.println("Input error:");
			ioe.printStackTrace();
		}
		return input;
	}
	
	public int getInt() {
		String input = getString();
		int value = -1;
		try {
			value = Integer.parseInt(input);
		} catch(NumberFormatException nfe) {
			System.out.println("Invalid number was input.");
			nfe.printStackTrace();
		}
		return value;
	}
}
