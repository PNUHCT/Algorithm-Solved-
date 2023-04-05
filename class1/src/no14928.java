import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no14928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         *  Bigint 클래스 사용시 시간초과 발생
         */
//        BigInteger bigint = new BigInteger(br.readLine());
//        int dev = 20000303;
//        System.out.println(bigint.mod(BigInteger.valueOf(dev)));


        /**
         * 나머지 연산 분배 법칙 사용
         *
         * 예를 들어,
         * 20000303200003032000030320000303200003032000030320000303200003032000030320000303 일 때,
         * 맨 앞자리 2부터 시작해서 20000303마다 나눠짐.
         * 즉, 20000303으로 나눠지는 수가 되면, 나누고 나머지만 남는 형식
         */
        String input = br.readLine(); // 입력 값

        long remainder = 0; // 나머지를 저장할 값
        for(int i = 0 ; i<input.length(); i++) {
            remainder = (remainder * 10 + (input.charAt(i) - '0')) % 20000303;
        }
        System.out.println(remainder);
    }
}