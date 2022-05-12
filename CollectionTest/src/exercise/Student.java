package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Student implements Comparable<Student> {
	public static void main(String[] args) {
		
		List<Student> studentList = new ArrayList<Student>();
		
		 studentList.add(new Student("3333", "성춘향", 87, 85, 79 ));
		 studentList.add(new Student("4444", "이순신", 87, 96, 74 ));
		 studentList.add(new Student("2222", "변학도", 86, 94, 77 ));
		 studentList.add(new Student("1111", "홍길동", 77, 86, 94 ));
	     studentList.add(new Student("5555", "강감찬", 67, 87, 84 ));
	     studentList.add(new Student("6666", "일지매", 87, 76, 97 ));
	     System.out.println("학번의 오름차순 정렬");
	     Collections.sort(studentList);
	     for (Student num : studentList) {
	    	System.out.println(num);
		}
	     
	     Collections.sort(studentList, new AmountDesc());
	     
	     System.out.println("총점의 역순 정렬");
	     for (Student amt : studentList) {
			System.out.println(amt);
		}
	}
   
	String studentNum;
	String name;
	int korean;
	int english;
	int math;
	int amount;
	int rank;
	
	public Student(String studentNum, String name, int korean, int english, int math) {
		super();
		this.studentNum = studentNum;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.amount = korean + english + math;
	}
	
	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
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

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
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

	@Override
	public String toString() {
		return "Student [studentNum=" + studentNum + ", name=" + name + ", korean=" + korean + ", english=" + english
				+ ", math=" + math + ", amount=" + amount + ", rank=" + rank + "]";
	}
	
	@Override
	public int compareTo(Student num) {
		return this.getStudentNum().compareTo(num.getStudentNum());
	}
	
	
	
	
}

class AmountDesc implements Comparator<Student> {

	public int compare(Student amt1, Student amt2) {
		if(amt1.getAmount() > amt2.getAmount()) {
			return -1;
		} else if(amt1.getAmount() == amt2.getAmount()) {
			return new String(amt1.getStudentNum())
					.compareTo(amt2.getStudentNum())*-1;
		} else {
			return 1;
		}
		
	}
	
}
	

	
	


