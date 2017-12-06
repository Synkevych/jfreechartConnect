import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.text.DecimalFormat;


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

        JFreeChart barChart2 = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "Score",
                createDataset2(),
                PlotOrientation.VERTICAL,
                true, true, false);
//create window

        CategoryPlot plot2 = (CategoryPlot) barChart2.getPlot();
        BarRenderer renderer2 = ((BarRenderer) plot2.getRenderer());
      /* Deactivates 3D effect and shadow */
        renderer2.setShadowVisible(false);
        renderer2.setBarPainter(new StandardBarPainter());
      /* Sets the border and the border color, цвет рамки*/
        renderer2.setDrawBarOutline(true);
        renderer2.setBaseOutlinePaint(Color.BLACK);
      /* Gap bewtween the bars (value in percent), размер отступа между графиками */

        /* виводимое значение над каждым графиком */
        StandardCategoryItemLabelGenerator labelGen2 = new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.0"));
        renderer2.setBaseItemLabelGenerator(labelGen2);
        renderer2.setBaseItemLabelsVisible(true);

        ChartPanel chartPanel2 = new ChartPanel(barChart2);
        chartPanel2.setPreferredSize(new java.awt.Dimension( 800 , 600 ) );
        setContentPane(chartPanel2);


        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        barChart.setBackgroundPaint(Color.lightGray);
        barChart.setBackgroundPaint( new Color(240, 248, 255));
        plot.setBackgroundImageAlpha( (float) 0.5 );

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension( 800 , 600 ) );
        setContentPane(chartPanel);



        BarRenderer renderer = ((BarRenderer) plot.getRenderer());
      /* Deactivates 3D effect and shadow */
        renderer.setShadowVisible(false);
        renderer.setBarPainter(new StandardBarPainter());
      /* Sets the border and the border color, цвет рамки*/
        renderer.setDrawBarOutline(true);
        renderer.setBaseOutlinePaint(Color.BLACK);
      /* Gap bewtween the bars (value in percent), размер отступа между графиками */
        renderer.setItemMargin(0.0);
        renderer.setItemLabelAnchorOffset(6);
        /* виводимое значение над каждым графиком */
        StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.0"));
        renderer.setBaseItemLabelGenerator(labelGen);
        renderer.setBaseItemLabelsVisible(true);


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
    private static CategoryDataset createDataset2( ) {
        final String iphone = "IPhone"; // сделать большим

        final String cost = "Cost";
        final String screen = "Screen";
        final String battery = "Battery";
        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        dataset.addValue( 3 , iphone , cost );     //1000$
        dataset.addValue( 3 , iphone , battery );  //2000 mA/h
        dataset.addValue( 3 , iphone , screen );     //4.5

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