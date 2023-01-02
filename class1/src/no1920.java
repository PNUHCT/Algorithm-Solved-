import java.io.*;
import java.util.*;

public class no1920 {
/* Set 사용 */
    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> setN = new HashSet<>();
        StringTokenizer stst = new StringTokenizer(br.readLine(), " ");
        for(int i =0 ; i<N ; i++) setN.add(stst.nextToken());

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(M-->0) {
            String str = st.nextToken();
            if(setN.contains(str)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);

    }

/* 시간초과 : ArrayList 사용 방식 */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        ArrayList<String> listN = new ArrayList<>();
//        StringTokenizer stst = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < N; i++) listN.add(stst.nextToken());
//
//        int M = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        while(M-->0) {
//            String str = st.nextToken();
//            if(listN.contains(str)) {
//                bw.write("1"+"\n");
//            } else {
//                bw.write("0"+"\n");
//            }
//        }
//        bw.close();
//    }



/* 시간초과 : 이중for문 사용 방식 */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        br.readLine();
//        String[] arrN = br.readLine().split(" ");
//        int M = Integer.parseInt(br.readLine());
//        boolean tf = false;
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < M; i++) {
//            String X = st.nextToken();
//            for (int j = 0; j < arrN.length; j++) {
//                if (X.equals(arrN[j])) {
//                    bw.write("1" + "\n");
//                    tf = true;
//                    break;
//                }
//            }
//            if(tf== false) {
//                bw.write("0" + "\n");
//            } else {
//                tf = false;
//            }
//        }
//
//        bw.close();
//    }
}

