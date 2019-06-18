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
 *Clase que aplica el filtro negativo sobre una imagen invirtiendo los colores de los píxeles.
 * @author julius
 */
public class Negativo extends BufferedImageOpAdapter{
    private final int limite = 255;
    private int red, green, blue;
    private Color rgb, res;
    
    /**
     *Esta operación recorre la imagen de entrada in píxel a píxel y vamos cogiendo el color de cada píxel y restamos el valor de cada componente rgb a 255 para conseguir
     * que cada componente quede invertida. Juntamos cada componente y los guardamos en la imagen de salida.
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
                red = limite - rgb.getRed();
                green = limite - rgb.getGreen();
                blue = limite - rgb.getBlue();
                
                res = new Color(red, green, blue);
                out.setRGB(x, y, res.getRGB());
                
            }
        }
        return out;
    }
    
}
