/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.graficos;

import java.awt.Color;
import java.awt.Composite;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author julius
 */
public class formas{
    private Color color;
    private Stroke trazo;
    private Color Relleno;
    private RenderingHints render;
    private Composite comp;
    Shape formaPrincipal;

    public Shape getFormaPrincipal() {
        return formaPrincipal;
    }
    
    formas(Shape shape){
        this.formaPrincipal = shape;
    }

    public void setFormaPrincipal(Shape formaPrincipal) {
        this.formaPrincipal = formaPrincipal;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Stroke getTrazo() {
        return trazo;
    }

    public void setTrazo(Stroke trazo) {
        this.trazo = trazo;
    }

    public Color getRelleno() {
        return Relleno;
    }

    public void setRelleno(Color Relleno) {
        this.Relleno = Relleno;
    }

    public RenderingHints getRender() {
        return render;
    }

    public void setRender(RenderingHints render) {
        this.render = render;
    }

    public Composite getComp() {
        return comp;
    }

    public void setComp(Composite comp) {
        this.comp = comp;
    }
    
    public void setLocation(Point2D pos, Line2D l, int forma, java.awt.event.MouseEvent evt){
    
        if (forma == 1 || forma == 2){
            double dx=pos.getX()-l.getX1();
            double dy=pos.getY()-l.getY1();
            Point2D np2 = new Point2D.Double(l.getX2()+dx,l.getY2()+dy);
            l.setLine(pos,np2);
        }else{
            ((Ellipse2D)formaPrincipal).setFrame(evt.getPoint().getX(), evt.getPoint().getY(), 
                   ((Ellipse2D)formaPrincipal).getWidth(), ((Ellipse2D)formaPrincipal).getHeight());
        }
    }
    
    
}
