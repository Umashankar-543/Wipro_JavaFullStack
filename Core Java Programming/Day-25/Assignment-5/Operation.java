package Day_25;

import java.io.Serializable;

public class Operation implements Serializable {

	private static final long serialVersionUID = 1L;
	public int num1;
	public int num2;
	public String operator;
	public Operation(int num1, int num2, String operator) {
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}
}