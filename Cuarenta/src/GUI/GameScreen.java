/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Game.Table;
import Game.CuarentaGame;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.imageio.*;
import java.io.File;
import java.awt.Color;

import Game.*;



/**
 *
 * @author tolaakso
 */
public class GameScreen implements Runnable {
  
    private JFrame frame;
    private CuarentaGame game;
    private CardListener cardListener;
    
    public GameScreen(CuarentaGame game) {
        this.game = game;
        Game.Logic.prepareGame(game);
    }
    
    @Override
    public void run() {
        frame = new JFrame("Who shall win?");
        frame.setPreferredSize(new Dimension(600, 600));

        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){
   //     setLayout(new Gridlayout(9,9));
        
        JPanel computerHand = drawComputerHand(game.getComputerPlayer().getHand());
        HandPanel playerHand = new HandPanel(game.getHumanHand());
        TablePanel tablePanel = new TablePanel(game);
      
        container.add(computerHand, BorderLayout.NORTH);
        container.add(playerHand, BorderLayout.SOUTH);
        
        JPanel options = playButton(game, playerHand, new TablePanel(game));
        container.add(options, BorderLayout.EAST);
        
        container.add(tablePanel, BorderLayout.CENTER);
    }
    
    private JPanel playButton(CuarentaGame game, HandPanel hand, TablePanel table){
        JPanel panel = new JPanel(new GridLayout(5,1));

        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        JButton playButton = new JButton("Click");
        panel.add(playButton);
        playButton.addActionListener(new PlayerListener(game, hand, table));

        panel.add(new JLabel(""));

        return panel;
    
    }
    
    
   /* private JPanel drawTable(Table table){
        JPanel panel = new JPanel(new GridLayout(4, 5));
        JLabel cards[];
        try{
            
        } catch(Exception e)
        {
            System.out.println("error in drawing the cards");
        }
        
                
        JPanel pointPanel = new JPanel(new BorderLayout());
        pointPanel.add(new JLabel("Points"), BorderLayout.NORTH);
        pointPanel.add(new JLabel("0"), BorderLayout.CENTER);
        panel.add(pointPanel);
        
        JPanel discardPanel = new JPanel(new BorderLayout());
        discardPanel.add(new JLabel("Discardpile"), BorderLayout.NORTH);
        discardPanel.add(new JLabel("0"), BorderLayout.CENTER);
        panel.add(discardPanel);
        return panel;
    }
    * */
    
    private JPanel drawComputerHand(Hand hand){
        JPanel panel = new JPanel(new GridLayout(1, 5));
        Card cards[] = new Card[5];
        try{
            
            for(int i=0;i<hand.numberOfCards();i++){
                cards[i]= hand.getCard(i);
                panel.add(cards[i]);
            }
            for(int i=hand.numberOfCards();i<5;i++){
                panel.add(new JLabel(""));
            }
        } catch(Exception e)
        {
            System.out.println("error in drawing computer's hand");
        }
        
                
        JPanel pointPanel = new JPanel(new BorderLayout());
        pointPanel.add(new JLabel("Points"), BorderLayout.NORTH);
        pointPanel.add(new JLabel("0"), BorderLayout.CENTER);
        panel.add(pointPanel);
        
        JPanel discardPanel = new JPanel(new BorderLayout());
        discardPanel.add(new JLabel("Discardpile"), BorderLayout.NORTH);
        discardPanel.add(new JLabel("0"), BorderLayout.CENTER);
        panel.add(discardPanel);
        return panel;
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
