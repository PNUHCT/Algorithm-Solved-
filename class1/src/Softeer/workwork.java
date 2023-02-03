package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class workwork {
    static int H, K, R, answer;
    static Worker[] tree;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken()); // 조직도 높이
        K = Integer.parseInt(st.nextToken()); // 업무량
        R = Integer.parseInt(st.nextToken()); // 날짜수

        tree = new Worker[((int) Math.pow(2, H)) * 2]; // 조직도 (최대 노드인 말단의 수는 2^H)

        init(1, 0);  // 루트상사

        for (int i = (int) Math.pow(2, H); i < (int) Math.pow(2, H + 1); i++) {  // 말단의 순서
            st = new StringTokenizer(br.readLine(), " "); // 말단에게 맡길 작업들
            for (int k = 0; k < K; k++) tree[i].job.offer(Integer.parseInt(st.nextToken())); // 말단에게 작업을 맡김 (K개 만큼)
        }

        answer = 0;
        for (int r = 1; r <= R; r++) workProcess(1, r, 0);  // 날짜별 계산 호출하여 answer에 합해짐

        System.out.println(answer);
    }

    static void workProcess(int idx, int r, int depth) {
        if (depth > H) return; // 말단이면 재귀 끝

        Worker worker = tree[idx];

        // 말단인데, 작업이 남아있다?
        if (depth == H && !worker.job.isEmpty()) {
            int job = worker.job.poll();  // 작업을 뽑아
            if (idx % 2 == 0) tree[idx / 2].leftJob.offer(job); // 본인이 상사의 왼팔이면 상사의 왼쪽 대기열에 작업을 넣어라
            else tree[idx / 2].rightJob.offer(job); // 본인이 상사의 오른팔이면 상사의 오른쪽 대기열에 작업을 넣어라
        }
        // 상사이고, 짝수날인데, 작업이 남아있다?
        else if (depth < H && r % 2 == 0 && !worker.rightJob.isEmpty()) {
            int job = worker.rightJob.poll(); // 작업을 뽑아
            if (idx == 1) answer += job; // 본인이 루트상사면 작업 시마이
            else {
                if (idx % 2 == 0) tree[idx / 2].leftJob.offer(job); // 루트가 아닌 왼팔상사면, 본인의 상사 왼쪽 대기열에 작업 넣어라
                else tree[idx / 2].rightJob.offer(job);  // 루트가 아닌 오른팔상사면, 본인의 상사 오른쪽 대기열에 작업 넣어라
            }
        }
        // 상사이고, 홀수날인데, 작업이 남아있다?
        else if (depth < H && r % 2 == 1 && !worker.leftJob.isEmpty()) {
            int job = worker.leftJob.poll(); // 작업을 뽑아
            if (idx == 1) answer += job; // 본인이 루트상사면 작업 시마이
            else {
                if (idx % 2 == 0) tree[idx / 2].leftJob.offer(job); // 루트가 아닌 왼팔상사면, 본인의 상사 왼쪽 대기열에 작업 넣어라
                else tree[idx / 2].rightJob.offer(job); // 루트가 아닌 오른팔상사면, 본인의 상사 오른왼쪽 대기열에 작업 넣어라
            }
        }

        // 이전에 올라온 작업을 처리했으니, 좌우 부하직원을 탐색해서 다시 반복
        workProcess(idx * 2, r, depth + 1);
        workProcess(idx * 2 + 1, r, depth + 1);
    }

    static void init(int idx, int depth) {
        if (depth > H) return;

        Worker newWorker = new Worker(depth);
        tree[idx] = newWorker;

        init(idx * 2, depth + 1);  // 왼쪽
        init(idx * 2 + 1, depth + 1);  // 오른쪽
    }

    static class Worker {
        int depth;
        Deque<Integer> leftJob, rightJob, job;

        public Worker(int depth) {
            this.depth = depth;
            initJob();
        }

        public void initJob() {
            if (depth == H) job = new ArrayDeque<>(); // 말단일 경우 : 가지고 있는 작업을 저장할 큐를 생성
            else { // 상사노드일 경우 : 왼쪽 부하직원 or 오른쪽 부하직원에 의해 작업을 전달받을 큐를 생성
                leftJob = new ArrayDeque<>();
                rightJob = new ArrayDeque<>();
            }
        }
    }
}

