import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class testConnection extends JFrame{


    static JTextField txtCandidatoUno;
    static JTextField txtCandidatoDos;
    static JTextField txtCandidatoTres;
    static JButton btnVer;
    static JLabel lblImagen;
    static JLabel lblC1;
    static JLabel lblC2;
    static JLabel lblC3;

    public static void main(String[] args) {
		new testConnection().setVisible(true);
		System.out.print("Hello!");
//        testConnection v = new testConnection();
//        v.setVisible(true);

    }

    public void pintar(){

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue(lblC1.getText(), Integer.parseInt(txtCandidatoUno.getText()));
        dataset.setValue(lblC2.getText(), Integer.parseInt(txtCandidatoDos.getText()));
        dataset.setValue(lblC3.getText(), Integer.parseInt(txtCandidatoTres.getText()));

        JFreeChart grafica = ChartFactory.createPieChart("Grafica Candidatos",dataset,true,true,false);
      //  JFreeChart grafica = ChartFactory.createBarChart(dataset,true,true);

        BufferedImage bri = grafica.createBufferedImage(500,500);
        ImageIcon img = new ImageIcon(bri);
        lblImagen.setIcon(img);

        ChartFrame frame = new ChartFrame("Graficator", grafica);
        frame.pack();


    }


    public testConnection(){

        super("Data display");

        setLayout(null);
        Container c = getContentPane();
        evento e= new evento();

        txtCandidatoUno = new JTextField();
        txtCandidatoUno.setBounds(80,10,70,30);

        txtCandidatoDos = new JTextField();
        txtCandidatoDos.setBounds(80,60,70,30);

        txtCandidatoTres = new JTextField();
        txtCandidatoTres.setBounds(80,110,70,30);

        btnVer = new JButton("Building");
        btnVer.setBounds(10, 160, 160, 30);
        btnVer.addActionListener(e);

        lblImagen = new JLabel();
        lblImagen.setBounds(200,20,500,500);

        lblC1 = new JLabel("Pedro");
        lblC1.setBounds(20,10,40,30);

        lblC2 = new JLabel("Maria");
        lblC2.setBounds(20,60,40,30);

        lblC3 = new JLabel("Carlos");
        lblC3.setBounds(20,110,40,30);

        c.add(txtCandidatoUno);
        c.add(txtCandidatoDos);
        c.add(txtCandidatoTres);
        c.add(btnVer);
        c.add(lblImagen);
        c.add(lblC1);
        c.add(lblC2);
        c.add(lblC3);

        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

    }//constructor

    private class evento implements ActionListener{
        public void actionPerformed(ActionEvent ev){

            if(ev.getSource().equals(btnVer)){
                pintar();
            }

        }


    }

}
