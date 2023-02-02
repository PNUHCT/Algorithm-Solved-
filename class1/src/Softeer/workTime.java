package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class workTime {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 5;
        int time = 0;
        while(count-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringTokenizer start = new StringTokenizer(st.nextToken(), ":");
            StringTokenizer end = new StringTokenizer(st.nextToken(), ":");
            Integer StartHour = Integer.valueOf(start.nextToken());
            Integer StartMin = Integer.valueOf(start.nextToken());
            Integer EndHour = Integer.valueOf(end.nextToken());
            Integer EndMin = Integer.valueOf(end.nextToken());

            time += (EndHour-StartHour)*60 + (EndMin-StartMin);
        }
        System.out.println(time);
    }
}

