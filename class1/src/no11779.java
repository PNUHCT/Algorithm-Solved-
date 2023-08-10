import java.io.*;
import java.util.*;

public class no11779 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int city_amount, bus_amount, min;
    private static Integer[][] map;
    private static StringTokenizer st;
    private static List<Integer> via;

    public static void main(String[] args) throws IOException {

        city_amount = Integer.parseInt(br.readLine());
        bus_amount = Integer.parseInt(br.readLine());

        map = new Integer[city_amount+1][city_amount+1];
        for(int i = 0; i< bus_amount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = cost;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 결과 입력용 변수 초기화
        min = Integer.MAX_VALUE;
        via = new ArrayList<>();

        dijkstra(A, B);

        bw.write("" + min + "\n");
        bw.write("" + via.size() + "\n");
        for(Integer city : via) bw.write("" + city + " ");

        bw.close();
    }

    private static void dijkstra (int A, int B) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        for(int i = 1 ; i <= city_amount ; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(A);
            list.add(i);
            if(map[A][i]!=null) pq.add(new Node(i, map[A][i], list));
        }


        while(!pq.isEmpty()) {
            Node now = pq.poll();
            ArrayList<Integer> list = now.list;

            if(now.city==B) {
                min = Math.min(min,now.cost);
                via = list;
                break;
            }

            for(int i=1 ; i<= city_amount ; i++) {
                if(map[now.city][i]!=null) {
                    ArrayList<Integer> now_list = new ArrayList<>();
                    now_list.addAll(list);
                    now_list.add(i);
                    pq.add(new Node(i, now.cost+map[now.city][i], now_list));
                }
            }
        }
    }

    private static class Node {
        private int city, cost;
        private  ArrayList<Integer> list;
        public Node (int city, int cost, ArrayList<Integer> list) {
            this.city = city;
            this.cost = cost;
            this.list = list;
        }
    }
}

