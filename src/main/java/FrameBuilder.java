import lombok.AllArgsConstructor;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@AllArgsConstructor
public class FrameBuilder {

    private final List<Chart> charts;

    public void buildFrame() {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, charts.size()));
        for (Chart chart : charts) {
            ChartPanel chartPanel = new ChartPanel(chart.buildChart());
            frame.getContentPane()
                    .add(chartPanel);

            frame.setSize(1800, 1000);
            frame.show();
        }
    }
}
