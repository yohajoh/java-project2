import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddQuestions extends JFrame implements ActionListener{
	
	JLabel label;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JTextField textField;
	JTextField textField1;
	JTextField textField2;
	JTextField textField3;
	JTextField textField4;
	JTextField textField5;
	JTextField textField6;
	JButton button;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	ImageIcon icon;
	
	FileWriter fout;
	FileReader reader;
	
	String str = "";
	String str1 = "";
	String str2 = "";
	String str3 = "";
	String str4 = "";
	String str5 = "";
	
	String[][] choices = new String[100][4];
	String[] questions = new String[100];
	String[] correctAnswers = new String[100];
	String[] guessAnswers = new String[100];
	
	int ch, k = 0, i = 0;
	
	AddQuestions(){

		label = new JLabel();
		label.setText("Type Your Question In The Box");
		label.setBounds(0, 100, 400, 40);
		label.setForeground(Color.cyan);
		label.setFont(new Font("Cosolas",Font.BOLD,20));
		label.setVisible(false);
		
		label1 = new JLabel();
		label1.setBounds(90, 450, 250, 30);
		label1.setForeground(Color.cyan);
		label1.setFont(new Font("Cosolas",Font.PLAIN,15));
		label1.setVisible(false);
		
		label2 = new JLabel();
		label2.setBounds(100, 520, 250, 30);
		label2.setForeground(Color.cyan);
		label2.setFont(new Font("Cosolas",Font.PLAIN,15));
		label2.setVisible(false);
		
		label3 = new JLabel();
		label3.setBounds(100, 30, 400, 30);
		label3.setForeground(Color.red);
		label3.setFont(new Font("Cosolas",Font.PLAIN,15));

		label3 = new JLabel();
		label3.setBounds(100, 30, 400, 30);
		label3.setForeground(Color.red);
		label3.setFont(new Font("Cosolas",Font.PLAIN,15));
		
		button = new JButton();
		button.setBounds(100, 410, 150, 40);
		button.setFocusable(false);
		button.setText("Submit");
		button.setForeground(Color.cyan);
		button.setFont(new Font("Cosolas",Font.BOLD,20));
		button.addActionListener(this);
		button.setVisible(false);
		
		button1 = new JButton();
		button1.setBounds(600, 20, 200, 40);
		button1.setFocusable(false);
		button1.setText("LaunchPage");
		button1.setForeground(Color.cyan);
		button1.setFont(new Font("Cosolas",Font.BOLD,20));
		button1.addActionListener(this);
		button1.setVisible(false);
		
		button2 = new JButton();
		button2.setBounds(600, 70, 200, 40);
		button2.setFocusable(false);
		button2.setText("AskQuestions");
		button2.setForeground(Color.cyan);
		button2.setFont(new Font("Cosolas",Font.BOLD,20));
		button2.addActionListener(this);
		button2.setVisible(false);
		
		button3 = new JButton();
		button3.setBounds(100, 480, 150, 40);
		button3.setFocusable(false);
		button3.setText("Finish");
		button3.setForeground(Color.cyan);
		button3.setFont(new Font("Cosolas",Font.BOLD,20));
		button3.addActionListener(this);
		button3.setVisible(false);
		
		button4 = new JButton();
		button4.setBounds(330, 2, 65, 30);
		button4.setFocusable(false);
		button4.setText("Ok");
		button4.setForeground(Color.cyan);
		button4.setFont(new Font("Cosolas",Font.BOLD,20));
		button4.addActionListener(this);
		
		button5 = new JButton();
		button5.setBounds(10, 60, 250, 30);
		button5.setFocusable(false);
		button5.setText("Add To Existing Questions");
		button5.setForeground(Color.cyan);
		button5.setFont(new Font("Cosolas",Font.BOLD,20));
		button5.addActionListener(this);
		button5.setVisible(false);
		
		
		button6 = new JButton();
		button6.setBounds(270, 60, 220, 30);
		button6.setFocusable(false);
		button6.setText("Create New Questions");
		button6.setForeground(Color.cyan);
		button6.setFont(new Font("Cosolas",Font.BOLD,20));
		button6.addActionListener(this);
		button6.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(80, 2, 240, 30);
		textField.setText("Enter Question Code");
		textField.setForeground(Color.cyan);
		textField.setFont(new Font("Cosolas",Font.BOLD,20));
		textField.setBackground(Color.gray);
		
		textField1 = new JTextField();
		textField1.setBounds(0, 140, 800, 30);
		textField1.setText("Question");
		textField1.setForeground(Color.cyan);
		textField1.setFont(new Font("Cosolas",Font.BOLD,20));
		textField1.setBackground(Color.gray);
		textField1.setVisible(false);
		
		textField2 = new JTextField();
		textField2.setBounds(0, 180, 800, 30);
		textField2.setText("Choice A:");
		textField2.setForeground(Color.cyan);
		textField2.setFont(new Font("Cosolas",Font.BOLD,20));
		textField2.setBackground(Color.gray);
		textField2.setVisible(false);
		
		textField3 = new JTextField();
		textField3.setBounds(0, 220, 800, 30);
		textField3.setText("Choice B:");
		textField3.setForeground(Color.cyan);
		textField3.setFont(new Font("Cosolas",Font.BOLD,20));
		textField3.setBackground(Color.gray);
		textField3.setVisible(false);
		
		textField4 = new JTextField();
		textField4.setBounds(0, 260, 800, 30);
		textField4.setText("Choice C:");
		textField4.setForeground(Color.cyan);
		textField4.setFont(new Font("Cosolas",Font.BOLD,20));
		textField4.setBackground(Color.gray);
		textField4.setVisible(false);
		
		textField5 = new JTextField();
		textField5.setBounds(0, 300, 800, 30);
		textField5.setText("Choice D:");
		textField5.setForeground(Color.cyan);
		textField5.setFont(new Font("Cosolas",Font.BOLD,20));
		textField5.setBackground(Color.gray);
		textField5.setVisible(false);
		
		textField6 = new JTextField();
		textField6.setBounds(0, 340, 800, 30);
		textField6.setText("Answer:");
		textField6.setForeground(Color.cyan);
		textField6.setFont(new Font("Cosolas",Font.BOLD,20));
		textField6.setBackground(Color.gray);
		textField6.setVisible(false);
		
		icon = new ImageIcon("E:\\image\\PNG_Folder\\verified.png");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 620);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(50,50,50));
		this.setLocationRelativeTo(this);
		this.setIconImage(icon.getImage());
		this.setTitle("Simple 'Question And Answer' Game");
		this.add(label);
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(textField);
		this.add(button4);
		this.add(button5);
		this.add(button6);
		this.add(button5);
		this.add(button6);
		this.add(textField1);
		this.add(textField2);
		this.add(textField3);
		this.add(textField4);
		this.add(textField5);
		this.add(textField6);
		this.add(button);
		this.add(button3);
		this.add(button1);
		this.add(button2);
		this.setVisible(true);	
	}
	int questionCode;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			
			String text1 = textField1.getText();
			textField1.setText("Question");
			
			String text2 = textField2.getText();
			textField2.setText("Choice A:");
			
			String text3 = textField3.getText();
			textField3.setText("Choice B:");
			
			String text4 = textField4.getText();
			textField4.setText("Choice C:");
			
			String text5 = textField5.getText();
			textField5.setText("Choice D:");
			
			String text6 = textField6.getText().toUpperCase();
			textField6.setText("Answer:");
			
			questions[k] = text1;
			choices[k][0] = text2;
			choices[k][1] = text3;
			choices[k][2] = text4;
			choices[k][3] = text5;
			correctAnswers[k] = text6;
			k++;
			
			label1.setText("Successfully Submitted!!!");	
		}
		if(e.getSource()==button4) {
			try {
				questionCode = Integer.parseInt(textField.getText());
				textField.setVisible(false);
				button4.setVisible(false);
				label3.setVisible(false);
				button5.setVisible(true);
				button6.setVisible(true);
			}
			catch(NumberFormatException e1) {
				label3.setText("Error: Question Code Must Be Integer!!!");
			}
		}
		if(e.getSource()==button5) {
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
						str5 = str5+(char)ch;	
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
					str5 = "";
					k++;
				}
			}
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
			label.setVisible(true);
			label1.setVisible(true);
			label2.setVisible(true);
			button.setVisible(true);
			button1.setVisible(true);
			button2.setVisible(true);
			button3.setVisible(true);
			button5.setVisible(false);
			button6.setVisible(false);
			textField1.setVisible(true);
			textField2.setVisible(true);
			textField3.setVisible(true);
			textField4.setVisible(true);
			textField5.setVisible(true);
			textField6.setVisible(true);
		}
		if(e.getSource()==button6) {
			label.setVisible(true);
			label1.setVisible(true);
			label2.setVisible(true);
			button.setVisible(true);
			button1.setVisible(true);
			button2.setVisible(true);
			button3.setVisible(true);
			button5.setVisible(false);
			button6.setVisible(false);
			textField1.setVisible(true);
			textField2.setVisible(true);
			textField3.setVisible(true);
			textField4.setVisible(true);
			textField5.setVisible(true);
			textField6.setVisible(true);
		}
		if(e.getSource()==button1) {
			this.dispose();
			new LaunchPage();
		}
		if(e.getSource()==button2) {
			this.dispose();
			new AskQuestions();
		}
		if(e.getSource()==button3) {
			if(questionCode == 1) {
				try {
					fout = new FileWriter("question_1");
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if(questionCode == 2) {
				try {
					fout = new FileWriter("question_2");
				} 
				catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			if(questionCode == 3) {
				try {
					fout = new FileWriter("question_3");
				} 
				catch (IOException e3) {
					e3.printStackTrace();
				}
			}
			if(questionCode == 4) {
				try {
					fout = new FileWriter("question_4");
				} 
				catch (IOException e4) {
					e4.printStackTrace();
				}
			}
			
			try {
				for(String quest:questions) {
					if(quest==null) {
						break;
					}
					else {
						fout.append(quest);
						fout.append('\n');
						for(int j = i; j < 100; j++) {
							for(int k = 0; k < 4; k++) {
								fout.append(choices[j][k]);
								fout.append('\n');
							}
							fout.append(correctAnswers[i]);
							fout.append('\n');
							i++;
							break;
						}
					}
				}
				fout.close();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			label2.setText("Successfully finished!!!");
		}
	}
}
