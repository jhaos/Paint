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
 * Clase que realiza una umbralización haciendo que si los pixeles superan un valor medio se les cambiará el color del pixel y si no lo superan no cambia.
 * @author julius
 */

    public class UmbralizacionOp extends BufferedImageOpAdapter{
        private int umbral;
        int red, green, blue;
        Color rgb, res;

    /**
     *Constructor del operador, ha de tener tener un umbral que marque a partir de que valores es necesario cambiar
     * el color de los componentes del pixel.
     * @param umbral Variable de tipo int. Debe estar comprendida entre 0 y 255.
     */
    public UmbralizacionOp(int umbral) {
            this.umbral = umbral;
        }
        
    /**
     *Método que permite cambiar el nivel del umbral.
     * @param umbral Variable de tipo int. Debe estar comprendida entre 0 y 255.
     */
    public void setUmbral(int umbral){
            this.umbral = umbral;
        }

    /**
     *Con este método conseguimos que los pixeles cuya combinación de componentes dividido entre tres sea mayor que el umbral
     * que tiene asignada la clase desde su construcción 
     * 
     * @param in Variable del tipo BufferedImage. No puede ser null. 
     * @param out Variable del tipo BufferedImage. Puede ser null.
     * @return Imagen de salida variable del tipo BufferedImage.
     */
    @Override
        public BufferedImage filter(BufferedImage in, BufferedImage out) {
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
                
                if (intensidad(red,green,blue) > umbral)
                    res = rgb;
                else
                    res = new Color(50, 50, 50);
                out.setRGB(x, y, res.getRGB());
            }
        }
        return out;
    }
        
    private double intensidad(int r, int g, int b){
        return (int)(r+g+b)/3;
    }
}
