import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChart_AWT extends ApplicationFrame {

    // create name of Window
    public PieChart_AWT(String title ) {
        super(title);
        setContentPane(createDemoPanel());
    }
// create dataset
    private static PieDataset createDataset( ) {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        dataset.setValue( "IPhone" , new Double( 20 ) );
        dataset.setValue( "Samsung" , new Double( 30 ) );
        dataset.setValue( "Motorola" , new Double( 40 ) );
        dataset.setValue( "Nokia" , new Double( 10 ) );
        return dataset;
    }
// create chart
    private static JFreeChart createChart( PieDataset dataset ) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Mobile Sales",   // chart title
                dataset,          // data
                true,             // include legend
                true,
                false);

        return chart;
    }
// create a panel
    public static JPanel createDemoPanel( ) {
        JFreeChart chart = createChart(createDataset( ) );
        return new ChartPanel( chart );
    }
// set name, size, position of window
    public static void main( String[ ] args ) {
        PieChart_AWT demo = new PieChart_AWT( "Mobile Sales" );
        demo.setSize( 500 , 400 );
        RefineryUtilities.centerFrameOnScreen( demo );
        demo.setVisible( true );
    }
}