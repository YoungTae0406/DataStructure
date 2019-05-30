package DS10_09;

public class Test {
	public static void main(String[] args) {
		//Func(17);
		Func(13);
		System.out.println();
		Func2(17,0);
	}
	
	public static void Func(int i) {
		int m, n;
		if(i/2==0) {
			m=i%2;
			System.out.print(m);
		}
		if(i/2>0) {
			n=i/2;
			m=i%2;
			Func(n);
			System.out.print(m);
		}
		
	}
	public static void Func2(int i, int count) {
		int m, n;
		if(i/2==1) {
			count++;
			System.out.println(count);
		}
		if(i/2>1) {
			n=i/2;
			count++;
			Func2(n,count);
		}
	}
	
	
}
