package GUIs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    //Botones
    private JButton button;
    private JPanel panelGUI;
    private JButton button1;

    public static void main(String[] args) {
        //Objeto tipo ventana
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().panelGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Metodo que le da funcion al boton cuando recive un clic
    public GUI() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Accion realizada en la IDE al precionar el boton
                System.out.println("asdasd");
                //Abre una ventana con un mensaje
                JOptionPane.showMessageDialog(null, "Hola mundo");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "soy otro boton :3");
            }
        });
    }



}
