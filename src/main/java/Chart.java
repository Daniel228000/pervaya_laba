import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.function.Function;

@Data
@Builder
public class Chart {

    private String title;

    private Float startX;

    private Float endX;

    private Float stepX;

    private Function<Double, Double> function;

    public JFreeChart buildChart() {
        XYSeries series = new XYSeries(title.split("=")[1]);
        for(double i = startX; i <= endX; i+=stepX){
            series.add(i, function.apply(i));
        }

        XYDataset xyDataset = new XYSeriesCollection(series);

        return ChartFactory
                .createXYLineChart(title, "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);

    }
}
