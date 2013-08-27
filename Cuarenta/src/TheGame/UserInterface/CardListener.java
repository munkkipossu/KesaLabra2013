/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame.UserInterface;

import TheGame.*;
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

    private JLabel raisedBorders;
    private HandPanel handPanel;
    
    public CardListener(HandPanel panel) {
        this.handPanel=panel;
        this.raisedBorders=null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (raisedBorders != null) {
            this.raisedBorders.setBorder(BorderFactory.createEmptyBorder());
        }
        this.raisedBorders = (JLabel) e.getSource();
        this.raisedBorders.setBorder(BorderFactory.createRaisedBevelBorder());

        this.handPanel.setChosenCard((Card)e.getSource());
    }
}   
