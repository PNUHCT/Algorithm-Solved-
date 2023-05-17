import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine(); // 비교할 숫자형 문자열 : 어차피 문자열 대 문자열 비교가 가능하기 때문에 int 형변환에 의한 메모리를 최소화
        StringTokenizer st = new StringTokenizer(br.readLine()); // 주차한 차량번호들을 하나씩 뱉어줄 Tokenizer
        int cnt = 0; // 위반한 차량을 세어줄 int
        for(int i=0; i<5 ; i++) if(st.nextToken().equals(num)) cnt++; // 주어진 조건은 5개이므로 5번만 반복

        System.out.println(cnt);
    }
}