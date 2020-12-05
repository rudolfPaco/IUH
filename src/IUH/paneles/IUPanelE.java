/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.paneles;

import IUH.etiquetas.IUEtiqueta;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class IUPanelE extends JPanel{
    private IUPanel panel;
    private IUEtiqueta etiqueta;        
    private Color colorFondo = new Color(64, 64, 64);
    private Color colorTexto = new Color(255, 255, 255);
    private boolean isBorder = false;   

    private Border border = new LineBorder(Ayuda.COLOR_BORDE);
    private int x;
    public Area area;
    private String texto;
    private int size = 0;
    private int posicionHorizontal;
           
    /**     
     * @param panel
     * @param area
     * @param texto
     * @param size
     * @param posicionHorizontal
     * @param colorFondo
     * @param colorTexto
     * @param isBorder
     */
    public IUPanelE(IUPanel panel, Area area, String texto, int size, int posicionHorizontal, Color colorFondo, Color colorTexto, boolean isBorder){
        super(null);
        this.panel = panel;
        this.area = area;
        this.texto = texto;
        this.size = size;
        this.posicionHorizontal = posicionHorizontal;
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
        this.isBorder = isBorder;
        
        construirPanel();
    }

    /**
     *
     * @param panel
     * @param x
     * @param area
     * @param texto
     * @param size
     * @param posicionHorizontal
     */
    public IUPanelE(IUPanel panel, int x, Area area, String texto, int size, int posicionHorizontal){
        super(null);
        this.panel = panel;
        this.x = x;
        this.area = area;
        this.texto = texto;
        this.size = size;
        this.posicionHorizontal = posicionHorizontal;        
        
        construirPanel();
    }
    private void construirPanel(){
        panel.agregar(this, area);
        setFocusable(false);        
        setBackground(colorFondo);        
        etiqueta = new IUEtiqueta(texto);
        etiqueta.setLayout(null);
        etiqueta.setBounds(x, 0, getWidth() - x*2, getHeight());
        etiqueta.setForeground(colorTexto);        
        etiqueta.setHorizontalAlignment(posicionHorizontal);
        
        if(size != 0)
            etiqueta.setFont(Ayuda.FONT(size));
        
        if(isBorder){
            setBorder(border);
        }
        
        add(etiqueta);
    }   
    
    public void agregar(JComponent componente, Area area){
        componente.setBounds(area.X(), area.Y(), area.An(), area.Al());
        add(componente);        
    }    
    public void setColores(Color colorTexto, Color colorFondo){
        etiqueta.setForeground(colorTexto);
        setBackground(colorFondo);
    }
    public void setFuente(Font fuente){
        etiqueta.setFont(fuente);
    }
    public String getTexto(){
        return etiqueta.getText();
    }
    public void setTexto(String texto){
        etiqueta.setText(texto);
    }
}
