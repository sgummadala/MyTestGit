package com.cvs.pos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonExample extends JFrame implements  ItemListener, ActionListener  {
	
	int i, j, ii, jj, x, y, yesnull;
	int a[][] = { { 10, 1, 2, 3, 11 }, { 10, 1, 4, 7, 11 }, { 10, 1, 5, 9, 11 }, { 10, 2, 5, 8, 11 },
				{ 10, 3, 5, 7, 11 }, { 10, 3, 6, 9, 11 }, { 10, 4, 5, 6, 11 }, { 10, 7, 8, 9, 11 } };
    int a1[][] = { { 10, 1, 2, 3, 11 }, { 10, 1, 4, 7, 11 }, { 10, 1, 5, 9, 11 }, { 10, 2, 5, 8, 11 },
	             { 10, 3, 5, 7, 11 }, { 10, 3, 6, 9, 11 }, { 10, 4, 5, 6, 11 }, { 10, 7, 8, 9, 11 } };

	boolean state, type, set;

	Icon ic1, ic2, icon, ic11, ic22;
	Checkbox c1, c2;
	JLabel l1, l2;
	JButton b[] = new JButton[9];
	JButton reset = null;
	
	
	public   void showButton() {

		 x = 10;
		 y = 10;
		 j = 0;
		for (i = 0; i <= 8; i++, x += 100, j++) 
		{
			b[i] = new JButton();
			if (j == 3) 
				{
					j = 0;
					y += 100;
					x = 10;
				}
			b[i].setBounds(x, y, 100, 100);
			add(b[i]);
			b[i].addActionListener(this);
		
		} // eof for

		reset = new JButton("RESET");
		reset.setBounds(100, 350, 100, 50);
		add(reset);
		reset.addActionListener(this);

	}// eof showButton
	
	
	public static void main(String[] args) {
		
//		JFrame f = new JFrame("Button Example");
//		JButton br = new JButton("Click Here");
//		br.setBounds(50, 100, 95, 30);
//		f.add(br);
//		f.setSize(400, 400);
//		f.setLayout(null);
//		f.setVisible(true);
		
		
		
		new ButtonExample();
		
		//ButtonExample be = new ButtonExample();
		//be.showButton();
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	//System.out.println("hello");
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		if (c1.getState()) {
			type = false;
		}

		else if (c2.getState()) {
			type = true;
		}
		remove(c1);
		remove(c2);
		repaint(0, 0, 330, 450);
		//System.out.println("C1 State " + c1.getState());
		//System.out.println("C2 State " + c2.getState());
		showButton();
	}// eof itemstate
	
	

	ButtonExample() {
		super(" tic tac toe ");

		CheckboxGroup cbg = new CheckboxGroup();
		c1 = new Checkbox("vs computer", cbg, false);
		c2 = new Checkbox("vs friend", cbg, false);
		c1.setBounds(120, 80, 100, 40);
		c2.setBounds(120, 150, 100, 40);
		add(c1);
		add(c2);
		c1.addItemListener(this);
		c2.addItemListener(this);

		state = true;
		type = true;
		set = true;
		ic1 = new ImageIcon("ic1.jpg");
		ic2 = new ImageIcon("ic2.jpg");
		ic11 = new ImageIcon("ic11.jpg");
		ic22 = new ImageIcon("ic22.jpg");

		setLayout(null);
		setSize(330, 450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}// eof constructor
//
}