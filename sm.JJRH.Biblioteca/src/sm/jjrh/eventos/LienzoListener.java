/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.eventos;

import java.util.EventListener;

/**
 *Clase interfaz que recoge los eventos posibles que se puedan generar.
 * @author julius
 */
public interface LienzoListener extends EventListener{

    /**
     * Este método indica que en el lienzo se ha generado una figura nueva y agrega esa figura a la lista de figuras que hay en la clase principal.
     * @param evt evento de la clase LienzoEvent que llega desde lienzo para indicar que se ha añadido una figura.
     */
    public void shapeAdded(LienzoEvent evt);

    /**
     *Este método indica que en el lienzo alguna figura ha cambiado sus atributos por lo que este método
     * actualiza la información de la clase principal para que se indiquen los atributos en los botones y listas 
     * de la clase principal. Hace visible en principal los atributos que tiene la figura.
     * 
     * @param evt evento de la clase LienzoEvent que llega desde lienzo que indica que una figura ha cambiado sus atributos.
     */
    public void principalChange(LienzoEvent evt);

    /**
     * Al recibir el evento este método actualizará el valor de las coordenadas de la figura y hará que se muestren en la clase
     * principal. Hace visible la posición de la figura.
     *
     * @param evt evento de la clase LienzoEvent que llega desde lienzo que indica que una figura ha cambiado de posición.
     */
    public void actualizarPosicion(LienzoEvent evt);
}

