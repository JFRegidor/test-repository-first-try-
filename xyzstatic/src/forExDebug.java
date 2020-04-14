
public class forExDebug {
	

static int i=0;
static int variable=0;
	
	public static void main(String[] args) {
	
				
	while (i<10) {
			variable = i+1;
			System.out.print(i);
			i= suma(i);
			System.out.print(i);
		}
	i=100;
	System.out.print(i);
	}
	
	
	static int suma (int j) {
		j=j+1;
		return  j;
		
	}

}
