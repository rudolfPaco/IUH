/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.utilitarios;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author neo
 */
public class Ayuda {
    
    public static final Font FUENTE = new Font("Monospaced 13", Font.PLAIN, 16);
    public static final Color COLOR_FONDO = new Color(64, 64, 64);
    public static final Color COLOR_LETRA = new Color(32, 32, 32);
    public static final Color COLOR_BORDE = new Color(64, 64, 64);
    public static final Color COLOR_LINEA = new Color(230, 191, 116);
    public static final Color COLOR_FOCO = new Color(255, 250, 212);
    
    
    public static Font FONT(int size){
        return new Font("Monospaced 13", Font.PLAIN, size);
    }
}
