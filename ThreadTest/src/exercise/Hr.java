package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hr {
	
	static int rank;
	
	public static void main(String[] args) {
		
		List<Hs> hr = new ArrayList<Hs>();
		
		hr.add(new Hs("1번말"));
		hr.add(new Hs("2번말"));
		hr.add(new Hs("3번말"));
		hr.add(new Hs("4번말"));
		hr.add(new Hs("5번말"));
		hr.add(new Hs("6번말"));
		hr.add(new Hs("7번말"));
		hr.add(new Hs("8번말"));
		hr.add(new Hs("9번말"));
		hr.add(new Hs("10번말"));
		
		
		for (Hs hs : hr) {
			hs.start();
		}
		
		for (Hs hs : hr) {
			try {
				hs.join();
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("경기 끝...");
		System.out.println("---------------");
		System.out.println();
		System.out.println("경기 결과");
		
		Collections.sort(hr);
		
		for (Hs hs : hr) {
			System.out.println(hs.getHorseName() + " " + hs.getRank());
		}
		
		
		
	}
	
}

class Hs extends Thread implements Comparable<Hs>{
	
	int rank;
	String horseName;
	
		
	@Override
	public void run() {
		
		
		for(int i=0; i<=50; i++) {
			System.out.println(horseName + " : ");
			
			for(int k=0; k<=i; k++) {
				System.out.print("-");
			}
			
			System.out.print(">");
			
			for(int j=50; j>=i; j--) {
				System.out.print("-");
				
			}
			try {
				Thread.sleep((int)(Math.random() * 800 + 200));
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		System.out.println();
			
		}
		
		System.out.println(horseName + "도착!");
		setRank(Hr.rank);
		Hr.rank++;
		
		
		
		
		
		
	}
	
	
	
	
	public Hs(String horseName) {
		super();
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}


	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}


	@Override
	public int compareTo(Hs hs) {
		
		if (rank > hs.rank) {
		      return 1;
		    } else {
		      return -1;
		    }
		
//		return this.getRank()).compareTo(hs.getRank());
	}
	
	
	
	
	
}
