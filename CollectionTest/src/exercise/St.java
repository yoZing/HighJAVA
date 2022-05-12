package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class St implements Comparable<St>{
	
	 public static void main(String[] args) {
		
	 
	
	 List<St> stList = new ArrayList<St>();
	
	 stList.add(new St("3333", "성춘향", 87, 85, 79 ));
	 stList.add(new St("4444", "이순신", 87, 96, 74 ));
	 stList.add(new St("2222", "변학도", 86, 94, 77 ));
	 stList.add(new St("1111", "홍길동", 77, 86, 94 ));
	 stList.add(new St("5555", "강감찬", 67, 87, 84 ));
	 stList.add(new St("6666", "일지매", 87, 76, 97 ));
	 
	 sR(stList);
	 	 
	 System.out.println("학번의 오름차순 정렬");
	 Collections.sort(stList);
	 
	 for (St st : stList) {
		System.out.println(st);
	 }
	 
	 System.out.println("총점의 내림차순 정렬");
	 Collections.sort(stList, new DescAmt());
	 
	 for (St st : stList) {
		System.out.println(st);
	 } 
	 
	 
	
	 }
	
	String stNum;
	String name;
	int korean;
	int math;
	int english;
	int amount;
	int rank;
	
	
	public St(String stNum, String name, int korean, int math, int english) {
		this.stNum = stNum;
		this.name = name;
		this.korean = korean;
		this.math = math;
		this.english = english;
		this.amount = korean+math+english;
		this.rank = 1;
	}
	
	public String getStNum() {
		return stNum;
	}

	public void setStNum(String stNum) {
		this.stNum = stNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public static void sR(List<St> stList) {
		for (St st1 : stList) {
			int ranking = st1.rank;
			for (St st2 : stList) {
				if(st1.getAmount() < st2.getAmount()) {
					ranking++;
				}
				st1.setRank(ranking);
			}
		}
	}
	
	
	
	@Override
	public int compareTo(St st) {
		
		return this.getStNum().compareTo(st.getStNum());
	}

	@Override
	public String toString() {
		return "St [stNum=" + stNum + ", name=" + name + ", korean=" + korean + ", math=" + math + ", english="
				+ english + ", amount=" + amount + ", rank=" + rank + "]";
	}
	
	
	
}

class DescAmt implements Comparator<St>{

	@Override
	public int compare(St st1, St st2) {
		
		if(st1.getAmount() > st2.getAmount()) {
			return -1;
		} else if (st1.getAmount() == st2.getAmount()) {
			return new String(st1.getStNum()).compareTo(st2.getStNum())*-1;
		} else {
			return 1;
		}
		
	}
	
}

