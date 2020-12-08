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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class IUCampoTexto extends JTextField{
    private IUPanel panel;
    private int nroColumnas = 9999999;
    private  int size = 0;
    private Area area;
    private int posicionH = SwingConstants.LEFT;
    private Border bordeComponente;
        
    /**
     * Interfaz de Usuario Campo de Texto, se crea el componente al inicio de tipo texto, pero se puede restringir los datos de entrada al campo de texto.
     * @param panel contenedor de componentes
     * @param area posicion y dimension del Campo
     * @param texto cadena de caracteres que se mostraran al inicio en el componente.     
     * @param size tamaño de letra del texto
     * @param posicionH ubicacion horizontal del texto
     */
    public IUCampoTexto(IUPanel panel, Area area, String texto, int size, int posicionH){
        super(texto);
        this.panel = panel;
        this.size = size;
        this.posicionH = posicionH;
        this.area = area;
                
        construirCampoTexto();
        agregarEventos();
    }

    /**
     *
     * @param panel contenedor del campo texto
     * @param nroColumnas cantidad de letras para limitar los caracteres
     * @param size tamaño de letra
     * @param area posicion y dimension del Campo Texto
     * @param posicionH ubicaion horizontal del texto
     */
    public IUCampoTexto(IUPanel panel, Area area, int nroColumnas, int size, int posicionH){
        super("");
        this.panel = panel;
        this.area = area;
        this.nroColumnas = nroColumnas;
        this.size = size;        
        this.posicionH = posicionH;
        
        construirCampoTexto();
        agregarEventos();
        
    }
    private void construirCampoTexto(){
        
        panel.agregar(this, area);        
        setSelectedTextColor(getForeground());
        if(size == 0)
            setFont(Ayuda.FUENTE);
        else
            setFont(Ayuda.FONT(size));
        setHorizontalAlignment(posicionH);
        setSelectionColor(new Color(0, 0, 0, 0));
        setBorder(new LineBorder(Ayuda.COLOR_LINEA));
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
    }
    public void setRestriccion(String restriccion){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String cadena = Character.toString(e.getKeyChar());
                Pattern p = Pattern.compile(restriccion);
                Matcher matcher = p.matcher(cadena);  
                if(!matcher.find()) {
                    e.consume(); //hace que esa pulsación de tecla se rechace.                    
                    //Toolkit.getDefaultToolkit().beep();
                }
            }
        });        
    }

    /**
     * restringe la entrada en numero decimal y formatea el numero en #,###,##0.00
     */
    public void setRestriccionDosDecimales(){
        
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                
                /*if(!getText().isEmpty()){
                    try {
                        NumberFormat numberFormatOut = NumberFormat.getNumberInstance(Locale.getDefault());                        
                        setText(String.valueOf(numberFormatOut.parse(getText()).doubleValue()));
                    } catch (ParseException ex) {
                        Logger.getLogger(IUCampoTexto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
                
                
                
                
                DecimalFormat df = new DecimalFormat("#,###,##0.00", new DecimalFormatSymbols(Locale.US));
                //DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
                //dfs.setDecimalSeparator('.');
                //df.setDecimalFormatSymbols(dfs);
                //String.format("%,.2f", number) -> 15.548,45
                
                double number = 0.00;
                if(!getText().isEmpty()){
                    try {
                        //number = Double.parseDouble(df.format(getText()));
                        NumberFormat numberFormat  = NumberFormat.getNumberInstance(new Locale("en", "US"));
                        
                        number = numberFormat.parse(getText()).doubleValue();
                        number = NumberFormat.getNumberInstance(new Locale("es_BO", "BO")).parse(getText()).doubleValue();
                        
                        
                        //setText(NumberFormat.getNumberInstance(new Locale("es_BO", "BO")).format(NumberFormat.getNumberInstance(new Locale("es_BO","BO")).parse(getText()).doubleValue()));
                        //BigDecimal bd = new BigDecimal(number);
                        //bd = bd.setScale(nroDecimal, RoundingMode.HALF_UP);
                        setText(df.format(number));
                        //setText(String.format("%,.2f", number));
                    } catch (ParseException ex) {
                        Logger.getLogger(IUCampoTexto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else{
                //BigDecimal bd = new BigDecimal(number);
                //bd = bd.setScale(nroDecimal, RoundingMode.HALF_UP);
                    //setText(NumberFormat.getNumberInstance(new Locale("es_BO", "BO")).format(number));
                    setText(df.format(number));
                }
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) 
                        && (caracter != KeyEvent.VK_BACK_SPACE)
                        && (caracter != '.' || getText().contains(".")) ) {
                            e.consume();
                }
                /*if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.'){                    
                    e.consume();                    
                }
                if(e.getKeyChar() == '.' && getText().contains(".")){
                    e.consume();
                }*/
            }
        });
    }
    public void setTextoD(String texto){
        DecimalFormat df = new DecimalFormat("0.00");
        //DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
        //dfs.setDecimalSeparator('.');
        //df.setDecimalFormatSymbols(dfs);
        if(!texto.isEmpty())
            setText(df.format(Double.parseDouble(texto)));
    }

    public Border getBordeComponente() {
        return bordeComponente;
    }

    public void setBordeComponente(Border bordeComponente) {
        this.bordeComponente = bordeComponente;
    }
    
}
