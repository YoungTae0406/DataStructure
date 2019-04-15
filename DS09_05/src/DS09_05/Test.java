package DS09_05;

import java.util.Random;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		//시간 t가 x의 배수일 때...
		Scanner sc = new Scanner(System.in);
		int mean;	int x ;
		System.out.println("지수분표평균과 배수 x를 입력하세요");
		mean = sc.nextInt(); x = sc.nextInt();
		ExponentialRandom ER = new ExponentialRandom(mean);
		SLinkedQueue myQ01 = new SLinkedQueue();
		SLinkedQueue myQ02 = new SLinkedQueue();
		int tempTime=1;	int id=0;
		int timeRandom = ER.nextInt();
		tempTime += timeRandom;
		
		for(int i=1;i<101;i++) { //랜덤한 시간 간격
			if(tempTime==i) {// 객체 생성
				timeRandom = ER.nextInt();
				tempTime += timeRandom;
				if(myQ01.size() == myQ02.size()) {
					id++;
					arrivalClient aC = new arrivalClient(id);
					
					myQ01.add(aC);
					System.out.println("Time : "+ i + " Service "+id+" arrived."
							+ "Inserted Queue 0.");
					continue;
				}
				if(myQ01.size() > myQ02.size()) {
					id++;
					arrivalClient aC2 = new arrivalClient(id);
					
					myQ02.add(aC2);
					System.out.println("Time : "+ i + " Service "+id+" arrived."
							+ "Inserted Queue 1.");
					continue;
				}
				if(myQ01.size() < myQ02.size()){
					id++;
					arrivalClient aC = new arrivalClient(id);
					
					myQ01.add(aC);
					System.out.println("Time : "+ i + " Service "+id+" arrived."
							+ "Inserted Queue 0.");
					continue;
				}
			}
				
			if(i%x==0) {//첫 번째 큐에서 삭제
				if(myQ01.empty()) continue;
				else {
					System.out.println("Time : "+ i +" Service ID : "+myQ01.remove().toString()+" removed Queue ID : 0");
					
				}
					
			}if(i%x!=0) {//두 번째 큐에서 삭제, 프린트
				if(myQ02.empty()) continue;	
				else {System.out.println("Time : "+ i +" Service ID : "+myQ02.remove().toString()+" removed Queue ID : 1");//다시 생각
				 
				 }
			}
		}//for문 끝
		System.out.println("Queue 0에 원소가 "+myQ01.size()+"개 남아 있습니다.");
		System.out.println("Queue 1에 원소가 "+myQ02.size()+"개 남아있습니다.");
		
	}
}
