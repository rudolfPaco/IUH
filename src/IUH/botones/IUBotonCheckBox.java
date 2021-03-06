/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.botones;

import IUH.paneles.IUPanel;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

/**
 *
 * @author neo
 */
public class IUBotonCheckBox extends JCheckBox{
    private Color colorSeleccionado;
    private Color colorNoSeleccionado;
    
    private IUPanel panel;
    private Area area;
    private int size = 0;
    
    /**
     * Interfaz Usuario Boton CheckBox, la clase hereda del componente JCheckBox. al momento de hacer click cambia el color a seleccionado, caso contrario retorna al color no seleccionado.
     * @param panel
     * @param area
     * @param texto cadenad de caracteres que se muestra en el componente.
     * @param size
     * @param estado determina si el componente esta seleccionado si y solo si el estado es true, caso contrario el componente no esta seleccionado.
     */
    public IUBotonCheckBox(IUPanel panel, Area area, String texto, int size, boolean estado){
        super(texto, estado);
        this.panel = panel;
        this.area = area;        
        this.size = size;

        this.colorSeleccionado = Ayuda.COLOR_LETRA;//new Color(2, 67, 109);
        this.colorNoSeleccionado = Color.LIGHT_GRAY;
        
        construirBotonCheckBox();
        agregarEvento();
        
    }
    public IUBotonCheckBox(IUPanel panel, Area area, String texto, boolean estado){
        super(texto, estado);
        this.panel = panel;
        this.area = area;        

        this.colorSeleccionado = Ayuda.COLOR_LETRA;//new Color(2, 67, 109);
        this.colorNoSeleccionado = Color.LIGHT_GRAY;
        
        construirBotonCheckBox();
        agregarEvento();
        
    }
    private void construirBotonCheckBox(){        
        panel.agregar(this, area);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setIconTextGap(10);
        setFocusable(false);
        setOpaque(false);        
        setMargin(new Insets(1, 1, 1, 1));
        setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.WHITE, Color.LIGHT_GRAY, Color.WHITE));
        
        if(size == 0)
            setFont(Ayuda.FUENTE);
        else
            setFont(Ayuda.FONT(size));
        
        if(isSelected())
            setForeground(colorSeleccionado);        
        else
            setForeground(colorNoSeleccionado);
    }
    private void agregarEvento(){
        addItemListener((ItemEvent e) -> {
            if(isSelected())
                setForeground(colorSeleccionado);            
            else
                setForeground(colorNoSeleccionado);            
        });
    }

    /**
     * metodo que modifica los colores al momento de seleccionar o deseleccionar el componente.
     * @param colorSeleccionado el componente se pinta del colorSeleccionado si y solamente si esta seleccionado.
     * @param colorNoSeleccionado el componente se pinta del colorNoSeleccionado si y solamente si no esta seleccionado.
     */
    public void setColoresEstado(Color colorSeleccionado, Color colorNoSeleccionado){
        this.colorSeleccionado = colorSeleccionado;
        this.colorNoSeleccionado = colorNoSeleccionado;
        construirBotonCheckBox();
    }
}
