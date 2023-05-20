import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * N가지의 물건이 주어진다. (1<=N<=100)
 * 각 물건은 서로다른 무게(W)와 가치(V)가 주어진다. (1<=W<=100000) , (1<=V<=1000)
 * 무게 K를 채우는 가치의 최대합을 구하라. (1<=K<=100000)
 */
public class no12865 {
    private static int  N, K, W, V;
    private static List<Things> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input 입력 구간
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N ; i++) {
            StringTokenizer WV = new StringTokenizer(br.readLine(), " "); 
            W = Integer.parseInt(WV.nextToken());
            V = Integer.parseInt(WV.nextToken());
            list.add(new Things(W, V));
        }

        // list에 저장된 물건들을 가치/무게 순으로 정렬
        // Comparator<Things> compare = Comparator.comparing(Things::getW, Comparator.reverseOrder()).thenComparing(Things::getV, Comparator.reverseOrder());
        Comparator<Things> compare = Comparator.comparing(Things::getPer);
        List<Things> sortedList = list.stream().sorted(compare).collect(Collectors.toList());


        // Greedy
        int remains = K;
        int sum = 0;
        int maxVal = 0;
        for(int i=0; i<N ; i++) {
            int num = remains/(sortedList.get(i).W);
            sum += num; // 현재 물건의 무게를 더해주고
            maxVal += num * sortedList.get(i).V;
            remains -= num * sortedList.get(i).W;

            if(sum==K) break;
        }

        System.out.println(maxVal);
    }


    private static class Things {
        private int W;
        private int V;
        private long Per;
        public Things (int w, int v) {
            this.W = w;
            this.V = v;
            this.Per = v/w;
        }
        public long getW() {return this.W;}
        public long getV() {return this.V;}
        public long getPer() {return this.Per;}
    }
}

