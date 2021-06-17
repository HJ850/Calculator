package ex0512;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
	
	public void num(String c) { // 숫자 입력
		if(label.getText()=="0"||chk==1) {
			label.setText(c);
			chk=0;
		} else {
			label.setText(label.getText()+c);
		}
	}
	
	double d1, result; // 입력값, 결과값(연산)
	String Result01; // 결과값(표시)
	int chk=0; // C, =(1) 이후 연산인지 체크
	
	DecimalFormat df=new DecimalFormat("#.###########"); // 3.0 -> 3, 소수점 아래 11자리 표시
	
	public String cal(String operator) { // 사칙연산
		d1=Double.parseDouble(label.getText());
		if(chk==0) {
			result=d1;
			chk=1;
		} else {
			if(operator.equals("÷")) {
				result/=d1;
			} else if(operator.equals("x")) {
				result*=d1;
			} else if(operator.equals("-")) {
				result-=d1;
			} else if(operator.equals("+")) {
				result+=d1;
			}
		}
		Result01=df.format(result);
		sum.setText(Result01+operator);
		label.setText("");
		return Result01;
	}
	
	public void Math(String m) { // 공학계산
		d1=Double.parseDouble(label.getText());
		if(m.equals("√")) {
			result=Math.sqrt(d1);
		} else if(m.equals("sin")) {
			result=Math.sin(d1);
		} else if(m.equals("cos")) {
			result=Math.cos(d1);
		} else if(m.equals("tan")) {
			result=Math.tan(d1);
		}
		Result01=df.format(result);
		label.setText(Result01);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String text;
		
		switch(e.getActionCommand()) {
			case "0":
				num("0");
				break;
			case "1":
				num("1");
				break;
			case "2":
				num("2");
				break;
			case "3":
				num("3");
				break;
			case "4":
				num("4");
				break;
			case "5":
				num("5");
				break;
			case "6":
				num("6");
				break;
			case "7":
				num("7");
				break;
			case "8":
				num("8");
				break;
			case "9":
				num("9");
				break;
			case "sin":
				Math("sin");
				break;
			case "cos":
				Math("cos");
				break;
			case "tan":
				Math("tan");
				break;
			case "C":
				label.setText("0");
				sum.setText("");
				chk=1;
				result=0;
				break;
			case "()":
				
				break;
			case "%":
				result=result*Double.parseDouble(label.getText())/100; // 전체값*일부값/100
				Result01=df.format(result);
				sum.setText(Result01);
				label.setText("");
				break;
			case "←":
				text=label.getText();
				text=text.substring(0, text.length()-1); // 전체 글자수에서 하나씩 제거
				if(text.length()==0) { // 지울 글자가 없을 때
					label.setText("0");
				} else {
					label.setText(text);
				}
				break;
			case "⅟x":
				result=Double.parseDouble(label.getText());
				if(result!=0.0) { // 입력 글자가 0이 아닐 때
					String mi=df.format(1/result);
					label.setText(mi);
				} else {
					label.setText("0으로 나눌 수 없습니다");
				}
				break;
			case "x²":
				result=Double.parseDouble(label.getText());
				Result01=df.format(result*result);
				label.setText(Result01);
				break;
			case "√":
				Math("√");
				break;
			case "÷":
				cal("÷");
				break;
			case "×":
				cal("x");
				break;
			case "-":
				cal("-");
				break;
			case "+":
				cal("+");
				break;
			case "+/-":
				if(((Double.parseDouble(label.getText()))-(Double.parseDouble(label.getText())))==0.0) {
	                label.setText("("+(Integer.parseInt(label.getText().toString())*-1)+")");
	            }
	            else {
	            	label.setText("("+(Double.parseDouble(label.getText().toString())*-1)+")");
	            }
				break;
			case ".":
				label.setText(label.getText()+".");
				break;
			case "=":
				String o = String.valueOf(sum.getText().charAt(sum.getText().length()-1)); // 연산 기록 부분의 끝 문자
				if(o.equals("÷")||o.equals("x")||o.equals("-")||o.equals("+")) { // 사칙연산 기호일 때
					chk=1;
					cal(o);
					sum.setText("");
					label.setText(Result01);
				} else {
					label.setText(label.getText());
				}
				result=0;
				break;
		}
	}

	JLabel label, sum;
	
	public Calculator() {
		setTitle("계산기");
		setBounds(150, 150, 340, 540);
		setVisible(true);
		setResizable(false); // 프레임 크기 변경 X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel fp = new Panel();
		fp.setLayout(new GridLayout(2,1));
		sum = new JLabel(" ", SwingConstants.RIGHT); // 연산 기록
		sum.setFont(new Font("Serif", Font.BOLD, 24));
		fp.add(sum);
		label = new JLabel("0", SwingConstants.RIGHT); // 입력, 결과
		label.setFont(new Font("Serif", Font.BOLD, 29));
		fp.add(label);
		
		Panel sp = new Panel();
		sp.setLayout(new GridLayout(7,4,5,5));
		JButton[] btn = new JButton[28];
		String[] str = {"sin","cos","tan","",
						"C","()","%","←",
						"⅟x","x²","√","÷",
						"7","8","9","×",
						"4","5","6","-",
						"1","2","3","+",
						"+/-","0",".","="};
		for (int i = 0; i < 28; i++) {
			btn[i]=new JButton(str[i]);
			btn[i].addActionListener(this); // 버튼이 눌렸을 때 동작
			sp.add(btn[i]);
		}
		
		add(BorderLayout.NORTH,fp);
		add(BorderLayout.CENTER,sp);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}