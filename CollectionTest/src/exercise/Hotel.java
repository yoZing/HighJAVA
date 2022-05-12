package exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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


public class Hotel {
   
	private Scanner scanner;
	private Map<Integer , Reservation> hotelMap;
	
	
	public Hotel() {
		scanner = new Scanner(System.in);
		hotelMap = new HashMap<Integer, Reservation>();
		File file = new File("d:/D_Other/hotelObj.bin");
	}
	
	public void menu() {
		System.out.println("*******************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("*******************************");
		System.out.print(" 번호입력 >> ");
	}
	
	public void start() {
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/hotelObj.bin")));
			
			hotelMap = (Map<Integer, Reservation>) ois.readObject();
			ois.close();
			
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			//ex.printStackTrace();
		} 
		
		System.out.println("*******************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("*******************************");
		while (true) {
			menu();
						
			int sNum = Integer.parseInt(scanner.nextLine());
			switch (sNum) {
			case 1:
				insert();
				break;
			case 2:
				delete();
				break;
			case 3:
				select();
				break;
			case 4:
				System.out.println("호텔 문을 닫았습니다.");
				
				ObjectOutputStream oos = null;
				
				try {
					oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotelObj.bin")));
					
					oos.writeObject(hotelMap); // 직렬화
					
					
				} catch(IOException ex) {
					ex.printStackTrace();
				} finally {
					try {
						oos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
		
	}

	private void insert() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		int selectNum = Integer.parseInt(scanner.nextLine());
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String name = scanner.nextLine();
		
		if(hotelMap.get(selectNum) != null) {
			System.out.println(selectNum + "번방은 이미 사람이 있습니다.");
			return;
		}
		
		hotelMap.put(selectNum, new Reservation(selectNum, name));
			
		System.out.println("체크인 되었습니다.");
	}

	private void delete() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		int selectNum = Integer.parseInt(scanner.nextLine());
		
		if(hotelMap.get(selectNum) == null) {
			System.out.println(selectNum + "방에는 체크인한 사람이 없습니다.");
			return;
		}
		
		hotelMap.remove(selectNum);
			
		System.out.println("체크아웃 되었습니다.");
	}

	private void select() {
		
		Set<Integer> keySet = hotelMap.keySet();
		if(keySet.size() == 0) {
			System.out.println("모든 방이 비어있습니다.");
		} else {
			Iterator<Integer> it = keySet.iterator();
			int cnt = 0;
			while(it.hasNext()) {
				cnt++;
				int selectNum = it.next();
				Reservation r = hotelMap.get(selectNum);
				System.out.printf(" " + cnt + ". 방번호 : %d, 투숙객 : %s", r.getRoomNum(),r.getName());
				System.out.println();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Hotel().start();
	}
	
}

class Reservation implements Serializable{
	int roomNum;
	String name;
	
	public Reservation(int roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Reservation [roomNum=" + roomNum + ", name=" + name + "]";
	}
	
	
}
