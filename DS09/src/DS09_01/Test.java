package DS09_01;

public class Test {
	public static void main(String[] args) {		
		ArrayTest at;
		at = new ArrayTest(10);
			
		System.out.println("생성된 배열 a는 다음과 같습니다.");
		System.out.print("배열의 원소 : ");	at.print();	
			
		
		System.out.println("배열 a에서 3의 배수를 모두 제거합니다.");
		at.removemultiples(3); System.out.print("배열의 크기 : "); at.print();
		System.out.println();
		
		System.out.println("배열 a의 공간을 두 배 확장합니다.");
		System.out.print("배열의 원소 : ");	at.print();
		at.doublelength();
		System.out.print("배열의 원소 : ");	at.print();
	}

}
