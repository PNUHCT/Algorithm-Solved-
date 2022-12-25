import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Double a = Double.valueOf(st.nextToken());
        Double b = Double.valueOf(st.nextToken());
        System.out.println(a/b);

    }
    
}