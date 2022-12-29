import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        String[] arr = String.valueOf(A*B*C).split("");

        int[] check = new int[10];
        Arrays.fill(check, 0);

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j <10 ; j++) {
                if(arr[i].equals(""+j)) {
                    check[j]++;
                    break;
                }
            }
        }

        for(int i = 0; i < check.length; i++) {
            bw.write(""+check[i]+"\n");
        }
        
        bw.close();  // stream을 flush 하고, stream을 닫음
    }
}

