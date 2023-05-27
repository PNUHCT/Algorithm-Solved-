import java.io.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class no2530 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());

        LocalDateTime time = LocalDateTime.of(2023,10,1,hour, min, sec);
        LocalDateTime after = time.plusSeconds(Integer.parseInt(br.readLine()));
        bw.append(""+after.getHour()+" ").append(""+after.getMinute()+" ").append(""+after.getSecond()+" ");

        bw.close();
    }
}

