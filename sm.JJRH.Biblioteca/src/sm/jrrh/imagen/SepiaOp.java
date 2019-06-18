/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jrrh.imagen;

import java.awt.Color;
import java.awt.image.BufferedImage;
import sm.image.BufferedImageOpAdapter;

/**
 *En este método recorremos la imagen y le aplicaremos una ecuación en el que tocamos cada componente rgb de la imagen de entrada
     * y asignandole el mínimo entre 255 y los tres componentes rgb multiplicados por un factor diferente, de esta manera controlamos que estos valores de la multiplicación
     * sean superiores a 255, y se los vamos asignando a la imagen de salida. 
 * @author julius
 */ 
public class SepiaOp extends BufferedImageOpAdapter{

    /**
     *
     * @param in Variable del tipo BufferedImage. No puede ser null. 
     * @param out Variable del tipo BufferedImage. Puede ser null.
     * @return Imagen de salida variable del tipo BufferedImage.
     */
    @Override
    public BufferedImage filter(BufferedImage in, BufferedImage out) {
        double sepiaR, sepiaG, sepiaB;
        Color rgb, res;
        int red, green, blue;
        
        
        if (in == null) {
            throw new NullPointerException("input image is null");
        }
        if (out == null) {
            out = createCompatibleDestImage(in, null);
        }
        for (int x = 0; x < in.getWidth(); x++) {
            for (int y = 0; y < in.getHeight(); y++) {
                rgb = new Color(in.getRGB(x, y));
                red = rgb.getRed();
                green = rgb.getGreen();
                blue = rgb.getBlue();
                
                sepiaR = minR(red, green, blue);
                sepiaG = minG(red, green, blue);
                sepiaB = minB(red, green, blue);
                
                res = new Color((int) sepiaR, (int) sepiaG, (int) sepiaB);
                out.setRGB(x, y, res.getRGB());
            }
        }
        return out;
    }
    
    private double minR(double r, double g, double b){
        double min = 255;
        r = 0.793*r;
        g = 0.969*g;
        b = 0.589*b;
        
        if (r<min)
           min = r;
        else if (g < min)
            min = g;
        else if (b < min)
            min = b;
        
        return min;
    }
    
    private double minG(double r, double g, double b){
        double min = 255;
       
        r = 0.649*r;
        g = 0.886*g;
        b = 0.468*b;
       
        if (r<min)
           min = r;
        else if (g < min)
            min = g;
        else if (b < min)
            min = b;
        
        return min;
    }
    
    private double minB(double r, double g, double b){
        double min = 255;
       
        r = 0.672*r;
        g = 0.934*g;
        b = 0.331*b;
       
        if (r<min)
           min = r;
        else if (g < min)
            min = g;
        else if (b < min)
            min = b;
        
        return min;
    }
    
}
