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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author neo
 */
public class IUPanelT extends IUPanel{
    private IUPanel panel;
    private IUPanelE iuTitulo;
    private IUEtiqueta iuTexto;
    private Color colorFondo = new Color(64, 64, 64);
    private Color colorTexto = Ayuda.COLOR_LETRA;
    private boolean isBorder = false;   

    private Border border = new LineBorder(Color.LIGHT_GRAY);
    public Area areaPanel;
    private int x;
    private int altoTexto;
    private String titulo;
    private String texto;
    private int sizeTitulo = 0;
    private int sizeTexto;
    private int posicionHorizontal;
           
    /**     
     * @param panel
     * @param areaPanel
     * @param altoTexto
     * @param texto
     * @param size
     * @param posicionHorizontal
     * @param colorFondo
     * @param colorTexto
     * @param isBorder
     */
    public IUPanelT(IUPanel panel, Area areaPanel, int altoTexto, String texto, int size, int posicionHorizontal, Color colorFondo, Color colorTexto, boolean isBorder){
        super(panel, areaPanel, isBorder, colorFondo);
        this.panel = panel;
        this.areaPanel = areaPanel;        
        this.altoTexto = altoTexto;
        this.titulo = texto;
        this.sizeTitulo = size;
        this.posicionHorizontal = posicionHorizontal;
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
        this.isBorder = isBorder;
        
        construirPanel();
    }

    /**
     *
     * @param panel
     * @param areaPanel
     * @param x
     * @param altoTexto
     * @param titulo
     * @param texto
     * @param sizeTitulo
     * @param sizeTexto
     * @param posicionHorizontal
     * @param isBorder
     */
    public IUPanelT(IUPanel panel, Area areaPanel, int x, int altoTexto, String titulo, String texto, int sizeTitulo, int sizeTexto, int posicionHorizontal, boolean isBorder){
        super(panel, areaPanel, isBorder);
        this.panel = panel;
        this.areaPanel = areaPanel;
        this.x = x;
        this.altoTexto = altoTexto;
        this.titulo = titulo;
        this.texto = texto;
        this.sizeTitulo = sizeTitulo;
        this.sizeTexto = sizeTexto;
        this.posicionHorizontal = posicionHorizontal;        
        this.isBorder = isBorder;
        
        construirPanel();
        this.titulo = titulo;
    }
    private void construirPanel(){
        
        iuTitulo = new IUPanelE(this, x, new Area(x, x, area.An() - x*2, area.AlP(altoTexto)), titulo, sizeTitulo, posicionHorizontal);        
        iuTexto = new IUEtiqueta(this, texto, new Area(x, area.AlP(altoTexto), area.An() - x*2, area.AlP(100 - altoTexto)), sizeTexto, SwingConstants.LEFT, false);
        
        if(sizeTitulo != 0)
            iuTitulo.setFont(Ayuda.FONT(sizeTitulo));
        
        if(isBorder){
            setBorder(border);
        }
        
        add(iuTitulo);
    }   
    
    public void agregar(JComponent componente, Area area){
        componente.setBounds(area.X(), area.Y(), area.An(), area.Al());
        add(componente);        
    }    
    public void setColores(Color colorTexto, Color colorFondo){
        iuTitulo.setForeground(colorTexto);
        setBackground(colorFondo);
    }
    public void setFuente(Font fuente){
        iuTitulo.setFont(fuente);
    }
}
