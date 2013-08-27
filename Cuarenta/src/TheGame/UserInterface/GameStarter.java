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

public class GameStarter implements ActionListener {

    private CuarentaGame game;
    private JTextArea playerName;
    
    
    public GameStarter(JTextArea playerName){
        this.game = new CuarentaGame(playerName.getText());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        GameScreen gameScreen = new GameScreen(game);
        System.out.println("Game Started");
        
        SwingUtilities.invokeLater(gameScreen);
    }
}