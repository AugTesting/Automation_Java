package ControlStatements;

public class nestedswitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char letter='h';
		int values=2;
		switch(values) {
		case 1:
			System.out.println("a,b,c");
			break;
		case 2: 
			switch(letter) {
			case 'a':
				System.out.println("animals");
				break;
			case 'b':
				System.out.println("birds");
				break;
			case 'c':
				System.out.println("cats");
				break;	
			default:{
				System.out.println("not matched");
			}
			}
		case 3:
			switch(letter) {
			case 'g':
				System.out.println("grass");
				break;
			case 'h':
				System.out.println("house");
				break;
			default:{
				System.out.println("matched");
			}
			}
		}
		
	}

}
