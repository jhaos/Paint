/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.graficos;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author julius
 */
public class Circunferencia extends formas{
    
    int radio;
    Point2D centro; 
    
    public Circunferencia() {
        super(new Ellipse2D.Float());
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Point2D getCentro() {
        return centro;
    }

    public void setCentro(Point2D centro) {
        this.centro = centro;
    }
    
}
