import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no17144 {

    // https://www.acmicpc.net/problem/17144
    /**
     * 1.미세먼지 확산
     *  1-1) 각 칸을 객체화 : 기존 값, 새로 확산으로 추가된 값을 구분해서 가짐
     *  1-2) 각 칸을 순차적으로 순회하며, (1차 순회)
     *       기존값 노드 조회
     *       -> 확산 가능한 칸을 조회하여 새로 확산된 양에 확산 저장
     *       -> 확산시킨 총량 임시저장
     *       -> 기존량 - 확산총량을 기존량에 저장
     *  1-3) 재순회 하면서,
     *       -> 기존량에 확산량 합산
     *       -> 확산량을 0으로 초기화
     *
     * 2.공기 청정으로 미세먼지 이동
     *  2-1) 공청기 윗칸에 해당하는 경우,
     *       -> 해당칸에서 우 => 상 => 좌 => 하 => 우 순회하며 기존값 밀어내기
     *  2-2) 공청기 윗칸에 해당하는 경우,
     *       -> 해당칸에서 우 => 하 => 좌 => 상 => 우 순회하며 기존값 밀어내기
     *
     * 3. 이 모든 과정을 T만큼 반복
     *
     * 4. T만큼 반복 후, 맵을 순회하며, 각 칸의 기존값 합산
     */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int R, C, T, val;
    private static ArrayList<ArrayList<Node>> map;
    private static StringTokenizer st;
    private static int[] hor = {-1,1,0,0};
    private static int[] ver = {0,0,-1,1};
    private static int headY, headX, tailY, tailX;

    public static void main(String[] args) throws IOException {

        // 입력 및 초기화 구간
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        boolean isTail = false;

        map = new ArrayList<>();
        for(int i = 0 ; i<R ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ArrayList<Node> temp = new ArrayList<>();
            for(int j = 0; j<C ; j++) {
                val = Integer.parseInt(st.nextToken());
                temp.add(new Node(val, 0));
                if(val==-1) {
                    if(!isTail) {
                        headY = i;
                        headX = j;
                        isTail = true;
                    }
                    else {
                        tailY = i;
                        tailX = j;
                    }
                }
            }
        }

        // 메인 로직
        while(T-->0) {
            Diffusion();
            Circulation();
        }

        // 최종 입력 구간
        int result = 0;
        for(int i = 0 ; i<R ; i++) {
            for(int j = 0 ; j<C ; j++) result += map.get(i).get(j).Original;
        }

        bw.write(""+result);
        bw.close();
    }

    private static void Diffusion () {
        /**
         *      *  1-1) 각 칸을 객체화 : 기존 값, 새로 확산으로 추가된 값을 구분해서 가짐
         *      *  1-2) 각 칸을 순차적으로 순회하며, (1차 순회)
         *      *       기존값 노드 조회
         *      *       -> 확산 가능한 칸을 조회하여 새로 확산된 양에 확산 저장
         *      *       -> 확산시킨 총량 임시저장
         *      *       -> 기존량 - 확산총량을 기존량에 저장
         *      *  1-3) 재순회 하면서,
         *      *       -> 기존량에 확산량 합산
         *      *       -> 확산량을 0으로 초기화
         *      *
          */

        for(int i=0 ; i<R ; i++) {
            for(int j=0 ; j<C ; j++) {
                if(map.get(i).get(j).Original == 0) continue; // 0이면 확산될 것이 없기 때문
                if(map.get(i).get(j).Original == -1) continue; // 공기 청정기 위치

                int sum = 0;

                // 4방향 탐색
                for(int k=0 ; k<4 ; k++) {
                    int Y = i + ver[k];
                    int X = j + hor[k];

                    if(Y<0 || Y>=R || X<0 || X>=C || map.get(Y).get(X).Original == -1) continue;

                    Node temp_node = map.get(Y).get(X);
                    int add_val = map.get(i).get(j).Original/5;
                    sum += add_val;
                    temp_node.Additional += add_val;

                    map.get(Y).set(X, temp_node);
                }

                Node now_node = map.get(i).get(j);
                now_node.Original -= sum;
                map.get(i).set(j, now_node);
            }
        }

        // 합산 및 초기화
        for(int i=0 ; i<R ; i++) {
            for(int j=0 ; j<C ; j++) {
                map.get(i).get(j).Original =  map.get(i).get(j).Original + map.get(i).get(j).Additional;
                map.get(i).get(j).Additional = 0;
            }
        }
    }

    private static void Circulation () {
        int kai = (R*2) + (C*2);
        int temp_hY = headY;
        int temp_hX = headX;
        int temp_tY = tailY;
        int temp_tX = tailX;

        // head 순회
        Node memory =  map.get(temp_hY).get(temp_hX);
        for(int i=0 ; i<kai ; i++) {
            /**
             * 1. head 순회
             */

            if(temp_hX==headX && temp_hY==headY) map.get(headY).set(headX, new Node(0,0));
        }

        // tail 순회
        memory =  map.get(tailY).get(tailX);
        for(int i=0 ; i<kai ; i++) {
            /**
             * tail 순회
             */

            if(temp_tX==tailX && temp_tY==tailY) map.get(tailY).set(tailX, new Node(0,0));
        }
    }

    private static class Node {
        private int Original, Additional;
        public Node(int original, int additional) {
            this.Original = original;
            this.Additional = additional;
        }
    }
}

