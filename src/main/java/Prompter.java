import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompter {
	// for string input
	BufferedReader mBr;
	
	public Prompter() {
		 mBr = new BufferedReader(new InputStreamReader(System.in));
	}

	public int showMenu(String title, String[] options) {
		clearScreen();
		System.out.println(title);
		for(int x = 0; x < title.length(); x++) {
			System.out.print("=");
		}
		System.out.println();
		for (int x = 0; x < options.length; x++) {
			System.out.printf("%d. %s%n",x+1,options[x]);
		}
		return getInt();
	}
	
	// method to clear the screen (http://stackoverflow.com/a/32295974)
	private void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}

	private int getInt() {
		String input = "";
		try {
			input = mBr.readLine();
		} catch(IOException ioe) {
			System.out.println("Input error:");
			ioe.printStackTrace();
		}
		int value = Integer.parseInt(input);
		return value;
	}

	
}
