package kr.co.dong.classTest;

public class Product {
	int price;
	int point =(int) (price * 0.1);
	String name;
	
	Product(){
		this.price = 0;
		this.point = 0;
	}
	
	Product(int a){
		this.price = a;
		this.point = (int)(price * 0.1);
	}
	
	void power() {
		/* Àü¿øÀ» ²°´Ù Å³²¨¾ß */
	}
	
}
