/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame.UserInterface;

import TheGame.CuarentaGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;


import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author tolaakso
 */
public class CardListener implements MouseListener {

    private JLabel label;
    private boolean borderExists;

    public CardListener(JLabel jlabel) {
        this.label = jlabel;
        this.borderExists = false;
    }

    public void mouseClicked(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mousePressed(MouseEvent arg0) {
    }

    public void mouseReleased(MouseEvent arg0) {
        if(borderExists){
            this.label.setBorder(BorderFactory.createEmptyBorder());
            borderExists = false;
        }else{
            this.label.setBorder(BorderFactory.createRaisedBevelBorder());
            borderExists = true;
        }
    }
}
