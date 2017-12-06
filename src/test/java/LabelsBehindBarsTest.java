import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

    public class LabelsBehindBarsTest extends ApplicationFrame {

        public LabelsBehindBarsTest(String title) {
            super(title);
            DefaultCategoryDataset dataset = createDataset();
            JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo", // chart title
                    "Category", // domain axis label
                    "Value", // range axis label
                    dataset, // data
                    PlotOrientation.VERTICAL, // orientation
                    true, // include legend
                    true, // tooltips?
                    false // URLs?
            );

            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
      /* Deactivates 3D effect and shadow */
            renderer.setShadowVisible(false);
            renderer.setBarPainter(new StandardBarPainter());
      /* Sets the border and the border color */
            renderer.setDrawBarOutline(true);
            renderer.setBaseOutlinePaint(Color.BLACK);
      /* Gap bewtween the bars (value in percent) */
            renderer.setItemMargin(0.0);
            renderer.setItemLabelAnchorOffset(6);
      /* set value label text format */
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.00"));
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);

      /* creates chart panel */
            ChartPanel chartPanel = new ChartPanel(chart, false);
            chartPanel.setPreferredSize(new Dimension(500, 270));
            setContentPane(chartPanel);
        }

        private DefaultCategoryDataset createDataset() {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(10.12, "Row 1", "1");
            dataset.addValue(5.15, "Row 1", "2");
            dataset.addValue(3.9, "Row 1", "3");
            dataset.addValue(4.0, "Row 1", "4");
            dataset.addValue(3.50, "Row 1", "5");
            dataset.addValue(2.79, "Row 1", "6");
            dataset.addValue(4.0, "Row 1", "7");
            dataset.addValue(5.60, "Row 1", "8");
            dataset.addValue(8.0, "Row 1", "9");
            dataset.addValue(7.0, "Row 1", "10");
            dataset.addValue(2.0, "Row 1", "11");
            dataset.addValue(3.70, "Row 1", "12");
            dataset.addValue(1.0, "Row 1", "13");
            dataset.addValue(8.72, "Row 1", "14");
            dataset.addValue(7.0, "Row 1", "15");
            dataset.addValue(6.0, "Row 2", "1");
            dataset.addValue(10.43, "Row 2", "2");
            dataset.addValue(8.0, "Row 2", "3");
            dataset.addValue(7.55, "Row 2", "4");
            dataset.addValue(2.0, "Row 2", "5");
            dataset.addValue(9.0, "Row 2", "6");
            dataset.addValue(7.0, "Row 2", "7");
            dataset.addValue(2.38, "Row 2", "8");
            dataset.addValue(4.0, "Row 2", "9");
            dataset.addValue(5.89, "Row 2", "10");
            dataset.addValue(4.73, "Row 2", "11");
            dataset.addValue(8.79, "Row 2", "12");
            dataset.addValue(7.0, "Row 2", "13");
            dataset.addValue(6.18, "Row 2", "14");
            dataset.addValue(2.0, "Row 2", "15");
            return dataset;
        }

        /**
         * Starting point for the demonstration application.
         *
         * @param args ignored.
         */
        public static void main(String[] args) {
            LabelsBehindBarsTest demo = new LabelsBehindBarsTest("Bar Demo 1");
            demo.pack();
            RefineryUtilities.centerFrameOnScreen(demo);
            demo.setVisible(true);
        }
    }

