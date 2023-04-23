import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no16953 {
    private static int A;
    private static int B;
    private static int min = -1;
    // https://www.acmicpc.net/problem/16953
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        BFS();

        System.out.println(min);
    }

    private static void BFS() {
        Deque<Node> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[1000000001];
        dq.add(new Node(A, 0));
        visited[A] = true;

        while(!dq.isEmpty()) {
            Node now = dq.poll();
            if(now.Num==B) min = now.Cnt;
            else if(!visited[now.Num]) {
                dq.add(new Node(now.Num * 2, now.Cnt + 1));
                visited[now.Num*2] = true;

                String nowStr = now.Num + "1";
                int now1 = Integer.parseInt(nowStr);
                dq.add(new Node(now1, now.Cnt+1));
                visited[now1] = true;
            }
        }
    }

    private static class Node {
        private int Num;
        private int Cnt;

        public Node(int num, int cnt) {
            this.Num = num;
            this.Cnt = cnt;
        }
    }
}


// 챗 GPT 공식
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//
//public class no16953 {
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