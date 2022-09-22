package java.Test1;

public class Operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=12, b=9,c=10, d=-6;
		boolean omg=true;
		System.out.println(a++); //12(13)
		System.out.println(--a); //12
		System.out.println(++a); //13
		System.out.println(a--); //13(12)
		System.out.println(~b); // -10
		System.out.println(~a); //-13
		System.out.println(~d); //5
		System.out.println(!omg); //false
		System.out.println(b*d); //-54
		System.out.println(a+b); //21
		System.out.println(a-b); //3
		System.out.println(a/b); //1
		System.out.println(a%b); //3
		
		System.out.println(10<<3); //80 (10*2^3=10*2*2*2=80)
		System.out.println(10<<2); //40 (10*2^2=40)
		System.out.println(10<<4); //160
		System.out.println(10>>2); //2  (10/2^2=10/4=2)
		System.out.println(20>>4); //    (20/2^4=1)
		
		System.out.println(a>b&&b>c); //true&&false = false
		System.out.println(a<b&b<c); //false&true = false
		System.out.println(a++>b&&b>--c); //true&&false = false
		System.out.println(a);
		System.out.println(c);
		System.out.println(++b>c&&a>c); //false&true = false
		System.out.println("the b value is : "+b);
		System.out.println("the c value is : "+c);
		
		System.out.println(a<b|b<c); //false|false=false
		System.out.println(a<b||b>c); //false||true=true
		System.out.println(a>b|b<c); //true|true=true
		
		System.out.println(a);
		a+=4;       
		System.out.println(a); //17
		System.out.println("the b value is : "+b);
		b-=2;
		System.out.println("Arth operator : "+b); //8
		c/=2;
		System.out.println("Arth operator : "+c); //4
		System.out.println(c);
		c%=2;
		System.out.println("Arth operator : "+c); //0
		
	}

}
