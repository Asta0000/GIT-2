package test;

import java.util.regex.*;

public class SimpleExpression {

	private int a;
	private int b;
	private int result;
	private char operation;
	private char notation;

	public void print_result() {
		switch (notation) {
		case  ('A'):
			System.out.println(result);
		break;
		case ('R'):
			System.out.println(IntegerConverter.arabicToRoman(result));
		break;
		}	
	}

	public void calculate() {
		switch (operation) {
		case  ('+'):
			result = a + b;
		break;
		case ('-'):
			result = a - b;
		break;
		case  ('*'):
			result = a * b;
		break;
		case ('/'):
			result = a / b;
		break;
		}	
	}

	public SimpleExpression(String expr) throws BadExpressionException {
		if(expr.length() == 0) throw new BadExpressionException("EMP");

		Pattern pattern_a = Pattern.compile("\\d{1,2}\\s*(\\+|-|\\*|/)\\s*\\d{1,2}");
		Pattern pattern_r = Pattern.compile(
		"^(C{0,1})(L{0,1}X{0,3}|X[LC])(V{0,1}I{0,3}|I[VX])\\s*(\\+|-|\\*|/)\\s*(C{0,1})(L{0,1}X{0,3}|X[LC])(V{0,1}I{0,3}|I[VX])$");

		if(Pattern.matches(pattern_a.pattern(), expr.trim())) {
			// Правильное выражение с арабскими цифрами
			
			String[] add = expr.split("\\+");
			String[] sub = expr.split("-");
			String[] mul = expr.split("\\*");
			String[] div = expr.split("/");

			int oper_index = expr.indexOf("+");
			if(oper_index > 0) operation = '+'; 
			
			oper_index = expr.indexOf("-");
			if(oper_index > 0) operation = '-';
			
			oper_index = expr.indexOf("*");
			if(oper_index > 0) operation = '*';
			
			oper_index = expr.indexOf("/");
			if(oper_index > 0) operation = '/'; 

			switch (operation) {
			case  ('+'):
				a = Integer.parseInt(add[0].trim());
				b = Integer.parseInt(add[1].trim());
				break;
			case ('-'):
				a = Integer.parseInt(sub[0].trim());
				b = Integer.parseInt(sub[1].trim());
				break;
			case  ('*'):
				a = Integer.parseInt(mul[0].trim());
				b = Integer.parseInt(mul[1].trim());
				break;
			case ('/'):
				a = Integer.parseInt(div[0].trim());
				b = Integer.parseInt(div[1].trim());
				break;
			}
			
			notation = 'A';

		}
		else if(Pattern.matches(pattern_r.pattern(), expr.trim())) {
			// Правильное выражение с римскими цифрами

			String[] add = expr.split("\\+");
			String[] sub = expr.split("-");
			String[] mul = expr.split("\\*");
			String[] div = expr.split("/");

			int oper_index = expr.indexOf("+");
			if(oper_index > 0) operation = '+'; 
			
			oper_index = expr.indexOf("-");
			if(oper_index > 0) operation = '-';
			
			oper_index = expr.indexOf("*");
			if(oper_index > 0) operation = '*';
			
			oper_index = expr.indexOf("/");
			if(oper_index > 0) operation = '/'; 


			
			switch (operation) {
			case  ('+'):
				a = IntegerConverter.romanToArabic(add[0].trim());
				b = IntegerConverter.romanToArabic(add[1].trim());
				break;
			case ('-'):
				a = IntegerConverter.romanToArabic(sub[0].trim());
				b = IntegerConverter.romanToArabic(sub[1].trim());
				break;
			case  ('*'):
				a = IntegerConverter.romanToArabic(mul[0].trim());
				b = IntegerConverter.romanToArabic(mul[1].trim());
				break;
			case ('/'):
				a = IntegerConverter.romanToArabic(div[0].trim());
				b = IntegerConverter.romanToArabic(div[1].trim());
				break;
			}
			notation = 'R';
		}
		else
		{  // Неправильное выражение или слишком большие числа
			//	    	throw("Плохое выражение");
			throw new BadExpressionException("BAD");
			
		}
		
		if ((a > 10) || (b > 10)) throw new BadExpressionException("BIG");

	}

}
