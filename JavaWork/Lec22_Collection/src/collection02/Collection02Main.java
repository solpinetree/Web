package collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		//TODO:
		// String 타입을 담는 ArrayList를 만들고
		ArrayList<String> arr = new ArrayList<>();
		// 5개 이상의 String을 저장하고
		arr.add("h");
		arr.add("e");
		arr.add("l");
		arr.add("l");
		arr.add("o");
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		arr.set(3, "u");
		arr.remove(arr.size()-1);
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i)+" ");
		}
		System.out.println();
		
		for(String s : arr) {
			System.out.print(s+ " ");
		}
		System.out.println();
		
		Iterator<String> itr = arr.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
