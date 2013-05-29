/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JViewport;

/**
 *
 * @author Felipe
 */
public class DibujarPanel {
    public static void dibujarPanel(JFrame objetivo, JViewport contenedor, JPanel panel){
        objetivo.setSize(tamanioAjustadoFrame(panel));
        cambiarPanel(contenedor, panel);
        objetivo.setLocationRelativeTo(objetivo.getParent());
    }
    
    private static void cambiarPanel(JViewport contenedor, JPanel panel) {
        contenedor.getParent().setVisible(false);
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(panel);
        contenedor.setSize(panel.getPreferredSize().getSize());
        contenedor.getParent().setSize(panel.getPreferredSize().getSize());
        contenedor.getParent().revalidate();
        contenedor.getParent().repaint();
        contenedor.revalidate();
        contenedor.repaint();
        contenedor.getParent().setVisible(true);
        contenedor.setVisible(true);
    }
    
    private static Dimension tamanioAjustadoFrame (JPanel panel) {
        int ajuste = 50;
        return new Dimension (panel.getPreferredSize().width+ajuste, panel.getPreferredSize().height+ajuste);
    }
    
}
