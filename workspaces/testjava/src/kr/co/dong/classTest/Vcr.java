package kr.co.dong.classTest;

public class Vcr extends Product{
	String name;
	Vcr(){
		this.name = "VCR";
		this.price = 30;
	}
	
	void play() {
		System.out.println("����մϴ�.");
	}
	
	void stop() {
		System.out.println("����� ����ϴ�.");
	}
	
}
