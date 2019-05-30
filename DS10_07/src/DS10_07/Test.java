package DS10_07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.xml.soap.Text;

public class Test {
	public static void main(String[] args) {
		linearSearchHash ls = new linearSearchHash(11, 0.75);
		SquareSearchHash ss = new SquareSearchHash(11, 0.75);
		DoubleSearchHash ds = new DoubleSearchHash(11, 0.75);
		try {
			BufferedReader br = new BufferedReader(new FileReader("text.txt"));
			while(br.ready()) { //파일에 읽을 수 있는 데이터가 남아있는 지 확인
				String line = br.readLine(); //파일에서 데이터를 한 줄 읽음
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				while(parser.hasMoreTokens()) {//parser에 token이 남아 있는지 확인
					ls.add(parser.nextToken());
				}
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("text.txt"));
			while(br.ready()) { //파일에 읽을 수 있는 데이터가 남아있는 지 확인
				String line = br.readLine(); //파일에서 데이터를 한 줄 읽음
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				while(parser.hasMoreTokens()) {//parser에 token이 남아 있는지 확인
					ss.add(parser.nextToken());
				}
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("text.txt"));
			while(br.ready()) { //파일에 읽을 수 있는 데이터가 남아있는 지 확인
				String line = br.readLine(); //파일에서 데이터를 한 줄 읽음
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				while(parser.hasMoreTokens()) {//parser에 token이 남아 있는지 확인
					ds.add(parser.nextToken());
				}
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		System.out.println("선형조사의 충돌횟수 : "+ls.crash+" 제곱조사의 충돌횟수 : "+ss.crash+" 이중조사의 충돌횟수 : "+ds.crash);
		System.out.println("각 테이블에서 다음 단어들의 값 : < America, answer, where, disabled, believed >");
		System.out.println("America : 선형조사("+ls.get("America")+"), 제곱조사("+ss.get("America")+"), 이중해싱("+ds.get("America")+")");
		System.out.println("answer : 선형조사("+ls.get("answer")+"), 제곱조사("+ss.get("answer")+"), 이중해싱("+ds.get("answer")+")");
		System.out.println("where : 선형조사("+ls.get("where")+"), 제곱조사("+ss.get("where")+"), 이중해싱("+ds.get("where")+")");
		System.out.println("disabled : 선형조사("+ls.get("disabled")+"), 제곱조사("+ss.get("disabled")+"), 이중해싱("+ds.get("disabled")+")");
		System.out.println("believed : 선형조사("+ls.get("believed")+"), 제곱조사("+ss.get("believed")+"), 이중해싱("+ds.get("believed")+")");
		
		
	}
	
}
