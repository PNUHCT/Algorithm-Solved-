import java.io.*;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no16953 {
    private static BigInteger A;
    private static BigInteger B;
    private static BigInteger min = BigInteger.valueOf(-1);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A=new BigInteger(st.nextToken());
        B=new BigInteger(st.nextToken());
        BFS();

        System.out.println(min);
    }

    /**
     * Deque 대기열을 이용
     * Node 객체에 변형된 숫자와 연산 수를 담아 순차적으로 처리한다.
     * 이때, Deque에 두 가지 방식의 연산으로 각각 넣어주고 계산 시키는 방식이다.
     * 만약 제일 먼저 목표 숫자에 도달한다면, 연산 횟수 Cnt는 순차적으로 증가해서 들어가는 대기열이므로, 최소값이 되는 원리이다.
     *
     * 단, BigInteger를 사용할 경우, 연산에 사용될 숫자 범위가 제한되지 않으나,
     * 방문체크를 활용한 중복 연산을 방지하는 코드가 들어가질 못하고,
     * BigInteger는 하나의 객체이므로. 타입 변환 과정에 필요한 메모리가 추가되어 메모리 소모가 있다.
     */
    private static void BFS() {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(A, BigInteger.valueOf(1)));

        while(!dq.isEmpty()) {
            Node now = dq.poll();
            if(now.Num.compareTo(B)==0) {
                min = now.Cnt;
                break;
            }

            if(now.Num.compareTo(B) == -1) {
                dq.add(new Node(now.Num.multiply(BigInteger.valueOf(2)), now.Cnt.add(BigInteger.valueOf(1))));

                String nowStr = now.Num + "1";
                BigInteger now1 = new BigInteger(nowStr);
                dq.add(new Node(now1, now.Cnt.add(BigInteger.valueOf(1))));
            }
        }
    }

    /**
     * BFS 대기열에 넣을 객체를 생성해주기 위한 이너클래스
     */
    private static class Node {
        private BigInteger Num;
        private BigInteger Cnt;

        public Node(BigInteger num, BigInteger cnt) {
            this.Num = num;
            this.Cnt = cnt;
        }
    }
}


// 챗 GPT 공식
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int A = Integer.parseInt(input[0]);
//        int B = Integer.parseInt(input[1]);
//
//        int cnt = 0;
//
//        while (true) {
//            if (A == B) { // A와 B가 같은 경우
//                System.out.println(cnt+1); // cnt에 1을 더한 값을 출력
//                break;
//            } else if (B < A) { // B가 A보다 작은 경우, 더 이상 계산이 불가능함
//                System.out.println(-1); // -1 출력
//                break;
//            } else if (B % 2 == 0) { // B가 짝수인 경우, 2로 나눔
//                B /= 2;
//                cnt++;
//            } else if (B % 10 == 1) { // B의 일의 자리가 1인 경우, 1을 제거함
//                B /= 10;
//                cnt++;
//            } else { // B가 2로 나누어지지 않고 일의 자리가 1이 아닌 경우, 더 이상 계산이 불가능함
//                System.out.println(-1); // -1 출력
//                break;
//            }
//        }
//
//        br.close();
//    }
//}