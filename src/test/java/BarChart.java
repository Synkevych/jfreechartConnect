import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class BarChart extends ApplicationFrame {


    public BarChart(String applicationTitle , String chartTitle ) {
        super( applicationTitle );

        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);
//create window
                 barChart.setBackgroundPaint(Color.lightGray);
                 final CategoryPlot plot = barChart.getCategoryPlot();
        final CategoryItemRenderer renderer = new CustomRenderer(
                new Paint[] {Color.red, Color.blue, Color.green,
                        Color.yellow, Color.orange, Color.cyan,
                        Color.magenta, Color.blue}
        );


        renderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator("{2}",NumberFormat.getCurrencyInstance(Locale.US)));

        renderer.setSeriesItemLabelsVisible(0, true);


        ChartPanel chartPanel = new ChartPanel( barChart );
                  chartPanel.setPreferredSize(new java.awt.Dimension( 800 , 600 ) );
                  setContentPane(chartPanel);
    }
// create Data
private static CategoryDataset createDataset( ) {
        final String iphone = "IPhone"; // сделать большим
        final String samsung = "Samsung";
        final String lg = "LG";
        final String htc = "HTC";

        final String cost = "Cost";
        final String screen = "Screen";
        final String battery = "Battery";
        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

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


    public static void main( String[ ] args ) {
        BarChart chart = new BarChart("Sales phone by country",
                "");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }

}