package exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
  public static void main(String[] args) {
	 
	  Scanner scanner = new Scanner(System.in);
	  int i=0;
	  while(true) {
		  System.out.println("==========================");
		  System.out.println("Lotto 프로그램");
		  System.out.println("---------------------------");
		  System.out.println("1. Lotto 구입 \n2. 프로그램 종료");
		  System.out.print("메뉴 선택 : ");
		  int selectNum = scanner.nextInt();
		  if(selectNum == 1) {
			  System.out.print("금액 입력 : ");
			  double money = scanner.nextDouble();
			  int lottoCnt = (int)money/1000; 
			  int change = (int)money%1000;
			  System.out.println("행운의 로또번호는 아래와 같습니다.");
			  for(i=0; i<lottoCnt; i++) { 
			  Set<Integer> intRnd = new HashSet<>();
				while(intRnd.size() < 6) {
					int num = (int)(Math.random() * 45 + 1);
					intRnd.add(num);
				}
				
				List<Integer> intRndList = new ArrayList<Integer>(intRnd);
					System.out.println("로또"+ (i+1) +intRndList + " ");	
			  }					  
			  System.out.println("받은 금액은 " + (int)money + "원이고 거스름돈은 " + change + "원입니다." );
		  } else if(selectNum == 2) {
			  System.out.println("감사합니다.");
			  scanner.close();
			  break;
		  } else { 
			  System.out.println("잘못된 입력입니다.");
			  continue;
		  }
	  }
	  
	  
  }
}
