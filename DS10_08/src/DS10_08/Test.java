package DS10_08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		HashTable ht = new HashTable(11, 0.75);
		int valueline = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("text.txt"));
			while(br.ready()) { //파일에 읽을 수 있는 데이터가 남아있는 지 확인
				String line = br.readLine(); //파일에서 데이터를 한 줄 읽음
				valueline++;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				while(parser.hasMoreTokens()) {
					ht.add(parser.nextToken(), Integer.toString(valueline));
				}
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("America의 value 값 : "+ht.get("America"));
		System.out.println("answer의 value 값: "+ht.get("answer"));
		System.out.println("where의 value 값: "+ht.get("where"));
		System.out.println("disabled의 value 값: "+ht.get("disabled"));
		System.out.println("believed의 value 값: "+ht.get("believed"));
		System.out.println("we의 value 값: "+ht.get("we"));
		System.out.println("We의 value 값: "+ht.get("We"));
		System.out.println("free의 value 값: "+ht.get("free"));
		
		
	}

}
