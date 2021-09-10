import java.awt.*;
import javax.swing.*;

public class chooseTheme
{
    JFrame fra;
    public chooseTheme(JFrame frame, JPanel panel)
    {
       JPanel subPanel = panel;
       JFrame UIFrame = frame;
       String[] options = new String[2];
  	   options[0] = new String("Light Mode");
 	   options[1] = new String("Dark Mode");
 	   int result = JOptionPane.showOptionDialog(UIFrame,"Change Theme",
 	  			 "Title", 0,JOptionPane.INFORMATION_MESSAGE,
 	  			 null,options,null);
 	  	 switch (result) {
 	  	 case 0:
 	  		 subPanel.setBackground(Color.WHITE);
 	  		 break;
 	  	 case 1:
 	  		subPanel.setBackground(Color.PINK); 
 	  		 break;
 	  	 } 
    }  
}
