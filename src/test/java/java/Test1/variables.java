package java.Test1;

public class variables {
	int a=15;  //instance variable
	static int b=5; //static variable
	
	public void sum(int a, int b)
	{
	int c=a+b;
	System.out.println("the value of c is: "+c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		variables obj=new variables();
		obj.sum(5,9);
		System.out.println("the value of b is: "+b);
		System.out.println("the value of a is: "+obj.a);

	}

}
