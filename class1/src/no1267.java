import java.io.*;
import java.util.StringTokenizer;

public class no1267 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T;

    public static void main(String[] args) throws IOException {
        // 입력 구간
        T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 누적 비용을 저장할 변수
        int ys_sum = 0;
        int ms_sum = 0;

        // 각 케이스별 두 가지 plan으로 계산
        for(int i=0; i<T ; i++) {
            int sec = Integer.parseInt(st.nextToken());
            ys_sum += ys_plan(sec);
            ms_sum += ms_plan(sec);
        }

        // 총 비용 비교
        if(ys_sum < ms_sum) bw.append("Y " + ys_sum);
        else if(ys_sum > ms_sum) bw.append("M " + ms_sum);
        else bw.append("Y M " + ys_sum);

        bw.close();
    }

    /**
     * 영식 plan 비용계산 : 30초당 10원 부과
     * 이때, 30보다 적은 초(나머지)에 대해서도 10원 부과되므로, cnt에 +1 해줘야 함
     */
    private static int ys_plan (int sec) {
        int cnt = 0;
        while (sec>=30) {
            sec -= 30;
            cnt++;;
        }
        return (cnt + 1) * 10 ;
    }

    /**
     * 민식 plan 비용계산 : 60초당 15원 부과
     * 이때, 60보다 적은 초(나머지)에 대해서도 15원 부과되므로, cnt에 +1 해줘야 함
     */
    private static int ms_plan (int sec) {
        int cnt = 0;
        while (sec>=60) {
            sec -= 60;
            cnt++;;
        }
        return (cnt + 1) * 15 ;
    }
}
