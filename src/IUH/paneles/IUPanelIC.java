/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.paneles;

import IUH.campoTexto.IUCampoTexto;
import IUH.etiquetas.IUEtiqueta;
import IUH.etiquetas.IUEtiquetaI;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class IUPanelIC extends IUPanel{
    private IUPanel panel;
    private IUEtiquetaI iuIcono;
    private IUCampoTexto iuTexto;
    private Color colorFondo = new Color(255, 250, 212);
    private Color colorTexto = Ayuda.COLOR_LETRA;
    private int posicionHTexto;
    private boolean isBorder = false;   

    private Border border = new LineBorder(Color.LIGHT_GRAY);
    public Area areaPanel;
    private int x;
    private final int y;
    private int anchoIcono;
    private String urlIcono;
    private String texto;
    private int sizeTitulo = 0;
    private int sizeTexto;
    private int posicionHTitulo;
    private final String placeHolder;
           

    /**
     * Panel contiene Titulo arriba y Texto Abajo, solo es para mostrar contenido.
     * @param panel contenedor de los componentes
     * @param areaPanel posicion y dimension del panel
     * @param x distancia horizontal de la Etiqueta con el Panel
     * @param y
     * @param anchoIcono altura de la etiqueta medido en porcentajes Ej: altoPanel = 100, altoTitulo = 30, altoTexto = 70 
     * @param urlIcono texto que se muestran en la parte superior
     * @param sizeTexto tamaño de letra del texto
     * @param posicionHTexto posicion horizontal del texto
     * @param placeHolder
     */
    public IUPanelIC(IUPanel panel, Area areaPanel, int x, int y, int anchoIcono, String urlIcono, int sizeTexto, int posicionHTexto, String placeHolder){
        super(panel, areaPanel, false);
        this.panel = panel;
        this.areaPanel = areaPanel;
        this.x = x;
        this.y = y;
        this.anchoIcono = anchoIcono;
        this.urlIcono = urlIcono;        
        this.sizeTexto = sizeTexto;
        this.posicionHTexto = posicionHTexto;
        this.urlIcono = urlIcono;
        this.placeHolder = placeHolder;
        
        construirPanel();        
    }
    private void construirPanel(){
        setBackground(Ayuda.COLOR_FOCO);
        setBorder(new LineBorder(Ayuda.COLOR_LINEA));
        iuIcono = new IUEtiquetaI(this, new Area(x*2, y*2, area.AnP(anchoIcono) - x*3, area.Al() - y*4), urlIcono);
        
        iuTexto = new IUCampoTexto(this, new Area(x + area.AnP(anchoIcono), y*2, area.AnP(100 - anchoIcono) - x*2, area.Al() - y*4), texto, sizeTexto, posicionHTexto);
        iuTexto.setPlaceHolder(placeHolder);
        iuTexto.setBorder(null);
        
        if(sizeTitulo != 0)
            iuIcono.setFont(Ayuda.FONT(sizeTitulo));
        
        add(iuIcono);
    }   
    
    public void agregar(JComponent componente, Area area){
        componente.setBounds(area.X(), area.Y(), area.An(), area.Al());
        add(componente);        
    }    
    public void setColores(Color colorTexto, Color colorFondo){
        iuIcono.setForeground(colorTexto);
        setBackground(colorFondo);
    }
    public void setFuente(Font fuente){
        iuIcono.setFont(fuente);
    }
}
