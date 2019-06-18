/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *Clase heredada de Figuras relleno que permite construir, modificar y mover una línea o punto.
 * @author julius
 */
public class Linea2d extends FormasGraficos{

    /**
     *Constructor de Linea2d
     */
    public Linea2d(){
        super(new Line2D.Float());
    }
    
    /**
     *Método para pintar la linea con el color asignado.
     * @param g2d Variable de tipo Graphics2D.
     */
    @Override
    public void pintar(Graphics2D g2d){
        setAtributos(g2d);
        
        if (getColor() != null)
            g2d.setColor(getColor());
        
        g2d.draw(formaPrincipal);
    }
    
    /**
     * Método utilizado para relocalizar el punto final de la linea hacia ese 
     * @param p1 punto inicial.
     * @param p2 punto final.
     */
    
    
    public void setLinea(Point2D p1, Point2D p2){
        ((Line2D)formaPrincipal).setLine(p1, p2);
    }
    
    /**
     * Método para obtener el punto inicial de la Linea2D.
     * @return punto inicial.
     */
    public Point2D getP1(){
        return ((Line2D)formaPrincipal).getP1();
    }
    
    /**
     * Método para obtener el punto final de la Linea2D.
     * @return punto final.
     */
    public Point2D getP2(){
        return ((Line2D)formaPrincipal).getP2();
    }
    
    /**
     *Método realizado para ajustar la la forma de la línea desde el p1 hasta el p2.
     * 
     * @param p1 Variable del tipo Point2D
     * @param p2 Variable del tipo Point2D
     */
    @Override
    public void setForma(Point2D p1, Point2D p2){
         formaPrincipal = new Line2D.Float(p1, p2);
    }

    /**
     *Método que la distancia que hay desde la linea hasta el punto pasado por parámetro.
     * @param p Variable de tipo Point2D.
     * @return Variable de tipo float.
     */
    public float ptLineDist(Point2D p) {
        return (float) ((Line2D)formaPrincipal).ptLineDist(p);
    }

    /**
     * Devuelve la coordenada x del punto de inicio.
     * @return Variable de tipo double.
     */
    public double getX1() {
        return ((Line2D)formaPrincipal).getX1(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Devuelve la coordenada y del punto de inicio.
     * @return Variable de tipo double.
     */
    public double getY1() {
        return ((Line2D)formaPrincipal).getY1(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Devuelve la coordenada x del punto de final de la linea.
     * @return Variable de tipo double.
     */
    public double getX2() {
         return ((Line2D)formaPrincipal).getX2();//To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Devuelve la coordenada y del punto del final de la línea.
     * @return Variable de tipo double.
     */
    public double getY2() {
        return ((Line2D)formaPrincipal).getY2(); //To change body of generated methods, choose Tools | Templates.
    }


    /**
     *Devuelve el toString de la línea.
     * @return Variable de tipo String.
     */
    @Override
    public String toString() {
        return "Linea";
    }
    
    /**
     *Compara si el punto dado por parámatro esta a una distancia menor o igual del punto de inicio de la línea,
     * se usa para las lineas de que tienen p1 y p2 iguales, es decir, los puntos.
     * @param linea Variable del tipo Linea2d.
     * @param p Variable del tipo Point2D.
     * @return Variable de tipo boolean.
     */
    public boolean estaCercaPunto(Linea2d linea, Point2D p){
        return linea.getP1().distance(p) <= 4.0f;
    }

    /**
     *Método para saber si el punto que se pasa por parámetro esta dentro de la línea.
     * 
     * @param p Variable de tipo Point2D
     * @return Si el punto esta contenido en la linea devuelve el objeto Línea2d sino devuelve null.
     */
    @Override//es el metodo contains
    public FormasGraficos estaCerca(Point2D p) {
         if (this.getP1().equals(this.getP1())){
             if (estaCercaPunto(this, p)){
                 return this;
             }
        }
        if(this.ptLineDist(p)<= 4.0f){
            return this;
        }
         
         return null;
    }
    
    /**
     *Método para relocalizarla línea, distingue entre lineas con punto inicial y final iguales y con puntos inicial y final diferentes.
     * 
     * @param p Variable Point2D donde desplazar la Linea.
     */
    @Override
    public void setLocation(Point2D p) {
        if(this.getP1().equals(this.getP2())){
            this.setLinea(p, p);
        }else{
            double dx = p.getX()- getX1();
            double dy=p.getY()- getY1();
            Point2D np2 = new Point2D.Double(getX2()+dx, getY2()+dy);
            setLinea(p,np2);
        }
    }


    @Override
    public void setIsRelleno(boolean relleno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public boolean isRelleno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void setIsGradienteH(boolean g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIsGradienteV(boolean g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIsGradienteD(boolean g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getIsGradienteH() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getIsGradienteV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getIsGradienteD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPunto(Point2D p) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRelleno(Color Relleno) {
         
    }
    
    @Override
    public Color getRelleno() {
        return null; //To change body of generated methods, choose Tools | Templates.
    }


}
