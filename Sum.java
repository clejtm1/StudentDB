
public class Sum {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Output o1=new Output(1);
		Output o2=new Output(5);
		System.out.println("Number of Output Objects Created:"+Output.getNumofOutputsCreated());
		o1=o2;
		System.out.println("o1 d:"+o1.getNum());
		System.out.println("o2 d:"+o2.getNum());
		o1.setNum(7);
		System.out.println("o1 d:"+o1.getNum());
		System.out.println("o2 d:"+o2.getNum());
		String a="Hello";
		String b="World";
		
		a=b;
		b="ssssss";
		System.out.println("o1 d:"+o1.getNum());
		System.out.println("a"+a);
		System.out.println("b"+b);
		System.out.println("Number of Output Objects Created:"+Output.getNumofOutputsCreated());
		
	}

}
