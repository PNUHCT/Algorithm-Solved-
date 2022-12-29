import java.io.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class no2884 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        LocalDateTime time = LocalDateTime.of(2022, 5, 1, hour, min);
        LocalDateTime time2 = time.minusMinutes(45);
        System.out.println(String.format("%d %d",time2.getHour(),time2.getMinute()));

    }
}

