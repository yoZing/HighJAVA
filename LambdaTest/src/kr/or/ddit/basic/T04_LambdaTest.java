package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T04_LambdaTest {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("홍길동1");
		list.add("홍길동2");
		list.add("홍길동3");
		
		for (String str : list) {
			System.out.println(str);
		}
		
		System.out.println("------------");
		
		list.forEach((str)->System.out.println(str));
		
		
	}
}
