import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ys_sum = 0;
        int ms_sum = 0;

        for(int i=0; i<T ; i++) {
            int sec = Integer.parseInt(st.nextToken());
            ys_sum += ys_method(sec);
            ms_sum += ms_method(sec);
        }

        if(ys_sum < ms_sum) bw.append("Y " + ys_sum);
        else if(ys_sum > ms_sum) bw.append("M " + ms_sum);
        else bw.append("Y M " + ys_sum);

        bw.close();
    }

    private static int ys_method (int sec) {
        int cnt = 0;
        while (sec>=30) {
            sec -= 30;
            cnt++;;
        }
        return (cnt + 1) * 10 ;
    }

    private static int ms_method (int sec) {
        int cnt = 0;
        while (sec>=60) {
            sec -= 60;
            cnt++;;
        }
        return (cnt + 1) * 15 ;
    }
}