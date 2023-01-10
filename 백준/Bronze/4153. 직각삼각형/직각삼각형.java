import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int Ausar = Integer.parseInt(st.nextToken());
            int Auset = Integer.parseInt(st.nextToken());
            int Heru = Integer.parseInt(st.nextToken());
            if(Ausar==0 && Auset==0 && Heru==0) break;

            if(Math.pow(Heru, 2)==Math.pow(Ausar, 2)+Math.pow(Auset, 2)) bw.write("right\n");
            else if(Math.pow(Ausar, 2)==Math.pow(Heru, 2)+Math.pow(Auset, 2)) bw.write("right\n");
            else if(Math.pow(Auset, 2)==Math.pow(Heru, 2)+Math.pow(Ausar, 2)) bw.write("right\n");
            else bw.write("wrong\n");
        }

        bw.close();
    }
}

