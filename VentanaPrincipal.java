/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notas;

/**
 *
 * @author Usuario
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio, desviación, mayor, menor;
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JButton calcular, limpiar;

    public VentanaPrincipal() {
        inicio();
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        setTitle("Notas - Sistema Universitario");
        setSize(300, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Configuración de etiquetas y campos de texto para las 5 notas
        nota1 = new JLabel("Nota 1:");
        nota1.setBounds(20, 20, 135, 23);
        campoNota1 = new JTextField();
        campoNota1.setBounds(105, 20, 135, 23);

        nota2 = new JLabel("Nota 2:");
        nota2.setBounds(20, 50, 135, 23);
        campoNota2 = new JTextField();
        campoNota2.setBounds(105, 50, 135, 23);

        nota3 = new JLabel("Nota 3:");
        nota3.setBounds(20, 80, 135, 23);
        campoNota3 = new JTextField();
        campoNota3.setBounds(105, 80, 135, 23);

        nota4 = new JLabel("Nota 4:");
        nota4.setBounds(20, 110, 135, 23);
        campoNota4 = new JTextField();
        campoNota4.setBounds(105, 110, 135, 23);

        nota5 = new JLabel("Nota 5:");
        nota5.setBounds(20, 140, 135, 23);
        campoNota5 = new JTextField();
        campoNota5.setBounds(105, 140, 135, 23);

        // Botones de acción
        calcular = new JButton("Calcular");
        calcular.setBounds(20, 170, 100, 23);
        calcular.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(125, 170, 80, 23);
        limpiar.addActionListener(this);

        // Etiquetas para mostrar los resultados en la parte inferior
        promedio = new JLabel("Promedio = ");
        promedio.setBounds(20, 210, 250, 23);

        desviación = new JLabel("Desviación estándar = ");
        desviación.setBounds(20, 240, 250, 23);

        mayor = new JLabel("Valor mayor = ");
        mayor.setBounds(20, 270, 250, 23);

        menor = new JLabel("Valor menor = ");
        menor.setBounds(20, 300, 250, 23);

        // Adición de componentes al contenedor
        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviación);
        contenedor.add(mayor);
        contenedor.add(menor);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            try {
                // Ejercicio propuesto 2: Obligatoriedad de ingresar las 5 notas (validar vacíos)
                if (campoNota1.getText().isEmpty() || campoNota2.getText().isEmpty() ||
                    campoNota3.getText().isEmpty() || campoNota4.getText().isEmpty() ||
                    campoNota5.getText().isEmpty()) {
                    
                    JOptionPane.showMessageDialog(this, 
                        "Error: Es obligatorio ingresar las cinco notas.", 
                        "Campo Vacío", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Notas notas = new Notas();
                
                // Conversión de datos obtenidos de la interfaz
                notas.listaNotas[0] = Double.parseDouble(campoNota1.getText().trim());
                notas.listaNotas[1] = Double.parseDouble(campoNota2.getText().trim());
                notas.listaNotas[2] = Double.parseDouble(campoNota3.getText().trim());
                notas.listaNotas[3] = Double.parseDouble(campoNota4.getText().trim());
                notas.listaNotas[4] = Double.parseDouble(campoNota5.getText().trim());

                // Mostrar resultados formateados en las etiquetas
                promedio.setText("Promedio = " + String.format("%.2f", notas.calcularPromedio()));
                desviación.setText("Desviación estándar = " + String.format("%.2f", notas.calcularDesviación()));
                mayor.setText("Valor mayor = " + String.valueOf(notas.calcularMayor()));
                menor.setText("Valor menor = " + String.valueOf(notas.calcularMenor()));

            } catch (NumberFormatException e) {
                // Ejercicio propuesto 1: Mensaje de alerta al ingresar datos no numéricos
                JOptionPane.showMessageDialog(this, 
                    "Error: Ingrese únicamente valores numéricos válidos en las notas.", 
                    "Formato Incorrecto", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } else if (evento.getSource() == limpiar) {
            // Reinicia los campos de texto y resultados
            campoNota1.setText("");
            campoNota2.setText("");
            campoNota3.setText("");
            campoNota4.setText("");
            campoNota5.setText("");
            promedio.setText("Promedio = ");
            desviación.setText("Desviación estándar = ");
            mayor.setText("Valor mayor = ");
            menor.setText("Valor menor = ");
        }
    }
}