package exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Ht {
	
	private Scanner scan;
	private Map<Integer, Manage> hotelMap;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	File file = new File("d:/D_Other/Ht.txt");
	
	public Ht() {
		scan = new Scanner(System.in);
		hotelMap = new HashMap<Integer, Manage>();
	}
	
	public void displayMenu() {
		System.out.println();
		System.out.println("******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인 2. 체크아웃 3. 객실상태 4. 업무종료");
		System.out.println("******************************************");
	}
	
	public void hotelStart() throws IOException, ClassNotFoundException {
		System.out.println("******************************************");
		System.out.println("호텔문을 열었습니다.");
		System.out.println("******************************************");
		
		
		try {
			
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			hotelMap = (Map<Integer, Manage>) ois.readObject();
			
			ois.close();
			
		} catch(IOException ex) {
			ex.printStackTrace();
		} catch(ClassNotFoundException ex) {
//			ex.printStackTrace();
		}
		
		
		
		while(true) {
			
			displayMenu();
			
			int menuNum = Integer.parseInt(scan.nextLine());
			
			switch(menuNum) {
				case 1: checkIn();
					break;
				case 2: checkOut();
					break;
				case 3: status();
					break;
				case 4: System.out.println("호텔문을 닫았습니다.");
				
				oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/Ht.txt")));
				
				oos.writeObject(hotelMap);
				
					return;
				default : System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
			}
			
			
		}
		
		
		
	}

	private void status() {
		
		System.out.println("**************************************");
		System.out.println("				객실상태");
		System.out.println("**************************************");
		
		Set<Integer> keySet = hotelMap.keySet();
		
		if(keySet.size() == 0) {
			System.out.println("모든방이 비어있습니다.");
		} else {
			Iterator<Integer> it = keySet.iterator();
			
			while(it.hasNext()) {
				
				int name = it.next();
				Manage m = hotelMap.get(name);
				System.out.println(" 방번호 : " + m.getRoomNum() + ", 투숙객 : " + m.getName());
			}
		}
		
		
	}

	private void checkOut() {
		
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 > ");
		int rn = Integer.parseInt(scan.nextLine());
		
		if(hotelMap.remove(rn) == null) {
			System.out.println(rn + "번방은 비어있습니다.");
		} else {
			System.out.println("체크아웃 되었습니다.");
		}
		
	}

	private void checkIn() {
		
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 > ");
		int rn = Integer.parseInt(scan.nextLine());
		System.out.println("누구를 체크인 하시겠습니까?");
		String nm = scan.nextLine();
		
		hotelMap.put(rn, new Manage(rn, nm));
		
		System.out.println("체크인이 완료되었습니다.");
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Ht().hotelStart();
	}
	
}

class Manage implements Serializable{
	
	String name;
	int roomNum;
	public Manage(int roomNum, String name) {
		super();
		this.name = name;
		this.roomNum = roomNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	@Override
	public String toString() {
		return "Manage [name=" + name + ", roomNum=" + roomNum + "]";
	}
	
	
	
	
}
