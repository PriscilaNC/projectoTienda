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
    private JTabbedPane tabbedPane1;

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
                e -> TiendaMascota.main());

        consultarAcuaticoButton.addActionListener(
                e -> Acuatico.consultarAcuatico());

        consultarAereoButton.addActionListener(
                e -> Aereo.consultarAereo());

        consultarTerrestreButton.addActionListener(
                e -> Terrestre.consultarTerrestre());

        consultarClienteButton.addActionListener(
                e -> Cliente.consultarCliente());

        consultarFuncionarioButton.addActionListener(
                e -> Funcionario.consultarFuncionario());

        consultarProveedorButton.addActionListener(
                e -> Proveedor.consultarProveedor());

        consultarAccesorioButton.addActionListener(
                e -> Accesorio.consultarAccesorio());

        consultarAlimentoButton.addActionListener(
                e -> Alimento.consultarAlimento());

        consultarMedicamentoButton.addActionListener(
                e -> Medicamento.consultarMedicamento());

    }

    }

