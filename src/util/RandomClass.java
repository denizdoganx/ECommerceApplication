package util;

import java.util.Random;

public class RandomClass {

	private static RandomClass rndC = null;
	private Random rnd;
	
	private RandomClass() {
		rnd = new Random();
	}
	
	public static RandomClass getInstance() {
		if(rndC == null) {
			rndC = new RandomClass();
		}
		return rndC;
	}
	
	public int getRandomNumber(int min, int max) {		
		return rnd.nextInt(max-min + 1) + min ;
	}
	
	public int getRandomNumber(int bound) {
		return rnd.nextInt(bound);
	}
}
