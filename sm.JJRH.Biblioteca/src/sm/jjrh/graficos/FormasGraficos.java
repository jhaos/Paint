/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.graficos;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author julius
 */
public abstract  class FormasGraficos implements Shape{
    private Color color = new Color(255,0,0);
    private Stroke trazo = new BasicStroke(1);
    private RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);
    private Composite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);

    /**
     *
     */
    protected Shape formaPrincipal;
    private boolean isRender = false,
            isCompose = false, editar = false, isStroke= false;
    private int cambioStroke = 1;
    private float cambioTranspacencia = 1;
    
    /**
     *Método abstacto que permite dibujar una forma a partir de dos puntos pasados por parámetro.
     * @param p1 Variable de tipo Point2D.
     * @param p2 Variable de tipo Point2D.
     */
    abstract public void setForma(Point2D p1, Point2D p2);

    /**
     *Método abstracto para pintar la figura que corresponda.
     * @param g2d Variable tipo Graphics2D.
     */
    abstract public void pintar(Graphics2D g2d);

    /**
     *Método abstracto que devuelve el color de relleno de la figura en caso de tenerlo.
     * @return Devuelve variable tipo Color.
     */
    abstract public Color getRelleno();

    /**
     *Método para saber si el punto pasado por parámetro esta contenido en la figura, si lo está devuelve la figura
     * sino devuelve null.
     * @param p Variable de tipo Point2D.
     * @return <ul>
     * <li>FormaRelleno: Si esta contenido</li>
     * <li>null: Si no esta contenido</li>
     * </ul>
     */
    abstract public FormasGraficos estaCerca(Point2D p);

    /**
     *Método para guardar el color de relleno de la figura.
     * @param Relleno Variable de tipo Color.
     */
    abstract public void setRelleno(Color Relleno);

    /**
     * Método usado para cambiar la posición de la figura hacia un punto dado por parámetro.
     * @param p Variable del tipo Point2D.
     */
    abstract public void setLocation(Point2D p);

    /**Método para guardar si el gradiente horizontal esta activado.
     *
     * @param g Variable de tipo boolean.
     */
    abstract public void setIsGradienteH(boolean g);

    /**Método para guardar si el gradiente vertical esta activado.
     *
     * @param g Variable de tipo boolean.
     */
    abstract public void setIsGradienteV(boolean g);

    /**Método para guardar si el gradiente diagonal esta activado.
     *
     * @param g Variable de tipo boolean.
     */
    abstract public void setIsGradienteD(boolean g);

    /**
     *Método que devuelve si el gradiente horizontal está activo o no.
     * @return Variable de tipo boolean.
     */
    abstract public boolean getIsGradienteH();

    /**
     *Método que devuelve si el gradiente vertical está activo o no.
     * @return Variable de tipo boolean.
     */
    abstract public boolean getIsGradienteV();

    /**
     *Método que devuelve si el gradiente diagonal está activo o no.
     * @return Variable de tipo boolean.
     */
    abstract public boolean getIsGradienteD();

    /**
     *Método para guardar el punto en el que se encuentra la figura.
     * @param p Variable de tipo Point2D.
     */
    abstract public void setPunto(Point2D p);
    
    /**Método que devuelve si el Stroke está activado en la figura o es el que esta por defecto.
     *
     * @return Variable de tipo boolean. <ul>
     * <li>true: Si está activado</li>
     * <li>false: Si está activado el de por defecto </li>
     * </ul>
     */
    public boolean isIsStroke() {
        return isStroke;
    }

    /**
     * Método para almacenar si la figura tiene el stroke activado o el que esta por defecto.
     * @param isStroke nuevo valor para el stroke.
     */
    public void setIsStroke(boolean isStroke) {
        this.isStroke = isStroke;
    }
    
    /**
     * Método que devuelve el valor de la transparencia que tiene la figura.
     * @return Variable de tipo float.
     */
    public float getCambioTranspacencia() {
        return cambioTranspacencia;
    }

    /**
     *Método para guardar el grado de transparencia que tiene la figura.
     * @param cambioTranspacencia Variable de tipo float.
     */
    public void setCambioTranspacencia(float cambioTranspacencia) {
        this.cambioTranspacencia = cambioTranspacencia;
    }
    
    /**
     *Método que devuelve la figura.
     * @return Variable de tipo Shape.
     */
    public Shape getFormaPrincipal() {
        return formaPrincipal;
    }
    
    /**
     *Guarda el color de relleno pasado por parámetro.
     * @param relleno Variable de tipo Color.
     */
    abstract public void setIsRelleno(boolean relleno);
    
    FormasGraficos(Shape shape){
        this.formaPrincipal = shape;
    }

    /**
     *Método para cambiar la figura.
     * @param formaPrincipal Variable de tipo Shape.
     */
    public void setFormaPrincipal(Shape formaPrincipal) {
        this.formaPrincipal = formaPrincipal;
    }

    /**
     *Método que devuelve el color del trazo de la figura.
     * @return Variable de tipo Color.
     */
    public Color getColor() {
        return color;
    }

    /**
     *Método para guardar el color del trazo de la figura.
     * @param color Variable de tipo Color.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *Méteodo que devuelve el tipo de trazo(Stroke) de la figura.
     * @return Variable de tipo Stroke.
     */
    public Stroke getTrazo() {
        return trazo;
    }

    /**
     *Método para guardar el tipo de trazo que se le pasa por parámetro.
     * @param trazo Variable de tipo Stroke.
     */
    public void setTrazo(Stroke trazo) {
        this.trazo = trazo;
    }

    /**
     *Devuelve el nivel de grosor de trazo que tiene la figura.
     * @return Variable de tipo int
     */
    public int getCambioStroke() {
        return cambioStroke;
    }

    /**
     *Devuelve si la figura con relleno tiene un color de relleno o no.
     * @return Variable tipo boolean.
     */
    abstract public boolean isRelleno();

    /**
     *Devuelve si la figura con relleno tiene alisado o no.
     * @return Variable tipo boolean.
     */
    public boolean isRender() {
        return isRender;
    }

    /**
     *Método para guardar si la figura está en modo editar o no.
     * @param editar Variable de tipo boolean.
     */
    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    /**
     *Método que devuelve si una figura tiene transparencia o no.
     * @return Variable de tipo boolean.
     */
    public boolean isCompose() {
        return isCompose;
    }

    /**
     *Método que devuelve si una figura está en modo editar o no.
     * @return Variable de tipo boolean.
     */
    public boolean isEditar() {
        return editar;
    }


    /**
     *Método que se llama antes de pintar la forma para añadirle los atributos: tipo de trazo, tipo de alisado y 
     * tipo de transparencia.
     * @param g2d Variable de la clase Graphics2D.
     */
    public void setAtributos(Graphics2D g2d){   
        if (isRender){
            g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON));
        }else{
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_OFF);
            g2d.setRenderingHints(render);
        }
        if (isCompose){
            Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, cambioTranspacencia);
            g2d.setComposite(c);
        }else{
            Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
            g2d.setComposite(c);
        }
        if (isStroke){
            float[] patron = {10f, 4f};
            trazo = new BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, patron, 0.0f);
        }else{
            trazo = new BasicStroke(cambioStroke);
        }
        
        setTrazo(trazo);
        g2d.setStroke(trazo);
    }
        
    /**
     *Devuelve el rectángulo que cubre la figura.
     * @return Variable de tipo Rectangle.
     */
    @Override
    public Rectangle getBounds() {
        return formaPrincipal.getBounds(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Devuelve el rectángulo2D que cubre la figura.
     * @return Variable del tipo Rectangle2D.
     */
    @Override
    public Rectangle2D getBounds2D() {
        return formaPrincipal.getBounds2D(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Comprueba si las coordenadas dadas por parámetro estan dentro de la figura y retorna true o false si las contiene o no.
     * @param d Variable tipo double.
     * @param d1 Variable tipo double.
     * @return Variable de tipo boolean.
     */
    @Override
    public boolean contains(double d, double d1) {
        return formaPrincipal.contains(d,d1); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Comprueba si el punto dado por parámetro estan dentro de la figura y retorna true o false si lo contiene o no.
     * @param pd Variable de tipo Point2D.
     * @return Variable de tipo boolean.
     */
    @Override
    public boolean contains(Point2D pd) {
        return formaPrincipal.contains(pd);//To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Comprueba si el rectángulo que forman las coordenadas dadas por parámetro interseca con la figura.
     * y retorna true o false si lo contiene o no.
     * @param d Variable tipo double.
     * @param d1 Variable tipo double.
     * @param d2 Variable tipo double.
     * @param d3 Variable tipo double.
     * @return Variable de tipo boolean.
     */
    @Override
    public boolean intersects(double d, double d1, double d2, double d3) {
        return formaPrincipal.intersects(d, d1, d2, d3); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Comprueba si el rectángulo dado por parámetro interseca con la figura.
     * y retorna true o false si lo contiene o no.
     * @param rd Variable de tipo Rectangle2D.
     * @return Variable de tipo boolean.
     */
    @Override
    public boolean intersects(Rectangle2D rd) {
        return formaPrincipal.intersects(rd);//To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Comprueba si el rectángulo que forman las coordenadas dadas por parámetro estan dentro de la figura.
     * y retorna true o false si lo contiene o no.
     * @param d Variable tipo double.
     * @param d1 Variable tipo double.
     * @param d2 Variable tipo double.
     * @param d3 Variable tipo double.
     * @return Variable de tipo boolean.
     */
    @Override
    public boolean contains(double d, double d1, double d2, double d3) {
        return formaPrincipal.intersects(d, d1, d2, d3); //To change body of generated methods, choose Tools | Templates.
    }

     /**
     *Comprueba si el rectángulo dado por parámetro esta dentro de la figura 
     * y retorna true o false si lo contiene o no.
     * @param rd Variable de tipo Rectangle2D.
     * @return Variable de tipo boolean.
     */
    @Override
    public boolean contains(Rectangle2D rd) {
        return formaPrincipal.contains(rd); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Devuelve un objeto iterador que recorre el límite de la Forma y proporciona acceso a la geometría del contorno de la Forma.
     * @param at Variablde tipo AffineTransform.
     * @return Nueva variable PathIterator.
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return formaPrincipal.getPathIterator(at); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Devuelve un objeto iterador que recorre el límite de la forma y proporciona acceso a una vista aplanada de la geometría del contorno de la forma.
     * 
     * @param at Variablde tipo AffineTransform
     * @param d Variable de tipo double.
     * @return Nueva variable de tipo PathIterator.
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at, double d) {
        return formaPrincipal.getPathIterator(at, d);//To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Método para guardar el grosor del trazo de la figura.
     * @param stro Variable de tipo int que indica el grosor de la figura.
     */
    public void setCambioStroke(int stro) {
        cambioStroke = stro; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Método que guarda si la figura tiene algún grado de transparencia o no.
     * @param compose Variable de tipo boolean.
     */
    public void setCompose(boolean compose) {
        isCompose = compose; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Método que guarda si la figura tiene el alisado activado o no.
     * @param renderizado Variable de tipo boolean.
     */
    public void setRender(boolean renderizado) {
        isRender = renderizado; //To change body of generated methods, choose Tools | Templates.
    }
    

}
