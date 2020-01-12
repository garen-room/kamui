package sinkei;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class start extends JFrame implements ActionListener{
	
	JButton btn1, btn2, btn3;
	JLabel lb1;
	
	sinkei.setsumei setsu = new sinkei.setsumei("神経衰弱");
	sinkei.gamegamen gamen = new sinkei.gamegamen();
	
	
	int sw = 1;
	
	public start(String str){
		
		super(str);
		
		setsu.setVisible(false);
		gamen.setVisible(false);
		JPanel p = new JPanel();
		add(p);
		p.setLayout(null);
		
		lb1 = new JLabel("神経衰弱");
		
		
		lb1.setFont(new Font("MS Gothic", Font.BOLD, 72));
		
		btn1 = new JButton("始める");
		btn2 = new JButton("ゲーム説明");
		btn3 = new JButton("ゲーム終了");
		btn1.setFont(new Font("MS Gothic", Font.BOLD, 40));
		btn2.setFont(new Font("MS Gothic", Font.BOLD, 32));
		btn3.setFont(new Font("MS Gothic", Font.BOLD, 32));
		
		
		
		p.setBounds(0, 0, 1024, 768);
		p.add(lb1);
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);
		lb1.setBounds(350, 100, 500, 200);
		btn1.setBounds(400, 350, 200, 50);
		btn2.setBounds(400, 450, 200, 50);
		btn3.setBounds(400, 550, 200, 50);
		
		setLocation(300,200);
		setPreferredSize(new Dimension(1024,768));
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btn1.addActionListener(this);
		btn3.addActionListener(this);
		btn2.addActionListener(this);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new start("神経衰弱");
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn3) {
			System.exit(0);
		}
		if(sw==1) {
			if(e.getSource()==btn2) {
				setsu.setVisible(true);
				sw=0;
				}
		}
		if(sw==0)
		{
			if(e.getSource()==btn2) {
				setsu.dispose();
				setsu.setVisible(true);
			}
			else if(e.getSource()==setsu.jb1) {
				sw= 1;
			}
		}
		if(e.getSource()==btn1) {
			setVisible(false);
			gamen.setVisible(true);
		}
		
	
   }
}
