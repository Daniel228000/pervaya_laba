import java.util.Random;

public class RandomGenerator {

    public Integer getRandomBetween(Integer start, Integer end) {
        return new Random().nextInt(end - start) + start;
    }

    public int nextInt(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        int next = (int) ((((8682522807148012L ^ System.nanoTime()) * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1)) >> 17);

        return next % bound;
    }
}
