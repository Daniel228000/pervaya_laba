import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*RandomFunction randomFunction = new RandomFunction();
        System.out.println(randomFunction.nextInt(5));*/


        /*int startBound = 5;
        int endBound = 10;
        FunctionClass functionClass = new FunctionClass(startBound, endBound);
        System.out.printf("Average of list of numbers in range [%d - %d] = %f%n",
                startBound, endBound, functionClass.average());
        System.out.printf("Dispersion of list of numbers in range [%d - %d] = %f%n",
                startBound, endBound, functionClass.dispersion());
        System.out.printf("StandardDeviation of list of numbers in range [%d - %d] = %f%n",
                startBound, endBound, functionClass.standardDeviation());
        System.out.printf("RootMeanSquareError of list of numbers in range [%d - %d] = %f%n",
                startBound, endBound, functionClass.rootMeanSquareError());
        System.out.printf("Asymmetry of list of numbers in range [%d - %d] = %f%n",
                startBound, endBound, functionClass.asymmetry());
        System.out.printf("Excess of list of numbers in range [%d - %d] = %f%n",
                startBound, endBound, functionClass.excess());*/

        List<Integer> list = new ArrayList<>(Arrays.asList(5,6,7,8,9,10));
        FunctionClass functionClass = new FunctionClass(list);
        System.out.println("Average= " + functionClass.average());
        System.out.println("Dispersion= " + functionClass.dispersion());
        System.out.println("StandardDeviation= " + functionClass.standardDeviation());
        System.out.println("RootMeanSquareError= " + functionClass.rootMeanSquareError());
        System.out.println("Asymmetry= " + functionClass.asymmetry());
        System.out.println("Excess= " + functionClass.excess());


        /*Chart direct = Chart.builder()
                .title("y = kx + b")
                .startX(-5F)
                .endX(5F)
                .stepX(1F)
                .function(x -> 2 * x + 3).build();

        Chart direct1 = Chart.builder()
                .title("y = kx + b")
                .startX(-5F)
                .endX(5F)
                .stepX(1F)
                .function(x -> -7 * x + 3).build();

        Chart direct2 = Chart.builder()
                .title("y = kx + b")
                .startX(-5F)
                .endX(5F)
                .stepX(1F)
                .function(x -> 5 * x + 3).build();

        Chart exponent = Chart.builder()
                .title("y = b * exp(-a * x)")
                .startX(-1F)
                .endX(1F)
                .stepX(0.1F)
                .function(x -> 2 * Math.exp(-3 * x)).build();


        FrameBuilder frameBuilder = new FrameBuilder(Arrays.asList(direct, direct1, direct2, exponent));
        frameBuilder.buildFrame();*/
    }
}
