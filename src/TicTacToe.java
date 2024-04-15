import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JPanel panel2 = new JPanel();
	JPanel panel1 = new JPanel();
	JButton[] buttons = new JButton[9];
	ImageIcon image = new ImageIcon("B&D.png");
	boolean player1turn;
	
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setIconImage(image.getImage());
		frame.setTitle("B&D - Tic-Tac-Toe Game");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(34,54,123));
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		
		
		label.setBackground(new Color(23,23,23));
		label.setForeground(new Color(50,150,175));
		label.setFont(new Font("MV Boli",Font.BOLD,65));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("Tic-tac-Toe");
		label.setOpaque(true);
		
		panel1.setLayout(new BorderLayout());
		panel1.setBounds(0, 0, 800, 200);
		panel1.add(label);
		
		panel2.setLayout(new GridLayout(3,3));
		panel2.setBackground(new Color(50,75,100));
		
		for(int i=0;i<9;i++) {
			
			buttons[i] = new JButton();
			panel2.add(buttons[i]);
			buttons[i].setFont(new Font("Times New Roman",Font.BOLD,150));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
		}
		
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel2);
		frame.setVisible(true);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1turn ==true) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.RED);
						buttons[i].setText("X");
						player1turn=false;
						label.setText("O Turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.BLUE);
						buttons[i].setText("O");
						player1turn=true;
						label.setText("X Turn");
						check();
					}
				}
				
			}
		}
		
	}
	
	
	public void firstTurn()  {
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			
			player1turn = true;
			label.setText("X Turn");
		}
		else {
			
			player1turn = false;
			label.setText("O Turn");
		}
	}
	
	public void check() {
		//check X
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X") ) {xWin(0,1,2);
			
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X") ) {xWin(3,4,5);
			
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X") ) {xWin(6,7,8);
			
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X") ) {xWin(0,3,6);
			
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X") ) {xWin(1,4,7);
			
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X") ) {xWin(2,5,8);
			
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X") ) {xWin(0,4,8);
			
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X") ) {xWin(2,4,6);
			
		}
		//check O
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O") ) {OWin(0,1,2);
			
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O") ) {OWin(3,4,5);
			
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O") ) {OWin(6,7,8);
			
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O") ) {OWin(0,3,6);
			
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O") ) {OWin(1,4,7);
			
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O") ) {OWin(2,5,8);
			
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O") ) {OWin(0,4,8);
			
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O") ) {OWin(2,4,6);
			
		}
	}
	
	public void xWin(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		label.setText("X WIN");
	}
	
	public void OWin(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		label.setText("O WIN");
		
	}

}
