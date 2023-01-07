import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int N = Integer.parseInt(str);
        int result = 0;

        // i 는 가능한 최솟값인 N - 9 * N의 각 자릿수부터 시작
        for(int i = (N - (str.length() * 9)); i < N; i++) {
            int number = i;
            int sum = 0;	// 각 자릿수 합 변수

            while(number != 0) {
                sum += number % 10;	// 각 자릿수 더하기
                number /= 10;
            }

            // i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
            if(sum + i == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);


        // --로 구하는 방법(비추) --------------------
//        int T = Integer.parseInt(br.readLine());
//        String strT = String.valueOf(T);
//        int num = 1;
//        int result = 0;
//        while(true) {
//            int base = T-num;
//            if(base==0) {
//                break;
//            }
//            String baseStr = String.valueOf(base);
//            if(strT.length()>=3 && baseStr.length()<=strT.length()-1) break;
//            ArrayList<Integer> list = new ArrayList<>();
//            for(int i=0;i< baseStr.length();i++) list.add(Character.getNumericValue(baseStr.charAt(i)));
//            for(int i=0;i< list.size();i++) base += list.get(i);
//            if(base==T) {
//                result = Integer.parseInt(baseStr);
//            }
//            num++;
//        }
//        System.out.println(result);
    }
}

