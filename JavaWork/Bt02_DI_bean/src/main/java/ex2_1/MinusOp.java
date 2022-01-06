package ex2_1;

public class MinusOp implements OperatorBean{

	int operand1, operand2;
	
	public MinusOp(int operand1, int operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	public int doOperate() {
		return operand1 - operand2;
	}
}
