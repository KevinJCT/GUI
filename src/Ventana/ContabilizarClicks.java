/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author byron
 */
public class ContabilizarClicks extends JFrame {

    JPanel panel;
    JLabel texto;
    JButton boton;
    int contador;

    public ContabilizarClicks() {

        this.setTitle("Contabilizar Clicks");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Eventos");
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(400, 400));

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarCajaTexto();
        colocarBoton();
        eventoActionListener();
    }

    private void colocarPanel() {
        panel = new JPanel();
        this.setContentPane(panel);
        panel.setLayout(null);

    }

    private void colocarCajaTexto() {

        texto = new JLabel("Pulsa el boton");
        texto.setBounds(30, 30, 200, 50);
        texto.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(texto);

    }

    private void colocarBoton() {

        boton = new JButton("Pulsar aqui");
        boton.setBounds(80, texto.getY() + 100, 150, 30);
        boton.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(boton);

    }

    private void eventoActionListener() {

        ActionListener evento = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                contador++;
                if (contador == 1) {
                    texto.setText("Has precionado 1 vez");
                }else{
                    texto.setText("Has precionado "+contador+" veces");
                }
                
                   
            }
        };
        boton.addActionListener(evento);

    }

}
