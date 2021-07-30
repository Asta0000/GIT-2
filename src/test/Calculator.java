package test;

import java.util.Scanner;
//import java.io.*;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Консольное приложение 'Калькулятор'");
		System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну строку.");
		System.out.println("Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.");
		System.out.println("Пример работы программы:");
		System.out.println("Input:");
		System.out.println("1 + 2");
		System.out.println("Output:");
		System.out.println("3");
		System.out.println("");

		Scanner in = new Scanner(System.in);
		String expr;

		System.out.println("Input:");


		try {
			expr = in.nextLine();
			SimpleExpression mycalc = new SimpleExpression(expr);
			mycalc.calculate();

			System.out.println("Output:");
			mycalc.print_result();
		} 

		catch (BadExpressionException e2) {
			// TODO Auto-generated catch block

		}
		in.close();	


	}

}
