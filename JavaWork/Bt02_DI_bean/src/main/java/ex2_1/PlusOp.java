package ex2_1;

public class PlusOp implements OperatorBean{
	
	int operand1, operand2;
	
	public PlusOp(int operand1, int operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	public int doOperate() {
		return operand1 + operand2;
	}
}
