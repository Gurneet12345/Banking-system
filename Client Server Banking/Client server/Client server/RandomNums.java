import java.util.Random;

public class RandomNums {
    private Random random;

    public RandomNums() {
        random = new Random();
    }

    public int getRandomNumber() {
        return random.nextInt(100); // Generate a random number between 0 and 99
    }
}
