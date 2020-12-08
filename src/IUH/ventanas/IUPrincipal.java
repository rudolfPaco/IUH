/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.ventanas;

import IUH.paneles.IUPanel;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author neo
 */
public class IUPrincipal extends JFrame{
    public IUPanel contenedor;
    private Area area;
    protected boolean estado;
    private String urlIcono;
    
    public IUPrincipal(String titulo, String urlIcono){
        super(titulo);        
        this.area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);        
        this.urlIcono = urlIcono;
        this.estado = false;
        
        construirVentanaPrincipal();        
    }
    
    private void construirVentanaPrincipal(){        
        setSize(area.An(), area.Al());
        setAlwaysOnTop(true);
        setResizable(false);
        setUndecorated(true);
        setLayout(null);
        setFont(Ayuda.FUENTE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setIconImage(new ImageIcon(new ImageIcon(getClass().getResource(urlIcono)).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)).getImage());
        ((com.jtattoo.plaf.texture.TextureTitlePane)getLayeredPane().getComponent(1)).setFont(Ayuda.FUENTE);
        
        contenedor = new IUPanel();        
        contenedor.setBounds(0, 0, area.An()-7, area.Al()-28);
        //add(contenedor);
        //Area a = new Area(0, 0, sec.An()-6, sec.Al()-35);
        
        
    }
    public void agregar(IUPanel panel, Area area){
        panel.setBounds(area.X(), area.Y(), area.An(), area.Al());
        //contenedor.add(panel);        
        getContentPane().add(panel);
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public void mostrar(){
        setVisible(true);
    }
    public int An(){
        return area.An();
    }
    public int Al(){
        return area.Al();
    }
}
