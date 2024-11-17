import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AskQuestions extends JFrame implements ActionListener{
	
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JTextField textField;
	JRadioButton choiseA;
	JRadioButton choiseB;
	JRadioButton choiseC;
	JRadioButton choiseD;
	ImageIcon icon;
	FileReader reader;

	String str = "";
	String str1 = "";
	String str2 = "";
	String str3 = "";
	String str4 = "";
	char str5;
	
	String[][] choices = new String[100][4];
	String[] questions = new String[100];
	char[] correctAnswers = new char[100];
	String[] guessAnswers = new String[100];
	
	int questionCode, ch, k = 0, i = 1, l =0;
	
	AskQuestions(){
		
		label1 = new JLabel();
		label1.setBounds(50, 0, 450, 40);
		label1.setText("Question #"+i);
		label1.setForeground(Color.cyan);
		label1.setFont(new Font("Cosolas",Font.BOLD,30));
		label1.setVisible(false);
		
		label2 = new JLabel();
		label2.setBounds(0, 50, 800, 60);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Cosolas",Font.BOLD,30));
		label2.setVisible(false);
		
		label3 = new JLabel();
		label3.setBounds(0, 350, 800, 40);
		label3.setForeground(Color.magenta);
		label3.setFont(new Font("Cosolas",Font.BOLD,30));
		label3.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(80, 100, 240, 30);
		textField.setText("Enter Question Code");
		textField.setForeground(Color.cyan);
		textField.setFont(new Font("Cosolas",Font.BOLD,20));
		textField.setBackground(Color.gray);
		
		choiseA = new JRadioButton();
		choiseA.setForeground(Color.white);
		choiseA.setFont(new Font("Consolas", Font.BOLD,20));
		choiseA.setBackground(new Color(50,50,50));
		choiseA.setBounds(20, 120, 800, 20);
		choiseA.setFocusable(false);
		choiseA.setVisible(false);
		
		choiseB = new JRadioButton();
		choiseB.setForeground(Color.white);
		choiseB.setFont(new Font("Consolas", Font.BOLD,20));
		choiseB.setBackground(new Color(50,50,50));
		choiseB.setBounds(20, 160, 800, 20);
		choiseB.setFocusable(false);
		choiseB.setVisible(false);
		
		choiseC = new JRadioButton();
		choiseC.setForeground(Color.white);
		choiseC.setFont(new Font("Consolas", Font.BOLD,20));
		choiseC.setBackground(new Color(50,50,50));
		choiseC.setBounds(20, 200, 800, 20);
		choiseC.setFocusable(false);
		choiseC.setVisible(false);
		
		choiseD = new JRadioButton();
		choiseD.setForeground(Color.white);
		choiseD.setFont(new Font("Consolas", Font.BOLD,20));
		choiseD.setBackground(new Color(50,50,50));
		choiseD.setBounds(20, 240, 800, 20);
		choiseD.setFocusable(false);
		choiseD.setVisible(false);
		
		ButtonGroup group = new ButtonGroup();
		group.add(choiseA);
		group.add(choiseB);
		group.add(choiseC);
		group.add(choiseD);
		
		button1 = new JButton();
		button1.setBounds(30, 290, 100, 40);
		button1.setText("Previous");
		button1.setForeground(Color.cyan);
		button1.setFont(new Font("Cosolas",Font.BOLD,20));
		button1.setFocusable(false);
		button1.addActionListener(this);
		button1.setVisible(false);
		
		button2 = new JButton();
		button2.setBounds(160, 290, 100, 40);
		button2.setText("Next");
		button2.setForeground(Color.cyan);
		button2.setFont(new Font("Cosolas",Font.BOLD,20));
		button2.setFocusable(false);
		button2.addActionListener(this);
		button2.setVisible(false);
		
		button3 = new JButton();
		button3.setBounds(500, 5, 170, 40);
		button3.setText("Show Result");
		button3.setForeground(Color.cyan);
		button3.setFont(new Font("Cosolas",Font.BOLD,20));
		button3.setFocusable(false);
		button3.addActionListener(this);
		button3.setVisible(false);
		
		button4 = new JButton();
		button4.setBounds(330, 100, 65, 30);
		button4.setFocusable(false);
		button4.setText("Ok");
		button4.setForeground(Color.cyan);
		button4.setFont(new Font("Cosolas",Font.BOLD,20));
		button4.addActionListener(this);
		
		icon = new ImageIcon("E:\\image\\PNG_Folder\\verified.png");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);
		this.getContentPane().setBackground(new Color(50,50,50));
		this.setTitle("Simple 'Question And Answer' Game");
		this.setIconImage(icon.getImage());
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(textField);
		this.add(choiseA);
		this.add(choiseB);
		this.add(choiseC);
		this.add(choiseD);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			if(l>=1&&i>1) {
				i--;
				l--;
				label1.setText("Question #"+i);
				label2.setText(questions[l]);
				choiseA.setText(choices[l][0]);
				choiseB.setText(choices[l][1]);
				choiseC.setText(choices[l][2]);
				choiseD.setText(choices[l][3]);
			}
		}
		if(e.getSource()==button2) {
			try {
				if(l>=0&&i<=100) {
					i++;
					l++;
					label1.setText("Question #"+i);
					label2.setText(questions[l]);
					choiseA.setText(choices[l][0]);
					choiseB.setText(choices[l][1]);
					choiseC.setText(choices[l][2]);
					choiseD.setText(choices[l][3]);
				}
			}
			catch(ArrayIndexOutOfBoundsException e1) {
				label3.setText("Error: You Are Finished All Questions!!!");
			}
		}
		if(choiseA.isSelected()) {
			guessAnswers[l-1] = "A";
		}
		if(choiseB.isSelected()) {
			guessAnswers[l-1] = "B";
		}
		if(choiseC.isSelected()) {
			guessAnswers[l-1] = "C";
		}
		if(choiseD.isSelected()) {
			guessAnswers[l-1] = "D";
		}
		if(e.getSource()==button3) {
			new ResultWindow(correctAnswers,guessAnswers);
		}
		if(e.getSource()==button4) {
			questionCode = Integer.parseInt(textField.getText());
			try {
				if(questionCode==1) {
					reader = new FileReader("question_1");
				}
				if(questionCode==2) {
					reader = new FileReader("question_2");
				}
				if(questionCode==3) {
					reader = new FileReader("question_3");
				}
				if(questionCode==4) {
					reader = new FileReader("question_4");
				}
				while((ch =reader.read()) != -1) {
					str = str+(char)ch;
					while((char)(ch=reader.read())!='\n') {
						str = str+(char)ch;
					}
					while((char)(ch=reader.read())!='\n') {
						str1 = str1+(char)ch;	
					}
					while((char)(ch=reader.read())!='\n') {
						str2 = str2+(char)ch;	
					}
					while((char)(ch=reader.read())!='\n') {
						str3 = str3+(char)ch;	
					}
					while((char)(ch=reader.read())!='\n') {
						str4 = str4+(char)ch;	
					}
					while((char)(ch=reader.read())!='\n') {
						str5 = (char)ch;	
					}
					questions[k] = str;
					choices[k][0] = str1;
					choices[k][1] = str2;
					choices[k][2] = str3;
					choices[k][3] = str4;
					correctAnswers[k] = str5;
					
					str = "";
					str1 = "";
					str2 = "";
					str3 = "";
					str4 = "";
					k++;
				}
			}
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
			finally {
				try {
					reader.close();
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			textField.setVisible(false);
			button4.setVisible(false);
			label1.setVisible(true);
			label2.setVisible(true);
			label3.setVisible(true);
			choiseA.setVisible(true);
			choiseB.setVisible(true);
			choiseC.setVisible(true);
			choiseD.setVisible(true);
			button1.setVisible(true);
			button2.setVisible(true);
			button3.setVisible(true);
			label2.setText(questions[l]);
			choiseA.setText(choices[l][0]);
			choiseB.setText(choices[l][1]);
			choiseC.setText(choices[l][2]);
			choiseD.setText(choices[l][3]);
		}
	}
}
