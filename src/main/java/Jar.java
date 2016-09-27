import java.util.Random;

public class Jar {
	private String mItemType;
	private int mMaxItems;
	private int mNumItems;
	private int mNumGuesses;
	
	public Jar(String itemType, int maxItems) {
		mItemType = itemType;
		mMaxItems = maxItems;
		
		Random rand = new Random();
		mNumItems = rand.nextInt(maxItems)+1;
	}

	public boolean makeGuess(int guess) {
		// check if guess is within bounds
		if (guess <= mMaxItems && guess > 0) {
			mNumGuesses++;
			if (guess > mNumItems)
				System.out.println("Your guess is too high");
			else if (guess < mNumItems)
				System.out.println("Your guess is too low");
		} else if (guess > mMaxItems) {
			System.out.printf("Your guess must be less than %d!%n",mMaxItems);
		} else if (guess == 0) {
			System.out.println("There's obviously at least one!");
		} else {
			System.out.println("How is that even possible?");
		}
		return guess == mNumItems;
	}
	
	public int getNumGuesses() {
		return mNumGuesses;
	}
	
	public String getItemType() {
		return mItemType;
	}

	public int getMaxItems() {
		return mMaxItems;
	}

	public int getNumItems() {
		return mNumItems;
	}
	
	
}