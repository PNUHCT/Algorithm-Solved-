import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=1 ; i<=T ; i++) {
            String str = br.readLine();
            bw.write(""+i+". "+str+"\n");
        }
        bw.close();
    }
}