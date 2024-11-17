import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResultWindow extends JFrame{
	
	ResultWindow(char[] correctAnswers, String[] guessAnswers){
		
		JLabel label1 = new JLabel();
		label1.setBounds(0,0,800, 30);
		label1.setText("Correct Answers: "+answer(correctAnswers,guessAnswers));
		label1.setFont(new Font("Consolas", Font.BOLD,20));
		label1.setForeground(Color.green);
		JLabel label2 = new JLabel();
		label2.setBounds(0,30,800, 30);
		label2.setText("Your Answers: "+answer(guessAnswers));
		label2.setFont(new Font("Consolas", Font.BOLD,20));
		label2.setForeground(Color.green);
		JLabel label3 = new JLabel();
		label3.setBounds(0,60,800, 30);
		label3.setText("Result: "+result(correctAnswers,guessAnswers)+"/"+amountOfAnsweredQuestions(guessAnswers));
		label3.setFont(new Font("Consolas", Font.BOLD,20));
		label3.setForeground(Color.green);
		JLabel label4 = new JLabel();
		label4.setBounds(0,90,800, 30);
		label4.setText("Score: "+score(result(correctAnswers,guessAnswers), amountOfAnsweredQuestions(guessAnswers))+"%");
		label4.setFont(new Font("Consolas", Font.BOLD,20));
		label4.setForeground(Color.green);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(50,50,50));
		this.setLocationRelativeTo(null);
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.pack();
		this.setVisible(true);
	}
	public String answer(char[] array, String[] guessAnswers ) {
		String str = "";
		for(int i = 0; i<amountOfAnsweredQuestions(guessAnswers);i++) {
			str = str+array[i]+",";
			}
		return str;
	}
	public String answer(String[] guessAnswers ) {
		String str = "";
		for(String item:guessAnswers) {
			if(item==null) {
				break;}
			else {
				str = str+item+",";}}
		return str;
	}
	public int amountOfAnsweredQuestions(String[] guessAnswers) {
		int counter = 0;
		for(String item:guessAnswers) {
			if(item==null) {
				break;}
			else {
				counter++; }}
		return counter;
	}
	public int result(char[] correctAnswers, String[] guessAnswers) {
		int result = 0, i = 0;
		for(String item:guessAnswers) {
			if(item==null) {
				break;}
			else {
				if(item=="A" && correctAnswers[i] == 'A')
					result=result+1;
				if(item=="B" && correctAnswers[i] == 'B')
					result=result+1;
				if(item=="C" && correctAnswers[i] == 'C')
					result=result+1;
				if(item=="D" && correctAnswers[i] == 'D') 
					result=result+1;}
			i++;
		}
		return result;
	}
	public int score(int resul, int amountOfAnsweredQuestions) {
		double j = ((double)resul/(double)amountOfAnsweredQuestions)*100;
		return (int)j;
	}	
}
