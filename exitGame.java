import javax.swing.JFrame;
import javax.swing.JOptionPane;

//this class just exits the game

public class exitGame {
	
	public JFrame mainUI;
	
	public exitGame(JFrame frame) {
		
		mainUI = frame;
		int reply = JOptionPane.showConfirmDialog(
				mainUI,
			    "Are you sure you want to exit the game?",
			    "An Insane Question",
			    JOptionPane.YES_NO_OPTION);
	  if (reply == JOptionPane.YES_OPTION)
      {
		  System.exit(0);
      }
		
	}
	
}
