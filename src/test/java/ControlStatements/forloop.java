package ControlStatements;

public class forloop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ch= {'q','w','e','r','t','y'};
		for(int i=1;i<=10;i++)
		{
			System.out.println(i);
		}
		for(char c:ch) {
			System.out.println(c);
			if(c=='r') {
				System.out.println("identified character r ");
				break;
			}
		}
        for(int j=1;j<=ch.length;j++)
        {
        	System.out.println(j);
        	if(j=='t') {
        		System.out.println("identified character t ");
        		break;
        	}
        		
        }
	}

}
