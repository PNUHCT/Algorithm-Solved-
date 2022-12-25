import java.io.*;
import java.util.*;

public class no1008 {
//    // 풀이1. buffer사용
//    public static void main(String[] args) throws IOException {
//        // 콘솔 입력용 리터럴. Scanner와 유사함. 단, Buffer특성과 String으로 고정 형변화이라는 특징으로 조금더 빠를수 있음.
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        // 콘솔 출력용 리터럴. system.out.println과 유사하므로 필요에 따라 바꿔가면서 사용.
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        // 테스트 케이스 수
////        int T = Integer.parseInt(br.readLine());
//
////        for(int i=0; i<T ; i++) {
//            // String 형식의 입력값에서 delim(띄워쓰기) 기준으로 String 값을 내보내주는 역할
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//            Double a = Double.valueOf(st.nextToken());
//            Double b = Double.valueOf(st.nextToken());
//
//            bw.write(""+a/b);
////        }
//
//        //        bw.flush(); // stream을 flush 함. 프로세스를 닫지 않고 용량제어시 사용
//        bw.close();  // stream을 flush 하고, stream을 닫음
//    }

//     풀이2. sout사용: 더 빠름
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Double a = Double.valueOf(st.nextToken());
        Double b = Double.valueOf(st.nextToken());

        System.out.println(a/b);
    }

//    // 풀이3. sout + scanner 사용: 제일 느림
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
//        Double a = Double.valueOf(st.nextToken());
//        Double b = Double.valueOf(st.nextToken());
//
//        System.out.println(a/b);
//    }

}