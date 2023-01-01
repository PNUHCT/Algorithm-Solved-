import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
				
		System.out.println(gdc(a, b));
		System.out.println(lcm(a, b));
	}
	
	static int gdc(int a, int b) { //최대 공약수
		if(a<b) // 유클리드 호제법 조건
		{
			int temp = a;
			a = b;
			b = temp;
		}
		while(b!=0) { // 유클리드 호제법
			int r=a%b;
			a=b;
			b=r;
		}
		return a;
	}
	
	static int lcm(int a, int b) { //최소 공배수
		return a*b / gdc(a,b);
	}
}