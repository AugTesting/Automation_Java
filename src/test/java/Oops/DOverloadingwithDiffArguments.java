package Oops;


class Polymorphism {
	static int sum(int a, int b) {
		return a+b;
	}


		static int sum(int a, int b,int c) {
			return a*b*c;
		}
}
	public class DOverloadingwithDiffArguments {
	public static void main(String[] args) {
	
	System.out.println(Polymorphism.sum(2, 4, 3));
	System.out.println(Polymorphism.sum(4, 5));
	

	}

}
