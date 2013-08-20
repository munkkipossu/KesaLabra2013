/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame.UserInterface;
import TheGame.CuarentaGame;
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
public class MainScreen implements Runnable {

    public static void main(String[] args) {
        MainScreen mainScreen = new MainScreen();
        SwingUtilities.invokeLater(mainScreen);
    }
    
    
    private JFrame frame;
    
    public MainScreen() {
    }
    
    @Override
    public void run() {
        frame = new JFrame("Cuarenta");
        frame.setPreferredSize(new Dimension(400, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        
        container.add(new JLabel("Name"));
        JTextArea nameText = new JTextArea("Dude");
        container.add(nameText);
        
        container.add(addChoice("Difficulty", "Easy", "Hard"));
        container.add(addChoice("First Dealer", "Computer", "Player"));
        
        
        JButton startButton = new JButton("Start the GAME!");
        startButton.addActionListener(new GameStarter(nameText));

        container.add(startButton);
        
    }

    private JPanel addChoice(String title, String firstChoice, String secondCoice){
        JPanel panel = new JPanel();
        JLabel titleText = new JLabel(title);
        JRadioButton first = new JRadioButton(firstChoice, true);
        JRadioButton second = new JRadioButton(secondCoice);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(first);
        buttonGroup.add(second);
        
        panel.add(titleText);
        panel.add(first);   
        panel.add(second);
        
        return panel;
                
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
}
