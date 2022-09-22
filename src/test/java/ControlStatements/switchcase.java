package ControlStatements;

public class switchcase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fruit=5;
		switch (fruit) {
		case 1:
		System.out.println("apple");
		case 2:
			System.out.println("banana");
		case 3:
			System.out.println("orange");
		case 4:
			System.out.println("pineapple");
		case 5:
			System.out.println("strawberry");
			break;
		case 6:
			System.out.println("grapes");
		}
		System.out.println("------------------------------------");
		char ch= 'p';
		switch(ch) {
		case 'a':
			System.out.println('a');
			break;
		case 'p':
			System.out.println('p');
			break;
		case 'b':
			System.out.println('b');
		case 'l':
			System.out.println('l');
			break;
		case 'e':
			System.out.println('e');
		
		}

	}

}
