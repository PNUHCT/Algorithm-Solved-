import java.io.*;
import java.util.StringTokenizer;

public class no1330 {

    public static void main(String[] args) throws IOException {
        // 콘솔 입력용 리터럴. Scanner와 유사함. 단, Buffer특성과 String으로 고정 형변화이라는 특징으로 조금더 빠를수 있음.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // String 형식의 입력값에서 엔터 기준으로 String값을 내보내주는 역할
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a>b) System.out.println(">");
        else if (a<b) System.out.println("<");
        else System.out.println("==");

    }
}

