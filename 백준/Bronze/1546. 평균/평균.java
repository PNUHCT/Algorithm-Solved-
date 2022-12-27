import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        double[] arr = new double[T];
        double max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<T; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
            if(max<arr[i]) max = arr[i];
        }

        double total = 0;
        for (int j=0; j<arr.length; j++) {
                double temp = arr[j] / max;
                arr[j] = temp * 100;
                total += arr[j];
        }

        System.out.println(total/T);
        
    }
}

