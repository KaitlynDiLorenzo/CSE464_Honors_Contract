import java.awt.*;

import javax.swing.*;        

public class Main {
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TestRunner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel();
        RightPanel rPanel = new RightPanel();
        LeftPanel lPanel = new LeftPanel();
        
        mainPanel.setLayout(new GridLayout(1,1));
        
        // Add left and right panels to mainPanel
        mainPanel.add(lPanel);
        mainPanel.add(rPanel);
        
        frame.getContentPane().add(mainPanel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
//JUnit Core
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}