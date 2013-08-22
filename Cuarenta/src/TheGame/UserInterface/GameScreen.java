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
    CuarentaGame game;
    
    public GameScreen(CuarentaGame game) {
        this.game = game;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Who shall win?");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){
   //     setLayout(new Gridlayout(9,9));
        
        JPanel computerHand = drawJokerHand();
        JPanel playerHand = drawJokerHand();

        container.add(computerHand, BorderLayout.NORTH);
        container.add(playerHand, BorderLayout.SOUTH);
        
        
    }
    
    private JPanel drawGameInfo(){
        JPanel panel = new JPanel(new GridLayout(3,1));

        JTextArea computerPoints = new JTextArea("points");
        panel.add(computerPoints);
        JTextArea dealer = new JTextArea("computer");
        panel.add(dealer);
        JTextArea humanPoints = new JTextArea("points");
        panel.add(humanPoints);

        return panel;
    
    }
    
    private JPanel createHand(Hand hand){
        JPanel panel = new JPanel(new GridLayout(1, 5));
        JLabel cards[] = new JLabel[5];
        try{
            
            for(int i=0;i<5;i++){
                cards[i]= new JLabel(new ImageIcon(ImageIO.read(new File("/cs/fs/home/tolaakso/Desktop/Kurssit/KesaLabra2013/Cuarenta/cardImages/54.png"))));
                cards[i].addMouseListener(new CardListener(cards[i]));
                panel.add(cards[i]);
            }
        } catch(Exception e)
        {
            System.out.println("error in drawing the cards");
        }
        return panel;
    }
    
      private JPanel drawJokerHand(){
        JPanel panel = new JPanel(new GridLayout(1, 6));
        JLabel cards[] = new JLabel[5];
        Deck deck = new Deck();
        try{
            
            for(int i=0;i<5;i++){
                cards[i]= new JLabel(new ImageIcon(ImageIO.read(new File((deck.deal()).getImagePath()))));
                cards[i].addMouseListener(new CardListener(cards[i]));
                panel.add(cards[i]);
            }
        } catch(Exception e)
        {
            System.out.println("error in drawing the cards");
        }
        
        JPanel pointPanel = new JPanel(new BorderLayout());
        pointPanel.add(new JLabel("Points"), BorderLayout.NORTH);
        pointPanel.add(new JLabel("31"), BorderLayout.CENTER);
        panel.add(pointPanel);
        
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
