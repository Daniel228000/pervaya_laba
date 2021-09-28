import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

    }

    public static void checkStationarity(int sizeOfGroup) {
        RandomGenerator randomGenerator = new RandomGenerator();
        FunctionClass functionClass = new FunctionClass();
        StationarityChecker stationarityChecker = new StationarityChecker(randomGenerator, functionClass);
        boolean isStationar = stationarityChecker.checkStationarity(sizeOfGroup);
        System.out.println(isStationar ? "Group is stationar" : "Group is not stationar");
    }

    public static void buildCharts() {
        Chart direct = Chart.builder()
                .title("y = kx + b")
                .startX(-5F)
                .endX(5F)
                .stepX(1F)
                .function(x -> 2 * x + 3).build();

        Chart abs = Chart.builder()
                .title("y = |x|")
                .startX(-5F)
                .endX(5F)
                .stepX(1F)
                .function(Math::abs).build();

        Chart sqrt = Chart.builder()
                .title("y = sqrt(x)")
                .startX(0F)
                .endX(10F)
                .stepX(1F)
                .function(Math::sqrt).build();

        Chart parabola = Chart.builder()
                .title("y = -x^2")
                .startX(-5F)
                .endX(5F)
                .stepX(1F)
                .function(x -> -Math.pow(x, 2)).build();

        Chart hyperbola = Chart.builder()
                .title("y = x^3")
                .startX(-5F)
                .endX(5F)
                .stepX(1F)
                .function(x -> 2 * Math.pow(x, 3)).build();

        Chart exponent = Chart.builder()
                .title("y = b * exp(-a * x)")
                .startX(-1F)
                .endX(1F)
                .stepX(0.1F)
                .function(x -> 2 * Math.exp(-3 * x)).build();


        FrameBuilder frameBuilder = new FrameBuilder(Arrays.asList(direct, abs, sqrt, parabola, hyperbola, exponent));
        frameBuilder.buildFrame();
    }

    public static void checkFunctions() {
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Double> randomDoubles = IntStream.range(0, 10)
                .mapToDouble(value -> randomGenerator.nextDoubleInclusive())
                .boxed()
                .collect(Collectors.toList());
        FunctionClass functionClass = new FunctionClass();
        System.out.println("Average= " + functionClass.average(randomDoubles));
        System.out.println("Dispersion= " + functionClass.dispersion(randomDoubles));
        System.out.println("StandardDeviation= " + functionClass.standardDeviation(randomDoubles));
        System.out.println("RootMeanSquareError= " + functionClass.rootMeanSquareError(randomDoubles));
        System.out.println("Asymmetry= " + functionClass.asymmetry(randomDoubles));
        System.out.println("Excess= " + functionClass.excess(randomDoubles));
    }
}
