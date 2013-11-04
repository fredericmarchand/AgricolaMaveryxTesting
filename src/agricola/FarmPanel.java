package agricola;
//Author: Robert Souter 100802267
//Supervisor: Jean-Pierre Corriveau Ph.D.
//Carleton University
//School of Computer Science
//COMP 4905
//Winter 2013

import javax.swing.*;
import java.awt.*; 

@SuppressWarnings("serial")
public class FarmPanel extends JPanel {
	
	private JButton[][] b;
	private Farm s;
	
	public FarmPanel(Farm stadium){
		s=stadium;
		setLayout(new GridBagLayout());
		setSize(800,600);
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.black));
		b=new JButton[7][11];
		GridBagConstraints c = new GridBagConstraints();
		for (int r=0;r<7;r++){
			for (int col=0;col<11;col++){
				if (s.getFarm()[r][col].isSquare()){
					c = new GridBagConstraints();
					b[r][col]=new JButton();
					if ((col==1&&r==3)||(col==1&&r==5))
						b[r][col].setBackground(new Color(139,69,19));
					else
						b[r][col].setBackground(Color.white);
					c.gridx=col;
					c.gridy=r;
					c.ipadx=50;
					c.ipady=90;
					c.gridwidth=1;
					c.gridheight=1;
					add(b[r][col], c);
				}
				else {
					if (r%2==0&&col%2==0){
					
						c = new GridBagConstraints();
						b[r][col]=new JButton();
						b[r][col].setBackground(Color.white);
						c.gridx=col;
						c.gridy=r;
						c.gridwidth=1;
						c.gridheight=1;
						add(b[r][col], c);
					}
					else{
						c = new GridBagConstraints();
						b[r][col]=new JButton();
						b[r][col].setBackground(Color.cyan);
						c.gridx=col;
						c.gridy=r;
						if (col%2==1)
							c.ipadx=50;
						else
							c.ipady=90;
						c.gridwidth=1;
						c.gridheight=1;
						add(b[r][col], c);
					}
				}	
			}
		}
		
		
	/*	GridBagConstraints c = new GridBagConstraints();
		b[0][0]=new JButton();
		b[0][0].setBackground(Color.white);
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=1;
		add(b[0][0], c);
		
		c = new GridBagConstraints();
		b[1][0]=new JButton();
		b[1][0].setBackground(Color.cyan);
		c.gridx=1;
		c.gridy=0;
		c.ipadx=20;
		c.gridwidth=1;
		c.gridheight=1;
		add(b[1][0], c);
		
		c = new GridBagConstraints();
		b[2][0]=new JButton();
		b[2][0].setBackground(Color.white);
		c.gridx=3;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=1;
		add(b[2][0], c);*/
		
		/*for (int r=0;r<7;r++){
			for (int col=0;col<11;col++){
				if (s.getSeat()[r][col].isSquare()){
					b[r][col]=new JButton();
					b[r][col].setBackground(Color.green);
					add(b[r][col]);
				}
				else {
					b[r][col]=new JButton();
					if (r%2==0&&col%2==0)
						b[r][col].setBackground(Color.white);
					else
						b[r][col].setBackground(Color.cyan);
					add(b[r][col]);
				}*/
			/*	if (s.getSeat()[r][col].getSection()=='3'){
					b[r][col]=new JButton();
					b[r][col].setBackground(Color.blue);
					add(b[r][col]);
				}
				if (s.getSeat()[r][col].getSection()=='4'){
					b[r][col]=new JButton();
					b[r][col].setBackground(Color.yellow);
					add(b[r][col]);
				}
					
				if ((s.getSeat()[r][col].getSection()==' ')||(s.getSeat()[r][col].getSection()=='-')||(s.getSeat()[r][col].getSection()=='|')){
					b[r][col]=new JButton();
					b[r][col].setBackground(Color.white);
					b[r][col].setBorder(BorderFactory.createEmptyBorder());
					b[r][col].setEnabled(false);
					add(b[r][col]);
				}*/
					
				
	//		}
	//	}
		
		
		
	}

public JButton[][] getButtons(){
	return b;
}

public Space[][] getFarm(){
	return s.getFarm();
}

public static void main(String args[]) {
	JFrame f = new JFrame("Stadium Panel Test");
	f.getContentPane().add(new FarmPanel(new Farm()));
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setSize(656, 450);
	f.setVisible(true);
}

    
}