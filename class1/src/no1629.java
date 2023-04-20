import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no1629 {

    // 단순 계산법 - 메모리 초과
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        BigInteger A = new BigInteger(st.nextToken());
//        int B = Integer.parseInt(st.nextToken());
//        BigInteger C = new BigInteger(st.nextToken());
//        BigInteger mod = new BigInteger("2147483647");
//        BigInteger result = new BigInteger("1");
//
//
//        while(B-->1) {
//            BigInteger now = result.multiply(A);
//            if(now.compareTo(mod)==-1) {
//                result = now;
//            } else {
//                result = now.mod(C);
//            }
//        }
//        System.out.println(result);
//    }

    // 점화식 - long 사용
//    private static long C;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        long A = Long.parseLong(st.nextToken());
//        long B = Long.parseLong(st.nextToken());
//        C = Long.parseLong(st.nextToken());
//
//        System.out.println(pow(A, B));
//    }
//
//    private static long pow(long A, long exp) {
//        if(exp == 1) return A % C; // 지수가 1일 경우
//
//        long temp = pow(A, exp/2);
//
//        if(exp % 2 == 1) return ((temp * temp % C) * A) % C; // 지수가 홀수일 경우
//
//        return (temp * temp) % C; // 지수가 짝수일 경우
//    }


    // 점화식 - BigInteger 사용
    private static BigInteger C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());
        C = new BigInteger(st.nextToken());

        System.out.println(pow(A, B));
    }

    private static BigInteger pow(BigInteger A, BigInteger exp) {
        if(exp.equals(BigInteger.valueOf(1))) return A.mod(C); // 지수가 1일 경우

        BigInteger temp = pow(A, exp.divide(BigInteger.valueOf(2)));

        if(exp.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(1))) return ((temp.multiply(temp).mod(C)).multiply(A)).mod(C); // 지수가 홀수일 경우

        return (temp.multiply(temp)).mod(C); // 지수가 짝수일 경우
    }
}