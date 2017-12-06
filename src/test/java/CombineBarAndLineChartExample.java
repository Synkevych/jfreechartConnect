import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.DefaultCategoryDataset;

import java.text.DecimalFormat;

public class CombineBarAndLineChartExample extends JFrame {

    private static final long serialVersionUID = 1L;

    public CombineBarAndLineChartExample(String title) {
        super(title);

        // Create Category plot
        CategoryPlot plot = new CategoryPlot();

        // Add the first dataset and render as bar
  //      CategoryItemRenderer lineRenderer = new LineAndShapeRenderer();
//        plot.setDataset(0, createDataset());
//        plot.setRenderer(0, lineRenderer);

        // Add the second dataset2 and render as lines
        CategoryItemRenderer baRenderer = new BarRenderer();
        plot.setDataset(1, createDataset2());
        plot.setRenderer(1, baRenderer);
        plot.setDomainGridlinesVisible(false);


        CategoryItemRenderer baRenderer2 = new BarRenderer();
        plot.setDataset(0, createDataset());
        plot.setRenderer(0, baRenderer2);

        // Set Axis
        plot.setDomainAxis(new CategoryAxis("Time"));
        plot.setRangeAxis(new NumberAxis("Value"));


        JFreeChart chart = new JFreeChart( "Combined Bar And Line Char",
                JFreeChart.DEFAULT_TITLE_FONT,
                plot,
                true);

//      LayeredBarRenderer renderer = (LayeredBarRenderer) plot.getRenderer();
//   renderer.setShadowVisible(false);
//        renderer.setSeriesBarWidth(0, 1.0);
//        renderer.setSeriesBarWidth(1, 0.7);
//        renderer.setItemMargin(0.01);
//
//        CategoryAxis domainAxis = plot.getDomainAxis();
//        domainAxis.setCategoryMargin(0.25);
//        domainAxis.setUpperMargin(0.05);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
        DecimalFormat format = new DecimalFormat("####");
        format.setNegativePrefix("");

       // plot.setDrawSharedDomainAxis(true);
//
//      /* Deactivates 3D effect and shadow */
//        baRenderer.setShadowVisible(false);
//        baRenderer.setBarPainter(new StandardBarPainter());
//      /* Sets the border and the border color, цвет рамки*/
//        baRenderer.setDrawBarOutline(true);
//        baRenderer.setBaseOutlinePaint(Color.BLACK);
//      /* Gap bewtween the bars (value in percent), размер отступа между графиками */
//        baRenderer.setItemMargin(0.0);
//        baRenderer.setItemLabelAnchorOffset(6);
//
//        StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.00"));
//        renderer.setBaseItemLabelGenerator(labelGen);
//       renderer.setBaseItemLabelsVisible(true);
  }

    private DefaultCategoryDataset createDataset() {
        String iphone = "IPhone"; // сделать большим
        String samsung = "Samsung";
        String lg = "LG";
        String htc = "HTC";

        String cost = "Cost";
        String screen = "Screen";
        String battery = "Battery";
        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        dataset.addValue( 3 , iphone , cost );     //1000$
        dataset.addValue( 3 , iphone , battery );  //2000 mA/h
        dataset.addValue( 3 , iphone , screen );     //4.5

        dataset.addValue( 4 , samsung , cost );
        dataset.addValue( 5 , samsung , battery );
        dataset.addValue( 4 , samsung , screen );

        dataset.addValue( 4 , htc , cost );
        dataset.addValue( 5 , htc , battery );
        dataset.addValue( 5 , htc , screen );

        dataset.addValue( 5 , lg , cost );
        dataset.addValue( 4 , lg , battery );
        dataset.addValue( 5 , lg , screen );
        return dataset;
    }
    private DefaultCategoryDataset createDataset2() {
        final String max = "MAX"; // сделать большим
        final String cost = "Cost";
        final String screen = "Screen";
        final String battery = "Battery";
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();

        dataset2.addValue( 5 , max , cost );     //1000$
        dataset2.addValue( 5 , max , battery );  //2000 mA/h
        dataset2.addValue( 5 , max , screen );     //4.5
        return dataset2;
    }

    public static void main(String[] args) {
            CombineBarAndLineChartExample example = new CombineBarAndLineChartExample(
                    "Line Chart and Bar chart Example");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setVisible(true);
        }
    }