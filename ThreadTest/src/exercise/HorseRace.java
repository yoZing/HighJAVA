package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorseRace {

  static int rank = 1;

  public static void main(String[] args) {
    List<Horse> horseList = new ArrayList<>();

    horseList.add(new Horse("1번말 "));
    horseList.add(new Horse("2번말 "));
    horseList.add(new Horse("3번말 "));
    horseList.add(new Horse("4번말 "));
    horseList.add(new Horse("5번말 "));
    horseList.add(new Horse("6번말 "));
    horseList.add(new Horse("7번말 "));
    horseList.add(new Horse("8번말 "));
    horseList.add(new Horse("9번말 "));
    horseList.add(new Horse("10번말"));

    for (Horse horse: horseList) {
      horse.start();
    }

    for (Horse horse: horseList) {
      try {
        horse.join();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }

    System.out.println("경기 끝...");
    System.out.println("---------------");
    System.out.println();
    System.out.println("경기 결과");

    Collections.sort(horseList);

    for (Horse horse: horseList) {
      System.out.println(horse.getRank() + "등 : " + horse.getHorseName());
    }
  }

}

class Horse extends Thread implements Comparable<Horse>{
  private final String horseName;
  private int rank;

  public Horse(String name) {
    this.horseName = name;
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

  @Override
  public void run() {
    for(int i=0; i<=50; i++) {
      System.out.print(horseName + "번말 ");
      for(int k=0; k<i; k++) {
        System.out.print("-");
      }
      System.out.print(">");
      for(int j=50; j>i; j--) {
        System.out.print("-");
      }
      System.out.println();
      try {
        Thread.sleep((int)(Math.random() * 301 + 200));
      } catch(InterruptedException ex) {
        ex.printStackTrace();
      }
    }
    
    System.out.println(horseName + "도착.");
    setRank(HorseRace.rank);
    HorseRace.rank++;
  }

  @Override
  public int compareTo(Horse horse) {
    if (rank > horse.rank) {
      return 1;
    } else {
      return -1;
    }
  }

}