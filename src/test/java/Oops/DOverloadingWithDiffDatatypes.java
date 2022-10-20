package Oops;

class colors{
	static int sum(int a, int b) {
		return a+b;
	}
	static double mul(double a, double b) {
		return a*b;
	}
	static int add(char a, char b) {
		return a+b;
	}
	static double sub(float a, float b) {
		return a-b;
	}
}

public class DOverloadingWithDiffDatatypes {

	public static void main(String[] args) {
		System.out.println(colors.sum(3, 4));
		System.out.println(colors.mul(2.43, 3.45));
		System.out.println(colors.sub('d', 'e'));
		System.out.println(colors.add('d', 'e'));
		
		

	}

}
