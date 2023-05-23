import java.io.*;
import java.util.StringTokenizer;

public class no11943 {
    private static int apple1, apple2, orange1, orange2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        apple1 = Integer.parseInt(st1.nextToken());
        orange1 = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        apple2 = Integer.parseInt(st2.nextToken());
        orange2 = Integer.parseInt(st2.nextToken());

        int answer = 0;

        if(apple1>=apple2) {
            if(orange2<apple2) answer += apple1 + orange2;
            else answer += apple2 + orange1;
        }
        else {
            if(orange1<apple1) answer += apple2 + orange1;
            else answer += apple1 + orange2;
        }

        System.out.println(answer);
    }
}