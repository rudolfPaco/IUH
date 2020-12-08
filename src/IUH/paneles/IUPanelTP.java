/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.paneles;

import IUH.campoTexto.IUCampoPrivado;
import IUH.campoTexto.IUCampoTexto;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class IUPanelTP extends IUPanel{
    private IUPanel panel;
    public IUPanelT iuTitulo;
    public IUCampoPrivado iuCampo;
    private Color colorFondo = Ayuda.COLOR_FONDO;
    private Color colorTitulo = Color.WHITE;

    public Area areaPanel;
    private int x;
    private int y;
    private int altoTitulo;
    private String titulo;
    private int nroColumnas;
    private int sizeTitulo = 0;
    private int sizeCampo;
    private int posicionHTitulo;
    private final String placeHolder;
           
    /**     
     * Panel contiene Titulo arriba y Campo texto Abajo, se puede agregar texto, numeros enteros o decimales.
     * @param panel
     * @param areaPanel
     * @param x
     * @param y
     * @param altoTitulo
     * @param titulo
     * @param nroColumnas
     * @param sizeTitulo
     * @param sizeCampo
     * @param posicionHTitulo
     * @param colorFondo
     * @param colorTitulo
     * @param placeHolder
     */
    public IUPanelTP(IUPanel panel, Area areaPanel, int x, int y, int altoTitulo, String titulo, int nroColumnas, int sizeTitulo, int sizeCampo, int posicionHTitulo, Color colorFondo, Color colorTitulo, String placeHolder){
        super(panel, areaPanel, true, colorFondo);
        this.panel = panel;
        this.areaPanel = areaPanel;        
        this.x = x;
        this.y = y;
        this.altoTitulo = altoTitulo;
        this.titulo = titulo;
        this.nroColumnas = nroColumnas;
        this.sizeTitulo = sizeTitulo;
        this.sizeCampo = sizeCampo;
        this.posicionHTitulo = posicionHTitulo;
        this.colorFondo = colorFondo;
        this.colorTitulo = colorTitulo;
        this.placeHolder = placeHolder;
        
        construirPanel();
    }
    private void construirPanel(){
        setBackground(Ayuda.COLOR_FOCO);
        setBorder(new LineBorder(Ayuda.COLOR_LINEA));
        iuTitulo = new IUPanelT(this, x, new Area(x, y*2, area.An() - x*2, area.AlP(altoTitulo) - y*2), titulo, sizeTitulo, posicionHTitulo, colorFondo, colorTitulo, false);
        iuCampo = new IUCampoPrivado(this, new Area(x*2, area.AlP(altoTitulo), area.An() - y*4, area.AlP(100 - altoTitulo) - y*2), nroColumnas, sizeCampo);
        iuCampo.setBorder(null);
        iuCampo.setPlaceHolder(placeHolder);
        
        if(sizeTitulo != 0)
            iuTitulo.setFont(Ayuda.FONT(sizeTitulo));
        
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
