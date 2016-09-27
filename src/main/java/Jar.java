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