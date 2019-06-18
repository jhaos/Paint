/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.graficos;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *Clase heredada de Figuras relleno que permite construir, modificar y mover una figura redondeada.
 * @author julius
 */
public class Circunferencia extends FigurasRelleno{
    private Point2D p = new Point2D.Float(0,0);
    private GradientPaint gradiente;
    /**
     *Constructor de la clase Circunferencia
     */
    public Circunferencia() {
        super(new Ellipse2D.Float());
    }
    
     /**
     * s
     * @param gr nuevo gradiente para settear.
     */
    public void setGradiente(GradientPaint gr){
        this.gradiente = gr;
    }
    
    /**
     *Método realizado para ajustar la la forma de la circunferencia desde el p1 hasta el p2.
     * 
     * @param p1 Variable del tipo Point2D
     * @param p2 Variable del tipo Point2D
     */
    @Override
    public void setForma(Point2D p1, Point2D p2){
        ((Ellipse2D)formaPrincipal).setFrameFromDiagonal(p1, p2);
    }

    /**
     *Sirve para mover la figura a partir del rectángulo que la contiene. Se le pasan dos coordenadas x, y  que es donde se dirigirá
     * la figura con un ancho y un alto también dados.
     * @param x Variable del tipo double.
     * @param y Variable del tipo double.
     * @param width Variable del tipo double.
     * @param height Variable del tipo double.
     */
    public void setFrame(double x, double y, double width, double height) {
        ((Ellipse2D)formaPrincipal).setFrame(x, y, width, height); 
    }

    /**
     *Devuelve el ancho de la figura.
     * @return Devuelve variable tipo double.
     */
    public double getWidth() {
        return ((Ellipse2D)formaPrincipal).getWidth(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Devuelve el alto de la forma geométrica.
     * @return Variable tipo double.
     */
    public double getHeight() {
         return ((Ellipse2D)formaPrincipal).getHeight();//To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Devuelve el toString de la circunferencia.
     * @return Variable de tipo String.
     */
    @Override
    public String toString() {
        return "Circunferencia";
    }

    /**
     * Método usado para cambiar la posición de la circunferencia hacia un punto dado por parámetro.
     * @param p Variable del tipo Point2D.
     */
    @Override
    public void setLocation(Point2D p){
        ((Ellipse2D)formaPrincipal).setFrame(p.getX(), p.getY(), ((Ellipse2D)formaPrincipal).getWidth(),
                ((Ellipse2D)formaPrincipal).getHeight());
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
