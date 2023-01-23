import java.io.*;
import java.util.*;

public class no18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 0. 0<i<N, 0<j<M으로 순회하여 매트릭스 생성
         * 1. 매트릭스 내에서 같은 숫자가 가장 많은 수를 찾음 => HashMap을 이용한 count (밸류값이 갯수)
         * 2. 가장 많은 수 = maxVal
         * 3. 매트릭스를 순회하며, maxVal - a[i][j] 해서, 값이 음수면 removeWork += 해당 값   = 제거 해야함
         * 4. 매트릭스를 순회하며, maxVal - a[i][j] 해서, 값이 양수면 addWork += 해당 값   = 채워야 함
         * 5. 만약 removeWork + addWork + B가 0보다 적으면, removeWork - 매트릭스 총 사이즈(한 층 더 낮게 치워야됨)
         * 6. removeTime = removeWork * 2초
         * 7. addTime = addWork * 1초
         * 8. workTime = removeTime + addTime;
         */

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] rand = new int [N][M];
        Map<Integer, Integer> maxCheck = new HashMap<>();
        for(int i=0; i<N ; i++) {
            StringTokenizer stNum = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++) {
                int block = Integer.parseInt(stNum.nextToken());
                rand[i][j] = block;

                if (maxCheck.containsKey(block)) maxCheck.put(block, maxCheck.get(block) + 1);
                else maxCheck.put(block, 1);
            }
        }
        int maxVal = Collections.max(maxCheck.values());
        int max = getMaxValue(maxVal, maxCheck);

        int removeBlock = 0;
        int addBlock = 0;
        for(int i=0; i<N ; i++) {
            for(int j=0;j<M; j++) {
                if ((rand[i][j]-max)<0) removeBlock += (max - rand[i][j]);
                else addBlock += (max - rand[i][j]);
            }
        }
        if(removeBlock < addBlock - B) {
            removeBlock -= max*maxVal;
            max--;
        }

        System.out.println(Math.abs((removeBlock * 2) + (addBlock * 1))+ " " + max);
    }

    private static int getMaxValue(int maxVal, Map<Integer, Integer> maxCheck) {
        List<Integer> keyList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : maxCheck.entrySet()) {
            if (entry.getValue().equals(maxVal)) {
                keyList.add(entry.getKey());
            }
        }
        Collections.sort(keyList, Collections.reverseOrder());
        return keyList.get(0);
    }
}

