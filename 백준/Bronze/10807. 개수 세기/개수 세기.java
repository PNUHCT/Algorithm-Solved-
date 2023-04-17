import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String v = br.readLine();
        int count = 0;
        for(int i=0; i<N ; i++) if(st.nextToken().equals(v)) count++;

        System.out.println(count);
    }
}