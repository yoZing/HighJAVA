package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T03_ListSortTest {
   
	/*
	 정렬과 관련된 Interface는 Comparable과 Comparator 이렇게 두가지가 있다.
	  - 보통 객체 자체에 정렬기능을 넣기 위해서는 Comparable을 구현하고
	        정렬기준을 별도로 구현하고 싶을 때는 Comparator를 구현하여 사용한다.
	  
	  - Comparable에서는 compareTo() 메서드를 구현해야 하고,
	    Comparator에서는 compare() 메서드를 구현해야 한다. 
	 */
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬 전 : " + list);
		
		// 정렬은 Collections.sort()메서드를 이용하여 정렬한다.
		// 정렬은 기본적으로 '오름차순' 으로 수행된다.
		
		// 정렬방식을 변경하려면 정렬방식을 결정하는 객체를 만들어서
		// Collections.sort()메서드에 인수로 넘겨주면 된다.
		Collections.sort(list); // 오름차순으로 정렬하기
		System.out.println("정렬 후 : " + list);
	
	    Collections.shuffle(list); // 데이터를 섞어준다.
	    System.out.println("자료 섞기 후 : " + list);
	
	    // 정렬방식을 결정하는 객체를 이용하여 정렬하기
	    Collections.sort(list, new Desc());
	    System.out.println("정렬 후 : " + list);
	}
}

//  정렬방식을 결정하는 class는 Comparator라는 인터페이스를 구현해야 한다.
// 이 Comparator인터페이스의 compare()라는 메서드를 재정의 하여 구현하면 된다.
class Desc implements Comparator<String> {
/*
      compare()메서드의 반환값을 결정하는 방법
      => 이 메서드가 양수를 반환하면 두 값의 순서가 바뀐다.(오름차순이 기본임.)
      
      - 오름차순 정렬일 경우
      => 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환하도록 한다.
      
      -String객체에는 정렬을 위해서 compareTo()메서드가 구현되어 있는데 이 메서드의 반환값은 오름차순에 맞게 반환되도록 구현되어 있다.
 */
	@Override
	public int compare(String str1, String str2) {
			return str1.compareTo(str2) * -1; // * 1 이면 오름차순
	}
	
}






