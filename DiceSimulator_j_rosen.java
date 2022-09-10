import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

//****************************************************************************** 
// Jay Rosen
// 11/25/14
// COP2660.0M1
// Module 12 : DiceSimulator_j_rosen.java
//
// This program rolls a pair of dice.
//******************************************************************************

public class DiceSimulator_j_rosen extends JFrame
{
   private final int WINDOW_WIDTH = 240;  // Window width
   private final int WINDOW_HEIGHT = 190; // Window height
   
   private JPanel die1Panel;        // A panel to hold a label
   private JPanel die2Panel;        // A panel to hold a label
   private JPanel buttonPanel;      // A panel to hold a button
   private JLabel die1Label;        // A label to hold an image
   private JLabel die2Label;        // A label to hold an image
   private ImageIcon die1Image;     // To hold an image of die1
   private ImageIcon die2Image;     // To hold an image of die2
   private JButton button;          // A button to get roll the dice
   private Container contentPane;   // To reference the content pane
   
   private ArrayList<ImageIcon> dieImageList;  // To hold the die images.

   /**
      Constructor
   */
   
   public DiceSimulator_j_rosen()
   {
      // Set the title.
      setTitle("Dice Simulator");
   
      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Create a BorderLayout manager for the content pane.
      setLayout(new BorderLayout());
       
      // Build the dieImageList
      buildDieImageList();

      // Build the panels.
      buildDie1Panel();
      buildDie2Panel();
      buildButtonPanel();

      // Add the panels to the content pane.
      add(die1Panel, BorderLayout.WEST);
      add(die2Panel, BorderLayout.EAST);
      add(buttonPanel, BorderLayout.SOUTH);

      // Roll the dice initially.
      rollDice();
      
      // Display the window.
      setVisible(true);
   }

   /**
      The buildDie1Panel method adds a label
      to a panel that displays an image of 
      the first die.
   */

   private void buildDie1Panel()
   {
      // Create a panel.
      die1Panel = new JPanel();

      // Create a label.
      die1Label = new JLabel();

      // Add the label to the panel.
      die1Panel.add(die1Label);
   }

   /**
      The buildDie2Panel method adds a label
      to a panel that displays an image of 
      the second die.
   */

   private void buildDie2Panel()
   {
      // Create a panel.
      die2Panel = new JPanel();

      // Create a label.
      die2Label = new JLabel();

      // Add the label to the panel.
      die2Panel.add(die2Label);
   }
  
   /**
      The buildButtonPanel method adds a button
      to a panel.
   */

   private void buildButtonPanel()
   {
      // Create a panel.
      buttonPanel = new JPanel();
   
      // Create a button.
      button = new JButton("Roll the Dice");
      button.setMnemonic(KeyEvent.VK_R);
      button.setToolTipText("Click here to roll the dice.");
      
      // Register an action listener with the button.
      button.addActionListener(new ButtonListener());
      
      // Add the button to the panel.
      buttonPanel.add(button);
   }


   /**
      The buildDieImageList method fills the 
      ArrayList with images of a die.
   */

   private void buildDieImageList()
   {
      // Create the dieImageList ArrayList 
      // to hold the ImageIcon objects.
      dieImageList = new ArrayList<>();
      
      // Add the ImageIcon objects to the 
      // dieImageList ArrayList
      dieImageList.add(new ImageIcon("Dice\\Die1.png"));
      dieImageList.add(new ImageIcon("Dice\\Die2.png"));
      dieImageList.add(new ImageIcon("Dice\\Die3.png"));
      dieImageList.add(new ImageIcon("Dice\\Die4.png"));
      dieImageList.add(new ImageIcon("Dice\\Die5.png"));
      dieImageList.add(new ImageIcon("Dice\\Die6.png"));                                                    
   }

   /**
      The rollDice method simulates the 
      rolling of a pair of dice.
   */

   private void rollDice()
   {
      // Create a reference to a Random object.
      Random rand = new Random();      

      // Generate a random number between 0 and the 
      // number of items in the array list, and store 
      // the value in the index variables.
      int index1 = rand.nextInt(dieImageList.size());
      int index2 = rand.nextInt(dieImageList.size());

      // Get images from the array list using
      // the index values that were generated.
      die1Image = dieImageList.get(index1);
      die2Image = dieImageList.get(index2);
      
      // Display the dice.
      die1Label.setIcon(die1Image); 
      die2Label.setIcon(die2Image);                                                 
   }  
     
   /**
      Private inner class that handles the event when
      the user clicks the button.
   */
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // Roll the dice.
         rollDice();
      }
   }

   /**
      The main method creates an instance of the DiceSimulator
      class, causing it to display its window.
   */
     
   public static void main(String[] args)
   {
      DiceSimulator ds = new DiceSimulator();
   }
}
