/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Game.CuarentaGame;
import Game.Card;
import Game.Suit;
import Game.Rank;
import Game.Logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author tolaakso
 */
public class PlayerListener implements ActionListener {

    private HandPanel handPanel;
    private TablePanel tablePanel;
    private CuarentaGame game;
    private boolean humanGoesFirst;
    
    public PlayerListener(CuarentaGame game, HandPanel panel, TablePanel table){
        this.game = game;
        this.handPanel = panel;
        this.tablePanel = table;
        this.humanGoesFirst = game.humanPlaysFirst();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
                Game.Logic.humanMove(this.game, this.handPanel.getChosenCard(), tablePanel.getChosenCards());
                this.handPanel.getChosenCard().setBorder(BorderFactory.createEmptyBorder());
        }
        catch (Exception e) {
            System.out.println("Playing the move caused an error: " + tablePanel.getChosenCards().size() + " cards chosen");
        }
                        
        handPanel.drawHand();
        tablePanel.drawTable();
    }
}