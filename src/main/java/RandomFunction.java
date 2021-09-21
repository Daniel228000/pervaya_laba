import java.util.Random;

public class RandomFunction {

    public Integer getRandomBetween(Integer start, Integer end) {
        return new Random().nextInt(end - start) + start;
    }
}
