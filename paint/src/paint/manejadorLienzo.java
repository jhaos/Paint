/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import sm.jjrh.eventos.LienzoAdapter;
import sm.jjrh.eventos.LienzoEvent;

/**
 *
 * @author julius
 */
public class manejadorLienzo extends LienzoAdapter {
    principal ventanaPrincipal;
    
    /**
     *
     * @param v
     */
    public manejadorLienzo(principal v){
        ventanaPrincipal = v;
    }
    
    /**
     *
     * @param evt evento de la clase LienzoEvent que llega desde lienzo para indicar que se ha añadido una figura.
     */
    @Override
    public void shapeAdded(LienzoEvent evt){
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)ventanaPrincipal.listaEditar.getModel();
        modelo.addElement(evt.getForma());
    }
    
    /**
     *
     * @param evt evento de la clase LienzoEvent que llega desde lienzo que indica que una figura ha cambiado de posición.
     */
    @Override 
    public void actualizarPosicion(LienzoEvent evt){
        ventanaPrincipal.getCX().setText(String.valueOf(evt.getCx()));
        ventanaPrincipal.getCY().setText(String.valueOf(evt.getCy()));
    }
    
    /**
     *
     * @param evt evento de la clase LienzoEvent que llega desde lienzo que indica que una figura ha cambiado sus atributos.
     */
    @Override
    public void principalChange(LienzoEvent evt){
        

            if (evt.getForma().getColor().equals(Color.red)){
                ventanaPrincipal.getListaColores().setSelectedIndex(0);
            }else if (evt.getForma().getColor().equals(Color.black)){
                ventanaPrincipal.getListaColores().setSelectedIndex(1);
            }else if(evt.getForma().getColor().equals(Color.white)){
                ventanaPrincipal.getListaColores().setSelectedIndex(4);
            }else if (evt.getForma().getColor().equals(Color.blue)){
                ventanaPrincipal.getListaColores().setSelectedIndex(2);
            }else if (evt.getForma().getColor().equals(Color.yellow)){
                ventanaPrincipal.getListaColores().setSelectedIndex(5);
            }else if (evt.getForma().getColor().equals(Color.green)){
                ventanaPrincipal.getListaColores().setSelectedIndex(3);
            }
            if (evt.getForma().getRelleno() != null){
                if (evt.getForma().getRelleno().equals(Color.red)){
                    ventanaPrincipal.getListaRelleno().setSelectedIndex(0);
                }else if (evt.getForma().getRelleno().equals(Color.black)){
                    ventanaPrincipal.getListaRelleno().setSelectedIndex(1);
                }else if(evt.getForma().getRelleno().equals(Color.white)){
                    ventanaPrincipal.getListaRelleno().setSelectedIndex(4);
                }else if (evt.getForma().getRelleno().equals(Color.blue)){
                    ventanaPrincipal.getListaRelleno().setSelectedIndex(2);
                }else if (evt.getForma().getRelleno().equals(Color.yellow)){
                    ventanaPrincipal.getListaRelleno().setSelectedIndex(5);
                }else if (evt.getForma().getRelleno().equals(Color.green)){
                    ventanaPrincipal.getListaRelleno().setSelectedIndex(3);
                }
            }
            
            ventanaPrincipal.getBotonAlisar().setSelected(evt.getForma().isRender());
            if (evt.getForma().getRelleno() != null)
                ventanaPrincipal.getBotonRelleno().setSelected(evt.getForma().isRelleno());
            ventanaPrincipal.getCambioStroke().setSelected(evt.getForma().isIsStroke());
            float transparencia = evt.getForma().getCambioTranspacencia()*100.0f;
            ventanaPrincipal.getTransparencia().setValue((int)transparencia);
            ventanaPrincipal.getSpinnerStroke().setValue(evt.getForma().getCambioStroke());
        }    
}
