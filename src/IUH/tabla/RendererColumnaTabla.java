/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUH.tabla;
/**
 *
 * @author neo
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererColumnaTabla extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        Component c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        c.setBackground(Color.YELLOW);
        
        return c;
    }
}

