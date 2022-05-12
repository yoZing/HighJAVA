package exercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lt {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 
		int select = 0;
		boolean lotto = true;
		
		while(lotto) {
			System.out.println("==========================");
			System.out.println("    Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("   1. Lotto 구입");
			System.out.println("   2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴선택 : ");
			select = Integer.parseInt(scan.nextLine());
						
			switch(select) {
			case 1: 
					System.out.println("Lotto 구입 시작");
					System.out.println("(1000원에 로또번호 하나입니다.)");
					System.out.print("금액 입력 : ");
					int money = Integer.parseInt(scan.nextLine());
					int count = money/1000;
					int change = money%1000;
			
					
					System.out.println("행운의 로또번호는 아래와 같습니다.");
					
					for(int i=0; i<count; i++) {
						Set<Integer> lSet = new HashSet<>();
						while(lSet.size() < 6) {
							int rnd = (int)(Math.random()*45 +1);
							lSet.add(rnd);
						}
						System.out.println(lSet);
					}
					
					
					System.out.println("받은 금액은 " + money + "원이고, 거스름돈은 " + change + "원입니다.");
				
				  break;
			case 2: System.out.println("감사합니다.");
				lotto = false;
				break;
			default : System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
			    break;
			}
			
			 
			  
		}		
		
		
		
		
	
	}
}
