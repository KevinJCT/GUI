/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import com.sun.corba.se.impl.oa.poa.Policies;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javafx.scene.control.ScrollBar;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author byron
 */
public class Eventos extends JFrame {

    JPanel panel;
    JButton boton;
    JTextField textoLinea;
    JLabel saludo;
    JLabel titulo;
    JTextArea areaTexto;

    public Eventos() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Eventos");
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(400, 400));
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        colocarPanel();
//        colocarEtiqueta();
        colocarTextoLinea();
//        colocarBoton();
        colocarAreaTexto();
//        eventoActionListener();
//        eventoOyenteRaton();

    }

    private void colocarPanel() {

        panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);

        //EVENTO DE MOVIMIENTO DE RATON
//        eventoDeMovimientoRaton();
        //EEVENTO DE LA RUEDA DEL RATON
//        eventoRuedaRaton();
    }

    private void colocarEtiqueta() {

        titulo = new JLabel("Ingrese su nombre");
        titulo.setBounds(20, 20, 200, 50);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo);
    }

    private void colocarTextoLinea() {
        textoLinea = new JTextField();
        textoLinea.setBounds(300, 20, 200, 40);
        textoLinea.setFont(new Font("Arial", Font.HANGING_BASELINE, 20));
        panel.add(textoLinea);

        eventoTeclado();
    }

    private void colocarBoton() {
        boton = new JButton("¡Pulsa Aqui!");
        //Para el evento ActionListener
//        boton.setBounds(40, textoLinea.getY()+50, 100, 40);

        //Para el evento MouseListener
        boton.setBounds(100, 400, 100, 40);
        panel.add(boton);

    }

    private void eventoActionListener() {

        saludo = new JLabel();
        saludo.setBounds(20, boton.getY() + 40, 200, 60);
        saludo.setFont(new Font("Arial", 1, 20));

        panel.add(saludo);

        //ActionListener
        ActionListener oyenteAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                saludo.setText("Hola " + textoLinea.getText());
            }
        };
        boton.addActionListener(oyenteAccion);
    }

    private void colocarAreaTexto() {
        areaTexto = new JTextArea();
        areaTexto.setBounds(20, 20, 200, 300);
        panel.add(areaTexto);
        JScrollPane scroll = new JScrollPane(areaTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(20, 20, 200, 300);
        panel.add(scroll);

    }

    private void eventoOyenteRaton() {
        MouseListener oyenteRaton = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                // Cuando se haga click dentro del boton ocurre
                // Aqui añade "MouseClicked" cuando se da click en el boton
//                areaTexto.append("MouseClicked\n");

                if (me.isAltDown()) {// Si da un mouseClicked y presiona la tecla alt para que funcione
                    areaTexto.append("Alt\n");
                } else if (me.isControlDown()) {// Si presiona contral y da click muestra el mensaje
                    areaTexto.append("Control\n");
                } else if (me.isShiftDown()) { //Si presiona shift y da click muestra el mensaje
                    areaTexto.append("Shift\n");
                } else if (me.isMetaDown()) { // Presionar click derecho para mosrtar el mensaje
                    areaTexto.append("Click Derecho\n");
                } else {
//                    areaTexto.append("Click izquiedo\n");
                }

                if (me.getClickCount() == 2) {
                    areaTexto.append("Doble click\n");
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                // Solo con presionar se ejecuta el mousePressd
//                areaTexto.append("MousePressed\n");
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                // Presiona y suelta fuera ocurre el evento
//                areaTexto.append("MouseReleased\n");
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                // Solo se necesita poner encima del boton el mouse
//                areaTexto.append("MouseEntered\n");
            }

            @Override
            public void mouseExited(MouseEvent me) {
                // Poner por encima el mouse en el boton y salir para realizar el evento
//                areaTexto.append("MouesExited\n");
            }
        };
        boton.addMouseListener(oyenteRaton);

    }

    private void eventoDeMovimientoRaton() {

        MouseMotionListener movimientoRaton = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
                // Cuando haga click y arrastar
                areaTexto.append("MouseDragged\n");

            }

            @Override
            public void mouseMoved(MouseEvent me) {
                //Se ejecuta siempre cuando se mueva el raton dentro del elemnto
                areaTexto.append("MouseMoved\n");
            }
        };

        panel.addMouseMotionListener(movimientoRaton);

    }

    private void eventoRuedaRaton() {

        MouseWheelListener ruedaRaton = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent mwe) {
                areaTexto.append("MoviendoRuedaRaton\n");
                //Saber hacia a donde se ha movido
                if (mwe.getPreciseWheelRotation() == -1) {
                    //Se ha movido hacia arriba
                    areaTexto.setText("Se ha movido hacia arriba");
                } else if (mwe.getPreciseWheelRotation() == 1) {
                    areaTexto.setText("Se ha movido hacia abajo");
                }
            }
        };

        panel.addMouseWheelListener(ruedaRaton);

    }

    private void eventoTeclado() {
        KeyListener oyenteTeclado = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                // Solo admite caracteres a-z 1-0 -!-¡ No permite Ctrl Alt Shift Enter
                areaTexto.append("KeyTyped\n");
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //Presionar cualquier tecla no hace falta soltar
                areaTexto.append("KeyPressed\n");
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //Ejecuta cuando se presiona y suelta cualquier tecla
//                areaTexto.append("KeyReleased\n");

                if (ke.getKeyChar() == 'p') {
                    areaTexto.append("Presionado p");
                } 
                if (ke.getKeyChar() == '\n') {
                    areaTexto.append("Enter\n");

                } 
                if (ke.getKeyChar() == ' ') {
                    areaTexto.append("Espacio\n");

                }
            }
        };

        textoLinea.addKeyListener(oyenteTeclado);

    }

}
