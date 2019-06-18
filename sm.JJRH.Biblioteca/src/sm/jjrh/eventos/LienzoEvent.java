/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jjrh.eventos;

import java.util.EventObject;
import sm.jjrh.graficos.FormasGraficos;


/**
 * Clase que representa el evento lanzoado por un objeto de tipo Lienzo. La usaremos para comunicarnos con la clase principal mediante un manejador
 * al que se le pasará un objeto de este tipo para que pueda manejar los datos el evento.
 *
 * @author julius
 */
public class LienzoEvent extends EventObject{
    private FormasGraficos forma;

    /**
     * Función para devolver la coordenada X de la posición del rectángulo en el que se encuentra
     * el objeto forma de la clase FormasGraficos
     * @return Devuelve la coordenada X del rectángulo que contiene a forma.
     */
    public int getCx() {
        return (int)forma.getBounds2D().getX();
    }

    /**
     * Función para devolver la coordenada Y de la posición del rectángulo en el que se encuentra
     * el objeto forma de la clase FormasGraficos
     * @return Devuelve la coordenada Y del rectángulo que contiene a forma.
     */
    public int getCy() {
        return (int)forma.getBounds2D().getY();
    }
    
    /**
     *Constructor del objeto LienzoEvent. Utilizaremos el constructor de super para pasarle el objeto fuente que en este caso es un tipo Lienzo
     * un objeto FormasGraficos que contendrá la información necesaria para gestionar los métodos de esta clase y la forma geométrica que se esta pintando
     * 
     * @param source Objeto desde el que se lanza el evento, en este caso un objeto tipo Lienzo
     * @param forma Objeto de la clase FormasGraficos que es la superclase de las formas que estan implementadas en la biblioteca
     * 
     */
    public LienzoEvent(Object source, FormasGraficos forma) {
        super(source);
        this.forma = forma;
    }

    /**
     *Devuelve el objeto FormaGraficos que contiene información sobre lo que hay en el lienzo
     * 
     * @return Objeto FormasGraficos con información acerca de lo que hay en lienzo.
     */
    public FormasGraficos getForma() {
        return forma;
    }
}
