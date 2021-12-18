/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author byron
 */
public class Ventana extends JFrame {

    public JPanel panel;

    public Ventana() {
        // Establecer un tamaño de la ventana en el constructor
        this.setSize(500, 500);
        //Para cerrar ventana y finalizar por defente el programa sin hacer manualmente
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // establecer titulo de la ventana
        this.setTitle("Hola Mundo");
        // PARA QUE SALGA EN UNA POSICION  
//        this.setLocation(100, 200); //esablecemos la posicion de la venta para que salga al ejecutarse
        // Metodo para unir setSize y setLocation
        // 2 primeros son las coordenadas x,y de donde se va a colocar la ventana
        // 2 Ultimos es el ancho y alto de ventana
//        this.setBounds(100, 200, 500, 500);

        //Centrar ventana
        this.setLocationRelativeTo(null);

        //Desabilitar la redimension de la ventana
//        this.setResizable(false); // False para desibilitar / True si permite cambiar (Defecto)
        //Tamaño minimo que puede llegar a tener la ventana
        this.setMinimumSize(new Dimension(200, 200));

        // Color de ventana
//        this.getContentPane().setBackground(Color.WHITE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPaneles();
//        colocarEtiquetas();
//        colocarBotones();
//        colocarRadioBotones();
//        colorcarBotonesActivacion();
//        colocarCajasDeTexto();
//        colocarAreaTexto();
//        colocarCasillaVerificación();
//        colocarListasDesplegables();
//          colocarCampoContraseña();
//        colocarTablas();

        colocarListas();
    }

    private void colocarPaneles() {
        panel = new JPanel(); // Creacion de un panel
        //Poner el panel en la ventana
        // this hace referencia a la ventana
        this.getContentPane().add(panel); //Agregamos el Panel a la ventana
//        panel.setBackground(Color.yellow); //Color al panel
        // Desactivar el layaout o diseño
        panel.setLayout(null);

    }

    private void colocarEtiquetas() {
        // CLASE PARA PONER ETIQUETAS : JLabel
        // Creamos una etiqueta: 1.Parametro Texto / 2.Parametro alinea el texto
//        JLabel etiqueta = new JLabel("Hola", SwingConstants.CENTER);

        JLabel etiqueta = new JLabel();
        //Desactivar el diseño por defecto
        etiqueta.setOpaque(true); //True: Permite / False:No Permite

        etiqueta.setText("Hola"); //Se establece el texto

        // Posicion en x y y : Tamaño del cuadro de texto 
        etiqueta.setBounds(10, 10, 100, 40);

        // Cambiar el color de la letra del texto
        etiqueta.setForeground(Color.getHSBColor(1, 1, 1));

        //Cambiar el fondo de la etiqueta,(Primero desactivar el modelo)
        etiqueta.setBackground(Color.yellow);

        // Alinea el texto
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);

        // Modificar la fuente del texto
        etiqueta.setFont(new Font("arial", Font.BOLD, 25));

        panel.add(etiqueta);//Agregamos la etiqueta al Panel

        //Creacion de la imagen
        ImageIcon imagen = new ImageIcon("Avatar.jpeg");

        // Se inserta la imagen con el constructor ImageIcon
        JLabel etiqueta2 = new JLabel();

