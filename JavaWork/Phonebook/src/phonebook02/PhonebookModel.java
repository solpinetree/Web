package phonebook02;

import java.time.LocalDateTime;

//MODEL : 데이터 표현 
public class PhonebookModel {

	private int uid; // 고유 uid 값 (1 ~ ) 중복혀용 X
	private String name; // 이름(*필수*) 
	private String phoneNum; // 전화번호(*필수*)
	private String memo; // 메모
	private LocalDateTime regDate; // 등록일
	
	
	
	public PhonebookModel(int uid, String name, String phoneNum, String memo, LocalDateTime regDate) {
		super();
		this.uid = uid;
		this.name = name;
		this.phoneNum = phoneNum;
		this.memo = memo;
		this.regDate = regDate;
	}
	public int getUid() {return uid;}
	public void setUid(int uid) {this.uid = uid;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	public String getMemo() {return memo;}
	public void setMemo(String memo) {this.memo = memo;}
	public LocalDateTime getRegDate() {return regDate;}
	public void setRegDate(LocalDateTime regDate) {this.regDate = regDate;}
	
	@Override
	public String toString() {
		return String.format("%d] %s : %s : %s : %s",
			 uid, name, phoneNum, memo, regDate);
	}
}
