/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.graficos;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *Clase heredada de Figuras relleno que permite construir, modificar y mover una figura rectangular.
 * @author julius
 */
public class Rectangulo extends FigurasRelleno {
    
    private Point2D p = new Point2D.Float(0,0);
    private GradientPaint gradiente;
    
    /**
     * Constructor de la clase Circunferencia
     */
    public Rectangulo() {
        super(new Rectangle());
    }
    
    
    /**
     *Método realizado para ajustar la la forma del rectángulo desde el p1 hasta el p2.
     * 
     * @param p1 Variable del tipo Point2D
     * @param p2 Variable del tipo Point2D
     */
    @Override
    public void setForma(Point2D p1, Point2D p2){
        ((Rectangle2D)formaPrincipal).setFrameFromDiagonal(p1, p2);
    }

    /**
     *Método para guardar el punto en el que se encuentra la figura.
     * @param p Variable de tipo Point2D.
     */
    @Override
    public void setPunto(Point2D p){
        this.p = p;
    }
    
    /**
     *Devuelve el toString del rectángulo
     * @return Variable de tipo String.
     */
    @Override
    public String toString() {
        return "Rectangulo";
    }
    
    /**
     * Método usado para cambiar la posición del rectángulo hacia un punto dado por parámetro.
     * @param p Variable del tipo Point2D.
     */
    @Override 
    public void setLocation(Point2D p){
        this.p = p;
        ((Rectangle)formaPrincipal).setLocation((Point)p);
    }
    
    /**
     *Método para pintar la figura. Puede ser pintada con distintos colores, relleno y gradientes.
     * @param g2d Variable de tipo Graphics2D.
     */
    @Override
    public void pintar(Graphics2D g2d){
        setAtributos(g2d);
        
        if ((getRelleno() != null && isRelleno())){
            g2d.setColor(getRelleno());
            g2d.fill(formaPrincipal);
            
        }
        if (getColor() != null)
            g2d.setColor(getColor());
        
        g2d.draw(formaPrincipal);
        
        if (getIsGradienteH()){
            if ((getRelleno() != null)){
                 gradiente = new GradientPaint((float)p.getX(),(float)p.getY(), getColor(), formaPrincipal.getBounds().width + (float)p.getX(), 
                      (float)p.getY(), getRelleno());
                g2d.setPaint(gradiente);
                g2d.fill(formaPrincipal);
            }
        }else if (getIsGradienteV()){
            gradiente = new GradientPaint((float)p.getX(),(float)p.getY(), getColor(), (float)p.getX(), 
                      formaPrincipal.getBounds().height + (float)p.getY(), getRelleno());
            g2d.setPaint(gradiente);
            g2d.fill(formaPrincipal);
        }else if (getIsGradienteD()){
            gradiente = new GradientPaint((float)p.getY(),(float)p.getX(), getColor(), formaPrincipal.getBounds().width + (float)p.getX(), 
                      formaPrincipal.getBounds().height + (float)p.getY(), getRelleno());
            g2d.setPaint(gradiente);
            g2d.fill(formaPrincipal);
        }
    }
}
