import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double num = Double.parseDouble(st.nextToken());
            String unit = st.nextToken();
            bw.write(exchange(num, unit) + "\n");
        }

        bw.close();
    }

    private static String exchange (double num, String unit) {
        String result = "";

        switch (unit) {
            case ("kg") :
                result += change(num * 2.2046) + " lb";
                break;
            case ("l") :
                result += change(num * 0.2642) + " g";
                break;
            case ("lb") :
                result += change(num * 0.4536) + " kg";
                break;
            case ("g") :
                result += change(num * 3.7854) + " l";
                break;
        }

        return result;
    }

    private static String change(double num) {
        return String.format("%.4f", Math.abs(num * 10000)/10000);
    }
}