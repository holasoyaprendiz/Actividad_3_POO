/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.figuras;

/**
 *
 * @author Usuario
 */
public class Cilindro extends FiguraGeometrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return Math.PI * altura * Math.pow(radio, 2);
    }

    public double calcularSuperficie() {
        double áreaLadoA = 2.0 * Math.PI * radio * altura;
        double áreaLadoB = 2.0 * Math.PI * Math.pow(radio, 2);
        return áreaLadoA + áreaLadoB;
    }
}