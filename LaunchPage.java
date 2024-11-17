
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LaunchPage extends JFrame implements ActionListener{
	
	String[] comboBoxItems = {"Add Questions","Ask Questions"};
	
	ImageIcon icon;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JPanel panel;
	JButton button1;
	JButton button2;
	LaunchPage(){
		
		label1 = new JLabel();
		label1.setText("WellCome to");
		label1.setForeground(Color.cyan);
		label1.setBounds(0, 20, 200, 100);
		label1.setFont(new Font("Cosolas",Font.BOLD,20));
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.TOP);
		
		label2 = new JLabel();
		label2.setText("Question And Answer");
		label2.setForeground(Color.cyan);
		label2.setBounds(0, 50, 200, 100);
		label2.setFont(new Font("Cosolas",Font.BOLD,15));
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setVerticalAlignment(JLabel.TOP);
		
		label3 = new JLabel();
		label3.setText("Game");
		label3.setForeground(Color.cyan);
		label3.setBounds(0, 80, 200, 100);
		label3.setFont(new Font("Cosolas",Font.BOLD,20));
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setVerticalAlignment(JLabel.TOP);
		
		
		panel = new JPanel();
		panel.setBounds(100, 0, 200, 200);
		panel.setLayout(null);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
	
		button1 = new JButton();
		button1.setText("Add Questions");
		button1.setBounds(0, 0, 100, 50);
		button1.setFocusable(false);
		button1.addActionListener(this);
		
		button2 = new JButton();
		button2.setText("Ask Questions");
		button2.setBounds(0, 50, 100, 50);
		button2.setFocusable(false);
		button2.addActionListener(this);
		
		icon = new ImageIcon("E:\\image\\PNG_Folder\\verified.png");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		this.setLocationRelativeTo(this);
		this.getContentPane().setBackground(new Color(50,50,50));
		this.setTitle("Simple 'Question And Answer' Game");
		this.setIconImage(icon.getImage());
		this.setLayout(null);
		this.setResizable(false);
		
		this.add(button1);
		this.add(button2);
		this.add(panel);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			this.dispose();
			new AddQuestions();
		}
		if(e.getSource()==button2) {
			this.dispose();
			new AskQuestions();
		}
		
	}
}
