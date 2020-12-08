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
public class IUPanelTT extends IUPanel{
    private IUPanel panel;
    private IUPanelT iuTitulo;
    private IUEtiqueta iuTexto;
    private Color colorFondo = new Color(64, 64, 64);
    private Color colorTexto = Ayuda.COLOR_LETRA;
    private int posicionHTexto;
    private boolean isBorder = false;   

    private Border border = new LineBorder(Color.LIGHT_GRAY);
    public Area areaPanel;
    private int x;
    private int y;
    private int altoTitulo;
    private String titulo;
    private String texto;
    private int sizeTitulo = 0;
    private int sizeTexto;
    private int posicionHTitulo;
    private Color colorFondoTitulo;
    private Color colorLetraTitulo;
           
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
    public IUPanelTT(IUPanel panel, Area areaPanel, int altoTexto, String texto, int size, int posicionHorizontal, Color colorFondo, Color colorTexto, boolean isBorder){
        super(panel, areaPanel, isBorder, colorFondo);
        this.panel = panel;
        this.areaPanel = areaPanel;        
        this.altoTitulo = altoTexto;
        this.titulo = texto;
        this.sizeTitulo = size;
        this.posicionHTitulo = posicionHorizontal;
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
        this.isBorder = isBorder;
        
        construirPanel();
    }

    /**
     * Panel contiene Titulo arriba y Texto Abajo, solo es para mostrar contenido.
     * @param panel contenedor de los componentes
     * @param areaPanel posicion y dimension del panel
     * @param x distancia horizontal de la Etiqueta con el Panel
     * @param y
     * @param altoTitulo altura de la etiqueta medido en porcentajes Ej: altoPanel = 100, altoTitulo = 30, altoTexto = 70 
     * @param titulo texto que se muestran en la parte superior
     * @param texto que se muestra en la parte inferior
     * @param sizeTitulo tamaño de letra del titulo
     * @param sizeTexto tamaño de letra del texto
     * @param posicionHTitulo posicion horizontal del titulo
     * @param posicionHTexto posicion horizontal del texto
     * @param colorFondoTitulo
     * @param colorLetraTitulo
     * @param isBorder valor booleano para determinar si se agrega el Border o NO. Ej: isBorder = true, se agrega el BORDE caso contrario NO.
     */
    public IUPanelTT(IUPanel panel, Area areaPanel, int x, int y, int altoTitulo, String titulo, String texto, int sizeTitulo, int sizeTexto, int posicionHTitulo, int posicionHTexto, Color colorFondoTitulo, Color colorLetraTitulo){
        super(panel, areaPanel, false);
        this.panel = panel;
        this.areaPanel = areaPanel;
        this.x = x;
        this.y = y;
        this.altoTitulo = altoTitulo;
        this.titulo = titulo;
        this.texto = texto;
        this.sizeTitulo = sizeTitulo;
        this.sizeTexto = sizeTexto;
        this.posicionHTitulo = posicionHTitulo;        
        this.posicionHTexto = posicionHTexto;
        this.colorFondoTitulo = colorFondoTitulo;
        this.colorLetraTitulo = colorLetraTitulo;
        
        construirPanel();
        
    }
    private void construirPanel(){
        setBackground(Ayuda.COLOR_FOCO);
        setBorder(new LineBorder(Ayuda.COLOR_LINEA));
        
        iuTitulo = new IUPanelT(this, x, new Area(x, y, area.An() - x*2, area.AlP(altoTitulo)), titulo, sizeTitulo, posicionHTitulo, colorFondoTitulo, colorLetraTitulo, false);
        iuTexto = new IUEtiqueta(this, texto, new Area(x*2, y + area.AlP(altoTitulo), area.An() - x*4, area.AlP(100 - altoTitulo) - y*2), sizeTexto, posicionHTexto, false);
        
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
