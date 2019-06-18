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
 *Clase que aplica un filtro el cual consigue que la mitad superior de la imagen se copie
 * en la mitad inferior de la imagen realizando un duplicado. Esta clase hereda de BufferedImageOpAdapter sobre la cual se sobrecarga el método filter. 
 * @author julius
 */
public class DivideDupOp extends BufferedImageOpAdapter{ 

    /**
     *Esta operación recorre la imagen de entrada in píxel a píxel y vamos cogiendo el color de cada píxel. Cuando la imagen de entrada esté
     * por encima de la mitad en la mitad superior de la imagen de salida se copiaran los colores de los píxeles de la parte superior de la imagen de entrada
     * y además en la imagen de salida se copiarán a partir de la mitad de la imagen de salida se copiarán estos mismos colores de los píxeles. 
     * Si el segundo parámetro es null usaremos createCompatibleDestImage y se la asignaremos.
     * 
     * @param in Variable del tipo BufferedImage. No puede ser null. 
     * @param out Variable del tipo BufferedImage. Puede ser null.
     * @return Imagen de salida variable del tipo BufferedImage.
     */
    @Override
    public BufferedImage filter(BufferedImage in, BufferedImage out) {
        Color rgb;
        if (in == null) {
            throw new NullPointerException("input image is null");
        }
        if (out == null) {
            out = createCompatibleDestImage(in, null);
        }
        for (int x = 0; x < in.getWidth(); x++) {
            for (int y = 0; y < in.getHeight(); y++) {
                rgb = new Color(in.getRGB(x, y));
                if(y<=(in.getHeight()/2)){
                    out.setRGB(x, (in.getHeight()/2) +y-1, rgb.getRGB());
                    out.setRGB(x, y, rgb.getRGB());
                }
            }
        }
        return out;
    }
    
}


