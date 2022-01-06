package exception07;

// 우리가 만드는 예외 클래스 
// Exception or RuntimeException 클래스를 상속 받아서 만듬

// TODO : Exception 을 상속받아 예외 클래스 정의하기
public class ScoreException extends Exception{
	
	//생성자 
	public ScoreException() {
		super("점수 입력 오류");
	}
	
	public ScoreException(String msg) {
		super(msg);
	}
}
