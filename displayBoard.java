//group 4

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;



public class displayBoard implements ActionListener{ 
	
    public JFrame UIframe;
	public JPanel boardPanel;
    public JPanel backPanel;
    public JPanel buttonPanel;
    public JLabel inputNameLabel;
    public int row = 16;
    public int col = 17;
    public JButton[][] step;
    public JButton rollDice, saveGame, mainui, exit;
    public JLabel valueLabel = new JLabel("Dice Value: -  ");
    public JLabel turnOrder = new JLabel("Turn: " + Player.player1Name);
    public int diceValue, playerTurn;
    public Icon endgoal = new ImageIcon(displayBoard.class.getResource("/images/endgoal.png"));
    //public String[] names;
    
  
   
	
   
    public displayBoard(JFrame frame, JPanel p) {
    	UIframe = frame;
    	backPanel = p;
    	backPanel.removeAll();
    	backPanel.revalidate();
    	backPanel.repaint();
    	//String[] names = {"King", "Knight", "Rook", "Bishop"};
        
    	rollDice = new JButton("Roll Dice");
    	saveGame = new JButton("Save Game");
    	mainui = new JButton("Main Menu");
    	exit = new JButton("Exit Game");
    	
    	
    	backPanel.setLayout(new BorderLayout());
    	
    	buttonPanel = new JPanel();
    	
    	buttonPanel.add(turnOrder);
    	
    	buttonPanel.add(valueLabel);
    	
    	buttonPanel.add(rollDice);
    	rollDice.setEnabled(true);
		rollDice.addActionListener(this);
		
    	buttonPanel.add(saveGame);
    	saveGame.addActionListener(this);
    	
    	buttonPanel.add(mainui);
    	mainui.addActionListener(this);
    	
    	buttonPanel.add(exit);
    	exit.addActionListener(this);
    	
    	backPanel.add(buttonPanel, BorderLayout.SOUTH);
    	
    	
        boardPanel = new JPanel(new GridLayout(row, col));
        
        step = new JButton[row][col];
        
        
        //this nested for loop sets the board don't mess with it please
        for (int i = 0; i < row; i++){
        	for (int j = 0; j < col; j++){
        		step[i][j] = new JButton("");
        		step[i][j].setBackground(Color.WHITE);
        		step[i][j].setBorderPainted(false);
        		step[i][j].setSize(10,10);
        		step[i][j].setEnabled(false);
        		boardPanel.add(step[i][j]);
        	}
        }
        
        new setBoard(boardPanel, step);	//sets the empty pieces
        new boardPieces(boardPanel, step);	//sets pawns to starting position and barricade to its original position
        
        backPanel.add(boardPanel, BorderLayout.CENTER);
        
        
        /*while(String.valueOf(step[0][8].getIcon())==String.valueOf(endgoal))
        {
        	//this loop goes on till someone wins the game/reaches the endgoal point
        	for(int i = 0; i < names.length; i++) 
        	{
        		turnOrder.setText("turn: "+names[i]+"  ");
        		rollDice.setEnabled(true);
        		rollDice.addActionListener(this);
        	}
        }*/
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object selected = e.getSource();
		if(selected.equals(mainui)) {
			int reply = JOptionPane.showConfirmDialog(
					UIframe,
				    "Are you sure you want to go the Main Menu?",
				    "An Insane Question",
				    JOptionPane.YES_NO_OPTION);
		  if (reply == JOptionPane.YES_OPTION)
	      {
			  //direct to mainUI()
			  new mainUI(UIframe, backPanel);
	      }
		}
		
		if(selected.equals(exit)) {
			//Direct to exit game
			new exitGame(UIframe);
		}
		
		if(selected.equals(rollDice)) {
			playerTurn++;
			if(playerTurn > 4) {
				playerTurn = 1;
				
				
			}
			Random x = new Random();
			diceValue = x.nextInt(6) + 1;
			valueLabel.setText("Dice Value: "+String.valueOf(diceValue)+"  ");
			//valueLabel.setText("Dice Value: "+String.valueOf(endgoal)+"  ");
			//rollDice.setEnabled(false);
			
			if( playerTurn ==(1)){
				turnOrder.setText("Turn: "+ Player.player1Name);
				}
			else if( playerTurn == (2)){
				turnOrder.setText("Turn: "+ Player.player2Name);
				}
			else if( playerTurn == (3)){
				turnOrder.setText("Turn: "+ Player.player3Name);
				}
			else if( playerTurn == (4)){
				turnOrder.setText("Turn: "+ Player.player4Name);
				} 
			//turnOrder.setText("Turn: Player "+playerTurn);
			
			
			
			rollDice.setEnabled(false);
			new movePawn(UIframe,step,rollDice,diceValue,playerTurn,valueLabel,turnOrder,backPanel);
		}
		
		if(selected.equals(saveGame)) {
			JOptionPane.showMessageDialog(UIframe, "This feature will be added in the future Release.", 
					"Info", JOptionPane.WARNING_MESSAGE);
		}
		
	}
}
