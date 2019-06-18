/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.eventos;

/**
 *Adapter de LienzoListener que contendrá los metodos generados por LienzoListener si queremos implementar una configuración defecto.
 * En este caso no ha sido necesario.
 * De esta clase heredará la clase manejadora que será la que implemente estos metódos.
 * @author julius
 */
public class LienzoAdapter implements LienzoListener{

    /**
     * Este método indica que en el lienzo se ha generado una figura nueva y agrega esa figura a la lista de figuras que hay en la clase principal.
     * @param evt evento de la clase LienzoEvent que llega desde lienzo para indicar que se ha añadido una figura.
     */
    @Override
    public void shapeAdded(LienzoEvent evt){}

    /**
     *Este método indica que en el lienzo alguna figura ha cambiado sus atributos por lo que este método
     * actualiza la información de la clase principal para que se indiquen los atributos en los botones y listas 
     * de la clase principal. Hace visible en principal los atributos que tiene la figura.
     * 
     * @param evt evento de la clase LienzoEvent que llega desde lienzo que indica que una figura ha cambiado sus atributos.
     */
    @Override
    public void principalChange(LienzoEvent evt){}

    /**
     *Al recibir el evento este método actualizará el valor de las coordenadas de la figura y hará que se muestren en la clase
     * principal. Hace visible la posición de la figura.
     * 
     * @param evt evento de la clase LienzoEvent que llega desde lienzo que indica que una figura ha cambiado de posición.
     */
    @Override
    public void actualizarPosicion(LienzoEvent evt) {}
}