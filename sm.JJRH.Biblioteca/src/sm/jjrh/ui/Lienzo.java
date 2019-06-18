/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.ui;

import sm.jjrh.graficos.FormasGraficos;
import sm.jjrh.graficos.Circunferencia;
import sm.jjrh.graficos.Linea2d;
import sm.jjrh.graficos.Rectangulo;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import sm.jjrh.eventos.LienzoEvent;
import sm.jjrh.eventos.LienzoListener;

/**
 *Esta clase permite dibujar formas geoméetricas sobre un panel, moverlas y realizar actualizaciones con sus atributos.
 * @author julius
 */
public class Lienzo extends javax.swing.JPanel {
    private Point2D p1 = new Point(-10,-10);
    private Point2D p2 = new Point(-10,-10);
    private Color color = new Color(255,0,0), colorRelleno = new Color(255,0,0);
    private boolean relleno = false, isRender = false, editar = false;
    private int cambioStroke = 1;
    private FormasGraficos formaGraficos;
    public formas forma = formas.Puntos;
    private ArrayList<FormasGraficos> vFormas = new ArrayList();
    private FormasGraficos movida2;
    ArrayList<LienzoListener> lienzoEventListeners = new ArrayList();
    private int ancho = 300, alto = 300;
    private boolean strokeActivado =false;
    
    
    /**
     *Asigna el valor que le llega a una variable booleana. Util para guardar el estado del lienzo.
     * @param activad Variable del tipo boolean.
     */
    public void setStrokeActivado(boolean activad){
        strokeActivado = activad;
    }
    
    /**
     *Devuelve si ha cambiado el stroke o no. Util para saber en que estado
     * esta tu lienzo y usarlo para saber el estado antes de cambiar de lienzo.
     * @return devuelve variable del tipo int. 
     */
    public boolean getStrokeActivado(){
        return strokeActivado;
    }
    
    /**Devuelve una forma geométrica si existe en el lienzo, si no existe devuelve null.
     * @return <ul>
     *  <li>formasGraficos: si existe una forma geométrica devuelve una forma geométrica de la clase FormasGraficos.</li>
     * <li>null: si no hay ninguna figura dibujada.</li>
     * </ul>
     */
    public FormasGraficos getFormaGraficos(){
        if (formaGraficos != null)
            return formaGraficos;
        return null;
    }
    
