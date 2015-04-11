package services;

public class RandomService {
	private static RandomService instance;
	
	public RandomService getInstance(){
		if(instance == null)
			instance = new RandomService(); 
		return instance;
	}
	
	private RandomService(){
	
	}
	
}
