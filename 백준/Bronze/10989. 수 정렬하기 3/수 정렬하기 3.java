import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        int[] arr = new int[T];

        for(int i=0; i<T ; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.stream(arr).sorted().forEach(a -> {
            try {
                bw.write(""+a+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.close();
    }
}