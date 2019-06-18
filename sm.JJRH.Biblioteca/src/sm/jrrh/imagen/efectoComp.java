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
 *En esta clase se define una operación de mezcla de componentes de los píxeles.
 * @author julius
 */
public class efectoComp extends BufferedImageOpAdapter{

    /**
     *Esta operación recorre la imagen píxel a píxel los componentes de cada pixel y se intercambian
     * sustituyendo cada componente por la suma de los otros dos, es decir, si en el objeto Color la 
     * primera componente que le pasa es el color Rojo, pues en lugar de ese color se le pasa la suma de las 
     * componentes verdes y azules de ese pixel.
     * 
     * @param in Variable del tipo BufferedImage. No puede ser null. 
     * @param out Variable del tipo BufferedImage. Puede ser null.
     * @return Imagen de salida variable del tipo BufferedImage.
     */
    @Override
    public BufferedImage filter(BufferedImage in, BufferedImage out) {
        Color rgb, res;
        if (in == null) {
            throw new NullPointerException("input image is null");
        }
        if (out == null) {
            out = createCompatibleDestImage(in, null);
        }
        for (int x = 0; x < in.getWidth(); x++) {
            for (int y = 0; y < in.getHeight(); y++) {
                rgb = new Color(in.getRGB(x, y));
                res = new Color((rgb.getGreen()+rgb.getBlue())%255, 
                        (rgb.getRed()+rgb.getBlue())%255, (rgb.getGreen()+rgb.getRed())%255);
                out.setRGB(x, y, res.getRGB());
            }
        }
        return out;
    }
    
}
