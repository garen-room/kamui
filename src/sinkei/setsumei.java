package sinkei;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class setsumei extends JFrame implements ActionListener {
	
	JButton jb1 = new JButton("閉じる");
	
	public setsumei(String str) {
	
		
		super(str);
		
		ImageIcon ic = new ImageIcon("./images/setsumei.png");
		JLabel lb1 = new JLabel(ic);
		
		JPanel p = new JPanel();
		
		add(p);
		p.setLayout(null);
		
		
		p.add(lb1);
		p.add(jb1);
		
		lb1.setBounds(10, 10, 738, 375);
		jb1.setBounds(280, 430, 200, 50);
		
		setLocation(300,200);
		setPreferredSize(new Dimension(780,568));
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jb1.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new setsumei("神経衰弱");
		
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1) {
			dispose();
		}
	}

	}
