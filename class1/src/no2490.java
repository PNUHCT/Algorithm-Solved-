import java.io.*;
import java.util.*;

public class no2490 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        /**
         * 0은 뒤집힌 것 == true
         * 1은 안 뒤집힌 것 ==  false
         *
         * 0이 1개 도
         * 0이 2개 개
         * 0이 3개 걸
         * 0이 4개 윳
         * 0이 0개 모
         */
        int round = 3;
        while (round-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = 0;

            for (int i = 0; i < 4; i++) if (st.nextToken().equals("0")) cnt++;

            switch (cnt) {
                case 0:
                    System.out.println("E");
                    break;
                case 1:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("C");
                    break;
                case 4:
                    System.out.println("D");
                    break;
            }
        }
    }
}