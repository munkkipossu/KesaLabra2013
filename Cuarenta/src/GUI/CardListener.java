/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Game.Card;
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
    private boolean firstTime;

    public CardListener(HandPanel panel) {
        this.firstTime=true;
        this.handPanel = panel;
        this.raisedBorders = null;
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

        if(firstTime){
            this.raisedBorders = (JLabel) e.getSource();
            firstTime=false;
        }
            this.raisedBorders.setBorder(BorderFactory.createEmptyBorder());
            this.raisedBorders = (JLabel) e.getSource();
            this.raisedBorders.setBorder(BorderFactory.createRaisedBevelBorder());
            this.handPanel.setChosenCard((Card)e.getSource());
            
    }
}
