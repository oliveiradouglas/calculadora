/*
 * Autor: Douglas Oliveira
 * Descrição: Calculadora simples
 * Data de criação: 16/05/2015
 */

package main;

//imports
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculadora extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//declara os componentes
	JTextField jtfCampo = new JTextField(10);
	JTextField jtfResultado = new JTextField(10);
		
	JButton jb0 = new JButton("0");
	JButton jb1 = new JButton("1");
	JButton jb2 = new JButton("2");
	JButton jb3 = new JButton("3");
	JButton jb4 = new JButton("4");
	JButton jb5 = new JButton("5");
	JButton jb6 = new JButton("6");
	JButton jb7 = new JButton("7");
	JButton jb8 = new JButton("8");
	JButton jb9 = new JButton("9");
	
	JButton jbSoma = new JButton("+");
	JButton jbSubtracao = new JButton("-");
	JButton jbMultiplicacao = new JButton("*");
	JButton jbDivisao = new JButton("/");
	
	JButton jbClean = new JButton("C");
	JButton jbResultado = new JButton("=");
	
	JPanel jpSuperior = new JPanel();
	JPanel jpInferior = new JPanel();
	
	
	//construtor
	public Calculadora() {
		setTitle("Calculadora");
		setSize(250, 250);
		setLocation(550, 200);
		setLayout(new GridLayout(2,1));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		jtfCampo.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 30));
		jtfResultado.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 30));
		jtfResultado.setEditable(false);
		
		jpSuperior.setLayout(new GridLayout(2,2));
		jpSuperior.add(jtfResultado);
		jpSuperior.add(jtfCampo);
		
		jpInferior.setLayout(new GridLayout(4,4));
		jpInferior.add(jb7);
		jpInferior.add(jb8);
		jpInferior.add(jb9);
		jpInferior.add(jbDivisao);
		jpInferior.add(jb4);
		jpInferior.add(jb5);
		jpInferior.add(jb6);
		jpInferior.add(jbMultiplicacao);
		jpInferior.add(jb1);
		jpInferior.add(jb2);
		jpInferior.add(jb3);
		jpInferior.add(jbSubtracao);
		jpInferior.add(jb0);
		jpInferior.add(jbClean);
		jpInferior.add(jbResultado);
		jpInferior.add(jbSoma);
				
		add(jpSuperior);
		add(jpInferior);

		jb0.addActionListener(this);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		jb7.addActionListener(this);
		jb8.addActionListener(this);
		jb9.addActionListener(this);
		jbDivisao.addActionListener(this);
		jbMultiplicacao.addActionListener(this);
		jbSubtracao.addActionListener(this);
		jbSoma.addActionListener(this);
		jbResultado.addActionListener(this);
		jbClean.addActionListener(this);
	}
	
	//faz o calculo conforme o botão clicado
	public void operacao(String operador){
		String[] valorSplit = jtfResultado.getText().replace(",", ".").split(" ");
					
		Double resultado = 0.;

		try{
			if(valorSplit[1] != null){ //verifica se tem operador
				switch (operador) {
					case "/":
						try{
							resultado = Double.parseDouble(valorSplit[0]) / Double.parseDouble(jtfCampo.getText().replace(",", "."));
						} catch(Exception ex){
							jtfResultado.setText("Erro");
							jtfCampo.setText("");
							return;
						}
						break;
						
					case "*":
						try{
							resultado = Double.parseDouble(valorSplit[0]) * Double.parseDouble(jtfCampo.getText().replace(",", "."));
						} catch(Exception ex){
							jtfResultado.setText("Erro");
							jtfCampo.setText("");
							return;
						}
						break;
							
					case "-":
						try{
							resultado = Double.parseDouble(valorSplit[0]) - Double.parseDouble(jtfCampo.getText().replace(",", "."));
						} catch(Exception ex){
							jtfResultado.setText("Erro");
							jtfCampo.setText("");
							return;
						}
						break;
							
					case "+":
						try{
							resultado = Double.parseDouble(valorSplit[0]) + Double.parseDouble(jtfCampo.getText().replace(",", "."));
						} catch(Exception ex){
							jtfResultado.setText("Erro");
							jtfCampo.setText("");
							return;
						}
						break;
							
					default:
						jtfResultado.setText("Erro Operador");
						return;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e){
			return;
		}
			
			
		//Verifica se possui numero diferente de 0 depois da virgula.
		if(String.format("%.2f", resultado).endsWith(",00")){
			jtfResultado.setText(String.format("%.0f", resultado));
		} else {
			jtfResultado.setText(String.format("%.2f", resultado));
		}
			
		jtfCampo.setText("");
	}

	public void atribuiOperador(String operador){
		String[] valorSplit = jtfResultado.getText().split(" ");
		
		if(!jtfResultado.getText().trim().isEmpty() && jtfCampo.getText().trim().isEmpty()){
			jtfResultado.setText(valorSplit[0] + operador);
		} else if(!jtfCampo.getText().trim().isEmpty() && !jtfResultado.getText().trim().isEmpty()){
			if(valorSplit.length == 1){
				jtfResultado.setText(valorSplit[0] + operador);
			} else {
				operacao(operador.trim());
			}
		} else if(!jtfCampo.getText().trim().isEmpty() && jtfResultado.getText().trim().isEmpty()){	
			jtfResultado.setText(jtfCampo.getText().trim() + operador);
			jtfCampo.setText("");
		} 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object bt = (JButton) e.getSource();
		
		if(bt == jbClean){
			jtfResultado.setText("");
			jtfCampo.setText("");
		}
		
		if(bt == jb0) jtfCampo.setText(jtfCampo.getText() + "0");
		if(bt == jb1) jtfCampo.setText(jtfCampo.getText() + "1");
		if(bt == jb2) jtfCampo.setText(jtfCampo.getText() + "2");
		if(bt == jb3) jtfCampo.setText(jtfCampo.getText() + "3");
		if(bt == jb4) jtfCampo.setText(jtfCampo.getText() + "4");
		if(bt == jb5) jtfCampo.setText(jtfCampo.getText() + "5");
		if(bt == jb6) jtfCampo.setText(jtfCampo.getText() + "6");
		if(bt == jb7) jtfCampo.setText(jtfCampo.getText() + "7");
		if(bt == jb8) jtfCampo.setText(jtfCampo.getText() + "8");
		if(bt == jb9) jtfCampo.setText(jtfCampo.getText() + "9");
		
		if(bt == jbDivisao){
			atribuiOperador(" / ");
		}
		
		if(bt == jbMultiplicacao){
			atribuiOperador(" * ");
		}
		
		if(bt == jbSubtracao){
			atribuiOperador(" - ");
		}
		
		if(bt == jbSoma){
			atribuiOperador(" + ");
		}
		
		if(bt == jbResultado && !jtfResultado.getText().isEmpty() && !jtfCampo.getText().isEmpty()){
			try{ //tenta pegar o operador
				operacao(jtfResultado.getText().trim().substring(jtfResultado.getText().length()-2));
			} catch (StringIndexOutOfBoundsException ev){
				return;
			}
		}
	}
	
	public static void main(String[] args){
		new Calculadora();
	}
}
