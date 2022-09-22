package ControlStatements;

public class ifelseifladder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int age=50;
    if(age<25) {
    	System.out.println("not elible");
     }else if(age>=30 && age<40){
    	System.out.println("section A");
    }else if(age>40 && age<=50) {
    	System.out.println("section B");
    }else if(age>50 && age<60) {
    	System.out.println("section C");
    }else if(age>=60 && age<70) {
    	System.out.println("section D");
    }else {
    	System.out.println("section E");
    }
	}

}
