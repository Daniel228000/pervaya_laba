import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Chart direct = Chart.builder()
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
        frameBuilder.buildFrame();
    }
}
