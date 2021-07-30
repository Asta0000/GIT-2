package test;

public class BadExpressionException extends Exception{
	
	static final long serialVersionUID = 1;

	public BadExpressionException(String err) {
		// TODO Auto-generated constructor stub
		if(err.equalsIgnoreCase("BAD")) {
			System.out.println("Ќеправильный синтаксис выражени€ или слишком большие числа");
		}
		if(err.equalsIgnoreCase("BIG")) {
			System.out.println("ќперанд выражени€ (или оба) больше 10");
		}
		if(err.equalsIgnoreCase("EMP")) {
			System.out.println("ѕустое выражение");
		}
	}
}
