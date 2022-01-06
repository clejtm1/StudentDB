
public class Output {

	private int a1;
    private int b2;
    private int c;
    private int d;
	static int s=0;	
	    public Output(int d1)
	    {
			
	        a1=0;
	        b2=0;
	        d=d1;
	        s++;
	    }
		// TODO Auto-generated constructor stub
	     
	    public int summation(int a,int b){
	    	a1=a;
	    	b2=b;
	        c=a1+b2;

	        return c; //return type "int".
	    }
	    public void setNum(int d1)
	    {
	    	d=d1;
	    }
	    public int getNum() 
	    {
	    	return d;
	    }
	    //tells us how many Output objects created (but not neccisarily how many exist because an object can be created and destroyed if dereferenced)
	    public static int getNumofOutputsCreated() 
	    {
	    	return s;
	    }

}
