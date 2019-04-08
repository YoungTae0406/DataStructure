package DS09_04;

public class Test {
	public static void main(String[] args) {
		Object indexTemp01[] = new Object[10]; //인덱스번호 
		Object indexTemp02[] = new Object[10];
		int j=0;	int k=0;
		String h;
		MyLinkedStack mLS = new MyLinkedStack(); 
		MyLinkedStack index01 = new MyLinkedStack();
		MyLinkedStack index02 = new MyLinkedStack();
		
		for(int u=0;u<args.length;u++) { //args 인덱스 바꾸기
			System.out.println(args[u]);
			if(mLS.isTrue(args[u])) {
				System.out.println("괄호가 맞지 않습니다.");
				continue;
			}
			for(int i=0;i<args[u].length();i++) {
				char[] temp = new char[args[u].length()];
				temp[i] = args[u].charAt(i);
				if(temp[i]=='(') {
					h = Character.toString(temp[i]);
					mLS.push(h);
					index01.push(i);

				}
				if(temp[i]==')') {

					if(mLS.peek().equals("(")) {
						indexTemp01[j] = index01.pop();
						j++;
						
						index02.push(i);
						indexTemp02[k] = index02.pop();
						k++;
					
						mLS.pop();
					}
				}
			}
			for(int m=0;m<indexTemp02.length;m++) {
				if(indexTemp01[m]!=null) {
					System.out.print(indexTemp01[m]+", ");
				}
				if(indexTemp02[m]!=null) {
					System.out.print(indexTemp02[m]+"\n");
				}
			}
			j=0; k=0;
			System.out.println("괄호쓰기가 맞음");
		}	
	}
}
