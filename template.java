import java.io.*;
import java.util.*;

public class template {

    public static void main(String[] args) throws IOException {
        // 콘솔 입력용 리터럴 & 콘솔 출력용 리터럴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String 형식의 입력값에서 엔터 기준으로 String값을 내보내주는 역할
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        //        bw.flush(); // stream을 플러쉬 함
        bw.close();  // stream을 플러쉬 하고, stream을 닫음
    }
}

