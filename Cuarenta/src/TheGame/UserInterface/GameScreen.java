/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame.UserInterface;
import TheGame.*;
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
        TheGame.Logic.prepareGame(game);
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
        
        JPanel computerHand = drawComputerHand();
        HandPanel playerHand = new HandPanel(game.getHumanHand(),0);
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
    
    
    private JPanel drawTable(Table table){
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
    
    private JPanel drawComputerHand(){
        JPanel panel = new JPanel(new GridLayout(1, 5));
        JLabel cards[] = new JLabel[5];
        try{
            
            for(int i=0;i<5;i++){
                cards[i]= new JLabel(new ImageIcon(ImageIO.read(new File("/cs/fs/home/tolaakso/Desktop/Kurssit/KesaLabra2013/Cuarenta/cardImages/54.png"))));
                //cards[i]= new JLabel(new ImageIcon(getClass().getResource("../src/Images/54.png")));
                panel.add(cards[i]);
            }
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
    
    public JFrame getFrame() {
        return frame;
    }
}
