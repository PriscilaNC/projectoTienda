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
//todo actualizar gui
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
    private JTabbedPane tabbedPane1;
    private JProgressBar progressBar1;

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
            }
                });
// todo ver si resulta con lambda
        consultarAcuaticoButton.addActionListener(
                e -> Acuatico.consultarAcuatico());

        consultarAereoButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aereo.consultarAereo();
            }
                });

        consultarTerrestreButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Terrestre.consultarTerrestre();
            }
                });

        consultarClienteButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente.consultarCliente();

            }
                });

        consultarFuncionarioButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario.consultarFuncionario();
            }
                });

        consultarProveedorButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proveedor.consultarProveedor();
            }
                });

        consultarAccesorioButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accesorio.consultarAccesorio();
            }
                });

        consultarAlimentoButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alimento.consultarAlimento();
            }
                });

        consultarMedicamentoButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medicamento.consultarMedicamento();
            }
                });

    }

    }

