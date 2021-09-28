import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class StationarityChecker {

    private final RandomGenerator generator;
    private final FunctionClass functionClass;

    public boolean checkStationarity(int sizeOfGroup) {
        Map<Integer, Double> averages = IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.toMap(i -> i, i ->
                        functionClass.average(IntStream.range(0, sizeOfGroup)
                                .mapToDouble(value -> generator.nextDoubleInclusive())
                                .boxed()
                                .collect(Collectors.toList())), (a, b) -> b));

        List<Map.Entry<Integer, Double>> sorted = averages.entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(average -> Math.abs(average.getValue())))
                .collect(Collectors.toList());

        Double maxAbsAverage = sorted.get(sorted.size() - 1).getValue();
        Double minAbsAverage = sorted.get(0).getValue();

        System.out.printf("MaxAbsAverage = %f %nMinAbsAverage = %f%n", maxAbsAverage, minAbsAverage);

        return (maxAbsAverage - minAbsAverage) < 0.1 * minAbsAverage;
    }
}
