package sinkei;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

class Cardcheck {
	String keiro;
}

public class gamegamen extends JFrame implements ActionListener {

	ImageIcon[] Cardimage = new ImageIcon[20];
	JButton[] Cardlist = new JButton[Imagelist.length * 2];
	JLabel[] Charlist = new JLabel[2];
	ImageIcon Backimage;
	JLabel Score = new JLabel("0");
	static String[] Imagelist = { "./images/koishi.png", "./images/nue.png", "./images/rumia.png",
			"./images/suwako.png", "./images/yuyuko.png", "./images/nitori.png", "./images/momiji.png",
			"./images/sakuya.png", "./images/inaba.png", "./images/crownpeace.png" };
	String[] confirm = new String[2];
	static Cardcheck[] check = new Cardcheck[20];
	JButton[] Backlist = new JButton[Cardimage.length * 2];
	int intcheck;

	public gamegamen() {

		JPanel p = new JPanel();

		add(p);

		Charlist[0] = new JLabel(new ImageIcon("./images/remilia.png"));
		Charlist[1] = new JLabel(new ImageIcon("./images/flandre.png"));
		Backimage = new ImageIcon("./images/onmyo.png");

		for (int j = 0; j < Imagelist.length; j++) {
			check[j] = new Cardcheck();
			check[j + Imagelist.length] = new Cardcheck();

			Cardimage[j] = new ImageIcon(Imagelist[j]);
			Cardlist[j] = new JButton(Backimage);

			check[j].keiro = Imagelist[j];
			Cardlist[j + Imagelist.length] = new JButton(Backimage);
			check[j + Imagelist.length].keiro = Imagelist[j];

		}

		Cardlist = shuffle(Cardlist);

		p.setBounds(0, 0, 1024, 768);
		p.setLayout(null);

		p.add(Charlist[0]);
		p.add(Charlist[1]);
		p.add(Score);

		for (int i = 0; i < Cardlist.length; i++) {
			p.add(Cardlist[i]);

		}

		//Charlist[0].setBounds(50, 200, 128, 198);
		//Charlist[1].setBounds(830, 200, 128, 198);
		Score.setFont(new Font("바탕", Font.BOLD, 30));
		Score.setBounds(480, 20, 100, 50);

		for (int k = 0; k < Cardlist.length; k++) {
			Cardlist[k].setBounds(100 + (k % 5 * 180), 100 + (k / 5 * 160), 84, 108);
		}

		for (int l = 0; l < Cardlist.length; l++) {
			Cardlist[l].addActionListener(this);
		}

		setTitle("神経衰弱");
		setLocation(300, 200);
		setPreferredSize(new Dimension(1024, 768));
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new gamegamen();

	}

	public static JButton[] shuffle(JButton[] arr) {
		for (int x = 0; x < arr.length; x++) {
			int i = (int) (Math.random() * arr.length);
			System.out.println("i =" + i);
			int j = (int) (Math.random() * arr.length);
			System.out.println("j =" + j);

			JButton tmp = arr[i];
			String tmp2 = check[i].keiro;
			System.out.println("tmp = " + tmp);
			arr[i] = arr[j];
			check[i].keiro = check[j].keiro;
			System.out.println("arr[ " + j + "] = " + arr[j]);
			arr[j] = tmp;
			check[j].keiro = tmp2;
			System.out.println("arr[ " + j + "] = " + arr[j]);
		}
		return arr;
	}

	public void mConfirm(int i) {
		
		int temp = Integer.valueOf(Score.getText());
		if (confirm[0] == null) {
			confirm[0] = check[i].keiro;
			Cardimage[i] = new ImageIcon(check[i].keiro);
			Cardlist[i].setIcon(Cardimage[i]);
			System.out.println(confirm[0]);
			intcheck = i;
		} else if (confirm[1] == null) {
			confirm[1] = check[i].keiro;
			Cardimage[i] = new ImageIcon(check[i].keiro);
			Cardlist[i].setIcon(Cardimage[i]);
			System.out.println(confirm[1]);
			if (confirm[0].equals(confirm[1])) {
				
				temp = temp+100;
				Score.setText(temp+"");
				Cardlist[intcheck].setEnabled(false);
				Cardlist[i].setEnabled(false);
				System.out.println("같은그림");
				System.out.println("깃허브");
				
				confirm[0] = confirm[1] = null;
					}
			 else {
					 	Cardlist[i].setIcon(Cardimage[i]);
					 	System.out.println(Cardlist[i]);
						confirm[0] = confirm[1] = null;
						//Cardlist[intcheck].setIcon(Backimage);
						//Cardlist[i].setIcon(Backimage);
						System.out.println(confirm[0]);
						System.out.println(confirm[1]);					 
				
				}
			
				}
		
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i =0; i<Cardlist.length; i++) {
			if(e.getSource() == Cardlist[i]) {
				mConfirm(i);
			}
		}

	}

}
