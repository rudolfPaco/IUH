/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.comboBox;

import IUH.campoTexto.IUCampoTexto;
import IUH.paneles.IUPanel;
import IUH.utilitarios.Area;
import IUH.utilitarios.Ayuda;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class IUComboBox extends JComboBox<String> {

    private IUPanel panel;
    private Area area;
    private String tipo;
    private boolean estadoTexto;
    private int size;
    private Color colorLetra = new Color(2, 67, 109);
    private ArrayList<String> opciones = new ArrayList<>();
    private int nroColumnas = 0;
    private Border bordeComponente;

    /**
     * Interfaz de Usuario Combo Box, componente que hereda del JComboBox,
     * recibe dos parametros; una lista de opciones y su limitacion. por defecto
     * es editable, pero se puede restringir numeros decimales, enteros o
     * letras, mayusculas.
     *
     * @param panel
     * @param opciones lista de opciones que se reflejara en el componente.
     * @param area
     * @param size
     * @param nroColumnas
     */
    public IUComboBox(IUPanel panel, ArrayList<String> opciones, Area area, int size, int nroColumnas) {
        super();
        this.panel = panel;
        this.opciones = opciones;
        this.area = area;
        this.size = size;
        this.nroColumnas = nroColumnas;

        construirComboBox();
        setEventos();
    }

    private void construirComboBox() {
        opciones.forEach((item) -> this.addItem(item));
        panel.agregar(this, area);

        setFocusable(true);
        setEditable(true);
        //setOpaque(false);        
        setFont(Ayuda.FONT(size));
        setBorder(new LineBorder(Ayuda.COLOR_LINEA));
        ((JTextField) getEditor().getEditorComponent()).setSelectionColor(Ayuda.COLOR_FOCO);
        //setColorLetra(colorLetra);
        //setForeground(colorLetra);
        //setBordeComponente(getBorder());        
        //setDeshabilitarTexto(true);
        //setOpacidad(false);
    }

    /**
     *
     * @param opciones
     */
    public void actualizarOpciones(ArrayList<String> opciones) {
        removeAllItems();
        this.opciones = opciones;
        this.opciones.forEach((item) -> this.addItem(item));

    }

    public String getTexto() {
        return ((JTextField) getEditor().getEditorComponent()).getText();
    }

    public void setColorLetra(Color colorLetra) {
        ((JTextField) getEditor().getEditorComponent()).setForeground(colorLetra);
    }

    public void setOpacidad(boolean opacidad) {
        ((JTextField) getEditor().getEditorComponent()).setOpaque(opacidad);
    }

    public void setPosicionHorizontal(int posicion) {
        ((JLabel) getRenderer()).setHorizontalAlignment(posicion);
    }

    public void setEditar(boolean estado) {
        setFocusable(estado);
        setEnabled(estado);
        ((JTextField) getEditor().getEditorComponent()).setEditable(estado);
    }

    private void setEventos() {
        setOpaque(false);
        

        /*setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                BasicArrowButton botonFlecha = new BasicArrowButton(BasicArrowButton.SOUTH, //Direccion de la flecha
                        Ayuda.COLOR_FONDO, //Color de fondo
                        Color.RED,//sombra
                        Color.LIGHT_GRAY,//darkShadow
                        colorLetra //highlight
                );
                //se quita el efecto 3d del boton, sombra y darkShadow no se aplican 
                botonFlecha.setBorder(new LineBorder(Ayuda.COLOR_LINEA));
                botonFlecha.setCursor(new Cursor(Cursor.HAND_CURSOR));

                return botonFlecha;
                return new BasicArrowButton(SwingConstants.SOUTH);
            }

            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup comboBoxPopup = new BasicComboPopup(comboBox);
                comboBoxPopup.setBorder(new LineBorder(Ayuda.COLOR_LINEA));
                return comboBoxPopup;
            }
            
            protected ComboPopup createPopup() {
                BasicComboPopup popup = new BasicComboPopup(comboBox) {
                    @Override
                    protected Rectangle computePopupBounds(int px, int py, int pw, int ph) {
                        return super.computePopupBounds(px, py, Math.max(comboBox.getPreferredSize().width, pw), ph);
                    }
                };
                popup.getAccessibleContext().setAccessibleParent(comboBox);
                popup.setBorder(new LineBorder(Ayuda.COLOR_LINEA));
                return popup;
            }

        });*/

        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {

                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                list.setSelectionBackground(Ayuda.COLOR_FOCO);

                if (isSelected) {
                    setBackground(new Color(219, 210, 198));
                    setForeground(Ayuda.COLOR_LETRA);
                } else {
                    setBackground(Color.WHITE);
                    setForeground(Ayuda.COLOR_LETRA);
                }
                return this;
            }
        });
        
        /*Object comp = getUI().getAccessibleChild(this, 0);
        if (!(comp instanceof JPopupMenu)) {
            return;
        }        
        JComponent scrollPane = (JComponent) ((JPopupMenu) comp).getComponent(0);
        Dimension size = new Dimension();
        size.width = getPreferredSize().width*2;
        size.height = scrollPane.getPreferredSize().height;
        scrollPane.setPreferredSize(size);
        scrollPane.setBorder(new LineBorder(Ayuda.COLOR_LINEA));*/

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //if(KeyEvent.VK_ENTER == e.getKeyCode()){
                //    transferFocus();
                //}
                //if(KeyEvent.VK_F2 == e.getKeyCode())
                //  transferFocusBackward();
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (getTexto().length() == nroColumnas) {
                    e.consume();
                }
            }
        });
        ((JTextField) getEditor().getEditorComponent()).addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                ((JTextField) getEditor().getEditorComponent()).setSelectionStart(0);
                ((JTextField) getEditor().getEditorComponent()).setSelectionEnd(((JTextField) getEditor().getEditorComponent()).getText().length());
            }
        });
    }

    public void setRestriccion(String restriccion) {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String cadena = Character.toString(e.getKeyChar());
                Pattern p = Pattern.compile(restriccion);
                Matcher matcher = p.matcher(cadena);
                if (!matcher.find()) {
                    e.consume(); //hace que esa pulsación de tecla se rechace.                    
                    //Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }

    public void setRestriccionNumeroDecimal(int nroDecimal) {
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
                String texto = ((JTextField) getEditor().getEditorComponent()).getText();
                if (!texto.isEmpty()) {
                    try {
                        //number = Double.parseDouble(df.format(getText()));
                        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("en", "US"));

                        number = numberFormat.parse(texto).doubleValue();
                        number = NumberFormat.getNumberInstance(new Locale("es_BO", "BO")).parse(texto).doubleValue();

                        //setText(NumberFormat.getNumberInstance(new Locale("es_BO", "BO")).format(NumberFormat.getNumberInstance(new Locale("es_BO","BO")).parse(getText()).doubleValue()));
                        //BigDecimal bd = new BigDecimal(number);
                        //bd = bd.setScale(nroDecimal, RoundingMode.HALF_UP);
                        ((JTextField) getEditor().getEditorComponent()).setText(df.format(number));
                        //setText(String.format("%,.2f", number));
                    } catch (ParseException ex) {
                        Logger.getLogger(IUCampoTexto.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    //BigDecimal bd = new BigDecimal(number);
                    //bd = bd.setScale(nroDecimal, RoundingMode.HALF_UP);
                    //setText(NumberFormat.getNumberInstance(new Locale("es_BO", "BO")).format(number));
                    ((JTextField) getEditor().getEditorComponent()).setText(df.format(number));
                }
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != KeyEvent.VK_BACK_SPACE)
                        && (caracter != '.' || ((JTextField) getEditor().getEditorComponent()).getText().contains("."))) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEstadoTexto() {
        return estadoTexto;
    }

    public void setDeshabilitarTexto(boolean estado) {
        this.estadoTexto = estado;
    }

    public Border getBordeComponente() {
        return bordeComponente;
    }

    public void setBordeComponente(Border bordeComponente) {
        this.bordeComponente = bordeComponente;
    }

}
