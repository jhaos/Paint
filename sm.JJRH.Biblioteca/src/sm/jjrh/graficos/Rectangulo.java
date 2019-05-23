/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.graficos;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author julius
 */
public class Rectangulo extends formas {
    
    Point2D p1, diagonal;
    
    public Rectangulo() {
        super(new Rectangle2D.Float());
    }
    
    public void setRectangulo(Point2D p1, Point2D diagonal){
        this.p1 = p1;
        this.diagonal = diagonal;
    }

    public Point2D getP1() {
        return p1;
    }

    public void setP1(Point2D p1) {
        this.p1 = p1;
    }

    public Point2D getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Point2D diagonal) {
        this.diagonal = diagonal;
    }
    
    
}
