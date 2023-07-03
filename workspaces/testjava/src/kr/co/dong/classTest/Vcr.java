package kr.co.dong.classTest;

public class Vcr extends Product{
	String name;
	Vcr(){
		this.name = "VCR";
		this.price = 30;
	}
	
	void play() {
		System.out.println("재생합니다.");
	}
	
	void stop() {
		System.out.println("재생을 멈춥니다.");
	}
	
}
