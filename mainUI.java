//contributor: zac, Nima, Aman, Fysal

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainUI implements ActionListener
 {
    Icon name1 = new ImageIcon(mainUI.class.getResource("/images/name.png"));
    public JMenuItem cursor, theme, instructions;
    public JFrame frame;
    public JPanel mainPanel;
    public JButton newGame;
    public JLabel name = new JLabel(name1);
    public JPanel centerPanel = new JPanel();
    public JPanel northPanel = new JPanel();
    
    public mainUI(JFrame UIframe, JPanel UIpanel) 
    {
        //Creating the Frame
        Icon newGameimage = new ImageIcon(mainUI.class.getResource("/images/newGame.png"));
        Icon loadGameimage = new ImageIcon(mainUI.class.getResource("/images/LoadGame.png"));
        Icon exitGameimage = new ImageIcon(mainUI.class.getResource("/images/ExitGame.png"));
    	frame = UIframe;
    	mainPanel = UIpanel;
    	mainPanel.removeAll();
    	mainPanel.revalidate();
    	mainPanel.repaint();
        frame.setTitle("Malefiz");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        
        //Creating the MenuBar and adding components
        JMenuBar menubar = new JMenuBar();
        JMenu menubar_display = new JMenu("Display Options");
        JMenu menubar_help = new JMenu("Help");
        
        menubar.add(menubar_display);
        menubar.add(menubar_help);
        
        cursor = new JMenuItem("Choose cursor");
        theme = new JMenuItem("Choose theme");
        instructions = new JMenuItem("Instructions");
        
        //creating buttons
        JButton newGame = new JButton(newGameimage);
        JButton exitGame = new JButton(exitGameimage);
        JButton loadGame = new JButton(loadGameimage);
        newGame.setFont(new Font("Tahoma", Font.PLAIN, 40));
        exitGame.setFont(new Font("Tahoma", Font.PLAIN, 40));
        loadGame.setFont(new Font("Tahoma", Font.PLAIN, 40));
        newGame.setSize(40, 40);
        loadGame.setSize(40, 40);
        exitGame.setSize(40, 40);
        
        exitGame.addActionListener(this);
        mainPanel.setLayout(new BorderLayout());
        Color maincolour = new Color(158, 123, 100);
        mainPanel.setBackground(maincolour);
        
        northPanel.setLayout(new FlowLayout());
        northPanel.setOpaque(false);
        name.setFont(new Font("Tahoma", Font.PLAIN, 80));
        northPanel.add(name);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        
        centerPanel.setLayout(new GridLayout(3, 1));
        centerPanel.setOpaque(false);
        centerPanel.add(newGame).setLocation(1, 1);
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == newGame)
              {
                  
            	  new newGame(frame, mainPanel);
               
              }  
            }
        });
        
        centerPanel.add(loadGame).setLocation(2, 1);
        loadGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
            	Object selected = aActionEvent.getSource();
              if(selected.equals(loadGame))
              {
            	  
            	  JOptionPane.showMessageDialog(frame, "This feature will be added in the future Release.", 
      					"Info", JOptionPane.WARNING_MESSAGE);
            	  
              }  
            }
        });
        centerPanel.add(exitGame).setLocation(3, 1);
        exitGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
            	Object selected = aActionEvent.getSource();
              if(selected.equals(exitGame)) //pop up box prompting user to confirm quitting
              {
            	  
            	  new exitGame(frame);
            	  
              }  
            }
        });
        
        newGame.setOpaque(false);
        newGame.setContentAreaFilled(false);
        newGame.setBorderPainted(false);
        loadGame.setOpaque(false);
        loadGame.setContentAreaFilled(false);
        loadGame.setBorderPainted(false);
        exitGame.setOpaque(false);
        exitGame.setContentAreaFilled(false);
        exitGame.setBorderPainted(false);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        menubar_display.add(cursor);
        cursor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == cursor)
              {
            	  new chooseCursor(frame);
               
              }  
            }
        });
        
        menubar_display.add(theme);
        theme.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == theme)
              {
            	  new chooseTheme(frame,mainPanel);
              } 
              
            }
        });
        
        menubar_help.add(instructions);
        instructions.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == instructions)
              {
            	  JOptionPane.showMessageDialog(frame, "> Each player rolls the die takes turn according to the turn order at the bottom left of the board. \r\n"
            	  		+ "> That player selects one of their five pawns to move the number of spaces shown on the die. \r\n"
            	  		+ "   They can not select a different pawn after they have selected that pawn.\r\n"
            	  		+ "> Players can not forgo their turn.\r\n"
            	  		+ "> The spaces within the players houses are not counted against the die-roll; \r\n"
            	  		+ "   the first space counted by each pawn is the space immediately above the house. \r\n"
            	  		+ "> A pawn may pass other pawns of any color, but only one pawn may occupy a given space.\r\n"
            	  		+ "> In the event that a pawn finishes its move by landing on a space occupied by another pawn, \r\n"
            	  		+ "   the pawn occupying that space is captured. Captured pawns are returned to their respective \r\n"
            	  		+ "   houses and may rejoin play on their owner's next turn. \r\n"
            	  		+ "> Unlike pawns, barricade pieces may not be passed. In order for play to progress past a barricade, \r\n"
            	  		+ "   the barricade must be captured by a pawn.\r\n"
            	  		+ "> A player who captures a barricade must relocate the barrier to an unoccupied space on the board. \r\n"
            	  		+ "   Barricades may not be placed in the four houses or any of the 17 spaces in the bottom-most row. ", 
      					"Instructions", JOptionPane.WARNING_MESSAGE);
              } 
              
            }
        });


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, menubar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setVisible(true);

        
    }
    
    public void actionPerformed(ActionEvent aevt)
    {
    	
    }
}