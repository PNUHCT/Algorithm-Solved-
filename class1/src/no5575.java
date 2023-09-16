import java.io.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class no5575 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T;

    public static void main(String[] args) throws IOException {
        /**
         * 출근시간 : 7시부터
         * 퇴근시간 : 23시까지
         *
         * 출근시간 시/분/초 및 퇴근시간 시/분/초가 주어진다.
         * 근무한 시간을 출력하라
         */
        StringTokenizer st;

        int worker = 3;

        while (worker-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            int start_hour = Integer.parseInt(st.nextToken());
            int start_minute = Integer.parseInt(st.nextToken());
            int start_second = Integer.parseInt(st.nextToken());

            int end_hour = Integer.parseInt(st.nextToken());
            int end_minute = Integer.parseInt(st.nextToken());
            int end_second = Integer.parseInt(st.nextToken());

            LocalTime start = LocalTime.of(start_hour, start_minute, start_second);
            LocalTime end = LocalTime.of(end_hour, end_minute, end_second);

            long sec = ChronoUnit.SECONDS.between(start, end); // 두 시간의 차이를 초(sec)로 반환
            long hour = sec/3600; // 시간값부터 제외
            sec -= hour*3600;
            long min = sec/60;
            sec -= min*60;

            bw.write("" + hour + " " + min + " " + sec + "\n");
        }

        bw.close();
    }
}

