/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.paneles;

import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import IUH.ventanas.IUPrincipal;
import IUH.ventanas.IUSecundario;
import IUH.ventanas.IUVentana;
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
public class IUPanel extends JPanel{
    private IUPrincipal principal;
    private IUSecundario secundario;
    private IUVentana ventana;
    private IUPanel panel;
        
    private Color colorFondo = null;
    private boolean isBorde = false;   

    private Border border = new LineBorder(Ayuda.COLOR_BORDE);//.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
    public Area area;
    
    public IUPanel(){
        super(null);
    }
    
    /**
     *
     * @param ventana
     * @param area
     * @param isBorde
     */
    public IUPanel(IUVentana ventana, Area area, boolean isBorde){
        super(null);
        this.ventana = ventana;
        this.panel = null;
        this.principal = null;
        this.area = area;
        this.isBorde = isBorde;
        this.colorFondo = Color.WHITE;
        construirPanel();        
    }
    
    /**
     *
     * @param secundario
     * @param area
     * @param isBorde
     */
    public IUPanel(IUSecundario secundario, Area area, boolean isBorde){
        super(null);
        this.secundario = secundario;
        this.panel = null;
        this.principal = null;
        this.area = area;
        this.isBorde = isBorde;
        this.colorFondo = Color.WHITE;
        construirPanel();        
    }
    
    /**
     * panel sin borde y sin el foco.
     * @param ventana
     * @param area     
     * @param isBorde     
     */
    public IUPanel(IUPrincipal ventana, Area area, boolean isBorde){
        super(null);
        this.principal = ventana;
        this.panel = null;
        this.secundario = null;
        this.area = area;
        this.isBorde = isBorde;
        construirPanel();        
    }
    
    /**     
     * @param panel
     * @param area
     * @param addBorde
     */
    public IUPanel(IUPanel panel, Area area, boolean addBorde){
        super(null);
        this.panel = panel;
        this.area = area;
        this.principal = null;
        this.secundario = null;
        this.isBorde = addBorde;
        
        construirPanel();
    }

    /**
     *
     * @param panel
     * @param area
     * @param addBorde
     * @param colorFondo
     */
    public IUPanel(IUPanel panel, Area area, boolean addBorde, Color colorFondo){
        super(null);
        this.panel = panel;
        this.area = area;
        this.principal = null;
        this.secundario = null;
        this.isBorde = addBorde;
        this.colorFondo = colorFondo;
        
        construirPanel();        
    }
    private void construirPanel(){
        if(principal != null){            
            principal.agregar(this, area);
        }
        if(secundario != null){            
            secundario.agregar(this, area);
        }
        if(ventana != null){            
            ventana.agregar(this, area);
        }
        if(panel != null){            
            panel.agregar(this, area);
        }
        setFocusable(false);        
        
        if(colorFondo != null)
            setBackground(colorFondo);
        
        if(isBorde){
            setBorder(border);
        }else{
            setBorder(null);
        }
    }   
    
    public void agregar(JComponent componente, Area area){
        componente.setBounds(area.X(), area.Y(), area.An(), area.Al());
        add(componente);        
    }
    
    public void mostrarDimensiones(){
        JLabel label = new JLabel("w:"+getWidth()+" h:"+getHeight());
        label.setFont(new Font("Arial", Font.PLAIN, 10));
        label.setBounds(getWidth() - 80, 0, 80, 10);
        add(label);        
    }
}
