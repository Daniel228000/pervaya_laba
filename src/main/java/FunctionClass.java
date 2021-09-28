import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionClass {

    private final List<Integer> randomInts;

    public FunctionClass(Integer startBound, Integer endBound) {
        RandomGenerator randomGenerator = new RandomGenerator();
        this.randomInts = IntStream.range(0, 10)
                .map(value -> randomGenerator.getRandomBetween(startBound, endBound))
                .boxed()
                .collect(Collectors.toList());
    }

    public FunctionClass(List<Integer> list) {
        this.randomInts = list;
    }

    public double average() {
        return randomInts.stream().mapToDouble(Integer::doubleValue).sum() / randomInts.size();
    }

    public BigDecimal dispersion() {
        double average = average();

        return BigDecimal.valueOf(randomInts.stream()
                .mapToDouble(xK -> Math.pow(xK - average, 2))
                .sum() / randomInts.size());
    }

    public double standardDeviation() {
        return Math.sqrt(dispersion().doubleValue());
    }

    public Double rootMeanSquareError() {
        return Math.sqrt(randomInts.stream()
                .mapToDouble(xK -> Math.pow(xK, 2))
                .sum() / randomInts.size());
    }

    public Double asymmetry() {
        double average = average();

        return (randomInts.stream()
                .mapToDouble(xK -> Math.pow(xK - average, 3))
                .sum() / randomInts.size()) / Math.pow(standardDeviation(), 3);
    }

    public Double excess() {
        double average = average();

        return (randomInts.stream()
                .mapToDouble(xK -> Math.pow(xK - average, 4))
                .sum() / randomInts.size()) / Math.pow(standardDeviation(), 4) - 3;
    }
}
