/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Game.CardHolder;
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
import java.util.ArrayList;
import Game.*;
/**
 *
 * @author tolaakso
 */
public class TableListener implements MouseListener {

    private Card raisedBorders;
    private ArrayList<Card> cards;
    private boolean raised;
    private boolean firstTime;
    
    public TableListener(ArrayList<Card> cards) {
        this.firstTime=true;
        this.cards=cards;
        this.raised = false;
        this.raisedBorders = null;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        if(firstTime){
            this.raisedBorders = (Card)e.getSource();
            firstTime=false;
        }
        
        if(raised){
            this.raisedBorders.setBorder(BorderFactory.createEmptyBorder());
            this.cards.remove(raisedBorders);
            raised=false;
        }
        else{
            this.raisedBorders.setBorder(BorderFactory.createRaisedBevelBorder());
            this.cards.add(raisedBorders);
            raised=true;
        }
    }
}
