package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

/*
     컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
     
     컴퓨터의 가위 바위 보는 난수를 이용하여 구하고
     사용자의 가위 바위 보는 showInputDialog()메서드를 이용하여 입력받는다.
     
     입력시간은 5초로 제한하고 카운트 다운을 진행한다.
   5초안에 입력이 없으면 게임을 진 것으로 처리한다.
   
   5초안에 입력이 완료되면 승패를 출력한다.
   
   결과예시)
   === 결 과 ===
      컴퓨터 : 가위
      당   신 : 바위
      결   과 : 당신이 이겼습니다.
 */
public class T07_ThreadGame {
	
	static String man = "";
	
   public static boolean inputCheck = false;
   
   public static void main(String[] args) {
	   
	  
	   Random random = new Random();
	   String[] game = {"가위", "바위", "보"};
	   String com = game[random.nextInt(3)];
	   
	   Thread th1 = new GameInput();
	   Thread th2 = new GameCount();
	   
	   
		th1.start();
		th2.start();
		
		try {
			   Thread.sleep(4000); // 1초동안 잠시 멈춘다.
		   } catch(InterruptedException ex) {
			   ex.printStackTrace();
		   }
		
		int result = 0;
		if(com.equals(man)) {
            result = 0;
		} else if(com.equals("바위") && man.equals("가위") ||
				  com.equals("가위") && man.equals("보") ||
				  com.equals("보") && man.equals("바위")) {
			result = 1;
		} else {
			result = -1;
		}
	   
		System.out.println("컴퓨터 : " + com);
		System.out.println("당   신 : " + man);
		
		if(result == 0) {
			System.out.println("결   과 : 비겼습니다.");
		} else if(result > 0) {
			System.out.println("결   과 : 컴퓨터가 이겼습니다.");
		} else {
			System.out.println("결   과 : 당신이 이겼습니다.");
		}
	   
   }
}

class GameInput extends Thread {
	
	@Override
	public void run() {
		T07_ThreadGame.man = JOptionPane.showInputDialog("가위 바위 보 게임");
		
		T07_ThreadGame.inputCheck = true;
		
		
	}
}

class GameCount extends Thread {
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
		   if(T07_ThreadGame.inputCheck == true) {
				return;
		   }
			
		   System.out.println(i);
		   try {
			   Thread.sleep(1000); 
		   } catch(InterruptedException ex) {
			   ex.printStackTrace();
		   }
		}
		System.out.println("5초가 지났습니다. 패배하였습니다.");
		System.exit(0); 
	}
}


