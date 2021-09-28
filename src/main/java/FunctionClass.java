import lombok.NoArgsConstructor;

import java.util.List;

public class FunctionClass {

    public double average(List<Double> ints) {
        return ints.stream().mapToDouble(Double::doubleValue).sum() / ints.size();
    }

    public Double dispersion(List<Double> ints) {
        double average = average(ints);

        return ints.stream()
                .mapToDouble(xK -> Math.pow(xK - average, 2))
                .sum() / ints.size();
    }

    public double standardDeviation(List<Double> ints) {
        return Math.sqrt(dispersion(ints));
    }

    public Double rootMeanSquareError(List<Double> ints) {
        return Math.sqrt(ints.stream()
                .mapToDouble(xK -> Math.pow(xK, 2))
                .sum() / ints.size());
    }

    public Double asymmetry(List<Double> ints) {
        double average = average(ints);

        return (ints.stream()
                .mapToDouble(xK -> Math.pow(xK - average, 3))
                .sum() / ints.size()) / Math.pow(standardDeviation(ints), 3);
    }

    public Double excess(List<Double> ints) {
        double average = average(ints);

        return (ints.stream()
                .mapToDouble(xK -> Math.pow(xK - average, 4))
                .sum() / ints.size()) / Math.pow(standardDeviation(ints), 4) - 3;
    }
}
