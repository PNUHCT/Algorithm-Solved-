import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class no18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        /**
         * 입력받은 대로 꼭 매트릭스일 필요가 없다.
         * 어차피 모든 위치의 블록수를 계산하기 때문에 자료구조로 일렬로 나열해도 된다.
         */
        List<Integer> rand = new ArrayList<>();
        for(int i=0; i<N ; i++) {
            StringTokenizer randSt = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M ; j++) {
                rand.add(Integer.valueOf(randSt.nextToken()));
            }
        }

        /**
         * 최대 높이를 구해서 한 층씩 내려갈 것임. 위에서부터 내려오는게 연산이 더 적다.
         */
        int floor = rand.stream().mapToInt(a->a).max().getAsInt();

        /**
         * 땅의 넓이 = N*M이며, N과 M은 최대 500이므로, 2500를 초과할 수 없다. 또한, 치우는 시간이 더 크므로, 최대 블록수*2를 초과할 수 없다
         * 따라서, 500 * 500 * 2를 최대 시간으로 기준을 잡는다.
         */
        int time = 128000000;
        /**
         * while문 시작시 max에서 -1 되므로, 시작을 max에 +1 해주고 시작.
         */
        floor++;

        while(floor-->=0) {
            int inventory = B;
            int removedBlock = 0;
            int needs = 0;
            for(int i=0; i<N*M ; i++) {
                int block = rand.get(i);
                if(block>floor) {
                    inventory += block - floor;
                    removedBlock += block - floor;
                }
                else needs += floor - block;
            }

            // 채워야 할 블록보다 가진 블록이 적을 경우 다음 층으로 내려감
            if(inventory<needs) continue;

            // 현재 층 작업시간 계산
            int tempTime = (removedBlock * 2) + needs;

            // 이전 시간이 현재 층보다 작업시간이 적은 경우, 한 층 빠진만큼 +1
            if(time <= tempTime) {
                floor++;
                break;
            } else {
                // 현재 층의 작업시간이 더 적을 경우, 현재 작업 시간을 기준시간에 세팅 후 아래층으로 이동
                time = tempTime;
            }
        }

        System.out.println(""+time+" "+floor);
    }
}

