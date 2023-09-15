import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no1837 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * A : 두 소수의 곱으로 이루어진 수
     * K : 비교할 수
     *
     * A를 인수분해하여,
     * 1. 둘다 K보다 크면 'GOOD'
     * 2. 둘중 하나라도 K보다 작으면 'BAD'와 '둘중_더_작은_소수'를 출력
     */
    // BigInteger 방법 2번째 : 성공
    private static BigInteger ORG, K, NUM;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ORG = new BigInteger(st.nextToken());
        K = new BigInteger(st.nextToken());
        NUM = new BigInteger("2");

        while (true) {
            if( NUM.compareTo(K) == 1 || NUM.compareTo(K) == 0 ) {
                System.out.println("GOOD");
                break;
            }

            NUM = NUM.add(BigInteger.ONE);

            if(ORG.remainder(NUM).compareTo(BigInteger.ZERO) == 0 && NUM.compareTo(K) == -1) {
                System.out.println("BAD " + NUM);
                break;
            }
        }
    }


//    일반 int 사용 : 오버플로우 발생
//    private static int A, K;
//    public static void main(String[] args) throws IOException {
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        A = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//        int increase = 2;
//        int sol = 0;
//        while(true) {
//            if(A%increase==0) {
//                sol = A/increase;
//                break;
//            }
//            increase++;
//        }
//
//        if (increase<K || sol<K) System.out.println(String.format("BAD %d", Math.min(increase, sol)));
//        else System.out.println("GOOD");
//    }

//    BigInteger 사용 : 시간초과
//    public static void main(String[] args) throws IOException {
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        BigInteger A = new BigInteger(st.nextToken());
//        BigInteger K = new BigInteger(st.nextToken());
//        BigInteger increase = new BigInteger("2");
//        BigInteger sol = new BigInteger("0");
//        BigInteger zero = new BigInteger("0");
//        while(true) {
//            if(A.mod(increase).equals(zero)) {
//                sol = A.divide(increase);
//                break;
//            }
//            increase = increase.subtract(new BigInteger("-1"));
//        }
//        BigInteger answer = increase.compareTo(sol) == -1 ? increase : sol;
//        if (increase.compareTo(K) == -1 || sol.compareTo(K) == -1) System.out.println(String.format("BAD %d", answer));
//        else System.out.println("GOOD");
//    }
}