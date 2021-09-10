import javax.swing.*;


public class setBoard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JPanel boardPanel;
	public JButton[][] step;
	public Icon emptySpace = new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png"));

	public setBoard(JPanel panel, JButton[][] button) {
		
		int row = 16;
        int col = 17;
		boardPanel = panel;
		step = button;
		
		for (int i = 0; i < row; i++){
        	for (int j = 0; j < col; j++){
        		if (i==0) {
        			if(j==8) { 
                    step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==1) {
        			if(j ==0||j ==1||j ==2||j ==3||j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12||
        					j ==13||j ==14||j ==15||j ==16) {
                    step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==2) {
        			if(j ==0||j ==16) {
                    step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==3) {
        			if(j ==0||j ==1||j ==2||j ==3||j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12||
        					j ==13||j ==14||j ==15||j ==16) {
                    step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==4) {
        			if(j ==8) {
        		    step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==5) {
        			if(j ==6||j ==7||j ==8||j ==9||j ==10) {
        			step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==6) {
        			if(j ==6||j ==10) {
        			step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==7) {
        			if(j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12) {
        			step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==8) {
        			if(j ==4||j ==12) {
        			step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==9) {
        			if(j ==2||j ==3||j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12||
        					j ==13||j ==14) {
        			step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==10) {
        			if(j ==2|j ==6|j ==10|j ==14) {
        			step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==11) {
        			if(j ==0||j ==1||j ==2||j ==3||j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12||
        					j ==13||j ==14||j ==15||j ==16) {
        			step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==12) {
        			if(j ==0|j ==4|j ==8|j ==12||j ==16) {
        			step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==13) {
        			if(j ==0||j ==1||j ==2||j ==3||j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12||
        					j ==13||j ==14||j ==15||j ==16) {
        			step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==14) {
        			if(j ==1||j ==2||j ==3||j ==5||j ==6||j ==7||j ==9||j ==10||j ==11||
        					j ==13||j ==14||j ==15) {
        			step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==15) {
        			if(j ==1||j ==3||j ==5||j ==7||j ==9||j ==11||
        					j ==13||j ==15) {
        			step[i][j].setIcon(emptySpace);
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        	}
        }
		
		
	}
		

}
