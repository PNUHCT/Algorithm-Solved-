package Softeer;

import java.io.*;
import java.util.*;

public class safecracker {

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 버퍼 (최소한의 입력 속도)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 가방무게와 금속의 갯수를 받기위한 부분
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int W = Integer.parseInt(st.nextToken());
        int ea = Integer.parseInt(st.nextToken());

        // 결과값이 될 부분
        int result = 0;

        /**
         * 핵심 부분
         * 1. 우선순위큐를 이용해 가치가 큰 순(숫자로 치면 역순)으로 정렬을 해줘야 한다.
         *    이때, 우선순위큐가 아닌 다른 자료구조의 sort를 사용하는 순간 시간 초과다.
         * 2. 우선순위큐에 값을 객체로 받아서 넣어준다. (kg: 무게, val: 가치, metal: 귀금속)
         */
        PriorityQueue<metal> pq = new PriorityQueue<>((a,b) -> b.val - a.val);
        for(int  i = 0; i<ea ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            metal metal = new metal(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));
            pq.add(metal);
        }

        /**
         * 이제 가방의 용량이 0이 될 때까지 반복만 해주면 된다.
         * 1. 가방용량이 더 크면, 지금 뽑은 물질의 가치 * 최대가용량을 넣어주고, 그 만큼 가방의 용량에서 빼준다.
         * 2. 가방용량이 더 부족하면, 지금 뽑은 물질의 가치 * 가방의 남은 용량만큼 넣어주고, 가방의 남은 용량은 0으로 해준다.
         */
        while(W!=0) {
            metal now = pq.poll();
            if(W>=now.kg) {
                W -= now.kg;
                result += (now.kg * now.val);
            } else {
                result += (W * now.val);
                W = 0;
            }
        }
        System.out.println(result);
    }

    /**
     * 물질을 객체로 만들기 위한 이너클래스
     */
    private static class metal {
        private int kg;
        private int val;
        public metal(int kg, int val) {
            this.kg = kg;
            this.val = val;
        }
    }
}