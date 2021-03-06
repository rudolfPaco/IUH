/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.etiquetas;

import IUH.paneles.IUPanel;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class IUEtiqueta extends JLabel{
    private IUPanel panel;
    public Area area;
    private int size = 0;
    private int posicion;
    private Color colorTexto;
    private IULinea linea;
    private boolean tachado = false;
    private boolean isBorde;
    private Border border = new LineBorder(Color.LIGHT_GRAY);
    
    public IUEtiqueta(String texto){
        super(texto);        
    }
    /**
     * Interfaz de Usuario Etiqueta, hereda atributos y metodos del componente JLabel.
     * @param panel componente padre
     * @param texto cadena de caractares, que se mostrara en el componente.
     * @param area sistema de posicion
     * @param size tamaño de letra
     * @param posicion LEFT, RIGHT, CENTER establece la pasicion horizontal
     * @param isBorde
     */
    public IUEtiqueta(IUPanel panel, String texto, Area area, int size, int posicion, boolean isBorde){
        super(texto);
        this.panel = panel;
        this.area = area;
        this.size = size;
        this.posicion = posicion;
        this.isBorde = isBorde;
        this.colorTexto = new Color(32,32,32);//new Color(2, 67, 109);        
        construirEtiqueta();        
        
    }
    public IUEtiqueta(IUPanel panel, String texto, Area area, int posicion, Color colorTexto){
        super(texto);
        this.panel = panel;
        this.area = area;
        this.posicion = posicion;
        this.colorTexto = colorTexto;
        
        construirEtiqueta();        
    }
    private void construirEtiqueta(){        
        panel.agregar(this, area);
        
        setOpaque(false);
        setLayout(null);
        setFocusable(false);
        setToolTipText("");
        setHorizontalAlignment(posicion);
        
        if(isBorde){
            setBorder(border);
        }else{
            setBorder(null);
        }
        if(size == 0)
            setFont(Ayuda.FUENTE);
        else
            setFont(Ayuda.FONT(size));
        setForeground(colorTexto);
    } 
    public void agregar(JComponent componente, Area area){
        componente.setBounds(area.X(), area.Y(), area.An(), area.Al());
        add(componente);
    }
    public void setSubrayarTexto(boolean estado) {
        Map attributes = getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);        
        setFont(getFont().deriveFont(attributes));        
    }
    public void setTextoD(String texto){
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        if(!texto.isEmpty())
            setText(df.format(Double.parseDouble(texto)));
    }
    public void setTachar(boolean tachado){
        this.tachado = tachado;
        if(tachado){
            linea = new IULinea(this, new Area(0, 11, 12, 1), new Color(120, 0, 0));
        }else{
            linea = null;
        }
    }
}
