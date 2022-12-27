import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 콘솔 입력용 리터럴. Scanner와 유사함. 단, Buffer특성과 String으로 고정 형변화이라는 특징으로 조금더 빠를수 있음.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 콘솔 출력용 리터럴. system.out.println과 유사하므로 필요에 따라 바꿔가면서 사용.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T ; i++) {

        }

        // String 형식의 입력값에서 엔터 기준으로 String값을 내보내주는 역할
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

//        bw.write(""+"\n");

        //        bw.flush(); // stream을 flush 함. 프로세스를 닫지 않고 용량제어시 사용
        bw.close();  // stream을 flush 하고, stream을 닫음
    }
}

