import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=1; i<=T ; i++) answer += i;
        System.out.println(answer);
    }
}