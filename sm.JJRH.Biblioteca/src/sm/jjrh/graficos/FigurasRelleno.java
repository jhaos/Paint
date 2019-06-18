/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 *Clase que hereda de FormasGraficos. Es utilizada para las figuras que puedan tener un color de relleno así como un gradiente en combinación de color.
 * @author julius
 */
public class FigurasRelleno extends FormasGraficos{
    private Color Relleno = null;
    private boolean isRelleno = false, isGradienteH = false,
            isGradienteV = false, isGradienteD = false;

    
    
    
    /**
     *  Constructor de una figura con relleno a partir del shape que sele pasa por parámetro.
     * @param shape Parámetro del tipo Shape.
     */
    public FigurasRelleno(Shape shape) {
        super(shape);
    }

    /**
     *Guarda el color de relleno pasado por parámetro.
     * @param Relleno Variable de tipo Color.
     */
    @Override
    public void setRelleno(Color Relleno) {
        this.Relleno = Relleno;
    }
    
    /**
     *Devuelve el color de relleno de la figura con relleno.
     * @return Variable de tipo color.
     */
    @Override
    public Color getRelleno(){
        return Relleno;
    }
    
    /**
     *Devuelve si la figura con relleno tiene un color de relleno o no.
     * @return Variable tipo boolean.
     */
    @Override
    public boolean isRelleno() {
        return isRelleno;
    }
    
    /**
     *Método para recibir si la figura con relleno tiene relleno o no.
     * @param relleno Variable de tipo boolean.
     */
    @Override
    public void setIsRelleno(boolean relleno) {
        this.isRelleno = relleno;
    }
    

    @Override
    public void setForma(Point2D p1, Point2D p2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Método para saber si el punto pasado por parámetro esta contenido en la figura con relleno si lo está devuelve la figura
     * sino devuelve null.
     * @param p Variable de tipo Point2D.
     * @return <ul>
     * <li>FormaRelleno: Si esta contenido</li>
     * <li>null: Si no esta contenido</li>
     * </ul>
     */
    @Override
    public FormasGraficos estaCerca(Point2D p) {
        if(this.contains(p)){ 
            return this;
        }
        return null;
    }

    
    @Override
    public void setLocation(Point2D p) {
        System.out.println("estoy en el de blanco"); //To change body of generated methods, choose Tools | Templates.
    }

    /**Método para guardar si el gradiente horizontal esta activado.
     *
     * @param g Variable de tipo boolean.
     */
    @Override
    public void setIsGradienteH(boolean g) {
        
        this.isGradienteH = g; 
    }

    /**Método para guardar si el gradiente vertical esta activado.
     *
     * @param g Variable de tipo boolean.
     */
    @Override
    public void setIsGradienteV(boolean g) {
        this.isGradienteV = g; 
    }

    /**Método para guardar si el diagonal horizontal esta activado.
     *
     * @param g Variable de tipo boolean.
     */
    @Override
    public void setIsGradienteD(boolean g) {
        this.isGradienteD = g; 
    }

    /**
     *Método que devuelve si el gradiente horizontal está activo o no.
     * @return Variable de tipo boolean.
     */
    @Override
    public boolean getIsGradienteH() {
        return isGradienteH; 
    }

    /**
     *Método que devuelve si el gradiente vertical está activo o no.
     * @return Variable de tipo boolean.
     */
    @Override
    public boolean getIsGradienteV() {
        return isGradienteV;
    }

    /**
     *Método que devuelve si el gradiente diagonal está activo o no.
     * @return Variable de tipo boolean.
     */
    @Override
    public boolean getIsGradienteD() {
        return isGradienteD; 
    }


    @Override
    public void setPunto(Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void pintar(Graphics2D g2d){
        System.out.println("no necesaria implementacion");
    }


    
    
    
    
}
