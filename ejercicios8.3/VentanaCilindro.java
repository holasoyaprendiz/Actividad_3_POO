/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.figuras;

/**
 *
 * @author Usuario
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, altura, volumen, superficie;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;

    public VentanaCilindro() {
        inicio();
        setTitle("Cilindro");
        setSize(280, 210);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel("Radio (cms):");
        radio.setBounds(20, 20, 135, 23);
        campoRadio = new JTextField();
        campoRadio.setBounds(100, 20, 135, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(100, 50, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(100, 80, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 110, 135, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 140, 135, 23);

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == calcular) {
            boolean error = false;
            try {
                double rad = Double.parseDouble(campoRadio.getText());
                double alt = Double.parseDouble(campoAltura.getText());
                Cilindro cilindro = new Cilindro(rad, alt);
                volumen.setText("Volumen (cm3): " + String.format("%.2f", cilindro.getVolumen()));
                superficie.setText("Superficie (cm2): " + String.format("%.2f", cilindro.getSuperficie()));
            } catch (Exception e) {
                error = true;
            }
            if (error) {
                JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
