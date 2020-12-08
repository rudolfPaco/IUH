/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.paneles;

import IUH.campoTexto.IUCampoPrivado;
import IUH.campoTexto.IUCampoTexto;
import IUH.etiquetas.IUEtiquetaI;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class IUPanelIP extends IUPanel{
    private IUPanel panel;
    private IUEtiquetaI iuIcono;
    private IUCampoPrivado iuTexto;
    private int posicionHTexto;

    public Area areaPanel;
    private int x;
    private int y;
    private int anchoIcono;
    private String urlIcono;
    private int sizeTitulo = 0;
    private int sizeTexto;    
    private final int nroColumnas;
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
     * @param nroColumnas
     * @param placeHolder
     */
    public IUPanelIP(IUPanel panel, Area areaPanel, int x, int y, int anchoIcono, String urlIcono, int sizeTexto, int posicionHTexto, int nroColumnas, String placeHolder){
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
        this.nroColumnas = nroColumnas;
        this.placeHolder = placeHolder;
        
        construirPanel();        
    }
    private void construirPanel(){
        setBackground(Ayuda.COLOR_FOCO);
        setBorder(new LineBorder(Ayuda.COLOR_LINEA));
        iuIcono = new IUEtiquetaI(this, new Area(x*2, y*2, area.AnP(anchoIcono) - x*3, area.Al() - y*4), urlIcono);
        
        iuTexto = new IUCampoPrivado(this, new Area(x + area.AnP(anchoIcono), y*2, area.AnP(100 - anchoIcono) - x*2, area.Al() - y*4), nroColumnas, sizeTexto);
        iuTexto.setBorder(null);
        iuTexto.setPlaceHolder(placeHolder);
        
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