        //Se establece las medidas de la imagen
        etiqueta2.setBounds(10, 80, 500, 500);
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getWidth(), Image.SCALE_SMOOTH)));

        // Se coloca al panel
        panel.add(etiqueta2);

    }

    private void colocarBotones() {

        //Boton 1 
        JButton boton1 = new JButton();
        boton1.setBounds(10, 10, 100, 90);

        // Texto dentro del boton
        boton1.setText("Login");

        // Desabilita boton para dar click
        boton1.setEnabled(true);

        // pemrmite dar click con alt + letraAsignada
        boton1.setMnemonic('a');
        boton1.setBackground(Color.blue);

        //Cambiar color a la letra
        boton1.setForeground(Color.GREEN);

        //Cambiar fuente de la letra
        boton1.setFont(new Font("Calibri", Font.BOLD, 30));
        panel.add(boton1);

        //BOTON 2 (IMAGEN)
        JButton boton2 = new JButton();
        boton2.setBounds(10, 150, 100, 70);

        //Habilitar el modelo
//        boton2.setOpaque(true);
        // Poner imagen
        ImageIcon clicAqui = new ImageIcon("Avatar.jpeg");
        //Alto,Ancho,Escala
        boton2.setIcon(new ImageIcon(clicAqui.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));

        boton2.setBackground(Color.yellow);
        panel.add(boton2);

        //BOTON 3 (BORDES)
        JButton boton3 = new JButton();
        boton3.setBounds(boton2.getX(), boton2.getY() + 100, boton2.getWidth(), boton2.getHeight());
        boton3.setBackground(Color.yellow);
        // True : Esquinas redondeadas / False : Esquinas Cuadradas
        boton3.setBorder(BorderFactory.createLineBorder(Color.red, 5, true));
        panel.add(boton3);
    }

    private void colocarRadioBotones() {

        //  True: Sale marcado la opcion / False: No sale marcado la opcion
        JRadioButton radioBoton1 = new JRadioButton("Opcion 1", true);
        radioBoton1.setBounds(10, 10, 100, 40);
        JRadioButton radioBoton2 = new JRadioButton("Opcion 2", false);
        radioBoton2.setBounds(10, radioBoton1.getY() + 40, 100, 40);
        JRadioButton radioBoton3 = new JRadioButton("Opcion 3", false);
        radioBoton3.setBounds(10, radioBoton2.getY() + 40, 100, 40);
        panel.add(radioBoton1);
        panel.add(radioBoton2);
        panel.add(radioBoton3);

        // Agrupa el radioBoton de la cual solo puede marcar una opcion
        ButtonGroup grupoRadioBotones = new ButtonGroup();
        grupoRadioBotones.add(radioBoton1);
        grupoRadioBotones.add(radioBoton2);
        grupoRadioBotones.add(radioBoton3);

    }

    private void colorcarBotonesActivacion() {
        JToggleButton botonActivacion1 = new JToggleButton("Opcion 1", true);
        botonActivacion1.setBounds(20, 20, 100, 50);
        JToggleButton botonActivacion2 = new JToggleButton("Opcion 1", false);
        botonActivacion2.setBounds(20, botonActivacion1.getY() + 70, 100, 50);
        JToggleButton botonActivacion3 = new JToggleButton("Opcion 1", false);
        botonActivacion3.setBounds(20, botonActivacion2.getY() + 70, 100, 50);
        panel.add(botonActivacion1);
        panel.add(botonActivacion2);
        panel.add(botonActivacion3);

        ButtonGroup grupoBotonesActivados = new ButtonGroup();
        grupoBotonesActivados.add(botonActivacion1);
        grupoBotonesActivados.add(botonActivacion2);
        grupoBotonesActivados.add(botonActivacion3);

    }

    private void colocarCajasDeTexto() {
        // Caja de texto de una sola linea

        JTextField cajaTexto = new JTextField("@gmail", 50);
        cajaTexto.setBounds(20, 20, 100, 50);
        cajaTexto.setText("@gamil.com");

        System.out.println(cajaTexto.getText());

        panel.add(cajaTexto);

    }

    private void colocarAreaTexto() {

        JTextArea areaTexto = new JTextArea();
        areaTexto.setText("Yo soy ...");
        areaTexto.setBounds(20, 20, 300, 200);

        //Añadir mas texto
        areaTexto.append(" vivo en ...");

        //Poder borrar o no borrar del contenido del area de texto
        areaTexto.setEditable(true);

        System.out.println("El texto es : " + areaTexto.getText());

        areaTexto.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(areaTexto);

        // Barras de desplazamiento en Area de texto
        JScrollPane barrasDeplazamiento = new JScrollPane(areaTexto, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barrasDeplazamiento.setBounds(areaTexto.getX(), areaTexto.getY(), areaTexto.getWidth(), areaTexto.getHeight());
        // Se coloca las barras de desplazamiento solo cunado es necesario NEEDED
//        barrasDeplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//        barrasDeplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(barrasDeplazamiento);

    }

    private void colocarCasillaVerificación() {
        JCheckBox casillaVerificacion1 = new JCheckBox("Leche", true);
        casillaVerificacion1.setEnabled(false); //Desabilitamos la casilla
        casillaVerificacion1.setBounds(10, 10, 100, 40);
        JCheckBox casillaVerificacion2 = new JCheckBox("Galleta");
        casillaVerificacion2.setBounds(10, casillaVerificacion1.getY() + 40, 100, 40);
        JCheckBox casillaVerificacion3 = new JCheckBox("Arroz");
        casillaVerificacion3.setBounds(10, casillaVerificacion2.getY() + 40, 100, 40);

        panel.add(casillaVerificacion1);
        panel.add(casillaVerificacion2);
        panel.add(casillaVerificacion3);

    }

    private void colocarListasDesplegables() {

        /*String [] paises = {"Peru","Ecuador","Colombia","Chile"};
        
        JComboBox listaDesplegable1 = new JComboBox(paises);
        listaDesplegable1.setBounds(20, 20, 200, 40);
        listaDesplegable1.setFont(new Font("Arial", Font.BOLD, 20));
        
        //Agregar objetos al lista, al ultimo
        listaDesplegable1.addItem("Argentina");
        
        //Que salga el primero
        listaDesplegable1.setSelectedItem(paises[3]);
        
        panel.add(listaDesplegable1);*/
        // Listas Desplegables Default
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        Persona persona1 = new Persona("Kevin", 18, "Ecuatoriano");
        Persona persona2 = new Persona("Joel", 19, "Peruano");
        Persona persona3 = new Persona("Marco", 20, "Colombiano");
        // Agregar objetos en modelo
        modelo.addElement(persona1);
        modelo.addElement(persona2);
        modelo.addElement(persona3);

        JComboBox listaDesplegable2 = new JComboBox(modelo);
        listaDesplegable2.setBounds(20, 20, 400, 40);
        listaDesplegable2.setFont(new Font("Arial", Font.BOLD, 20));

        // Lo que mostraria seria el toString();
        panel.add(listaDesplegable2);
    }

    private void colocarCampoContraseña() {
        JPasswordField campoContraseña = new JPasswordField();
        campoContraseña.setText("Contraseña");
        campoContraseña.setBounds(10, 10, 100, 30);

        panel.add(campoContraseña);

        String contraseña = "";

        for (int i = 0; i < campoContraseña.getPassword().length; i++) {
            contraseña += campoContraseña.getPassword()[i];
        }

        System.out.println("Contraseña " + contraseña);
    }

    private void colocarTablas() {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Sexo");

        String[] persona1 = {"Kevin", "16", "Masculino"};
        String[] persona2 = {"Kevin", "16", "Masculino"};
        String[] persona3 = {"Kevin", "16", "Masculino"};

        modelo.addRow(persona1);
        modelo.addRow(persona2);
        modelo.addRow(persona3);

        JTable tabla = new JTable(modelo);
        tabla.setBounds(20, 20, 300, 300);
        panel.add(tabla);

        JScrollPane scroll = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setBounds(20, 20, 300, 300);

        panel.add(scroll);
    }

    private void colocarListas() {

        DefaultListModel modelo = new DefaultListModel();
        modelo.addElement("Kevin");
        modelo.addElement("Joel");
        modelo.addElement("Tipan");
        modelo.addElement("Joel");
        modelo.addElement("Tipan");
        modelo.addElement("Tipan");
        modelo.addElement("Joel");
        modelo.addElement("Tipan");

        JList lista = new JList(modelo);
        lista.setBounds(10, 10, 100, 50);
        panel.add(lista);

        JScrollPane scroll = new JScrollPane(lista, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(10, 10, 100, 50);
        panel.add(scroll);

    }

}
