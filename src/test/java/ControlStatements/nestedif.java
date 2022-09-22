package ControlStatements;

public class nestedif {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value=30;
		int price=50;
		if(value>=20) {
			if(price>60) {
				System.out.println("product available");
			}else {
				System.out.println("product not available");
			}
	}else {
		System.out.println("out of stock");
	}
	}
	}
