/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.graficos;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author julius
 */
public class Linea2d extends formas{

    private Point2D p1, p2;
    
    Linea2d(){
        super(new Line2D.Float());
        
    }
    
    void setLinea(Point2D p1, Point2D p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    
}
