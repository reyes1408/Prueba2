package calculadoraiva;

/**
 *
 * @author LENOVO
 */

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


public class CalculadoraIva extends JFrame implements ActionListener{
    
    private JLabel mensaje;
    private JLabel mensaje2;
    private JLabel mensajeSuma;
    private JButton boton;
    //private JTextField caja;
    private String selectIva;
    private JComboBox iva;
    private JTextField caja2;
    
    public CalculadoraIva(){
        super();
        configurarVentana();
        crearComponentes();
    }
    private void configurarVentana(){
        this.setTitle("Hello World");
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void crearComponentes(){
    
        mensaje2 = new JLabel();
        mensaje2.setText("Iva: ");
        mensaje2.setBounds(140,20,200,20);//(x,y,ancho,alto)
        mensaje2.setForeground(Color.red);
        this .add(mensaje2);
        
        mensajeSuma = new JLabel();
        mensajeSuma.setText("Ingrese el valor: ");
        mensajeSuma.setBounds(70,65,100,20);//(x,y,ancho,alto)
        mensajeSuma.setForeground(Color.red);
        this .add(mensajeSuma);
        
       /* caja = new JTextField();
        caja.setBounds(80,60,50,30);//(x,y,ancho,alto)
        this.add(caja);
        */
        
        String[] ivaList = new String[] {"16", "8"};
        JComboBox<String> iva = new JComboBox<>(ivaList);
        iva.setBounds(165, 20, 60, 25);
        iva.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectIva = iva.getItemAt(iva.getSelectedIndex());
                System.out.println("El valor de iva es: " + selectIva);
        }
        });
        this.add(iva);
        
        caja2 = new JTextField();
        caja2.setBounds(165,60,60,30);//(x,y,ancho,alto)
        this.add(caja2);
        
        boton = new JButton();
        boton.setText("Calcular");
        boton.setBounds(80,100,100,30);//(x,y,ancho,alto)
        boton.addActionListener(this);
        this.add(boton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        double resultado1 = Double.parseDouble(selectIva);
        int resultado2 = Integer.parseInt(caja2.getText());
        double Iva = (resultado1*resultado2)/100;
        
        JOptionPane.showMessageDialog(this, "El resultado es: " + (resultado2 + Iva));
    }
    
    public static void main(String[] args){
      
      CalculadoraIva ventana = new CalculadoraIva();
      ventana.setVisible(true);
    }
}