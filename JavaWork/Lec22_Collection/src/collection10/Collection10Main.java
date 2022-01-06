package collection10;

import java.util.Iterator;
import java.util.TreeSet;

public class Collection10Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 연습");
		
		// String 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		TreeSet<String>	tset = new TreeSet<>();
		// 5개 이상의 데이터를 저장해보고
		// 오름차순, 내림차순으로 출력해보기
		
		// 데이터 저장
//		tset.add("qwerty");
//		tset.add("asdf");
//		tset.add("zscv");
//		tset.add("bnm");
//		tset.add("jsl");

		Iterator<String> itr = tset.iterator();
		System.out.println("오름차순: ");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

















