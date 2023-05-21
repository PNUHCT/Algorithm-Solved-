//import java.io.*;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class no12865 {
//    private static int  N, K, W, V;
//    private static List<Things> list = new ArrayList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        // Input 입력 구간
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//
//        for(int i=0; i<N ; i++) {
//            StringTokenizer WV = new StringTokenizer(br.readLine(), " ");
//            W = Integer.parseInt(WV.nextToken());
//            V = Integer.parseInt(WV.nextToken());
//            list.add(new Things(W, V));
//        }
//
//        // list에 저장된 물건들을 가치/무게 순으로 정렬
////         Comparator<Things> compare = Comparator.comparing(Things::getW, Comparator.reverseOrder()).thenComparing(Things::getV, Comparator.reverseOrder());
//        Comparator<Things> compare = Comparator.comparing(Things::getPer);
//        List<Things> sortedList = list.stream().sorted(compare).collect(Collectors.toList());
//
//        List<Integer> results = new ArrayList<>();
//        // Greedy
//        for(int j = 0 ; j<N ; j++) {
//            int remains = K;
//            int sum = 0;
//            int maxVal = 0;
//            for (int i = j; i < N; i++) {
//                int num = remains / (sortedList.get(i).W);
//                sum += num; // 현재 물건의 무게를 더해주고
//                maxVal += num * sortedList.get(i).V;
//                remains -= num * sortedList.get(i).W;
//
//                if (sum == K) break;
//            }
//            results.add(maxVal);
//        }
//        int result = Collections.max(results);
//        System.out.println(result);
//    }
//
//
//    private static class Things {
//        private int W;
//        private int V;
//        private long Per;
//        public Things (int w, int v) {
//            this.W = w;
//            this.V = v;
//            this.Per = v/w;
//        }
////        public long getW() {return this.W;}
////        public long getV() {return this.V;}
//        public long getPer() {return this.Per;}
//    }
//}

import java.io.*;
import java.util.StringTokenizer;

public class no12865 {
    private static int N, K;
    private static int[] W, V, DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 구간
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        W = new int[N + 1];
        V = new int[N + 1];
        DP = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        // DP 연산 구간
        for (int i = 1; i <= N; i++) {
            for (int j = K; j - W[i] >= 0; j--) {
                DP[j] = Math.max(DP[j], DP[j - W[i]] + V[i]);
            }
        }

        // 출력
        System.out.println(DP[K]);
    }
}