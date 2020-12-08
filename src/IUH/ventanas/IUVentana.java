/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.ventanas;

import IUH.paneles.IUPanel;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author neo
 */
public class IUVentana extends JDialog{
    public Area area;
    protected boolean estado;
    private final String tipoSize;
    
    /**
     *
     * @param ventanaPrincipal
     * @param titulo
     * @param tipoSize
     */
    public IUVentana(JFrame ventanaPrincipal, String titulo, String tipoSize){
        super(ventanaPrincipal, titulo, true);
        this.tipoSize = tipoSize;
        this.estado = false;
        
        construirVentanaSecundaria();        
    }
    public IUVentana(JDialog ventanaPrincipal, String titulo, String tipoSize){
        super(ventanaPrincipal, titulo, true);
        this.tipoSize = tipoSize;
        this.estado = false;
        
        construirVentanaSecundaria();        
    }
    public IUVentana(String tipoSize){
        super();
        this.tipoSize = tipoSize;
        this.estado = false;
        
        construirVentanaSecundaria();        
    }
    private void construirVentanaSecundaria(){
        switch(tipoSize){
            case "grande":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
            break;
            case "semi-grande":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height - Toolkit.getDefaultToolkit().getScreenSize().height/7);
            break;
            case "medio-grande":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width - Toolkit.getDefaultToolkit().getScreenSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height);
            break;
            case "mediano":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width - Toolkit.getDefaultToolkit().getScreenSize().width/7, Toolkit.getDefaultToolkit().getScreenSize().height - Toolkit.getDefaultToolkit().getScreenSize().height/7);
            break;
            case "intermedio":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width - Toolkit.getDefaultToolkit().getScreenSize().width/3, Toolkit.getDefaultToolkit().getScreenSize().height - Toolkit.getDefaultToolkit().getScreenSize().height/7);
            break;
            case "pequeno":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width/3 + Toolkit.getDefaultToolkit().getScreenSize().width/50, Toolkit.getDefaultToolkit().getScreenSize().height/2 + Toolkit.getDefaultToolkit().getScreenSize().height/50);
            break;
            case "mini":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width/10, Toolkit.getDefaultToolkit().getScreenSize().height/20);
            break;
        }
        
        setSize(new Dimension(area.An(), area.Al()));
        setUndecorated(true);        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(this);        
        //getLayeredPane().setVisible(false);        
        ((com.jtattoo.plaf.texture.TextureTitlePane)getLayeredPane().getComponent(1)).setVisible(false);
        //((com.jtattoo.plaf.texture.TextureTitlePane)getLayeredPane().getComponent(1)).setFont(Ayuda.FUENTE);
        //setAlwaysOnTop(true);
        setIconImage(null);
        setResizable(false);        
        setLayout(null);        
    }
    public void agregar(IUPanel panel, Area area){
        panel.setBounds(area.X(), area.Y(), area.An(), area.Al());
        add(panel);        
    }
    public boolean getEstado(){
        return estado;
    }
    public void setEstado(boolean estado){        
        this.estado = estado;
    }
    public void mostrarVentana(){
        setVisible(true);
    }
    public void cerrarVentana(){
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));        
    }
    public int An(){
        return area.An();
    }
    public int Al(){
        return area.Al();
    }
}
