package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import IUH.botones.IUBoton;
import IUH.botones.IUBotonCheckBox;
import IUH.botones.IUBotonRadio;
import IUH.paneles.IUPanel;
import IUH.paneles.IUPanelE;
import IUH.paneles.IUPanelT;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import IUH.ventanas.IUPrincipal;
import IUH.ventanas.IUSecundario;
import com.jtattoo.plaf.BaseBorders;
import com.jtattoo.plaf.acryl.AcrylBorders;
import com.jtattoo.plaf.texture.TextureBorders;
import com.sun.java.swing.plaf.motif.MotifBorders;
import com.sun.java.swing.plaf.windows.WindowsBorders;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;


/**
 *
 * @author Rudolf Felipez Mancilla
 */
public class Principal {

    public static void main(String[] arg){
        
        try {
            // setTheme(String themeName, String licenseKey, String logoString)
            //com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green", "INSERT YOUR LICENSE KEY HERE", "my company");
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        IUPrincipal sec = new IUPrincipal("Titulo de la Ventana", "/img/tienda.png");
        
        Area a = new Area(2, 2, (sec.An()-10)/10, (sec.Al()-4)/10);
        Area a1 = new Area(2, 2, (sec.An()-10)/10, (sec.Al()-4)/20);
        Area a2 = new Area(4, a.Al(3), (sec.An()-16), (sec.Al()-12)/2);
        
        IUPanel panel1 = new IUPanel(sec, new Area(a.X(1), a.Y(1), a.An(1), a.Al(1)), true);
        IUPanel panel2 = new IUPanel(sec, new Area(a.X(2) + a.An(1), a.Y(1), a.An(1), a.Al(1)), true);
        IUPanel panel3 = new IUPanel(sec, new Area(a.X(3) + a.An(2), a.Y(1), a.An(1), a.Al(1)), true);
        IUPanel panel5 = new IUPanel(sec, new Area(a.X(4) + a.An(3), a.Y(1), a.An(1), a1.Al(1)), true);
        IUPanel panel6 = new IUPanel(sec, new Area(a.X(5) + a.An(4), a.Y(1), a.An(1), a.Al(1)), true);
        
        IUPanel panel7 = new IUPanel(sec, new Area(a.X(6) + a.An(5), a.Y(1), a.An(1), a1.Al(1)), true);
        
        IUPanel panel = new IUPanel(sec, a2, false);
        
        
        
        Area a3 = new Area(4, 4, (panel.area.An()-10)/10, (panel.area.Al()-4)/14);
        
        IUPanelT pa = new IUPanelT(panel, new Area(200, 100, 300, 50), 4, 40, "hola este es mi panelT", "letras del texto", 12, 16, SwingConstants.LEFT, true);
        
        //IUBoton boton1 = new IUBoton(panel, new Area(a3.X(), a3.Y(), a3.An(), a3.Al()), "usuario", "/img/user.png", 14, 20, 15, SwingConstants.RIGHT, SwingConstants.CENTER, 'u', "boton usuario");
        //boton1.setBorder(new TextureBorders.ButtonBorder());
        IUBoton boton2 = new IUBoton(panel, new Area(a3.X(2) + a3.An(3), a3.Y(), a3.An(), a3.Al()), "usuario", "/img/user.png", 14, 20, 15, SwingConstants.RIGHT, SwingConstants.CENTER, 'u', "boton usuario");
        //boton2.setBorder(new TextureBorders.TextFieldBorder());
        
        IUPanelE iuTitulo = new IUPanelE(panel, 4, new Area(panel.area.X(), panel.area.Y(), panel.area.AnP(20), panel.area.AlP(10)), "Titulo de la ventana: ", 20, SwingConstants.CENTER);
        
        IUBotonCheckBox check = new IUBotonCheckBox(panel, new Area(a3.X(5), a3.Y(2) + a3.Al(2), a3.An(), a3.Al()), "Titulo de ventana", true);
        check.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(check.isSelected()){
                    IUSecundario iuS = new IUSecundario(sec, "ventana secundaria", "grande");
                    iuS.mostrarVentana();
                }
            }
        });
        
        IUBotonRadio radio = new IUBotonRadio(panel, new Area(a3.X(), a3.Y(5) + a3.Al(4), a3.An(2), a3.Al()), "pelotas en venta", false);
        
        sec.setVisible(true);
        /*IUSecundario sec = new IUSecundario(p, "ventana secundaria", "intermedio");
        
        
        sec.mostrarVentana();
        /*SIUPanel contenedor = new SIUPanel(principal, new Grid(new Arena(principal.contenedor.getWidth(), principal.contenedor.getHeight()), 13, 13), true);        
        contenedor.mostrarPuntos(true);
        contenedor.setColorFondo(Color.orange, 0);
        
        SIUPanel panel0 = new SIUPanel(contenedor, new Grid(13, 25, 1, 1, 4, 10), true);
        panel0.mostrarPuntos(true);
        
        SIUBoton boton = new SIUBoton(panel0, new Grid(1, 1, 4, 3), "Ingresar", "/img/addUser.png", 14, 40, 5, SwingConstants.CENTER, SwingConstants.BOTTOM, 'I', "boton de ingreso al sistema");
        SIUBoton boton1 = new SIUBoton(panel0, new Grid(6, 1, 3, 1), "Salir", "", 14, 0, 0, SwingConstants.CENTER, SwingConstants.CENTER, 'a', "boton de salida del sistema");
        
        ButtonGroup grupo = new ButtonGroup();
        SIUBotonRadio iuRadio = new SIUBotonRadio(panel0, new Grid(1, 4, 8, 1), "Lenguaje Java", 14, true);
        
        SIUBotonRadio iuRadio1 = new SIUBotonRadio(panel0, new Grid(1, 5, 8, 1), "Lenguaje C++", 14, false);
        grupo.add(iuRadio);
        grupo.add(iuRadio1);
        
        SIUBotonCheckBox iuCheck1 = new SIUBotonCheckBox(panel0, new Grid(1, 10, 5, 2), "Futbol", 14, true);
        SIUBotonCheckBox iuCheck2 = new SIUBotonCheckBox(panel0, new Grid(1, 12, 5, 2), "Raquet", 14, false);
        grupo.add(iuCheck1);
        grupo.add(iuCheck2);
                
        boton1.addActionListener((ActionEvent e) -> {
            if(e.getActionCommand().equalsIgnoreCase("Salir")){
                System.exit(0);
            }
        });
        
        //SIUFormatoCampoTexto iuFormatoCampo = new SIUFormatoCampoTexto(panel0, new Grid(5, 5, 4, 1), 16, SwingConstants.RIGHT);
        
        
        //SIUPanel panel1 = new SIUPanel(contenedor, new Grid(13, 25, 6, 1, 4, 10), true);
        
        //SIUCampoTexto iuCampo = new SIUCampoTexto(panel1, "hola este es el texto", 14, new Grid(1, 1, 7, 1));
        
        
        //SIUPanel panel2 = new SIUPanel(contenedor, new Grid(11, 1, 4, 10), true);
        
        //SIUPanel panel3 = new SIUPanel(contenedor, new Grid(16, 1, 4, 10), true);
        
        //SIUPanel panel4 = new SIUPanel(contenedor, new Grid(21, 1, 2, 10), true);*/
    }
}