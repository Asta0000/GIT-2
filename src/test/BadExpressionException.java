package test;

public class BadExpressionException extends Exception{
	
	static final long serialVersionUID = 1;

	public BadExpressionException(String err) {
		// TODO Auto-generated constructor stub
		if(err.equalsIgnoreCase("BAD")) {
			System.out.println("������������ ��������� ��������� ��� ������� ������� �����");
		}
		if(err.equalsIgnoreCase("BIG")) {
			System.out.println("������� ��������� (��� ���) ������ 10");
		}
		if(err.equalsIgnoreCase("EMP")) {
			System.out.println("������ ���������");
		}
	}
}
