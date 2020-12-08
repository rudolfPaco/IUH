package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import IUH.botones.IUBoton;
import IUH.botones.IUBotonCheckBox;
import IUH.botones.IUBotonRadio;
import IUH.campoTexto.IUAreaTexto;
import IUH.campoTexto.IUCampoTexto;
import IUH.comboBox.IUComboBox;
import IUH.etiquetas.IUEtiquetaI;
import IUH.paneles.IUPanel;
import IUH.paneles.IUPanelIC;
import IUH.paneles.IUPanelIP;
import IUH.paneles.IUPanelT;
import IUH.paneles.IUPanelTA;
import IUH.paneles.IUPanelTC;
import IUH.paneles.IUPanelTP;
import IUH.paneles.IUPanelTT;
import IUH.tabla.IUTabla;
import IUH.tabla.ModeloTabla;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import IUH.ventanas.IUPrincipal;
import IUH.ventanas.IUSecundario;
import IUH.ventanas.IUVentana;
import com.jtattoo.plaf.BaseBorders;
import com.jtattoo.plaf.acryl.AcrylBorders;
import com.jtattoo.plaf.texture.TextureBorders;
import com.sun.java.swing.plaf.motif.MotifBorders;
import com.sun.java.swing.plaf.windows.WindowsBorders;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
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
        
        
        IUPrincipal sec = new IUPrincipal("HOTEL FELIPEZ  Su Amigo de Siempre...", "/img/hotel.png");
        
        Area a = new Area(0, 0, sec.An()-6, sec.Al()-35);
        
        IUPanel panel = new IUPanel(sec, a, true);
        
        Area ap = new Area(2, 2, panel.area.An() - 10, panel.area.Al() - 10);
        
        IUPanelTT pa = new IUPanelTT(panel, new Area(ap.X(4), ap.Y(3), ap.AnP(20), ap.AlP(7)), 4, 3, 30, "hola este es mi panelT", "letras del texto", 12, 16, SwingConstants.LEFT, SwingConstants.LEFT, Ayuda.COLOR_FONDO, Color.white);
        
        IUBoton boton1 = new IUBoton(panel, new Area(ap.X(5) + ap.AnP(20), ap.Y(3) + ap.AlP(2), ap.AnP(5), ap.AlP(8)), "usuario", "/img/user.png", 12, 30, 3, SwingConstants.CENTER, SwingConstants.BOTTOM, 'u', "boton usuario");
        IUPanelTA iuTA = new IUPanelTA(panel, new Area(ap.X(5) + ap.AnP(30), ap.Y(3) + ap.AlP(2), ap.AnP(20), ap.AlP(20)), 3, 3, 15, "titulo del panel area texto", 10, "solo texto", 12, 16, SwingConstants.LEFT, null, Ayuda.COLOR_LETRA);
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("inicio");
        opciones.add("segundo");
        opciones.add("tercero");
        IUComboBox iuC = new IUComboBox(panel, opciones, new Area(ap.X(6) + ap.AnP(60), ap.Y(3) + ap.AlP(10), ap.AnP(20), ap.AlP(5)), 16, 10);
        //IUAreaTexto iuArea = new IUAreaTexto(panel, new Area(ap.X(5) + ap.AnP(30), ap.Y(3) + ap.AlP(2), ap.AnP(20), ap.AlP(20)), "", 16, 10, false);
        //boton1.setBorder(new TextureBorders.ButtonBorder());
        //IUBoton boton2 = new IUBoton(panel, new Area(panel.area.X(2) + panel.area.AnP(5), panel.area.Y(), panel.area.AnP(20), panel.area.AlP(5)), "usuario", "/img/user.png", 14, 20, 15, SwingConstants.RIGHT, SwingConstants.CENTER, 'u', "boton usuario");
        //boton2.setBorder(new TextureBorders.TextFieldBorder());
        
        IUPanelT iuTitulo = new IUPanelT(panel, 4, new Area(ap.X(), ap.Y(2) + ap.AlP(30), ap.AnP(20), ap.AlP(10)), "Titulo de la ventana: ", 20, SwingConstants.CENTER);
        
        IUPanelIC iuIC = new IUPanelIC(panel, new Area(ap.X(2) + ap.AnP(30), ap.Y(2) + ap.AlP(30), ap.AnP(20), ap.AlP(5)), 4, 3, 14, "src/img/user.png", 16, SwingConstants.LEFT, "username");
        
        IUCampoTexto iuCampo = new IUCampoTexto(panel, new Area(ap.X(2), ap.Y(3) + ap.AlP(50), ap.AnP(30), ap.AnP(2)), "", 14, SwingConstants.RIGHT);
        iuCampo.setRestriccionDosDecimales();
        //iuC.setEditar(false);
        
        IUPanelTC iuTC = new IUPanelTC(panel, new Area(ap.X(4) + ap.AnP(50), ap.Y(2) + ap.AlP(28), ap.AnP(20), ap.AlP(7)), 4, 3, 40, "tipo de moneda (Bolivianos/Dolares)", 10, "", 12, 18, SwingConstants.LEFT, SwingConstants.LEFT, null, Ayuda.COLOR_FONDO, "");
        iuTC.iuCampo.setRestriccionDosDecimales();
        
        IUPanelTP iuTP = new IUPanelTP(panel, new Area(ap.X(5) + ap.AnP(70), ap.Y(2) + ap.AlP(28), ap.AnP(20), ap.AlP(7)), 4, 3, 40, "tipo de moneda (Bolivianos/Dolares)", 10, 12, 16, SwingConstants.LEFT, null, Ayuda.COLOR_FONDO, "");
        
        IUPanelIP iuIP = new IUPanelIP(panel, new Area(ap.X(2) + ap.AnP(30), ap.Y(2) + ap.AlP(50), ap.AnP(20), ap.AlP(5)), 4, 3, 14, "src/img/bloqueado.png", 16, SwingConstants.LEFT, 10, "password...");
        
        IUBotonCheckBox check = new IUBotonCheckBox(panel, new Area(ap.X(2) + ap.AnP(60), ap.Y(), ap.AnP(20), ap.AlP(10)), "Titulo de ventana", true);
        check.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(check.isSelected()){
                    IUVentana iuS = new IUVentana("pequeno");
                    Area a = new Area(0, 0, iuS.An()-6, iuS.Al()-35);
                    IUPanel pan = new IUPanel(iuS, a, false);
                    pan.setBackground(Ayuda.COLOR_FOCO);
                    
                    IUEtiquetaI icon = new IUEtiquetaI(pan, new Area(50, 50, 300, 200), "src/img/felipez.png");
                    
                    iuS.mostrarVentana();
                }
            }
        });
        
        IUBotonRadio radio = new IUBotonRadio(panel, new Area(ap.X(3) + ap.AnP(40), ap.Y(1) + ap.AlP(40), ap.AnP(20), ap.AlP(10)), "pelotas en venta", false);
        
        IUTabla iuTabla = new IUTabla(panel, 
        new Area(ap.X(3) + ap.AnP(70), ap.Y(1) + ap.AlP(40), ap.AnP(20), ap.AlP(10)), 
        new String[]{"Nombre", "Apellido", "Ciudad", "Pais"}, 
        new Class[]{String.class, String.class, String.class, String.class}, 
        new int[]{25, 25, 25, 25}, 
        opciones, 
        new ModeloTabla<String>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch(columnIndex){
                    case 0:
                        return lista.get(rowIndex);
                    default:
                        return null;
                }
            }
        });
        
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