    /**
     *Asigna un color a la variable color del lienzo. Util para guardar el estado del lienzo.
     * 
     * @param color Variable del tipo Color.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *Asigna un color de relleno a la variable colorRelleno del lienzo. Util para guardar el estado del lienzo.
     * 
     * @param colorRelleno Variable del tipo Color.
     */
    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }
    
    /**
     *Devuelve el último color de relleno que se le ha asignado a lienzo. Util para saber en que estado
     * esta tu lienzo y usarlo para saber el estado antes de cambiar de lienzo.
     * 
     * @return Devuelve variable de tipo Color.
     */
    public Color getColorRelleno(){
        return colorRelleno;
    }
    
    /**
     *Asignar si el lienzo tenia asignado un color de relleno. Util para guardar el estado del lienzo.
     * @param r Variable del tipo boolean.
     */
    public void setIsRelleno(boolean r){
        relleno = r;
    }
    
    /**
     *Asigna el ancho del lienzo. Se puede usar para personalizar el tamaño del ancho del lienzo.
     * Por defecto tiene valor 300.
     * @param ancho Variable del tipo int.
     */
    public void setAncho(int ancho){
        this.ancho = ancho;
    }
    
    /**
     *Asigna el alto del lienzo. Se puede usar para personalizar el tamaño del alto del lienzo.
     * Por defecto tiene valor 300.
     * @param alto Variable del tipo int.
     */
    public void setAlto(int alto){
        this.alto = alto;
    }
    
    /**
     *Método que añade al vector de eventos de lienzo un manejador del tipo LienzoListener. Permite la comunicación
     * entre clases y eventos.
     * 
     * @param listener Objeto de la clase LienzoListener
     */
    public void addLienzoListener(LienzoListener listener){
        if (listener != null) {
            lienzoEventListeners.add(listener);
        }
    }
    /**
     *Método para notificar a los manejadores que se ha producido un evento, en este caso que se ha añadido una
     * figura. Recorre el vector de manejadores enviando el evento.
     * 
     * @param evt Objeto de la clase LienzoListener notificando que ha ocurrido un evento.
     */
    private void notifyShapeAddedEvent(LienzoEvent evt) {
        if (!lienzoEventListeners.isEmpty()) {
            for (LienzoListener listener : lienzoEventListeners) {
                listener.shapeAdded(evt);
            }
        }
    }
    

    private void notifyPropertyChangeEvent(LienzoEvent evt) {
        if (!lienzoEventListeners.isEmpty()) {
            for (LienzoListener listener : lienzoEventListeners) {
                listener.principalChange(evt);
            }
        }
    }
    

    private void notifyCambioPosicion(LienzoEvent evt) {
        if (!lienzoEventListeners.isEmpty()) {
            for (LienzoListener listener : lienzoEventListeners) {
                listener.actualizarPosicion(evt);
            }
        }
    }
    
    /**
     *Método que devuelve el ArrayList del tipo FormasGraficos con todas las formas dibujadas en el lienzo.
     * @return Devuelve un objeto ArrayList del tipo FormasGraficos.
     */
    public ArrayList<FormasGraficos> getvShape() {
        return vFormas;
    }
        
    /**
     *Devuelve el estado de la variable que contiene el último valor que se ha puesto de  stroke para el grosor del trazo. 
     * Util para saber en que estado esta tu lienzo y usarlo para saber el estado antes de cambiar de lienzo.
     * 
     * @return Devuelve un objeto de tipo int.
     */
    public int getStrokeValue(){
        return cambioStroke;
    }

    /**
     *Devuelve el estado de la variable que refleja si existe un color de relleno para el lienzo. Util para saber en que estado
     * esta tu lienzo y usarlo para saber el estado antes de cambiar de lienzo.
     * @return Devuelve un objeto de tipo boolean.
     */
    public boolean isRelleno() {
        return relleno;
    }

    /**
     * Devuelve el estado de la variable que refleja si el lienzo se puede editar o no.
     * @return Devuelve un objeto de tipo boolean.
     */
    public boolean isEditar() {
        return editar;
    }
    
    /**
     *Devuelve el estado de la variable que refleja si esta renderizado. Util para saber en que estado
     * esta tu lienzo y usarlo para saber el estado antes de cambiar de lienzo.
     * @return Devuelve un objeto de tipo boolean.
     */
    public boolean isRender() {
        return isRender;
    }

    
    /**
     *Asignar si el lienzo estaba en estado editar o no. Util para guardar el estado del lienzo.
     * @param edit Variable del tipo boolean.
     */
    public void setEditar(boolean edit){
        this.editar = edit;
    }
    
    /**
     *Asignar la anchura del trazo marcado en ese lienzo. Util para guardar el estado del lienzo. Si el estado entrante es 0
     * se cambia a 1 ya que el ancho de trazo no puede ser 0.
     * 
     * @param stro Variable de tipo int
     */
    public void setStroke(int stro){
        if (stro == 0){
            stro = 1;
        }
    }
    
    /**
     *Asignar una forma dibujada al lienzo. Util para guardar el estado del lienzo.
     * @param forma variable del tipo formas.
     */
    public void setFormaLienzo(formas forma){
        this.forma = forma;
    }
    
    /*
     *Devuelve el estado de la variable que tiene la forma geométrica que se ha dibujado. Util para saber en que estado
     * esta tu lienzo y usarlo para saber el estado antes de cambiar de lienzo.
     * @return Devuelve un objeto de tipo formas.
    */
    public formas getForma(){
        return forma;
    }

    /**
     *Devuelve el último color de trazo que se le ha asignado a lienzo. Util para saber en que estado
     * esta tu lienzo y usarlo para saber el estado antes de cambiar de lienzo.
     * 
     * @return Devuelve variabe del tipo Color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Constructor de la clase Lienzo.
     *
     */
    public Lienzo() {
        initComponents();
    }

    /**
     * Método que pinta las formas geométricas, el espacio de dibujado enmarcar la figura que este en edición.
     *
     * @param g Variable de tipo Graphics. 
     */
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.clipRect(0, 0, ancho, alto);
        
        
        for (FormasGraficos s: vFormas){
            s.pintar(g2d);
            if (s.isEditar()){
               g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
               float[] patron = {10f, 10f, 15f, 10f};
               Stroke stroke1 = new BasicStroke(2f, BasicStroke.CAP_SQUARE,
                        BasicStroke.JOIN_MITER, 1.0f, patron, 0.0f);
                g2d.setColor(Color.black);
                g2d.setStroke(stroke1);
                g2d.draw(s.getBounds()); 
            }
        }
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(500, 500));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private FormasGraficos createShape(Point2D p1, Point2D p2){
        
        switch(forma){
            case Puntos:
                formaGraficos = new Linea2d();
                formaGraficos.setForma(p1,p1);
                break;
            case Lineas:
                formaGraficos = new Linea2d();
                formaGraficos.setForma(p1,p2);
                break;
            case Rectangulo:
                formaGraficos = new Rectangulo();
                formaGraficos.setForma(p1, p2);
                break;
            case Circulo:
                formaGraficos = new Circunferencia();
                formaGraficos.setForma(p1, p2); 
                break;
            default:
                System.out.println("forma no correcta");
                break;
        }
        
        return formaGraficos;
    }
    
    private void updateShape(Point2D p1, Point2D n_p2){
        if (forma != formas.Puntos)
            formaGraficos.setForma(p1, n_p2); 
    }
    
    
    private FormasGraficos getSelectedShape(Point2D p){
        for(FormasGraficos s: vFormas){
            if(s.estaCerca(p)!= null){
                return s.estaCerca(p);
            }
        }
        return null;
        
    }
    
    /**
     * Asignar una una forma geométrica del tipo FormasGraficos al lienzo.
     * @param formG Un objeto del tipo FormasGraficos.
     */
    public void setFormaGraficos(FormasGraficos formG){
       formaGraficos = formG;
   }
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        
        if (!editar){
            p1 = evt.getPoint();
            FormasGraficos f = createShape(p1,p1);
            this.vFormas.add(f);    
            notifyShapeAddedEvent( new LienzoEvent(this,f) );
            this.repaint();
        }else{
            movida2 = (FormasGraficos)getSelectedShape(evt.getPoint());
            formaGraficos = movida2;
            if (movida2 != null)
                notifyPropertyChangeEvent(new LienzoEvent(this,movida2));            
        }
        
        
    }//GEN-LAST:event_formMousePressed

    
    
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here: 
        if (!editar){
            p2 = evt.getPoint();
            updateShape(p1, p2);
            this.repaint();
        }else{
            if (movida2 != null){
                movida2.setPunto(evt.getPoint());
                movida2.setLocation(evt.getPoint());
                notifyCambioPosicion(new LienzoEvent(this,movida2));
                System.out.println(movida2.getCambioStroke());
            }
            repaint();
        }
        
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        if(forma != formas.Puntos)
            this.formMouseDragged(evt);
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
