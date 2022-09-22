package ControlStatements;

public class enumswitch {
	public enum month{jan,feb,mar,apr,may,sunday,june,july,aug}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		month[] enumarray=month.values();
	//	int[] intarray= {4,5,6,7};
		for(month individualmonth:enumarray) {
			switch(individualmonth) {
			case jan:
				System.out.println("this is january");
				break;
			case feb:
				System.out.println("this is feburary");
				break;
			case mar:
				System.out.println("this is march");
				break;
			case apr:
				System.out.println("this is april");
				break;
			case may:
				System.out.println("this is may");
				break;
			case june:
				System.out.println("this is june");
				break;
			case july:
				System.out.println("this is july");
				break;
			case aug:
				System.out.println("this is august");
				break;
		    default:
		    	System.out.println("default");
		    	break;
			}
		}

	}

}
