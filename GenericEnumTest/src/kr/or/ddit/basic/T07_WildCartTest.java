package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class T07_WildCartTest {
	
	/*
	 *  장바구니 항목 조회를 위한 메서드(모든항목)
	 */
//	public static void displayCartItemInfo(Cart<?> cart) {
		public static <T> void displayCartItemInfo(Cart<T> cart) {
		System.out.println("= 장바구니 항목 리스트= ");
		for (T obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("-----------------------------");
	}
	
	/*
	 *  장바구니 항목 조회를 위한 메서드(음료나 그 하위항목)
	 */
//	public static void displayCartItemInfo2(Cart<? extends Drink> cart) {
		public static <T extends Drink> void displayCartItemInfo2(Cart<T> cart) {
		System.out.println("= 장바구니 항목 리스트= ");
		for (Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("-----------------------------");
	}
		
	
	/*
	 *  장바구니 항목 조회를 위한 메서드(고기항목이나 그 상위항목)
	 */
	public static void displayCartItemInfo3(Cart<? super Meat> cart) {
		System.out.println("= 장바구니 항목 리스트= ");
		for (Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("-----------------------------");
	}
	
	public static void main(String[] args) {
		
		Cart<Food> foodCart = new Cart<>();
		foodCart.addItem(new Meat("돼지고기", 5000));
		foodCart.addItem(new Meat("소고기", 20000));
		foodCart.addItem(new Juice("오렌지쥬스", 1000));
		foodCart.addItem(new Coffee("아메리카노", 2000));
		
		Cart<Meat> meatCart = new Cart<>();
		meatCart.addItem(new Meat("돼지고기", 5000));
		meatCart.addItem(new Meat("소고기", 20000));
		
		Cart<Drink> drinkCart = new Cart<>();
		drinkCart.addItem(new Juice("오렌지쥬스", 1000));
		drinkCart.addItem(new Coffee("아메리카노", 2000));
		
		displayCartItemInfo(foodCart);
		displayCartItemInfo(meatCart);
		displayCartItemInfo(drinkCart);
		
//		displayCartItemInfo2(foodCart);
//		displayCartItemInfo2(meatCart);
		displayCartItemInfo2(drinkCart);
		
		displayCartItemInfo3(foodCart);
		displayCartItemInfo3(meatCart);
//		displayCartItemInfo3(drinkCart);
	}

}

class Food {
	private String name; // 음식이름
	private int price;   // 음식가격
	public Food(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name + "(" + this.price + "원)";
	}
	
	
}

// 고기
class Meat extends Food {
	

	public Meat(String name, int price) {
		super(name, price);
	}
}

// 음료
class Drink extends Food {

	public Drink(String name, int price) {
		super(name, price);
	}
}

// 쥬스
class Juice extends Drink {

	public Juice(String name, int price) {
		super(name, price);
	}
}

// 커피
class Coffee extends Drink {

	public Coffee(String name, int price) {
		super(name, price);
	}
}

/*
 *   장바구니
 */

class Cart<T> {
	private List<T> list = new ArrayList<>();

	public List<T> getList() {
		return list;
	}
	
	public void addItem(T item) {
		list.add(item);
	}
}

