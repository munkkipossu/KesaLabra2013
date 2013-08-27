/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame.UserInterface;
import TheGame.CuarentaGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.*;

/**
 *
 * @author tolaakso
 */
public class PlayerListener implements ActionListener {

    private HandPanel panel;
    private TablePanel table;
    private CuarentaGame game;
    
    public PlayerListener(CuarentaGame game, HandPanel panel, TablePanel table){
        this.game = game;
        this.panel = panel;
        this.table = table;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        TheGame.Logic.humanMove(this.game, this.panel.getChosenCard(), this.table.getChosenCards());
        System.out.println("I am here");
        panel.repaint();
        table.repaint();
    }
}