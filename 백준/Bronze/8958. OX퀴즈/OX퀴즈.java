import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T ; i++) {
            String[] OX = br.readLine().split("");
            int total = 0;
            int point = 0;
            for(int j=0; j<OX.length; j++) {
                if(OX[j].equals("O")) {
                    point++;
                    total += point;
                }
                else if(OX[j].equals("X")) {
                    point = 0;
                }
            }
            System.out.println(total);
        }
    }
}