import javax.swing.ImageIcon;
import javax.swing.*;

public class boardPieces extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JPanel boardPanel;
	public JButton[][] step;
	public Icon endgoal = new ImageIcon(displayBoard.class.getResource("/images/endgoal.png"));
	public Icon barricade = new ImageIcon(displayBoard.class.getResource("/images/barricade.png"));

	public boardPieces(JPanel panel, JButton[][] button) {
		
		int row = 16;
        int col = 17;
		boardPanel = panel;
		step = button;
		
		for (int i = 0; i < row; i++){
        	for (int j = 0; j < col; j++){
        		if (i==0) {
        			if(j==8) { 
                    step[i][j].setIcon(endgoal);}
        			}
        		if (i==1) {
        			if(j==8) { 
                        step[i][j].setIcon(barricade);}
        			}
        		if (i==3) {
        			if(j==8) { 
                        step[i][j].setIcon(barricade);}
        			}
        		if (i==4) {
        			if(j==8) { 
                        step[i][j].setIcon(barricade);}
        			}
        		if (i==5) {
        			if(j==8) { 
                        step[i][j].setIcon(barricade);}
        			}
        		if (i==7) {
        			if(j ==6||j ==10) { 
                        step[i][j].setIcon(barricade);}
        			}
        		if (i==11) {
        			if(j ==0||j ==4||j ==8||j ==12||j ==16) {
        				step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/barricade.png")));}
        			}
        		if (i==14) {
        			if(j ==1||j ==2||j ==3) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/player1.png")));}
        			if(j ==5||j ==6||j ==7) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/player2.png")));}
        			if(j ==9||j ==10||j ==11) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/player3.png")));}
        			if(j ==13||j ==14||j ==15) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/player4.png")));}
        			}
        		if (i==15) {
        			if(j ==1||j ==3) {
            			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/player1.png")));}
            			if(j ==5||j ==7) {
            			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/player2.png")));}
            			if(j ==9||j ==11) {
            			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/player3.png")));}
            			if(j ==13||j ==15) {
            			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/player4.png")));}
        			}
        		}
        	}
        }
		
		
	}

