import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class movePawn implements ActionListener {

	public int row = 16;
	public int col = 17;
	public JFrame UIframe;
	public JPanel backPanel;
	public JButton[][] step;
	public JButton rollDice;
	public int diceValue, playerTurn;
	public JLabel valueLabel, turnOrder;
	public ImageIcon emptySpace = new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png"));
	public ImageIcon barricade = new ImageIcon(displayBoard.class.getResource("/images/barricade.png"));
	public ImageIcon endgoal = new ImageIcon(displayBoard.class.getResource("/images/endgoal.png"));
	public ImageIcon player1 = new ImageIcon(displayBoard.class.getResource("/images/player1.png"));
	public ImageIcon player2 = new ImageIcon(displayBoard.class.getResource("/images/player2.png"));
	public ImageIcon player3 = new ImageIcon(displayBoard.class.getResource("/images/player3.png"));
	public ImageIcon player4 = new ImageIcon(displayBoard.class.getResource("/images/player4.png"));
	public int flag;
	public int x1, x2;
	public int y1, y2;

	public String player1Des, player2Des, player3Des, player4Des; // to store the player descriptions (basically the
																	// path)

	public String emptySpaceDes, barricadeDes, endgoalDes; // to store the other object description

	/*
	 * the background useless(was necessary for the implementation) buttons are null
	 * if you wanna check something else, keep those useless stuffs in mind. wasted
	 * our precious time!! thanks Aman for figuring it out!!!
	 */

	public ImageIcon sample;
	// public String temp; // temporary string variable to hold the file path for
	// the current step[][] object
	// in the loop
	
	
	public ArrayList<JButton> legal = new ArrayList<>();

	public movePawn(JFrame frame, JButton[][] buttons, JButton rolldice, int dicevalue, int playerturn,
			JLabel valuelabel, JLabel turnorder, JPanel jpanel) {
		UIframe = frame;
		backPanel = jpanel;
		step = buttons;
		rollDice = rolldice;
		diceValue = dicevalue;
		playerTurn = playerturn;
		valueLabel = valuelabel;
		turnOrder = turnorder;
		
		player1Des = player1.getDescription();
		player2Des = player2.getDescription();
		player3Des = player3.getDescription();
		player4Des = player4.getDescription();
		emptySpaceDes = emptySpace.getDescription();
		barricadeDes = barricade.getDescription();
		endgoalDes = endgoal.getDescription();

		// adding action listener to all the buttons
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// FYSAL todo: only add listener to useful buttons

				sample = (ImageIcon) step[i][j].getIcon();
				if (sample != null) // this is the most important part. it checks for the white/useless spaces which
									// are basically null objects
				{
					step[i][j].addActionListener(this); // adding action listener to only useful buttons

					step[i][j].setEnabled(false); // disable all the buttons, later enable for each player

					// fysal todo: restrict the other players here
					String temp = sample.getDescription();

					// to enable player1 pawns
					if (playerTurn == 1) {
						if (temp.equals(player1Des)) {
							step[i][j].setEnabled(true);
						}
					}
					// to enable player2 pawns
					if (playerTurn == 2) {
						if (temp.equals(player2Des)) {
							step[i][j].setEnabled(true);
						}
					}
					// to enable player3 pawns
					if (playerTurn == 3) {
						if (temp.equals(player3Des)) {
							step[i][j].setEnabled(true);
						}
					}
					// to enable player4 pawns
					if (playerTurn == 4) {
						if (temp.equals(player4Des)) {
							step[i][j].setEnabled(true);
						}
					}
				}
			}
		}
	}
	
	//checking if the pawn this algo will move is in the starting position or not
	public void preMove(int x, int y, int rolled) {
		if (x > 13) {
			sample = (ImageIcon) step[x][y].getIcon();
			String temp = sample.getDescription();
			
			if (temp.equals(player1Des)) {
				legalmove(13, 2, rolled-1, 13, 2);
			}
			
			if (temp.equals(player2Des)) {
				legalmove(13, 6, rolled-1, 13, 6);
			}
			
			if (temp.equals(player3Des)) {
				legalmove(13, 10, rolled-1, 13, 10);
			}

			if (temp.equals(player4Des)) {
				legalmove(13, 14, rolled-1, 13, 14);
			}
		}
		else {
			legalmove(x,y,rolled,x,y);
		}
	}
	
	//please dont mess anything here took me a long time. if you need to change anything tell me first. -Fysal
	public void legalmove(int x, int y, int rolled, int x3, int y3) {
		
		if ((x > -1 && x < (row-2)) && (y > -1 && y < col)) {
			
			if ((step[x][y] != null) && (rolled == 0)) { 
				legal.add(step[x][y]); 
				return;
			}
			else {
				
				if (((x > -1 && x < (row-2)) && (y+1 > -1 && y+1 < col)) && ((ImageIcon) step[x][y+1].getIcon() != null) && (step[x][y+1] != step[x3][y3])) {
					sample = (ImageIcon) step[x][y+1].getIcon();
					String temp = sample.getDescription();
					if (!temp.equals(barricadeDes)) {
						legalmove(x, y+1, rolled - 1, x, y);
					}
					else if (temp.equals(barricadeDes) && (rolled-1 == 0)) {
						legalmove(x, y+1, rolled - 1, x, y);
					}
				}
				
				if (((x > -1 && x < (row-2)) && (y-1 > -1 && y-1 < col)) && ((ImageIcon) step[x][y-1].getIcon() != null) && (step[x][y-1] != step[x3][y3])) {
					sample = (ImageIcon) step[x][y-1].getIcon();
					String temp = sample.getDescription();
					if (!temp.equals(barricadeDes)) {
						legalmove(x, y-1, rolled - 1, x, y); 
					}
					else if (temp.equals(barricadeDes) && (rolled-1 == 0)) {
						legalmove(x, y-1, rolled - 1, x, y);
					}
				}
				
				if (((x+1 > -1 && x+1 < (row-2)) && (y > -1 && y < col)) && ((ImageIcon) step[x+1][y].getIcon() != null) && (step[x+1][y] != step[x3][y3])) {
					sample = (ImageIcon) step[x+1][y].getIcon();
					String temp = sample.getDescription();
					if (!temp.equals(barricadeDes)) {
						legalmove(x+1, y, rolled - 1, x, y);
					}
					else if (temp.equals(barricadeDes) && (rolled-1 == 0)) {
						legalmove(x+1, y, rolled - 1, x, y);
					}
				}
				
				if (((x-1 > -1 && x-1 < (row-2)) && (y > -1 && y < col)) && ((ImageIcon) step[x-1][y].getIcon() != null) && (step[x-1][y] != step[x3][y3])) {
					sample = (ImageIcon) step[x-1][y].getIcon();
					String temp = sample.getDescription();
					if (!temp.equals(barricadeDes)) {
						legalmove(x-1, y, rolled - 1, x, y);
					}
					else if (temp.equals(barricadeDes) && (rolled-1 == 0)) {
						legalmove(x-1, y, rolled - 1, x, y);
					} 
				}
				
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object selected = e.getSource();

		flag++;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sample = (ImageIcon) step[i][j].getIcon();
				if (sample != null) // this is the most important part. it checks for the white/useless spaces which
									// are basically null objects
				{
					//System.out.println(sample);
					if (selected.equals(step[i][j])) {

						if (flag == 1) {
							x1 = i;
							y1 = j;
							// System.out.println("i'm here!");
							// fysal todo: restrict the other players here
							
							//^^here^^ eykhane ashbe
							//rollDice.setEnabled(false);
							preMove(x1, y1, diceValue);
							int numberofmoves = legal.size();
							
							//aman take a look here
							if (numberofmoves == 0) {
								JOptionPane.showMessageDialog(UIframe, "No possible move for this Pawn. Next player will take turn.",
										"Action Required", JOptionPane.WARNING_MESSAGE);
								for (int x = 0; x < row; x++) {
									for (int y = 0; y < col; y++) {
										sample = (ImageIcon) step[x][y].getIcon();
										if (sample != null) {
											step[x][y].setEnabled(true);
										}
									}
								}
								int xx = playerTurn;
								if(xx == 4) {
									xx = 0;
								}
								valueLabel.setText("Dice Value: -  ");
								turnOrder.setText("Turn: Player "+(xx+1));
								rollDice.setEnabled(true);
								flag = 999;
							}
							
							for (int x = 0; x < row; x++) {
								for (int y = 0; y < col; y++) {
									step[x][y].setEnabled(false);
								}
							}
							
							for(int c = 0; c < numberofmoves; c++) {
								JButton legalbutton = (JButton) legal.get(c);
								legalbutton.setEnabled(true);
							}
							
						}

						else if (flag == 2) {
							x2 = i;
							y2 = j;

							/*
							 * if x1,y1 is a barricade we have to move it to a legal move if x1,y1 is
							 * another pawn we have to move it to it's players starting position
							 */
							String temp = sample.getDescription();
							if (temp.equals(emptySpaceDes)) {
								if (playerTurn == 1) {
									step[x2][y2].setIcon(player1);
									step[x1][y1].setIcon(emptySpace);
								} else if (playerTurn == 2) {
									step[x2][y2].setIcon(player2);
									step[x1][y1].setIcon(emptySpace);
								} else if (playerTurn == 3) {
									step[x2][y2].setIcon(player3);
									step[x1][y1].setIcon(emptySpace);
								} else if (playerTurn == 4) {
									step[x2][y2].setIcon(player4);
									step[x1][y1].setIcon(emptySpace);
								}
								for (int x = 0; x < row; x++) {
									for (int y = 0; y < col; y++) {
										sample = (ImageIcon) step[x][y].getIcon();
										if (sample != null) {
											step[x][y].setEnabled(true);
										}
									}
								}
								
								int xx = playerTurn;
								if(xx == 4) {
									xx = 0;
								}
								valueLabel.setText("Dice Value: -  ");
								turnOrder.setText("Turn: Player "+(xx+1));
								rollDice.setEnabled(true);
								
							} else { // capturing pawn and barricade

								if (temp.equals(barricadeDes)) { // moving barricade

									if (playerTurn == 1) {
										step[x2][y2].setIcon(player1);
										step[x1][y1].setIcon(emptySpace);
									} else if (playerTurn == 2) {
										step[x2][y2].setIcon(player2);
										step[x1][y1].setIcon(emptySpace);
									} else if (playerTurn == 3) {
										step[x2][y2].setIcon(player3);
										step[x1][y1].setIcon(emptySpace);
									} else if (playerTurn == 4) {
										step[x2][y2].setIcon(player4);
										step[x1][y1].setIcon(emptySpace);
									}

									JOptionPane.showMessageDialog(UIframe, "Move Barricade to a different location.",
											"Action Required", JOptionPane.WARNING_MESSAGE);

									for (int x = 0; x < row; x++) {
										for (int y = 0; y < col; y++) {
											sample = (ImageIcon) step[x][y].getIcon();

											// to enable the legal moves for barricade
											if (sample != null) {
												String check = sample.getDescription();
												if (x < (row - 3)) {
													if (check.equals(emptySpaceDes)) {
														step[x][y].setEnabled(true);
														//here "eykhane ashbe"
													}

													else {
														step[x][y].setEnabled(false);
													}
												} else {
													step[x][y].setEnabled(false);
												}
											}
										}
									}
									flag = 776;
									
									int xx = playerTurn;
									if(xx == 4) {
										xx = 0;
									}
									valueLabel.setText("Dice Value: -  ");
									turnOrder.setText("Turn: Player "+(xx+1));
									
									
								}

								else { // capturing pawn and endgoal
									sample = (ImageIcon) step[x2][y2].getIcon();
									String capturedPawn = sample.getDescription();
									if (capturedPawn.equals(((ImageIcon) step[x1][y1].getIcon()).getDescription())) {
										JOptionPane.showMessageDialog(UIframe, "You can not capture your own pawn. Next player will take turn",
												"Alert", JOptionPane.WARNING_MESSAGE);
										for (int x = 0; x < row; x++) {
											for (int y = 0; y < col; y++) {
												sample = (ImageIcon) step[x][y].getIcon();
												if (sample != null) {
													step[x][y].setEnabled(true);
												}
											}
										}
										int xx = playerTurn;
										if(xx == 4) {
											xx = 0;
										}
										valueLabel.setText("Dice Value: -  ");
										turnOrder.setText("Turn: Player "+(xx+1));
										rollDice.setEnabled(true);
										flag = 999;
										return;
									}
									if ((playerTurn<5) && (playerTurn>0)) {
										if (playerTurn == 1) {
											step[x2][y2].setIcon(player1);
											step[x1][y1].setIcon(emptySpace);
										} else if (playerTurn == 2) {
											step[x2][y2].setIcon(player2);
											step[x1][y1].setIcon(emptySpace);
										} else if (playerTurn == 3) {
											step[x2][y2].setIcon(player3);
											step[x1][y1].setIcon(emptySpace);
										} else if (playerTurn == 4) {
											step[x2][y2].setIcon(player4);
											step[x1][y1].setIcon(emptySpace);
										}
									}
									
									
									if (capturedPawn.equals(player1Des)) {
										outerloop:
										for (int x = 14; x < 16; x++) {
											for (int y = 0; y < col; y++) {
												if (((x==14) && (y==1||y==2||y==3))||((x==15) && (y==1||y==3))) {
													ImageIcon startingPosition = (ImageIcon) step[x][y].getIcon();
													String startPosition = startingPosition.getDescription();
													if(!capturedPawn.equals(startPosition)) {
														step[x][y].setIcon(sample);
														break outerloop;
													}
												}
											}
										}
										JOptionPane.showMessageDialog(UIframe, "Captured Pawn was sent back to the starting position.",
												"No Action Required", JOptionPane.WARNING_MESSAGE);
										
									} else if(capturedPawn.equals(player2Des)) {
										outerloop:
											for (int x = 14; x < 16; x++) {
												for (int y = 0; y < col; y++) {
													if (((x==14) && (y==5||y==6||y==7))||((x==15) && (y==5||y==7))) {
														ImageIcon startingPosition = (ImageIcon) step[x][y].getIcon();
														String startPosition = startingPosition.getDescription();
														if(!capturedPawn.equals(startPosition)) {
															step[x][y].setIcon(sample);
															break outerloop;
														}
													}
												}
											}
										JOptionPane.showMessageDialog(UIframe, "Captured Pawn was sent back to the starting position.",
												"No Action Required", JOptionPane.WARNING_MESSAGE);
										
									} else if(capturedPawn.equals(player3Des)) {
										outerloop:
											for (int x = 14; x < 16; x++) {
												for (int y = 0; y < col; y++) {
													if (((x==14) && (y==9||y==10||y==11))||((x==15) && (y==9||y==11))) {
														ImageIcon startingPosition = (ImageIcon) step[x][y].getIcon();
														String startPosition = startingPosition.getDescription();
														if(!capturedPawn.equals(startPosition)) {
															step[x][y].setIcon(sample);
															break outerloop;
														}
													}
												}
											}
										JOptionPane.showMessageDialog(UIframe, "Captured Pawn was sent back to the starting position.",
												"No Action Required", JOptionPane.WARNING_MESSAGE);
										
									} else if(capturedPawn.equals(player4Des)) {
										outerloop:
											for (int x = 14; x < 16; x++) {
												for (int y = 0; y < col; y++) {
													if (((x==14) && (y==13||y==14||y==15))||((x==15) && (y==13||y==15))) {
														ImageIcon startingPosition = (ImageIcon) step[x][y].getIcon();
														String startPosition = startingPosition.getDescription();
														if(!capturedPawn.equals(startPosition)) {
															step[x][y].setIcon(sample);
															break outerloop;
														}
													}
												}
											}
										JOptionPane.showMessageDialog(UIframe, "Captured Pawn was sent back to the starting position.",
												"No Action Required", JOptionPane.WARNING_MESSAGE);
										
									} else if(capturedPawn.equals(endgoalDes)) {
										if (playerTurn == 1) {
											JOptionPane.showMessageDialog(UIframe, "Player 1 Wins!",
													"Congratulations!", JOptionPane.WARNING_MESSAGE);
											new mainUI(UIframe, backPanel);
										} else if (playerTurn == 2) {
											JOptionPane.showMessageDialog(UIframe, "Player 2 Wins!",
													"Congratulations!", JOptionPane.WARNING_MESSAGE);
											new mainUI(UIframe, backPanel);
										} else if (playerTurn == 3) {
											JOptionPane.showMessageDialog(UIframe, "Player 3 Wins!",
													"Congratulations!", JOptionPane.WARNING_MESSAGE);
											new mainUI(UIframe, backPanel);
										} else if (playerTurn == 4) {
											JOptionPane.showMessageDialog(UIframe, "Player 4 Wins!",
													"Congratulations!", JOptionPane.WARNING_MESSAGE);
											new mainUI(UIframe, backPanel);
										}
									}
									for (int x = 0; x < row; x++) {
										for (int y = 0; y < col; y++) {
											sample = (ImageIcon) step[x][y].getIcon();
											if (sample != null) {
												step[x][y].setEnabled(true);
											}
										}
									}
									
									int xx = playerTurn;
									if(xx == 4) {
										xx = 0;
									}
									valueLabel.setText("Dice Value: -  ");
									turnOrder.setText("Turn: Player "+(xx+1));
									rollDice.setEnabled(true);
									
								}
								
							//end of capturing pawn and barricade
							}
							
							//end of flag 2
						} else if (flag == 777) {	//don't change 777, ask fysal for any questions
							int x3 = i;
							int y3 = j;
							
							String temp = sample.getDescription();
							if (temp.equals(emptySpaceDes)) {
								step[x3][y3].setIcon(barricade);
								for (int x = 0; x < row; x++) {
									for (int y = 0; y < col; y++) {
										sample = (ImageIcon) step[x][y].getIcon();
										if (sample != null) {
											step[x][y].setEnabled(true);
										}
									}
								}
							}
							
							int xx = playerTurn;
							if(xx == 4) {
								xx = 1;
							}
							valueLabel.setText("Dice Value: -  ");
							turnOrder.setText("Turn: Player "+(xx+1));
							rollDice.setEnabled(true);
						}
						
						
						
					}
				}
			}
		}
	}
}
