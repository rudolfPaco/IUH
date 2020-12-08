/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.campoTexto;

import IUH.paneles.IUPanel;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import IUH.utilitarios.TextPrompt;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * 
 * @author rudolf
 */
public class IUAreaTexto extends JTextArea{
    
    private IUPanel panel;
    private Area area;
    private final int size;
    private Border bordeComponente;
    private final int nroColumnas;
    private final boolean isBorder;

    /**
     *
     * @param panel
     * @param area
     * @param texto
     * @param size
     * @param nroColumnas
     * @param isBorder
     */
    public IUAreaTexto(IUPanel panel, Area area, String texto, int size, int nroColumnas, boolean isBorder){
        super(texto);
        this.panel = panel;
        this.area = area;
        this.size = size;
        this.nroColumnas = nroColumnas;
        this.isBorder = isBorder;
                        
        construirAreaTexto();
        agregarEventos();
    }    
    private void construirAreaTexto(){       
        
        panel.agregar(this, area);
        setSelectionColor(new Color(0, 0, 0, 0));
        setFont(Ayuda.FONT(size));
        setSelectedTextColor(Ayuda.COLOR_LETRA);        
        setLineWrap(true);
        setWrapStyleWord(true);
        //setOpaque(false);
        setForeground(Ayuda.COLOR_LETRA);
        setBorder((isBorder)?new LineBorder(Ayuda.COLOR_LINEA):getBorder());
            
        //setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.WHITE, Color.LIGHT_GRAY, Color.WHITE));
        //setBordeComponente(getBorder());
    }
    public void setPlaceHolder(String placeHolder){
        TextPrompt textPrompt = new TextPrompt(placeHolder, this);
        textPrompt.changeAlpha(0.4f);
        textPrompt.setShow(TextPrompt.Show.FOCUS_LOST);
    }
    public void setEditar(boolean estado){
        setFocusable(estado);
        setEditable(estado);
    }
    private void agregarEventos(){        
        if(nroColumnas >= 0){
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if(getText().length() == nroColumnas)
                        e.consume();                    
                }
            });
        }
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setSelectionStart(0);
                setSelectionEnd(getText().length());
            }
        });
        
        addKeyListener(new KeyAdapter(){ 
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_TAB){
                    e.consume();
                }
            }		
        });
    }
    public Border getBordeComponente() {
        return bordeComponente;
    }

    public void setBordeComponente(Border bordeComponente) {
        this.bordeComponente = bordeComponente;
    }
    
}
