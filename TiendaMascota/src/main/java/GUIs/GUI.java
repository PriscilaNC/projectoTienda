package GUIs;

import Animales.Acuatico;
import Animales.Aereo;
import Animales.Terrestre;
import Personas.Cliente;
import Personas.Funcionario;
import Personas.Proveedor;
import Productos.Accesorio;
import Productos.Alimento;
import Productos.Medicamento;
import Tienda.TiendaMascota;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    //Botones
    private JButton subirTodoButton;
    private JPanel panelGUI;
    private JButton consultarAcuaticoButton;
    private JButton consultarAereoButton;
    private JButton consultarTerrestreButton;
    private JButton consultarClienteButton;
    private JButton consultarFuncionarioButton;
    private JButton consultarProveedorButton;
    private JButton consultarAccesorioButton;
    private JButton consultarAlimentoButton;
    private JButton consultarMedicamentoButton;

    public static void main(String[] args) {
        //Objeto tipo ventana
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().panelGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    //Metodo que le da funcion al boton cuando recive un clic
    public GUI() {
        subirTodoButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Accion realizada en la IDE al precionar el boton
                TiendaMascota.main();
                //Abre una ventana con un mensaje
                JOptionPane.showMessageDialog(null, "Hola mundo");
            }
                });

        consultarAcuaticoButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Acuatico.consultarAcuatico();
                JOptionPane.showMessageDialog(null, "soy otro boton :3");
            }
                });

        consultarAereoButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aereo.consultarAereo();
                JOptionPane.showMessageDialog(null, "soy otro boton :3");
            }
                });

        consultarTerrestreButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Terrestre.consultarTerrestre();
                JOptionPane.showMessageDialog(null, "soy otro boton :3");
            }
                });

        consultarClienteButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente.consultarCliente();
                JOptionPane.showMessageDialog(null, "soy otro boton :3");
            }
                });

        consultarFuncionarioButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario.consultarFuncionario();
                JOptionPane.showMessageDialog(null, "soy otro boton :3");
            }
                });

        consultarProveedorButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proveedor.consultarProveedor();
                JOptionPane.showMessageDialog(null, "soy otro boton :3");
            }
                });

        consultarAccesorioButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accesorio.consultarAccesorio();
                JOptionPane.showMessageDialog(null, "soy otro boton :3");
            }
                });

        consultarAlimentoButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alimento.consultarAlimento();
                JOptionPane.showMessageDialog(null, "soy otro boton :3");
            }
                });

        consultarMedicamentoButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medicamento.consultarMedicamento();
                JOptionPane.showMessageDialog(null, "soy otro boton :3");
            }
                });

    }



}
