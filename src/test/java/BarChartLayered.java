//import java.awt.Color;
//
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//
//import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.data.general.Dataset;
//import org.jfree.ui.ApplicationFrame;
//import org.jfree.ui.RefineryUtilities;
//
//import org.jfree.chart.axis.ValueAxis;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.axis.CategoryAxis;
//
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//
//import org.jfree.data.category.CategoryDataset;
//
//import org.jfree.chart.renderer.category.LayeredBarRenderer;
//
//public class BarChartLayered extends ApplicationFrame
//{
//    private static final long serialVersionUID = 1L;
//
//    public BarChartLayered(final String title)
//    {
//        super(title);
//        Dataset dataset =  new Dataset();
//        CategoryAxis       categoryAxis = new CategoryAxis("Category");
//        ValueAxis          valueAxis    = new NumberAxis  ("Score, %");
//        LayeredBarRenderer renderer     = new LayeredBarRenderer    ();
//
//        CategoryPlot plot = new CategoryPlot(dataset, categoryAxis,
//                valueAxis, renderer);
//
//        plot.setOrientation(PlotOrientation.VERTICAL);
//        JFreeChart chart = new JFreeChart( "Layered Bar Chart",
//                JFreeChart.DEFAULT_TITLE_FONT,
//                plot, true );
//
//        chart.setBackgroundPaint(new Color(232, 232, 232));
//
//        // Индивидуальная настройка каждого столбца
//        // Ширина столбца (в %) определяется значением от 0 до 1
//        renderer.setSeriesBarWidth(0, 1.0);
//        renderer.setSeriesBarWidth(1, 0.6);
//        renderer.setSeriesBarWidth(2, 0.3);
//
//        renderer.setItemMargin(0.01);
//
//        final CategoryAxis domainAxis = plot.getDomainAxis();
//        domainAxis.setCategoryMargin(0.25);
//        domainAxis.setUpperMargin(0.05);
//        domainAxis.setLowerMargin(0.05);
//
//        // Размещение диаграммы на панели
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(540, 270));
//        setContentPane(chartPanel);
//    }
//
//    public static void main(final String[] args)
//    {
//        BarChartLayered demo = new BarChartLayered("Layered Bar Chart");
//        demo.pack();
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);
//    }
//}