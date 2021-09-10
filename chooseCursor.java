import javax.swing.*;
import java.awt.Cursor;

public class chooseCursor
{
    JFrame UI_frame;
    
    public chooseCursor(JFrame main_frame)
    {
    	 UI_frame = main_frame;
    	 String[] options = new String[2];
    	 options[0] = new String("Default Shape");
   	  	 options[1] = new String("Hand Shape");
   	  	 int result = JOptionPane.showOptionDialog(UI_frame,"Change Cursor Shape",
   	  			 "Title", 0,JOptionPane.INFORMATION_MESSAGE,
   	  			 null,options,null);
   	  	 switch (result) {
   	  	 case 0:
   	  		 Cursor mycursor0 =  new Cursor(Cursor.DEFAULT_CURSOR);
   	  		 UI_frame.setCursor(mycursor0);
   	  		 break;
   	  	 case 1:
   	  		 Cursor mycursor1 =  new Cursor(Cursor.HAND_CURSOR);
	  		 UI_frame.setCursor(mycursor1);
   	  		 break;
   	  	 }
    }   
}
